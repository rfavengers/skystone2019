package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "YYYY (Blocks to Java)", group = "")
public class YYYY extends LinearOpMode {

  private DcMotor mecanumFrontLeft;
  private DcMotor mecanumFrontRight;
  private DcMotor mecanumBackLeft;
  private DcMotor mecanumBackRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    mecanumFrontLeft = hardwareMap.dcMotor.get("mecanumFrontLeft");
    mecanumFrontRight = hardwareMap.dcMotor.get("mecanumFrontRight");
    mecanumBackLeft = hardwareMap.dcMotor.get("mecanumBackLeft");
    mecanumBackRight = hardwareMap.dcMotor.get("mecanumBackRight");

    // Reverse one of the drive motors.
    // You will have to determine which motor to reverse for your robot.
    // In this example, the right motor was reversed so that positive
    // applied power makes it move the robot in the forward direction.
    mecanumFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    // You will have to determine which motor to reverse for your robot.
    // In this example, the right motor was reversed so that positive
    // applied power makes it move the robot in the forward direction.
    mecanumFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
    mecanumBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    mecanumBackRight.setDirection(DcMotorSimple.Direction.FORWARD);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      for (i = 1; i <= 170; i++) {
        // The Y axis of a joystick ranges from -1 in its topmost position
        // to +1 in its bottommost position. We negate this value so that
        // the topmost position corresponds to maximum forward power.
        mecanumFrontLeft.setPower(100);
        mecanumFrontRight.setPower(100);
        // The Y axis of a joystick ranges from -1 in its topmost position
        // to +1 in its bottommost position. We negate this value so that
        // the topmost position corresponds to maximum forward power.
        mecanumBackLeft.setPower(100);
        mecanumBackRight.setPower(100);
        // Put loop blocks here.
        // Use left stick to drive and right stick to turn
      }
      telemetry.addData("Left Pow", mecanumFrontLeft.getPower());
      telemetry.addData("Right Pow", mecanumFrontRight.getPower());
      telemetry.update();
    }
  }
}