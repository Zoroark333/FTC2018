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

    boolean clawIsOpen = false;
    boolean clawButtonWasPressed = false;

    public static final double CLAW_OPEN = 1;
    public static final double CLAW_CLOSED = 0;
    public static final int BASE_INCREMENT = 3000;
    public static final int BASE_MIN = 0;

    public Arm(Hardware memeware, Telemetry telemetry) {
        robot = memeware;
        this.telemetry = telemetry;

        //Arm Motors
        robot.armBase = robot.hwMap.dcMotor.get("armBase");
//        robot.armJoint = robot.hwMap.dcMotor.get("armJoint");

        // Set all motors to run with/without encoders.
        robot.armBase.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        robot.armJoint.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Arm Servos
//        robot.armClaw = robot.hwMap.servo.get("armClaw");

        // Define and Initialize Buttons
//        robot.armMinButton = robot.hwMap.digitalChannel.get("armMinButton");
    }

    public void control(boolean armControlUp, boolean armControlDown, boolean armControlClaw) {
        //move arm up
        if(armControlUp) {
            robot.armBase.setTargetPosition(robot.armBase.getCurrentPosition() + BASE_INCREMENT);
        }
        //move arm down
        if(armControlDown) {
            robot.armBase.setTargetPosition(robot.armBase.getCurrentPosition() - BASE_INCREMENT);
        }
        robot.armBase.setPower(0.5);

        //restriction on minimum
        if(robot.armMinButton.getState()) {
            robot.armBase.setTargetPosition(BASE_MIN);
        }
        //claw open/close
        if(armControlClaw && !clawButtonWasPressed) {
            clawIsOpen = !clawIsOpen;
            clawButtonWasPressed = true;
        }
        if(!armControlClaw) {
            clawButtonWasPressed = false;
        }
        if(clawIsOpen) {
            robot.armClaw.setPosition(CLAW_OPEN);
        } else {
            robot.armClaw.setPosition(CLAW_CLOSED);
        }
    }
}
