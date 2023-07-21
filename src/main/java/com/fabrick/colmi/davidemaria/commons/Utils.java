package com.fabrick.colmi.davidemaria.commons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Utils {
	
	private Utils() {}
	
	public static String validateDateInput(String date) {
		return isValidDateFormat(date)? date: getCurrentDate();
	}
	
	private static String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(dateFormatter);
	}
	
    private static boolean isValidDateFormat(String input) {
        // Define the regular expression pattern for the format NNNN-NN-NN
        String pattern = "^\\d{4}-\\d{2}-\\d{2}$";
        // Create a Pattern object from the regular expression
        Pattern regex = Pattern.compile(pattern);
        // Use Matcher to check if the input string matches the pattern
        return regex.matcher(input).matches();
    }

}
