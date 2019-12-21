package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name = "TouchSensor (Blocks to Java)", group = "")
public class TouchSensor extends LinearOpMode {

  private TouchSensor RFTouchSensorAsTouchSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    RFTouchSensorAsTouchSensor = hardwareMap.touchSensor.get("RFTouchSensorAsTouchSensor");

    // Configure digital pin for input mode.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // button is pressed if value returned is LOW or false.
        if (RFTouchSensorAsTouchSensor.isPressed() == true) {
          telemetry.addData("Button", "PRESSED");
        } else {
          telemetry.addData("Button", "NOT PRESSED");
        }
        telemetry.update();
      }
    }
  }
}