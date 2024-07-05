package com.se.tests.smoke;

import com.se.rolesbase.StudentLoginBase;
import com.se.utils.UtilsSet;
import com.se.config.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentAccountTest extends StudentLoginBase {

    @Test
    public void VerifyTestResult() {

        UtilsSet.clickOnElement(Constants.Dashboard.BY_ThreeDots);

        UtilsSet.clickOnElement(Constants.Dashboard.BY_ExamsButton);


        String actualTitle = UtilsSet.getElementText(Constants.Exams.BY_ExamTitle);
        String actualDuration = UtilsSet.getElementText(Constants.Exams.BY_ExamDuration);
        String actualExaminer = UtilsSet.getElementText(Constants.Exams.BY_Examiner);
        String actualCourse = UtilsSet.getElementText(Constants.Exams.BY_Course);
        String actualStartTime = UtilsSet.getElementText(Constants.Exams.BY_StartTime);



        Assert.assertEquals(actualDuration, "Exam Closed");
        Assert.assertEquals(actualStartTime, "4/26/2024, 9:45:03 AM");
        Assert.assertEquals(actualExaminer, "Mukhtiar Zamin");
        Assert.assertEquals(actualTitle, "Quiz 1 SP24");
        Assert.assertEquals(actualCourse, "Software Testing");
    }

    @Test
    public void VerifyTestQuestion() {

        UtilsSet.clickOnElement(Constants.Dashboard.BY_Quiz1);

        int numberOfMCQs = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_MCQs));
        int numberOfTrueFalse = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_TrueFalseQuestions));
        int numberOfFillInTheBlanks = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_FillInTheBlanks));
        int numberOfShortQuestions = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_ShortQuestions));

        int calculatedTotalquestions = numberOfMCQs +
                numberOfTrueFalse+
                numberOfFillInTheBlanks +
                numberOfShortQuestions;

        int expectedTotalMarks = Integer.parseInt(UtilsSet.getElementText(Constants.ExamSummary.BY_TotalMarks));

        Assert.assertEquals(calculatedTotalquestions, expectedTotalMarks, "The calculated total marks do not match the expected total marks.");

        Assert.assertEquals(numberOfMCQs, 7);
        Assert.assertEquals(numberOfTrueFalse, 9);
        Assert.assertEquals(numberOfFillInTheBlanks, 0);
        Assert.assertEquals(numberOfShortQuestions, 0);
    }

}
