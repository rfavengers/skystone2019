package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "DRAGFOUNDATION (Blocks to Java)", group = "")
public class DRAGFOUNDATION extends LinearOpMode {

  private CRServo servoSide;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    servoSide = hardwareMap.crservo.get("servoSide");

    // Reverse one of the drive motors.
    waitForStart();
    if (opModeIsActive()) {
      turnForFoundation();
      sleep(1000);
    }
  }

  /**
   * Describe this function...
   */
  private void turnForFoundation() {
    for (int count = 0; count < 15; count++) {
      i = 0.1 + 0;
      for (i = 0.1; i <= 1; i += 0.1) {
        servoSide.setDirection(DcMotorSimple.Direction.FORWARD);
        servoSide.setPower(100);
      }
      telemetry.addData("servopower2", servoSide.getPower());
      telemetry.update();
    }
  }
}