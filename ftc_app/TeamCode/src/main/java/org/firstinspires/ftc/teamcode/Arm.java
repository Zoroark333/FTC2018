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
    Gamepad gamepad;

    //min values are also default positions
    static final int BASE_MIN = 0;
    static final int JOINT_MIN = 0;
    static final int CLAW_MIN = 0;

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
//        robot.armClaw = robot.hwMap.servo.get("armClaw");

        // Define and Initialize Buttons
        robot.armMinButton = robot.hwMap.digitalChannel.get("armMinButton");
    }

    //set arm to default position
    public void reset() {
        robot.armBase.setTargetPosition(BASE_MIN);
        robot.armJoint.setTargetPosition(JOINT_MIN);
        robot.armClaw.setPosition(CLAW_MIN);
    }

    //full stop
    public void stop() {
        robot.armBase.setPower(0);
        robot.armJoint.setPower(0);
        robot.armClaw.setPosition(robot.armClaw.getPosition());
    }

    public void control(double basePower, double jointPower, int clawIncrement) {
        //set motor power
        robot.armBase.setPower(basePower);
        robot.armJoint.setPower(jointPower);

        //limit arm positions to prevent damage
        if(robot.armMinButton.getState()) {
            robot.armBase.setTargetPosition(BASE_MIN);
        }
        if(robot.armJoint.getCurrentPosition() <= JOINT_MIN) {
            robot.armJoint.setTargetPosition(JOINT_MIN);
        }
        if(robot.armClaw.getPosition() <= CLAW_MIN) {
            robot.armClaw.setPosition(CLAW_MIN);
        }

        //control

    }
}
