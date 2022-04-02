package com.example.genii;

public class CardModel {

    private int id;
    private String question;
    private String answer;

    public CardModel(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
