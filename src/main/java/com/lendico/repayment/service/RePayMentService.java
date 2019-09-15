package com.lendico.repayment.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendico.repayment.model.Repayment;
import com.lendico.repayment.model.RepaymentInput;
import com.lendico.repayment.util.DataFormatter;

import java.time.temporal.ChronoUnit;

@Service
public class RePayMentService {

	@Autowired

	private RepaymentCalculator recalc;

	public List<Repayment> getRepayments(RepaymentInput repay) {


		List<Repayment> repayList = new ArrayList<Repayment>();

		double rate = repay.getNominalRate() / 100;
		int duration = repay.getDuration();
		LocalDate nextDate = repay.getStartDate();
		double principal = repay.getLoanAmount();
		int i = 1;

		double annuity = recalc.getAnuityamount(rate, principal, duration);
		do {
			Repayment output = new Repayment();
			output.setDate(nextDate);
			output.setBorrowerPaymentAmount(DataFormatter.getEuroAppender(DataFormatter.getFormattedNumber(annuity)));
			output.setInterest(DataFormatter
					.getEuroAppender(DataFormatter.getFormattedNumber(recalc.getInterest(rate, 30, principal, 360))));
			output.setPrincipal(DataFormatter.getEuroAppender(DataFormatter.getFormattedNumber(
					recalc.getPrincipal(annuity, Double.valueOf(DataFormatter.getRemover(output.getInterest()))))));

			output.setInitialOutstandingPrincipal(
					DataFormatter.getEuroAppender(DataFormatter.getFormattedNumber(principal)));
			output.setRemainingOutstandingPrincipal(DataFormatter.getEuroAppender(
					DataFormatter.getFormattedNumber(recalc.getRemainingPrincipal(principal, annuity))));
			if (Double.valueOf(DataFormatter.getRemover(output.getPrincipal())) > Double
					.valueOf(DataFormatter.getRemover(output.getInitialOutstandingPrincipal()))) {
				output.setPrincipal(DataFormatter.getEuroAppender(DataFormatter.getFormattedNumber(
						Double.valueOf(DataFormatter.getRemover(output.getInitialOutstandingPrincipal()))
						- Double.valueOf(DataFormatter.getRemover(output.getInterest())))));
				output.setRemainingOutstandingPrincipal(DataFormatter.getEuroAppender(DataFormatter.getFormattedNumber(0.0)));
				output.setBorrowerPaymentAmount(output.getInitialOutstandingPrincipal());
			}
			repayList.add(output);
			principal = Double.valueOf(DataFormatter.getRemover(output.getRemainingOutstandingPrincipal()));

			nextDate = nextDate.plus(1, ChronoUnit.MONTHS);
			
			i++;

		} while (i < duration + 1);

		return repayList;

	}

}
