package com.usdrawing.driveplease;

import java.util.Date;

public class Question {
    private String questionNumber;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    private String category;
    private String pubDate;

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer1() {
        return answer1;
    }

    public Question setAnswer1(String answer1) {
        this.answer1 = answer1;
        return this;
    }

    public String getAnswer2() {
        return answer2;
    }

    public Question setAnswer2(String answer2) {
        this.answer2 = answer2;
        return this;
    }

    public String getAnswer3() {
        return answer3;
    }

    public Question setAnswer3(String answer3) {
        this.answer3 = answer3;
        return this;
    }

    public String getAnswer4() {
        return answer4;
    }

    public Question setAnswer4(String answer4) {
        this.answer4 = answer4;
        return this;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Question setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Question setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public Question setPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public Question setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionNumber=" + questionNumber +
                ", question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", category='" + category + '\'' +
                ", pubDate=" + pubDate +
                '}';
    }
}
