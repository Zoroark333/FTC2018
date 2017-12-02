package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by njmin on 2017-12-02.
 */

@Autonomous(name="UltraSonicTest", group="Autonomous")
public class UltraSonicBetaAutonomous extends LinearOpMode {

    Hardware robot = new Hardware();

    UltrasonicSensor ultrasonicSensor = robot.hwMap.ultrasonicSensor.get("frontUltraSonic");

    @Override
    public void runOpMode() throws InterruptedException {
        //init code


    ultrasonicSensor.getUltrasonicLevel();

        telemetry.addData("ready!!!!!!", "go");
        waitForStart();
        // wait for play button pressed

        while (opModeIsActive()){

            telemetry.addData("Range", String.valueOf(ultrasonicSensor.getUltrasonicLevel()));

        }
    }
}
