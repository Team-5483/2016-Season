package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;
import org.usfirst.frc.team5483.robot.utils.CommandLogger;
public class DefaultDrive extends Command {
	
	private CommandLogger cmd_log;
	
	private double speedMultiplier =1;
	private int xMultiplier = 1;
	private boolean driveMode = false;
	
	public DefaultDrive() {
		cmd_log= new CommandLogger();
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
    	double x = IO.getPrimaryControllerLeftStickX() * speedMultiplier * xMultiplier;
    	double y =  -IO.getPrimaryControllerRightStickY() * speedMultiplier;
    	
    	cmd_log.logCommand(Double.toString(x)+','+Double.toString(y)+"\n");
    	
    	Robot.chassis.drive(x,y);
    	
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