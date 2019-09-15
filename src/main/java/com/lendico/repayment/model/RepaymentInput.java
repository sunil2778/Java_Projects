package com.lendico.repayment.model;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

public class RepaymentInput {
	@ApiModelProperty(notes  = "Duration of RePayment",name = "duration", required = true)
	@Positive(message = "Duration can not be negative or Zero")
	
	public int duration;
	@ApiModelProperty(notes = "Loan  Amount" , name ="loanAmount", required = true )
	@Positive(message = "loanAmount can not be negative or Zero")
	public double loanAmount;
	@ApiModelProperty(notes = "Rate", name = "nominalRate", required = true)
	@Positive(message = "nominalRate can not be negative or Zero")
	public double nominalRate;
	@ApiModelProperty(notes = "Start date of the Loan", name = "startDate", required = true)
	//public String startDate;
	
	public LocalDate startDate;
	public RepaymentInput(int duration, double loanAmount, double nominalRate, LocalDate startDate) {
		super();
		this.duration = duration;
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.startDate = startDate;
	}
	public RepaymentInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getNominalRate() {
		return nominalRate;
	}
	public void setNominalRate(double nominalRate) {
		this.nominalRate = nominalRate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	

}
