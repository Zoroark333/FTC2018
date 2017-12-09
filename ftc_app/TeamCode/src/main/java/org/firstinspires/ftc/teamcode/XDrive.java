package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Created by Jonathan on 2017-10-14.
 */

public class XDrive {
    Hardware robot;
    Telemetry telemetry;



    public XDrive(Hardware robot, Telemetry telemetry) {
        this.robot = robot;
        this.telemetry = telemetry;

        //Define Motors
        this.robot.leftFrontDriveMotor = robot.hwMap.dcMotor.get("leftFrontDriveMotor");
        this.robot.rightFrontDriveMotor = robot.hwMap.dcMotor.get("rightFrontDriveMotor");
        this.robot.leftRearDriveMotor = robot.hwMap.dcMotor.get("leftRearDriveMotor");
        this.robot.rightRearDriveMotor = robot.hwMap.dcMotor.get("rightRearDriveMotor");

        //Set Motor Directions
        this.robot.leftRearDriveMotor.setDirection(REVERSE);
        this.robot.rightRearDriveMotor.setDirection(REVERSE);
    }

    public void drive(Float forwardBack, Float leftRight, Float rotation) {
//        robot.leftFrontDriveMotor.setPower(forwardBack - leftRight - rotation);
//        robot.rightFrontDriveMotor.setPower(-forwardBack - leftRight - rotation);
//        robot.leftRearDriveMotor.setPower(-forwardBack - leftRight + rotation);
//        robot.rightRearDriveMotor.setPower(forwardBack - leftRight + rotation);

        robot.leftFrontDriveMotor.setPower(-forwardBack - leftRight - rotation);
        robot.rightFrontDriveMotor.setPower(forwardBack - leftRight - rotation);
        robot.leftRearDriveMotor.setPower(forwardBack - leftRight + rotation);
        robot.rightRearDriveMotor.setPower(-forwardBack - leftRight + rotation);

//        telemetry.addData("leftFront: ", robot.leftFrontDriveMotor.getPower());
//        telemetry.addData("rightFront: ", robot.rightFrontDriveMotor.getPower());
//        telemetry.addData("leftRear: ", robot.leftRearDriveMotor.getPower());
//        telemetry.addData("rightRear: ", robot.rightRearDriveMotor.getPower());
//        telemetry.addData("forward-back stick: ", forwardBack);
//        telemetry.addData("left-right stick: ", leftRight);
//        telemetry.addData("rotation stick: ", rotation);
//        telemetry.update();
    }
}
