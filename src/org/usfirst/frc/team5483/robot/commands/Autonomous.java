
package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5483.robot.IO;
import org.usfirst.frc.team5483.robot.Robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Autonomous extends Command {

	private BufferedReader reader;
	private File cmdLogFile;
	private FileReader toRead;
	private double speedMultiplier =1;
	private int xMultiplier = 1;
	private boolean driveMode = false;
	private  int buttLimit = 10,timeElapsed = 0;
	
    public Autonomous() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    	cmdLogFile = new File("media/sda1/cmdlog.txt");
    	
    	try {
			toRead = new FileReader(cmdLogFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	reader = new BufferedReader(toRead);
    }

    protected void execute() {
    	if(timeElapsed < buttLimit) {
    		timeElapsed++;
    	}
    	String cmd="";
    	try {
			cmd = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	double x = Double.valueOf(cmd.substring(0, cmd.indexOf(",")-1));
    	double y = Double.valueOf(cmd.substring(cmd.indexOf(","+1), cmd.length()-1));
    	
    	Robot.chassis.drive(x,y);
    }

    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
