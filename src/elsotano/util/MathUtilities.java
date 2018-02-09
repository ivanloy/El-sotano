package elsotano.util;

public class MathUtilities {

	public static double map(double var, double min, double max, double newMin, double newMax) {
		
		double ret = 0;
		
		if(var > max) var = max;
		else if(var < min) var = min;
		
		ret = (var - min) / (max - min); //map to 0,1
		ret *= newMax - newMin; 
		ret += newMin;
		
		return ret;
		
	}
	
}
