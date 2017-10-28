package com.datatype;

public class MetaData {

	String key ;
	String datatype;
	int length;
	
	public MetaData(String key, String datatype, int length) {
		super();
		this.key = key;
		this.datatype = datatype;
		this.length = length;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
}
