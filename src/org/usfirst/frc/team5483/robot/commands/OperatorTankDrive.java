package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;

public class OperatorTankDrive extends Command {
	
	private double BUMPER_SPEED = .5;
	private boolean TANK_DRIVE_MODE = true;
	
    public OperatorTankDrive() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (IO.isPrimaryRBButtonPressed())
        {
    		Robot.chassis.tankDrive(BUMPER_SPEED, -BUMPER_SPEED);
        }
        
        else if (IO.isPrimaryLBButtonPressed())
        {
        	Robot.chassis.tankDrive(-BUMPER_SPEED, BUMPER_SPEED);
        }
        
        else if (TANK_DRIVE_MODE)
        {
        	Robot.chassis.tankDrive(IO.getPrimaryControllerLeftStickY() * BUMPER_SPEED, IO.getPrimaryControllerRightStickY() * BUMPER_SPEED);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}