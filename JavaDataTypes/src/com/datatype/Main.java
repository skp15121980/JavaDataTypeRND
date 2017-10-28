package com.datatype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		/*
		 * boolean isNumber = DataType.isNumeric("2421341");
		 * System.out.println(isNumber);
		 * 
		 * boolean isString = DataType.isString("awewqeqe");
		 * System.out.println(isString);
		 * 
		 * boolean isValidDate = DataType.validateDateTimeFormat("1990-12-13 12:12:12");
		 * System.out.println(isValidDate);
		 */
		// System.out.println(CheckDataType.checkDataType("6767-12-13"));

		Map<String, MetaData> metadataMap = new HashMap<String, MetaData>();
		metadataMap.put("collateralId", new MetaData("collateralId", "NUMBER", 3));
		metadataMap.put("lob", new MetaData("lob", "VARCHAR", 60));
		metadataMap.put("createdDate", new MetaData("createdDate", "TIMESTAMP", 10));
		metadataMap.put("updatedDate", new MetaData("updatedDate", "DATE", 6));

		Map<String, String> metadataJson = new HashMap<String, String>();
		metadataJson.put("collateralId", "121211");
		metadataJson.put("lob", "lob");
		metadataJson.put("createdDate", "1990-12-13 12:12:12");
		metadataJson.put("updatedDate", "1990-12-13");

		Set<String> metadataJsonkeys = metadataJson.keySet();

		for (String metadataJsonkey : metadataJsonkeys) {
			MetaData metaData = metadataMap.get(metadataJsonkey);
			if (CheckDataType.checkDataType(metadataJson.get(metaData.key)).equalsIgnoreCase(metaData.getDatatype())) {
				System.out.println("the data type of this value  :" + metadataJson.get(metaData.key) + " is valid ");
			} else {
				System.out.println("the data type of this value  :" + metadataJson.get(metaData.key) + " is invalid ");
			}
		//	if (CheckDataType.checkDataType(metadataJson.get(metaData.key)).equalsIgnoreCase("VARCHAR")|| CheckDataType.checkDataType(metadataJson.get(metaData.key)).equalsIgnoreCase("NUMBER")) {
				if (metadataJson.get(metaData.key).length() <= metaData.getLength()) {
					System.out.println("the length of this value  :" + metadataJson.get(metaData.key) + " is valid ");
				} else {
					System.out.println(" the length of this value  :" + metadataJson.get(metaData.key) + " is invalid ");
				}
			}
		//}
	}
}
