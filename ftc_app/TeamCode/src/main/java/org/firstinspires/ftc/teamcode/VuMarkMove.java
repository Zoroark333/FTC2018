package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;

/**
 * Created by Chance on 2017-12-09.
 */


@Autonomous(name="VisionDriveTest", group="Autonomous")
public class VuMarkMove extends LinearOpMode{
    Hardware robot = new Hardware(); // use the class created to define a Pushbot's hardware\
    Gamepad gamepad = new Gamepad();
    Vision vision;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        vision  = new Vision(hardwareMap);
        gamepad = new Gamepad();
        XDrive drive = new XDrive(robot);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {

            try {
                float[] data = vision.directionToTarget().getData();
                vision.

                if (data[0] > 10) {
                    telemetry.addData("whereToMove", "Left");
                    drive.drive((float) 0, (float) 0.1, (float) 0);
                } else if (data[0] < -10){
                    telemetry.addData("whereToMove", "Right");
                    drive.drive((float) 0, (float) -0.1, (float) 0);
                } else {
                    telemetry.addData("whereToMove", "Nowhere");
                    drive.drive((float) 0, (float) 0, (float) 0);

                }

            } catch (Exception e) {
                telemetry.addData("whereToMove", "Cannot Find VuMark");

            }



            telemetry.update();

        }
    }
}
