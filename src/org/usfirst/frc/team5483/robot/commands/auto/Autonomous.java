
package org.usfirst.frc.team5483.robot.commands.auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.usfirst.frc.team5483.robot.commands.CommandBase;

public class Autonomous extends CommandBase {

	private BufferedReader reader;
	private File cmdLogFile;
	private FileReader toRead;
	private double speedMultiplier =1;
	private int xMultiplier = 1;
	private boolean driveMode = false;
	private  int buttLimit = 10,timeElapsed = 0;
	
    public Autonomous() {
        requires(chassis);
    }

    protected void initialize() {

    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    protected void interrupted() {
    }
}
