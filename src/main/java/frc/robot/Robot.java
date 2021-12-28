// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.spikes2212.command.drivetrains.TankDrivetrain;
import com.spikes2212.command.drivetrains.commands.DriveArcade;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    OI oi;
    DriveArcade driveArcade;
    TankDrivetrain drivetrain;

    WPI_TalonSRX leftTalonBottom;
    WPI_VictorSPX rightVictorTop;
    WPI_VictorSPX rightVictorBottom;
    WPI_VictorSPX leftVictorTop;
    SpeedControllerGroup leftSCG;
    SpeedControllerGroup rightSCG;

    @Override
    public void robotInit() {
        oi = new OI();

        int leftPortTop = 1, leftPortBottom = 3, rightPortTop = 2, rightPortBottom = 5;
        leftVictorTop = new WPI_VictorSPX(leftPortTop);
        leftTalonBottom = new WPI_TalonSRX(leftPortBottom);
        rightVictorTop = new WPI_VictorSPX(rightPortTop);
        rightVictorBottom = new WPI_VictorSPX(rightPortBottom);
        leftSCG = new SpeedControllerGroup(leftVictorTop, leftTalonBottom);
        rightSCG = new SpeedControllerGroup(rightVictorBottom, rightVictorTop);

        drivetrain = new TankDrivetrain(leftSCG, rightSCG);
        driveArcade = new DriveArcade(drivetrain, oi::getLeftY, oi::getRightX);

        drivetrain.setDefaultCommand(driveArcade);
    }

    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
