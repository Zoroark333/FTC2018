package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

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
        while (opModeIsActive()) {
            telemetry.addData("isRed: ", rightColorSensor.isRed());
            telemetry.addData("Red: ", rightColorSensor.colorSensor.red());
            telemetry.addData("Green: ", rightColorSensor.colorSensor.green());
            telemetry.addData("Blue : ", rightColorSensor.colorSensor.blue());
            telemetry.addData("Ultrasonic level", robot.frontDistanceSensor.getDistance(DistanceUnit.CM));

            telemetry.update();

            //drive forward until within distance, then drive left until right sensor detects colour
            if(robot.frontDistanceSensor.getDistance(DistanceUnit.CM) > 15) {
                drive.drive((float) FORWARD_SPEED,(float) 0,(float) 0);
            } else if(robot.frontDistanceSensor.getDistance(DistanceUnit.CM) <= 15
                    && !rightColorSensor.isRed()) {
                drive.drive((float) 0, (float) -STRAFE_SPEED, (float) 0);
            } else {
                drive.drive((float) 0, (float) 0, (float) 0);
            }
        }
        robot.leftFrontDriveMotor.setPower(0);
        robot.rightFrontDriveMotor.setPower(0);
        robot.leftRearDriveMotor.setPower(0);
        robot.rightRearDriveMotor.setPower(0);

        sleep(1000);
    }
}