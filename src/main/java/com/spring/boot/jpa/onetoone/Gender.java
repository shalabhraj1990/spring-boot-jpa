package com.spring.boot.jpa.onetoone;

public enum Gender {
	UNKNOWN(0),MALE(1), FEMALE(2),;

	private int value;

	private Gender(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
