package com.lendico.repayment.service;

@FunctionalInterface
public interface Principal {
	
	/* This Method calculate Principle of Loan Amount and remainingPrincipal Amount
	 * 
	 */
	public double getPrincipal(double annunity, double intrest);

}
