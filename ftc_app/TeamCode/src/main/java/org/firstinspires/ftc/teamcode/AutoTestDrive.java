package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by wildj on 2017-11-25.
 */
@Autonomous(name="Auto Test Drive", group="Autonomous")



public class AutoTestDrive extends LinearOpMode {

    ColourSensor rightColorSensor;

    Hardware robot = new Hardware();
    private ElapsedTime runtime = new ElapsedTime();

    static final double FORWARD_SPEED = 0.1;
    static final double TURN_SPEED = 0.1;

    public void runOpMode() {
        robot.init(hardwareMap);
        rightColorSensor = new ColourSensor(robot, telemetry, "rightColorSensor");

        waitForStart();

        runtime.reset();
        while (opModeIsActive()) {
            //drive forward
            if(!rightColorSensor.isGreen()) {
                robot.leftFrontDriveMotor.setPower(-FORWARD_SPEED);
                robot.rightFrontDriveMotor.setPower(FORWARD_SPEED);
                robot.leftRearDriveMotor.setPower(-FORWARD_SPEED);
                robot.rightRearDriveMotor.setPower(FORWARD_SPEED);
            } else {
                robot.leftFrontDriveMotor.setPower(0);
                robot.rightFrontDriveMotor.setPower(0);
                robot.leftRearDriveMotor.setPower(0);
                robot.rightRearDriveMotor.setPower(0);
            }

            telemetry.addData("isGreen: ", rightColorSensor.isGreen());
//            telemetry.addData("Red: ", rightColorSensor.colorSensor.red());
//            telemetry.addData("Green: ", rightColorSensor.colorSensor.green());
//            telemetry.addData("Blue : ", rightColorSensor.colorSensor.blue());
            telemetry.update();
        }
        sleep(1000);
    }

}