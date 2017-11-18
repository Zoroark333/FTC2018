package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static android.R.attr.right;

/**
 * Created by Jonathan on 2017-11-04.
 */

public class ColorSensor {
    Hardware robot;
    Telemetry telemetry;

    static float[] rightHsvValues;

    public ColorSensor(Hardware memeware, Telemetry telemetry) {
        robot = memeware;
        this.telemetry = telemetry;

//        robot.leftColorSensor = robot.hwMap.colorSensor.get("leftColorSensor");
        robot.rightColorSensor = robot.hwMap.colorSensor.get("rightColorSensor");

        rightHsvValues = new float[3];
    }

    public void loop() {
//        Color.RGBToHSV(robot.leftColorSensor.red()*8, robot.leftColorSensor.green()*8, robot.leftColorSensor.blue()*8, leftHsvValues);
        Color.RGBToHSV(robot.rightColorSensor.red()*8, robot.rightColorSensor.green()*8, robot.rightColorSensor.blue()*8, rightHsvValues);

        telemetry.addData("HSV: ", ColorSensor.rightHsvValues[0]);
        telemetry.addData("HSV: ", ColorSensor.rightHsvValues[1]);
        telemetry.addData("HSV: ", ColorSensor.rightHsvValues[2]);
        telemetry.update();
    }
}
