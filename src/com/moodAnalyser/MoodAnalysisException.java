package com.moodAnalyser;

public class MoodAnalysisException extends Exception {

	public enum ExceptionType {
		ENTERED_NULL, ENTERED_EMPTY;
	}

	ExceptionType type;

	public MoodAnalysisException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}