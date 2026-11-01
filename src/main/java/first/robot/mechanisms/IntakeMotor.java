// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.mechanisms;

import org.wpilib.command3.Command;
import org.wpilib.command3.Coroutine;
import org.wpilib.command3.Mechanism;
import org.wpilib.command3.Trigger;
import first.robot.constants.ExampleConstants;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.CANBus;

/** An example class demonstrating basic use of mechanisms and commands. */
public class IntakeMotor implements Mechanism {
  public final Trigger exampleCondition = new Trigger(() -> false);

  CANBus systemBus = new CANBus("1"); //canbus the motor is on
  private final TalonFX motor =
      new TalonFX(ExampleConstants.MotorID, systemBus); //initilizes motor and assigns the motor ID
  
  private void StopMotor (){
    motor.setVoltage(0);
  }

  public Command StopIntake () {
    return runRepeatedly(this::StopMotor).named("Stop Intake"); //when called, will run at every scheduler call
  }

  /**
   * An example command that requires this mechanism. Only one command that requires this mechanism
   * may run at a time - if a command is already running, this command will interrupt it.
   *
   * <p>This example runs indefinitely and prints a message every time it executes.
   *
   * @return An example command.
   */
  public Command MoveIntakeForward() {
    return run(coroutine -> {
          motor.setVoltage(ExampleConstants.MotorSpeed);

          coroutine.park();
        })
        .named("Intake.Roller.Intake");
  }
}
