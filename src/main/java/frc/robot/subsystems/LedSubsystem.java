// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LedSubsystem extends SubsystemBase {

  AddressableLED m_led;
  AddressableLEDBuffer m_ledBuffer;

  int m_rainbowFirstPixelHue;
  

  void startLed() {
    m_led = new AddressableLED(9);

    m_ledBuffer = new AddressableLEDBuffer(60);
    m_led.setLength(m_ledBuffer.getLength());

    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  void setLedColor(Color ledcolor) {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {

      m_ledBuffer.setLED(i, ledcolor);
    }

    m_rainbowFirstPixelHue += 3;

    m_rainbowFirstPixelHue %= 180;
  }

  public void init(Color color) {
    setLedColor(color);

    m_led.setData(m_ledBuffer);
  }

  /** Creates a new ExampleSubsystem. */
  public LedSubsystem() {
    startLed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
