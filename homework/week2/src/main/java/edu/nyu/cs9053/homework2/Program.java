package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 10:21 AM
 */

import java.math.BigDecimal;

public class Program{
	public static boolean isGpsLegal(String[] args){
		if(args.length > 1 && args[0].equals("gps")){
			for(int i = 1; i < args.length;i++){
				String[] splitArgs = args[i].split(",");
				if(splitArgs.length !=2) return false;
				try{
					Double.parseDouble(splitArgs[0]);
					Double.parseDouble(splitArgs[1]);
				}
				catch (NumberFormatException e){
					return false;
				}
			}
			return true;
		}
		else return false;
	}
	
	public static void gpsEncoder(String[] args){
		if(isGpsLegal(args)){
			Gps[] points = new Gps[args.length-1];
			for(int i = 1;i<args.length;i++){
				String[] splitArgs = args[i].split(",");
				points[i-1] = new Gps(Double.parseDouble(splitArgs[0]),Double.parseDouble(splitArgs[1]));
			}
			PolylineEncoder encoder = new PolylineEncoder();
			String encodedGps = encoder.encodePolyline(points);
			System.out.println(encodedGps);
		}
		else System.out.println("Invalid argument");
	}	
	
	public static boolean isAnnualLegal(String[] args){
		if(args.length == 6 && args[0].equals("interest") && args[1].equals("annual")){
			try{
				Double.parseDouble(args[2]);
				Double.parseDouble(args[3]);
				Integer.parseInt(args[4]);
				Integer.parseInt(args[5]);
			}
			catch (NumberFormatException e){
				return false;
			}
			return true;
		}
		else return false;
	}
	
	public static void annualInterest(String[] args){
		if(isAnnualLegal(args)){
			double principal = Double.parseDouble(args[2]);
			double rate = Double.parseDouble(args[3]);
			int periods = Integer.parseInt(args[4]);
			int years = Integer.parseInt(args[5]);
			CompoundInterestCalculator calculator = new CompoundInterestCalculator();
			BigDecimal interest = calculator.compoundAnnually(principal,rate,periods,years);
			System.out.println(interest);
		}
		else System.out.println("Invalid argument");
	}
	
	public static boolean isContinuousLegal(String[] args){
		if(args.length == 5 && args[0].equals("interest") && args[1].equals("continuous")){
			try{
				Double.parseDouble(args[2]);
				Double.parseDouble(args[3]);
				Integer.parseInt(args[4]);
			}
			catch(NumberFormatException e){
				return false;
			}
			return true;
		}
		else return false;
	}
	
	public static void continuousInterest(String[] args){
		if(isContinuousLegal(args)){
			Double principal = Double.parseDouble(args[2]);
			Double rate = Double.parseDouble(args[3]);
			int years = Integer.parseInt(args[4]);
			CompoundInterestCalculator calculator = new CompoundInterestCalculator();
			BigDecimal interest = calculator.continuousCompound(principal,rate,years);
			System.out.println(interest);
		}
		else System.out.println("Invalid argument");
	}
	
	public static void main(String[] args){
		if(args.length > 1){
			switch(args[0]){
				case "gps":
					gpsEncoder(args);
					break;
				case "interest":
					switch(args[1]){
						case "annual":
							annualInterest(args);
							break;
						case "continuous":
							continuousInterest(args);
							break;
						default:
							System.out.println("Invalid argument");
					}
					break;
				default:
					System.out.println("Invalid argument");
			}
		}
		else System.out.println("Invalid argument");
	}
}
