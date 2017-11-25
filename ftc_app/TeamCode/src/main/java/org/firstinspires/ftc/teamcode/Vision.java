package org.firstinspires.ftc.teamcode;

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
 * Created by awspi on 2017-11-18.
 */

public class Vision {

    VuforiaLocalizer vuforia;
    VuforiaTrackable relicTemplate;

    public Vision(HardwareMap hardwareMap) {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id",  hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);


        parameters.vuforiaLicenseKey = "ARa90MT/////AAAAGb7390gO7UwJkV+PyPBQZdht8G6VHxOJlHE+1GCTI+Yv3vZlBCJLP3quNEiCNRcnc3jqBSJaJN/jqsHYR42i/zAmGeHzVSgZsyHZxT34Y0ZD6q0cxlE5RtwWy5fB+xTgnrVJbc6ahELytMk/gQ1gieOGzN9NraDSE6k8Bck3znVMf2q3AjeSU1yF5q3XWV78y34co1ifgjoiJ0VOefYcwNM5WHTtDWJGIsz8+21YQKRCXh0es9kj5s/zJFVKWA1+vOJXb6lQ0WA+GX4Db4/iGdFmLsXZ4aQ2VAs6s/uXuBSIulKnF55RGpdBIPXZrFdyOVRYLIg9dkrCG1mrPk/d7vi8Kobi7z3sLtYPat5Tp5t2";


        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");

        relicTrackables.activate();

    }

    public RelicRecoveryVuMark findVuMark() {


        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);




        return vuMark;

    }

    public OpenGLMatrix directionToTarget(){
        OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)relicTemplate.getListener()).getPose();

        return pose;

    }
}


