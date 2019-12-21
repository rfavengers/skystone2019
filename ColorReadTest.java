package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaSkyStone;
import org.firstinspires.ftc.robotcore.external.tfod.TfodSkyStone;

@TeleOp(name = "ColorReadTest (Blocks to Java)", group = "")
public class ColorReadTest extends LinearOpMode {

  private VuforiaSkyStone vuforiaSkyStone;
  private TfodSkyStone tfodSkyStone;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    vuforiaSkyStone = new VuforiaSkyStone();
    tfodSkyStone = new TfodSkyStone();

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        identifiedStone = "Nostone";
        // We need Vuforia to provide TFOD with camera images.
        vuforiaSkyStone.initialize(
            "", // vuforiaLicenseKey
            VuforiaLocalizer.CameraDirection.BACK, // cameraDirection
            true, // useExtendedTracking
            true, // enableCameraMonitoring
            VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES, // cameraMonitorFeedback
            0, // dx
            0, // dy
            0, // dz
            0, // xAngle
            -90, // yAngle
            0, // zAngle
            true); // useCompetitionFieldTargetLocations
        detectStone();
        telemetry.addData("stoneDetectedIs", identifiedStone);
        telemetry.update();
      }
    }

    vuforiaSkyStone.close();
    tfodSkyStone.close();
  }

  /**
   * Describe this function...
   */
  private void detectStone() {
    tfodSkyStone.initialize(vuforiaSkyStone, 0.7F, true, true);
    for (int count = 0; count < 10; count++) {
      identifiedStone = "Nostone";
      // Init TFOD here so the object detection labels are visible
      // in the Camera Stream preview window on the Driver Station.
      tfodSkyStone.activate();
      sleep(200);
      // Get a list of recognitions from TFOD.
      recognitions = tfodSkyStone.getRecognitions();
      sleep(200);
      // If list is empty, inform the user. Otherwise, go
      // through list and display info for each recognition.
      if (recognitions.size() == 0) {
        identifiedStone = "Nostone";
        telemetry.addData("TFOD", "No items detected.");
      } else {
        index = 0;
        // Iterate through list and call a function to
        // display info for each recognized object.
        // TODO: Enter the type for variable named recognition
        for (UNKNOWN_TYPE recognition : recognitions) {
          if (recognition.getLabel().equals("Skystone")) {
            identifiedStone = "Skystone";
            telemetry.addData("Stone", "It is a Skystone");
            break;
          } else {
            identifiedStone = "Stone";
            telemetry.addData("Stone", "It is a normal stone");
            break;
          }
          // Display info.
        }
      }
    }
  }
}