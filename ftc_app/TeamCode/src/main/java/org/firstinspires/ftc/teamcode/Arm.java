package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Jonathan on 2017-10-21.
 */

public class Arm {
    Hardware robot;
    Telemetry telemetry;

    public Arm(Hardware memeware, Telemetry telemetry) {
        robot = memeware;
        this.telemetry = telemetry;

        //Arm Motors
        robot.armBase = robot.hwMap.dcMotor.get("armBase");
        robot.armJoint = robot.hwMap.dcMotor.get("armJoint");

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