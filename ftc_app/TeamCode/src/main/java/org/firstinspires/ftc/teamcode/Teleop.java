/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Teleop", group="TeleOp")
//@Disabled
public class Teleop extends OpMode{

    /* Declare OpMode members. */
    Hardware robot = new Hardware(); // use the class created to define a Pushbot's hardware\
    Gamepad gamepad = new Gamepad();
//    XDrive drive;
//    BallFlipper ballFlipper;
    ColourSensor leftColorSensor;
    ColourSensor rightColorSensor;
//    Arm arm;
//    ServoTest servoTest;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        gamepad = new Gamepad();
//        drive = new XDrive(robot, telemetry);
//        ballFlipper = new BallFlipper(robot, telemetry, gamepad1);
//        servoTest = new ServoTest();
        leftColorSensor = new ColourSensor(robot, telemetry, robot.leftColorSensor, "leftColorSensor");
        rightColorSensor = new ColourSensor(robot, telemetry, robot.rightColorSensor, "rightColorSensor");
//        arm = new Arm(robot, telemetry, gamepad1);

//        servoTest.init(robot ,gamepad1, telemetry);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
//        servoTest.loop();
//        drive.drive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        //flipper controls
//        ballFlipper.loop();

        //arm controls
//        arm.control();

        //color sensors

        //telemetry
//        telemetry.addData("Servo Position", "%5.2f", robot.servo.getPosition());
//        telemetry.addData("Base Position: ", "%5.2f", robot.ballBase.getPosition());
//        telemetry.addData("Flipper Position: ", "%5.2f", robot.ballFlipper.getPosition());
//        telemetry.addData("Light Level: ", robot.rightColorSensor.alpha());
//        telemetry.addData("Light Hue: ", robot.rightColorSensor.argb());
//        telemetry.addData("Red Level: ", robot.rightColorSensor.red());
//        telemetry.addData("Green Level: ", robot.rightColorSensor.green());
//        telemetry.addData("Blue Level: ", robot.rightColorSensor.blue());
//        telemetry.addData("Arm Claw: ", "%5.2f", robot.armClaw.getPosition());
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
