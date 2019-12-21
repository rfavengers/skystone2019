package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "A2ProgramRedFINALDontdelete (Blocks to Java)", group = "")
public class A2ProgramRedFINALDontdelete extends LinearOpMode {

  private CRServo servoSide;
  private DcMotor mecanumFrontLeft;
  private DcMotor mecanumFrontRight;
  private DcMotor mecanumBackLeft;
  private DcMotor mecanumBackRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    servoSide = hardwareMap.crservo.get("servoSide");
    mecanumFrontLeft = hardwareMap.dcMotor.get("mecanumFrontLeft");
    mecanumFrontRight = hardwareMap.dcMotor.get("mecanumFrontRight");
    mecanumBackLeft = hardwareMap.dcMotor.get("mecanumBackLeft");
    mecanumBackRight = hardwareMap.dcMotor.get("mecanumBackRight");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      slideRight(10 + 0);
      moveBackward(57 + 1);
      slideRight(122 + 0);
      turnForFoundation(0.8 + 0);
      slideLeft(190 + 0);
      turnForFoundation(0.6 + 0);
      moveForward(190 + 1);
    }
  }

  /**
   * Describe this function...
   */
  private void turnForFoundation(double turnCount) {
    for (int count = 0; count < 1; count++) {
      i = 0.1 + 0;
      double i_inc = 0.1;
      if (0.1 > turnCount) {
        i_inc = -i_inc;
      }
      for (i = 0.1; i_inc >= 0 ? i <= turnCount : i >= turnCount; i += i_inc) {
        servoSide.setDirection(DcMotorSimple.Direction.FORWARD);
        servoSide.setPower(10);
        sleep(200);
      }
      servoSide.setPower(0);
      sleep(200);
      telemetry.addData("servopower2", servoSide.getPower());
      telemetry.update();
    }
  }

  /**
   * Describe this function...
   */
  private void moveForward(double forwardNumber) {
    i = 1 + 0;
    double i_inc2 = 1;
    if (1 > forwardNumber) {
      i_inc2 = -i_inc2;
    }
    for (i = 1; i_inc2 >= 0 ? i <= forwardNumber : i >= forwardNumber; i += i_inc2) {
      mecanumFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
      mecanumFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
      mecanumBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
      mecanumBackRight.setDirection(DcMotorSimple.Direction.FORWARD);
      mecanumFrontLeft.setPower(100);
      mecanumFrontRight.setPower(100);
      mecanumBackLeft.setPower(100);
      mecanumBackRight.setPower(100);
    }
    mecanumFrontLeft.setPower(0);
    mecanumFrontRight.setPower(0);
    mecanumBackLeft.setPower(0);
    mecanumBackRight.setPower(0);
    sleep(1000);
  }

  /**
   * Describe this function...
   */
  private void moveBackward(double forwardNumber) {
    for (int count2 = 0; count2 < 1; count2++) {
      i = 1 + 0;
      double i_inc3 = 1;
      if (1 > forwardNumber) {
        i_inc3 = -i_inc3;
      }
      for (i = 1; i_inc3 >= 0 ? i <= forwardNumber : i >= forwardNumber; i += i_inc3) {
        mecanumFrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumBackLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumFrontLeft.setPower(80);
        mecanumFrontRight.setPower(80);
        mecanumBackLeft.setPower(80);
        mecanumBackRight.setPower(80);
      }
    }
    mecanumFrontLeft.setPower(0);
    mecanumFrontRight.setPower(0);
    mecanumBackLeft.setPower(0);
    mecanumBackRight.setPower(0);
    sleep(1000);
  }

  /**
   * Describe this function...
   */
  private void slideRight(double countOfSteps) {
    for (int count3 = 0; count3 < 1; count3++) {
      i = 1 + 0;
      double i_inc4 = 1;
      if (1 > countOfSteps) {
        i_inc4 = -i_inc4;
      }
      for (i = 1; i_inc4 >= 0 ? i <= countOfSteps : i >= countOfSteps; i += i_inc4) {
        mecanumFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumBackLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumBackRight.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumFrontLeft.setPower(100);
        mecanumFrontRight.setPower(100);
        mecanumBackLeft.setPower(100);
        mecanumBackRight.setPower(100);
      }
    }
    mecanumFrontLeft.setPower(0);
    mecanumFrontRight.setPower(0);
    mecanumBackLeft.setPower(0);
    mecanumBackRight.setPower(0);
    sleep(1000);
  }

  /**
   * Describe this function...
   */
  private void slideLeft(double countOfSteps) {
    for (int count4 = 0; count4 < 1; count4++) {
      i = 1 + 0;
      double i_inc5 = 1;
      if (1 > countOfSteps) {
        i_inc5 = -i_inc5;
      }
      for (i = 1; i_inc5 >= 0 ? i <= countOfSteps : i >= countOfSteps; i += i_inc5) {
        mecanumFrontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumFrontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        mecanumBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        mecanumFrontLeft.setPower(100);
        mecanumFrontRight.setPower(100);
        mecanumBackLeft.setPower(100);
        mecanumBackRight.setPower(100);
      }
    }
    mecanumFrontLeft.setPower(0);
    mecanumFrontRight.setPower(0);
    mecanumBackLeft.setPower(0);
    mecanumBackRight.setPower(0);
    sleep(1000);
  }
}