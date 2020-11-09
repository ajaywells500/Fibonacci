package com.aem.fibseries.core.fibnacbean;

public class FibnaciBean {
	private String firstNumber;
	private String secondNumber;
	private int limit;

	public String getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(String firstNumber) {
		this.firstNumber = firstNumber;
	}

	public String getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(String secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "FibBean [firstNumber=" + firstNumber + ", secondNumber=" + secondNumber + ", limit=" + limit + "]";
	}

}

