package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Jonathan on 2017-11-04.
 */

public class ColourSensor {
    Hardware robot;
    Telemetry telemetry;

    ColorSensor colorSensor;



    static float[] rightHsvValues;

    public ColourSensor(Hardware memeware, Telemetry telemetry, String colorSensorName) {
        robot = memeware;
        this.telemetry = telemetry;
        colorSensor = robot.hwMap.colorSensor.get(colorSensorName);

//        rightHsvValues = new float[3];
    }

    public void loop() {
//        Color.RGBToHSV(robot.leftColorSensor.red()*8, robot.leftColorSensor.green()*8, robot.leftColorSensor.blue()*8, leftHsvValues);
//        Color.RGBToHSV(robot.rightColorSensor.red()*8, robot.rightColorSensor.green()*8, robot.rightColorSensor.blue()*8, rightHsvValues);

//        telemetry.addData("HSV: ", ColourSensor.rightHsvValues[0]);
//        telemetry.addData("HSV: ", ColourSensor.rightHsvValues[1]);
//        telemetry.addData("HSV: ", ColourSensor.rightHsvValues[2]);
        telemetry.update();
    }

    public boolean isRed() {
        int redCutoff = colorSensor.red() - 10;
        if(redCutoff >= colorSensor.green() && redCutoff >= colorSensor.blue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGreen() {
        int greenCutoff = colorSensor.green() - 10;
        if(greenCutoff >= colorSensor.red() && greenCutoff >= colorSensor.blue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBlue() {
        int blueCutoff = colorSensor.blue() - 10;
        if(blueCutoff >= colorSensor.red() && blueCutoff >= colorSensor.green()) {
            return true;
        } else {
            return false;
        }
    }
}
