package model;

import java.io.Serializable;

public class TheDate implements Serializable {
	int day;
	int month;
	int year;

	public TheDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public TheDate(String date) {
		String[] data = date.split("[/-]");
		this.day = Integer.parseInt(data[0]);
		this.month = Integer.parseInt(data[1]);
		this.year = Integer.parseInt(data[2]);
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

	public void setY(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "TheDate [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}
