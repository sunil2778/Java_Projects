package com.lendico.repayment.service;

import org.springframework.stereotype.Service;



@Service
public class RepaymentCalculator implements Calculator{

	public double getInterest(double rate, int monthday, double remainingPrincipalAmount, int yearDay) {
        
      
		return ((rate * monthday * remainingPrincipalAmount) / yearDay);

	}

	/*
	 * public double getPrincipal(double annunity, double intrest) { return
	 * (annunity - intrest); }
	 */
	
	public double getPrincipal(double annunity, double intrest) { 
		
		Principal princpal =(a,b)->a-b;
		
		return princpal.getPrincipal(annunity, intrest);
	}
	public double getAnuityamount(double rate, double principal, int duration) {

		rate = rate / 12;
		return ((rate * principal) / (1 - Math.pow(1 + rate, -duration)));
	}

	/*
	 * public double getRemainingPrincipal(double principal, double annunity) {
	 * return principal - annunity; }
	 */

	public double getRemainingPrincipal(double principal, double annunity) {
		Principal remainigPrincipal= (a,b)->a-b;
		return remainigPrincipal.getPrincipal(principal, annunity);
	}
	
}