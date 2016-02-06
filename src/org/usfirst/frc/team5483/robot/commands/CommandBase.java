package org.usfirst.frc.team5483.robot.commands;

import org.usfirst.frc.team5483.robot.subsystems.BCRS;
import org.usfirst.frc.team5483.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static BCRS bcrs;
	public static Chassis chassis;
	
	public CommandBase() {
        super();
    }
	
	public CommandBase(String name) {
        super(name);
    }
	
	public static void init() {
		bcrs = new BCRS();
		chassis = new Chassis();
    }
	
}
