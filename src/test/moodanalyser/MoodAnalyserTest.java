package test.moodanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.moodAnalyser.MoodAnalyser;
import com.moodAnalyser.MoodAnalysisException;

public class MoodAnalyserTest {

    @Test
    public void testMoodAnalyse() throws MoodAnalyser, MoodAnalysisException {
       MoodAnalyser md = new MoodAnalyser();
        String mood = md.analyseMood("This is a sad message");
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public void testHappyMood() throws MoodAnalyser, MoodAnalysisException {
        MoodAnalyser md = new MoodAnalyser();
        String mood = md.analyseMood("This is a happy message");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMoodShouldReturnHappy()  {
        MoodAnalyser md = new MoodAnalyser(null);
        String mood = null;
        try {
            mood = md.analyseMood("This is a happy message");
        } catch (MoodAnalyser moodAnalyser) {
            moodAnalyser.printStackTrace();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenInAnyMood_Should_Return_Happy() throws MoodAnalyser, MoodAnalysisException {
        MoodAnalyser md = new MoodAnalyser();
        String mood = md.analyseMood("This is in any mood");
        Assert.assertEquals("HAPPY",mood);
    }
    @Test
    public void givenInHappy_MoodShould_ReturnSad() throws MoodAnalyser, MoodAnalysisException {
        MoodAnalyser md = new MoodAnalyser();
        String mood = md.analyseMood("This is in happy mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenNullMoodShouldThrowException() throws MoodAnalyser {
        MoodAnalyser md = new MoodAnalyser(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            md.analyseMood(null);
        } catch (Exception e) {
            Assert.assertEquals("Please enter proper message" ,e.getMessage());
        }

    }
}