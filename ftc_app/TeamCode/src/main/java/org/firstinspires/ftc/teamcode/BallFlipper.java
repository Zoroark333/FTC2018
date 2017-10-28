package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Jonathan on 2017-10-21.
 */

public class BallFlipper {
    Hardware robot;
    Telemetry telemetry;

    public static final double SERVO_BASE_STOWED = 1;
    public static final double SERVO_BASE_EXTENDED = 0.15;
    public static final double SERVO_FLIPPER_STOWED = 0.5;
    public static final double SERVO_FLIPPER_MID = 0.5;
    public static final double SERVO_FLIPPER_LEFT = 0.33;
    public static final double SERVO_FLIPPER_RIGHT = 0.75;

    public BallFlipper(Hardware memeware, Telemetry telemetry) {
        robot = memeware;
        this.telemetry = telemetry;

        //Ball Remover Servos
        robot.ballBase = robot.hwMap.servo.get("ballBase");
        robot.ballFlipper = robot.hwMap.servo.get("ballFlipper");
    }

    public void moveTo(double servoBase, double servoFlipper) {
        robot.ballBase.setPosition(servoBase);
        robot.ballFlipper.setPosition(servoFlipper);
    }

    public void stow() {
        moveTo(SERVO_BASE_STOWED, SERVO_FLIPPER_STOWED);
    }

    public void extend() {
        moveTo(SERVO_BASE_EXTENDED, SERVO_FLIPPER_MID);
    }

    public void flip(boolean direction) {
        if(direction) {
            moveTo(SERVO_BASE_EXTENDED, SERVO_FLIPPER_RIGHT);
        } else {
            moveTo(SERVO_BASE_EXTENDED, SERVO_FLIPPER_LEFT);
        }
    }
}
