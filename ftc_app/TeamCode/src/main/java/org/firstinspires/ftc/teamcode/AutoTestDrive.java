package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by wildj on 2017-11-25.
 */
@Autonomous(name="Auto Test Drive", group="Autonomous")



public class AutoTestDrive extends LinearOpMode {

    ColourSensor rightColorSensor;

    Hardware robot = new Hardware();
    private ElapsedTime runtime = new ElapsedTime();

    XDrive drive;


    static final double FORWARD_SPEED = 0.1;
    static final double STRAFE_SPEED = 0.1;

    public void runOpMode() {
        robot.init(hardwareMap);
        drive = new XDrive(robot, telemetry);
        rightColorSensor = new ColourSensor(robot, telemetry, "rightColorSensor");

        waitForStart();

        runtime.reset();
        while (opModeIsActive() && !rightColorSensor.isGreen()) {
            //drive forward
//                robot.leftFrontDriveMotor.setPower(FORWARD_SPEED);
//                robot.rightFrontDriveMotor.setPower(FORWARD_SPEED);
//                robot.leftRearDriveMotor.setPower(FORWARD_SPEED);
//                robot.rightRearDriveMotor.setPower(FORWARD_SPEED);
            drive.drive((float) -FORWARD_SPEED,(float) -STRAFE_SPEED, (float) 0.0);

            }
                robot.leftFrontDriveMotor.setPower(0);
                robot.rightFrontDriveMotor.setPower(0);
                robot.leftRearDriveMotor.setPower(0);
                robot.rightRearDriveMotor.setPower(0);

            telemetry.addData("isGreen: ", rightColorSensor.isGreen());
//            telemetry.addData("Red: ", rightColorSensor.colorSensor.red());
//            telemetry.addData("Green: ", rightColorSensor.colorSensor.green());
//            telemetry.addData("Blue : ", rightColorSensor.colorSensor.blue());
            telemetry.update();
        sleep(1000);
        }

    }

