package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static android.os.Build.VERSION_CODES.BASE;

/**
 * Created by Jonathan on 2017-10-21.
 */

public class Arm {
    Hardware robot;
    Telemetry telemetry;

<<<<<<< HEAD
    //min values are also default positions
    static final int BASE_MIN = 0;
    static final int JOINT_MIN = 0;
    static final int CLAW_MIN = 0;
=======
    boolean clawIsOpen = false;
    boolean clawButtonWasPressed = false;

    public static final double CLAW_OPEN = 1;
    public static final double CLAW_CLOSED = 0;
    public static final int BASE_INCREMENT = 50;
    public static final int BASE_MIN = 0;
    public static final int JOINT_INCREMENT = 50;
    public static final int JOINT_MIN = 0;
    public static final double EXTENDER_INCREMENT = 0.02;
    public static final double EXTENDER_EXTENDED = 1;
    public static final double EXTENDER_RETRACTED = 0;
>>>>>>> Arm

    public Arm(Hardware memeware, Telemetry telemetry, Gamepad gamepad) {
        robot = memeware;
        this.telemetry = telemetry;

        //Arm Motors
        robot.armBaseLeft = robot.hwMap.dcMotor.get("armBaseLeft");
        robot.armBaseRight = robot.hwMap.dcMotor.get("armBaseRight");
        robot.armJoint = robot.hwMap.dcMotor.get("armJoint");

        // Set all motors to run with/without encoders.
        robot.armBaseLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.armBaseRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.armJoint.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Arm Servos
        robot.armClaw = robot.hwMap.servo.get("armClaw");
        robot.armExtender = robot.hwMap.servo.get("armExtender");

        // Define and Initialize Buttons
//        robot.armMinButton = robot.hwMap.digitalChannel.get("armMinButton");
    }

        //control
    public void control(boolean armControlBaseUp, boolean armControlBaseDown,
                        boolean armControlJointUp, boolean armControlJointDown,
                        boolean armControlClaw, boolean armControlExtend,
                        boolean armControlRetract) {
//        //base control
//        //move arm base up
//        if(armControlBaseUp && !armControlBaseDown) {
//            robot.armBaseLeft.setTargetPosition(robot.armBaseLeft.getCurrentPosition() + BASE_INCREMENT);
//            robot.armBaseRight.setTargetPosition(robot.armBaseRight.getCurrentPosition() - BASE_INCREMENT);
//        }
//        //move arm base down
//        else if(armControlBaseDown && !armControlBaseUp) {
//            robot.armBaseLeft.setTargetPosition(robot.armBaseLeft.getCurrentPosition() - BASE_INCREMENT);
//            robot.armBaseRight.setTargetPosition(robot.armBaseRight.getCurrentPosition() + BASE_INCREMENT);
//        }
//        //otherwise stay still
//        else {
//            robot.armBaseLeft.setTargetPosition(robot.armBaseLeft.getCurrentPosition());
//            robot.armBaseRight.setTargetPosition(robot.armBaseRight.getCurrentPosition());
//        }
//        //set power
//        robot.armBaseLeft.setPower(0.1);
//        robot.armBaseRight.setPower(-0.1);
//        //restriction on minimum base position
//        if(robot.armMinButton.getState()) {
//            robot.armBaseLeft.setTargetPosition(BASE_MIN + BASE_INCREMENT);
//            robot.armBaseRight.setTargetPosition(BASE_MIN + BASE_INCREMENT);
//        }

        //joint control
        //move arm joint up
        if(armControlJointUp && !armControlJointDown) {
            robot.armJoint.setTargetPosition(robot.armJoint.getCurrentPosition() + JOINT_INCREMENT);
        }
        //move arm joint down
        else if(armControlJointDown && !armControlJointUp) {
            robot.armJoint.setTargetPosition(robot.armJoint.getCurrentPosition() - JOINT_INCREMENT);
        }
        //otherwise stay still
        else {
            robot.armJoint.setTargetPosition(robot.armJoint.getCurrentPosition());
        }
        //set power
        robot.armJoint.setPower(0.1);
        //restriction on minimum joint position
        if(robot.armJoint.getCurrentPosition() <= JOINT_MIN) {
            robot.armJoint.setTargetPosition(JOINT_MIN + JOINT_INCREMENT);
        }

//        //claw extend/retract
//        //extend
//        if(armControlExtend && !armControlRetract) {
//            robot.armExtender.setPosition(robot.armExtender.getPosition() + EXTENDER_INCREMENT);
//        }
//        //retract
//        else if(!armControlExtend && armControlRetract) {
//            robot.armExtender.setPosition(robot.armExtender.getPosition() - EXTENDER_INCREMENT);
//        }
//        //otherwise stay still
//        else {
//            robot.armExtender.setPosition(robot.armExtender.getPosition());
//        }
//        //max position
//        if(robot.armExtender.getPosition() >= EXTENDER_EXTENDED) {
//          robot.armExtender.setPosition(EXTENDER_EXTENDED - 0.05);
//        }
//        //min position
//        else if(robot.armExtender.getPosition() <= EXTENDER_RETRACTED) {
//          robot.armExtender.setPosition(EXTENDER_RETRACTED + 0.05);
//        }

//        //claw open/close
//        if(armControlClaw && !clawButtonWasPressed) {
//            clawIsOpen = !clawIsOpen;
//            clawButtonWasPressed = true;
//        }
//        if(!armControlClaw) {
//            clawButtonWasPressed = false;
//        }
//        if(clawIsOpen) {
//            robot.armClaw.setPosition(CLAW_OPEN);
//        } else {
//            robot.armClaw.setPosition(CLAW_CLOSED);
//        }
    }
}
