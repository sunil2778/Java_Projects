package com.lendico.repayment.util;

import java.text.DecimalFormat;

public   class DataFormatter {
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public  static String getFormattedNumber(double input) {
		return df2.format(input);
	}

	public static String getEuroAppender(String input) {
		 return input.concat("€");
	}
	
	public static String getRemover(String input) {
		 return input.replace("€", "");
	}
}
