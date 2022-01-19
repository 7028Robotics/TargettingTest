// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.LedCommand;
import frc.robot.subsystems.LedSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final LedSubsystem m_ledSubsystem = new LedSubsystem();

  private final LedCommand m_ledCommandBlue = new LedCommand(m_ledSubsystem, Color.kBlue);

  private final LedCommand m_ledCommandRed = new LedCommand(m_ledSubsystem, Color.kRed);

  private final LedCommand m_ledCommandOff = new LedCommand(m_ledSubsystem, Color.kBlack);

  XboxController m_driverController = new XboxController(0);

  SendableChooser<Command> m_ledchooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();

    m_ledchooser.setDefaultOption("Disabled", m_ledCommandOff);
    m_ledchooser.addOption("Red Alliance", m_ledCommandBlue);
    m_ledchooser.addOption("Blue Alliance", m_ledCommandRed);

    Shuffleboard.getTab("Led Color").add(m_ledchooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /**new JoystickButton(m_driverController, XboxController.Button.kA.value)
      .whenPressed(new LedCommand(m_ledSubsystem, Color.kGreen));

    new JoystickButton(m_driverController, XboxController.Button.kB.value)
      .whenPressed(new LedCommand(m_ledSubsystem, Color.kRed));**/
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_ledchooser.getSelected();
  }

  public Command getTeleopCommand() {
    // An ExampleCommand will run in autonomous
    return m_ledchooser.getSelected();
  }
}
