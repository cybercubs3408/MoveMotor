// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import org.wpilib.opmode.OpMode;
import org.wpilib.opmode.Teleop;
import org.wpilib.command3.button.CommandXboxController;
import first.robot.mechanisms.IntakeMotor;

@Teleop
public class ExampleTeleop implements OpMode {
  public ExampleTeleop(Robot robot) {
    robot.exampleController.rightStick().whileTrue(robot.exampleMechanism.exampleCommand());

    CommandXboxController driverController0 = new CommandXboxController(0);

    driverController0.a().whileTrue(robot.IntakeMotor.MoveIntakeForward());
  }
}
