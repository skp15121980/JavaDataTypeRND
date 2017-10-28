package com.datatype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class DataType {
	
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
	
	public static boolean isString(String s) {
		return s.chars().allMatch(Character::isLetter);
	}
	
	public static boolean validateDateTimeFormat(String stringToValidate){
	    String sdf = "yyyy-MM-dd HH:mm:ss";
	    SimpleDateFormat format=new SimpleDateFormat(sdf);   
	    String dateFormat = "[12]{1,1}[0-9]{3,3}-(([0]{0,1}[1-9]{1,1})|([1]{0,1}[0-2]{1,1}))-(([0-2]{0,1}[1-9]{1,1})|([3]{0,1}[01]{1,1}))[ ](([01]{0,1}[0-9]{1,1})|([2]{0,1}[0-3]{1,1}))((([:][0-5]{0,1}[0-9]{0,1})|([:][0-5]{0,1}[0-9]{0,1}))){0,2}";
	    boolean isPassed = false;

	    isPassed = (stringToValidate.matches(dateFormat)) ? true : false;


	    if (isPassed){
	        // digits are correct. Now, check that the date itself is correct
	        // correct the date format to the full date format
	        String correctDate = correctDateFormat(stringToValidate);
	        try
	        {
	            Date d = format.parse(correctDate);
	            isPassed = (correctDate.equals(new SimpleDateFormat(sdf).format(d))) ? true : false;
	            System.out.println("In = " + correctDate + "; Out = " 
	                    + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d) + " equals = " 
	                    + (correctDate.equals(new SimpleDateFormat(sdf).format(d))));
	            // check that are date is less than current
	            if (!isPassed || d.after(new Date())) {
	                System.out.println(new SimpleDateFormat(sdf).format(d) + " is after current day " 
	                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	                isPassed = false;
	            } else {
	                isPassed = true;
	            }
	        } catch (ParseException e) {
	            System.out.println(correctDate + " Exception! " + e.getMessage());
	            isPassed = false;
	        }
	    } else {
	        return false;
	    }
	    return isPassed;
	}

	/**
	 *  method to fill up the values that are not full, like 2 hours -> 02 hours
	 *  to avoid undesirable difference when we will compare original date with parsed date with SimpleDateFormat
	 */
	private static String correctDateFormat(String stringToValidate) {
	    String correctDate = "";
	    StringTokenizer stringTokens = new StringTokenizer(stringToValidate, "-" + " " + ":", false);
	    List<String> tokens = new ArrayList<>();
	    System.out.println("Inside of recognizer");
	    while (stringTokens.hasMoreTokens()) {
	        String token = stringTokens.nextToken();
	        tokens.add(token);
	        // for debug
	        System.out.print(token + "|");
	    }
	    for (int i=0; i<tokens.size(); i++){
	        if (tokens.get(i).length() % 2 != 0){
	            String element = tokens.get(i);
	            element = "0" + element;
	            tokens.set(i, element);
	        }
	    }
	    // build a correct final string
	    // 6 elements in the date: yyyy-MM-dd hh:mm:ss
	    // come through and add mandatory 2 elements
	    for (int i=0; i<2; i++){
	        correctDate = correctDate + tokens.get(i) + "-";
	    }
	    // add mandatory 3rd (dd) and 4th elements (hh)
	    correctDate = correctDate + tokens.get(2) + " " + tokens.get(3);
	    if (tokens.size() == 4){
	        correctDate = correctDate + ":00:00";
	    } else if (tokens.size() == 5){
	        correctDate = correctDate + ":" + tokens.get(4) + ":00";
	    } else if (tokens.size() == 6){
	        correctDate = correctDate + ":" + tokens.get(4) + ":" + tokens.get(5);
	    }  

	    System.out.println("The full correct date format is " + correctDate);
	    return correctDate;
	}
	
	public static boolean isDateCorrect(String dateString) {
	    try {
	    	SimpleDateFormat mDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = mDateFormatter.parse(dateString);
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        return matchesDatePattern(dateString);    //added my method
	    }
	    catch (ParseException e) {
	        return false;
	    }
	}

	/**
	 * This will check if the provided string matches our date format
	 * @param dateString
	 * @return true if the passed string matches format 2014-1-15 (YYYY-MM-dd)
	 */
	private static boolean matchesDatePattern(String dateString) {
	    return dateString.matches("^\\d+\\-\\d+\\-\\d+");
	}
	
	public static boolean isThisDateValid(String dateToValidate, String dateFromat){

		if(dateToValidate == null){
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}
}
