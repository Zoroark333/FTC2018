package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by Chance on 2017-12-09.
 */


@Autonomous(name="VisionDriveTest", group="Autonomous")
public class move2VuMark extends LinearOpMode {
    Hardware robot = new Hardware(); // use the class created to define a Pushbot's hardware\
    Gamepad gamepad = new Gamepad();
    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        gamepad = new Gamepad();
        XDrive drive = new XDrive(robot, telemetry);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "ARa90MT/////AAAAGb7390gO7UwJkV+PyPBQZdht8G6VHxOJlHE+1GCTI+Yv3vZlBCJLP3quNEiCNRcnc3jqBSJaJN/jqsHYR42i/zAmGeHzVSgZsyHZxT34Y0ZD6q0cxlE5RtwWy5fB+xTgnrVJbc6ahELytMk/gQ1gieOGzN9NraDSE6k8Bck3znVMf2q3AjeSU1yF5q3XWV78y34co1ifgjoiJ0VOefYcwNM5WHTtDWJGIsz8+21YQKRCXh0es9kj5s/zJFVKWA1+vOJXb6lQ0WA+GX4Db4/iGdFmLsXZ4aQ2VAs6s/uXuBSIulKnF55RGpdBIPXZrFdyOVRYLIg9dkrCG1mrPk/d7vi8Kobi7z3sLtYPat5Tp5t2";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        boolean a = true;
        waitForStart();
        while (opModeIsActive()) {
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
                vuMark = RelicRecoveryVuMark.from(relicTemplate);
                /**
                 * See if any of the instances of {@link relicTemplate} are currently visible.
                 * {@link RelicRecoveryVuMark} is an enum which can have the following values:
                 * UNKNOWN, LEFT, CENTER, and RIGHT. When a VuMark is visible, something other than
                 * UNKNOWN will be returned by {@link RelicRecoveryVuMark#from(VuforiaTrackable)}.
                 */

                    /* Found an instance of the template. In the actual game, you will probably
                    *   loop until this condition occurs, then move on to act accordingly depending
                    * on which VuMark was visible. */
                telemetry.addData("VuMark", "%s visible", vuMark);

                    /* For fun, we also exhibit the navigational pose. In the Relic Recovery game,
                    * it is perhaps unlikely that you will actually need to act on this pose information, but
                    * we illustrate it nevertheless, for completeness. */
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose();
                telemetry.addData("Pose", pose);

                    /* We further illustrate how to decompose the pose into useful rotational and
                    *  translational components */
                if (pose != null) {
                    VectorF trans = pose.getTranslation();
                    Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                    // Extract the X, Y, and Z components of the offset of the target relative to the robot
                    double tX = trans.get(0);
                    double tY = trans.get(1);
                    double tZ = trans.get(2);

                    // Extract the rotational components of the target relative to the robot
                    double rX = rot.firstAngle;
                    double rY = rot.secondAngle;
                    double rZ = rot.thirdAngle;
                    telemetry.addData("tX", tX);
                    telemetry.addData("tY", tY);
                    telemetry.addData("tZ", tZ);
                    telemetry.addData("rX", rX);
                    telemetry.addData("rY", rY);
                    telemetry.addData("rZ", rZ);
                    if (tX >= 10) {
                        if (tY >= 10) {
                            telemetry.addData("whereToMove", "Up Left");
                            drive.drive((float) 0.1, (float) 0.1, (float) 0);
                        } else if (tY <= -10) {
                            telemetry.addData("whereToMove", "Down Left");
                            drive.drive((float) -0.1, (float) 0.1, (float) 0);
                        } else {
                            telemetry.addData("whereToMove", "Left");
                            drive.drive((float) 0, (float) 0.1, (float) 0);
                        }
                    } else if (tX >= -10) {
                        if (tY >= 10) {
                            telemetry.addData("whereToMove", "Up Right");
                            drive.drive((float) 0.1, (float) -0.1, (float) 0);
                        } else if (tY <= -10) {
                            telemetry.addData("whereToMove", "Down Right");
                            drive.drive((float) -0.1, (float) -0.1, (float) 0);
                        } else {
                            telemetry.addData("whereToMove", "Right");
                            drive.drive((float) 0, (float) -0.1, (float) 0);
                        }
                    } else {
                        if (tY >= 10) {
                            telemetry.addData("whereToMove", "Up");
                            drive.drive((float) 0.1, (float) 0, (float) 0);
                        } else if (tY <= -10) {
                            telemetry.addData("whereToMove", "Down");
                            drive.drive((float) -0.1, (float) 0, (float) 0);
                        } else {
                            telemetry.addData("whereToMove", "Stay");
                            drive.drive((float) 0, (float) 0, (float) 0);
                            break;
                            }
                        }
                    }


                } else {
                telemetry.addData("VuMark", "not visible");
            }
            telemetry.update();
        }
    }
}