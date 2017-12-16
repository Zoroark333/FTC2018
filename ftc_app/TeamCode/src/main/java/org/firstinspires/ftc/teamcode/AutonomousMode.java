package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Jonathan on 2017-11-18.
 */

@Autonomous(name="Autonomous", group="Autonomous")
public class AutonomousMode extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware robot = new Hardware();
    Gamepad gamepad = new Gamepad();
//    XDrive drive;
//    BallFlipper ballFlipper;
    ColourSensor leftColorSensor;
    ColourSensor rightColorSensor;
//    Arm arm;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        gamepad = new Gamepad();
//        drive = new XDrive(robot, telemetry);
//        ballFlipper = new BallFlipper(robot, telemetry, gamepad1);
//        servoTest = new ServoTest();
        leftColorSensor = new ColourSensor(robot, telemetry, "leftColorSensor");
        rightColorSensor = new ColourSensor(robot, telemetry, "rightColorSensor");
//        arm = new Arm(robot, telemetry, gamepad1);

        telemetry.addData("Status", "Initialized");
        updateTelemetry(telemetry);

        //Wait for the match to begin
        waitForStart();

        while (opModeIsActive()) {

        }
    }
}