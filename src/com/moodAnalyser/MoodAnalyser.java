package com.moodAnalyser;

public class MoodAnalyser extends Throwable {

    String message;

    public MoodAnalyser(String message) {
        this.message=message;

    }

    public MoodAnalyser() {

    }
       String MoodAnalyser(){
        return "SAD";
       }

    public String analyseMood(String message) throws MoodAnalyser, MoodAnalysisException {
        try {
          if (message.length()==0)
              throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please enter proper message");
            if (message.contains("SAD"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please enter proper message");
        }
    }
}