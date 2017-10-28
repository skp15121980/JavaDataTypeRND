package com.datatype;

public class CheckDataType {

	public static String checkDataType(String stringToBeCheck) {
		
		if(DataType.isNumeric(stringToBeCheck))
		{
			return "NUMBER";
		} else if (DataType.isString(stringToBeCheck)) {
			return "VARCHAR";
		}else if (DataType.validateDateTimeFormat(stringToBeCheck)) {
			return "TIMESTAMP";
		}else if (DataType.isThisDateValid(stringToBeCheck,"yyyy-MM-dd")) {
			return "DATE";
		}
		return "Invalid Data Type";
	}
	
}
