package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Jonathan on 2017-10-21.
 */

public class Arm {
    Hardware robot;
    Telemetry telemetry;
    Gamepad gamepad;

    public Arm(Hardware memeware, Telemetry telemetry, Gamepad gamepad) {
        robot = memeware;
        this.telemetry = telemetry;
        this.gamepad = gamepad;

        //Arm Motors
//        robot.armBase = robot.hwMap.dcMotor.get("armBase");
//        robot.armJoint = robot.hwMap.dcMotor.get("armJoint");

        // Set all motors to run with/without encoders.
        robot.armBase.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.armJoint.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Arm Servos
        robot.armClaw = robot.hwMap.servo.get("armClaw");

        // Define and Initialize Buttons
        robot.armMinButton = robot.hwMap.digitalChannel.get("armMinButton");
    }

    public void control() {

    }
}
