package com.lendico.repayment.service;

public interface Calculator {
	/*
	 * This Method calculate the interest of the Loan Amount
	 */
	public double getInterest(double rate, int monthday, double remainingPrincipalAmount, int yearDay);
    
	
	/* This Method calculate Annuity of Loan Amount
	 * 
	 */

	public double getAnuityamount(double rate, double principal, int duration);

	/* This Method calculate Remaining Principle of Loan Amount
	 * 
	 */
	public double getRemainingPrincipal(double principal, double annunity);

}
