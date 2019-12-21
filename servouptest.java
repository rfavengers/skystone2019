package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "servouptest (Blocks to Java)", group = "")
public class servouptest extends LinearOpMode {

  private CRServo servoupAsCRServo;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    servoupAsCRServo = hardwareMap.crservo.get("servoupAsCRServo");

    // Reverse one of the drive motors.
    servoupAsCRServo.setDirection(DcMotorSimple.Direction.FORWARD);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        // Use left stick to drive and right stick to turn
        servoupAsCRServo.setPower(25);
      }
    }
  }
}