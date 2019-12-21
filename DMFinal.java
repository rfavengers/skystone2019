package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "DMFinal (Blocks to Java)", group = "")
public class DMFinal extends LinearOpMode {

  private DcMotor mecanumFrontRight;
  private DcMotor mecanumBackRight;
  private DcMotor mecanumFrontLeft;
  private DcMotor mecanumBackLeft;
  private DcMotor clawMotorUp;
  private CRServo servoSide;
  private CRServo servoUpClaw;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    mecanumFrontRight = hardwareMap.dcMotor.get("mecanumFrontRight");
    mecanumBackRight = hardwareMap.dcMotor.get("mecanumBackRight");
    mecanumFrontLeft = hardwareMap.dcMotor.get("mecanumFrontLeft");
    mecanumBackLeft = hardwareMap.dcMotor.get("mecanumBackLeft");
    clawMotorUp = hardwareMap.dcMotor.get("clawMotorUp");
    servoSide = hardwareMap.crservo.get("servoSide");
    servoUpClaw = hardwareMap.crservo.get("servoUpClaw");

    // Put initialization blocks here.
    mecanumFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    mecanumBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
    mecanumFrontRight.setPower(0);
    mecanumFrontLeft.setPower(0);
    mecanumBackLeft.setPower(0);
    mecanumBackRight.setPower(0);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        Vertical = gamepad1.right_stick_y;
        Horizontal = -gamepad1.right_stick_x;
        Pivit = -gamepad1.left_stick_x;
        mecanumFrontRight.setPower(-Pivit + (Vertical - Horizontal));
        mecanumBackRight.setPower(-Pivit + Vertical + Horizontal);
        mecanumFrontLeft.setPower(Vertical + Horizontal);
        mecanumBackLeft.setPower(Vertical - Horizontal);
        telemetry.addData("Front", -Pivit + (Vertical - Horizontal));
        telemetry.addData("Back", Pivit + Vertical + Horizontal);
        // Put loop blocks here.
        telemetry.update();
        clawMotorUp.setDirection(DcMotorSimple.Direction.FORWARD);
        clawMotorUp.setPower(gamepad2.left_stick_y);
        if (clawMotorUp.isBusy()) {
          clawMotorUp.setPower(0);
        }
        if (false) {
        }
        servoSide.setDirection(DcMotorSimple.Direction.FORWARD);
        servoSide.setPower(gamepad1.left_trigger);
        servoUpClaw.setDirection(DcMotorSimple.Direction.FORWARD);
        servoUpClaw.setPower(gamepad2.left_trigger);
      }
    }
  }
}