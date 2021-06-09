package model;

import java.util.StringTokenizer;

public class Date {
	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Date() {
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	// get curent date
	public Date currrentDate() {
		String date =java.time.LocalDate.now().toString();
		StringTokenizer tokenizer = new StringTokenizer(date, "-");
		this.year=Integer.parseInt(tokenizer.nextToken());
		this.month=Integer.parseInt(tokenizer.nextToken());
		this.day=Integer.parseInt(tokenizer.nextToken());
		return this;
	}
	public Date convertFormatDate(String d) {
		StringTokenizer tokenizer = new StringTokenizer(d, "-");
		this.year=Integer.parseInt(tokenizer.nextToken());
		this.month=Integer.parseInt(tokenizer.nextToken());
		this.day=Integer.parseInt(tokenizer.nextToken());
		return this;
	}
	
	@Override
	public String toString() {
		return day + "-" + month + "-" + year;
	}
	public String toStringToDB() {
		return year + "-" + month + "-" +day ;
	}
	
	
}
