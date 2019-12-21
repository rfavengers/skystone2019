
package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "colorDistanceSensor (Blocks to Java)", group = "")
public class colorDistanceSensor extends LinearOpMode {

  private DistanceSensor rfDistancsSensorAsDistanceSensor;
  private ColorSensor RFColorSensorAsColorSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    rfDistancsSensorAsDistanceSensor = hardwareMap.get(DistanceSensor.class, "rfDistancsSensorAsDistanceSensor");
    RFColorSensorAsColorSensor = hardwareMap.colorSensor.get("RFColorSensorAsColorSensor");

    // This op mode demonstrates the color and distance features of the REV sensor.
    telemetry.addData("Color Distance Example", "Press start to continue...");
    telemetry.update();
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Display distance info.
        telemetry.addData("Dist to tgt (cm)", rfDistancsSensorAsDistanceSensor.getDistance(DistanceUnit.INCH));
        telemetry.update();
        sleep(20000);
      }
    }
  }
}