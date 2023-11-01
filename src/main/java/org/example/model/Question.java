package org.example.model;

import java.util.List;

public class Question {
    private String header;
    private List<String> alternatives;
    private int indexCorrectQuestion;
    private TypeQuestions typeQuestion;
    private int id;

    public Question(String header, List<String> alternatives, int indexCorrectQuestion, TypeQuestions typeQuestion, int id) {
        this.header = header;
        this.alternatives = alternatives;
        this.indexCorrectQuestion = indexCorrectQuestion;
        this.typeQuestion = typeQuestion;
        this.id = id;
    }


    /// GET & SET:
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public int getIndexCorrectQuestion() {
        return indexCorrectQuestion;
    }

    public void setIndexCorrectQuestion(int indexCorrectQuestion) {
        this.indexCorrectQuestion = indexCorrectQuestion;
    }

    public TypeQuestions getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestions typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
