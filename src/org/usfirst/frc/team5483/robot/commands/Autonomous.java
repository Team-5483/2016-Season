
package org.usfirst.frc.team5483.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5483.robot.Robot;

public class Autonomous extends Command {

    public Autonomous() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
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
