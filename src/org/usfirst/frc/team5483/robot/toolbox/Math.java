package org.usfirst.frc.team5483.robot.toolbox;

public class Math {
	
	public static double squareMaintainSign(double val) {
        double output = val * val;
        
        if(val < 0) {
            output = -output;
        }
        
        return output;
    }
	
	public static double limitValue(double val) {
        return limitValue(val, 1.0);
    }
    
    public static double limitValue(double val, double max) {
        if(val > max) {
            return max;
        } else if(val < -max) {
            return -max;
        } else {
            return val;
        }
    }
	
	public static double calcLeftDrive(double x, double y) {
        return limitValue(y + x);
    }
    
    public static double calcRightDrive(double x, double y) {
        return limitValue(y - x);
    }
}
