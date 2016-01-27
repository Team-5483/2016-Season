package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;

public class DefaultDrive extends Command {
	
	private double speedMultiplier =1;
	private int xMultiplier = 1;
	private boolean driveMode = false;
	
	public DefaultDrive() {
        requires(Robot.chassis);
    }
	
	//LIAM, I LEFT FOR TPM, KEEP LAPTOP SAFE BOI, I CANT MLG NOSCOPE WITHOUT IT
	//I WILL BE BACK IN 2 HOURS, IF NEEDED USE MY CHARGER CABLE IN MY BAG
	//GLHF -EVAN (XXX_MLG_NO_SCOOPER)p.s you suck dick
	
	//thx m9 mai u live u quikscope another day

    protected void initialize() {
    	
    }
    int buttLimit = 10,timeElapsed = 0;
    //heheheee
    protected void execute() {
    	if(timeElapsed < buttLimit) {
    		timeElapsed++;
    	}
    	
    	if(IO.isPrimaryAButtonPressed() && timeElapsed >= buttLimit) {
    		driveMode = !driveMode;
    		xMultiplier*=-1;
    		timeElapsed = 0;
    	}
    	Robot.chassis.drive(IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier, -IO.getPrimaryControllerRightStickY() * speedMultiplier);
    	//if(!driveMode) Robot.chassis.drive(IO.getPrimaryControllerLeftStickX() * speedMultiplier, IO.getPrimaryControllerRightStickY() * speedMultiplier);
    	//else Robot.chassis.drive(IO.getPrimaryControllerLeftStickX() * speedMultiplier, IO.getPrimaryControllerRightStickY() * speedMultiplier);
    
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