package org.example.model;

import java.util.List;

public class Question {
    private String header;
    private List<String> alternatives;
    private int indexCorrectQuestion;
    private TypeQuestions typeQuestion;
    private int id;
    private int quantityCorrectAnsewrs;
    private int quantityWrongAnsewrs;
    private int quantityAnsewrs;

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
        return this.id;
    }

    public int getQuantityCorrectAnsewrs() {
        return quantityCorrectAnsewrs;
    }

    public void addCorrectAnsewrs(int quantityCorrectAnsewrs) {
        this.quantityCorrectAnsewrs = quantityCorrectAnsewrs + 1;
    }

    public int getQuantityWrongAnsewrs() {
        return quantityWrongAnsewrs;
    }

    public void addWrongAnsewrs(int quantityWrongAnsewrs) {
        this.quantityWrongAnsewrs++;
    }

    public int getQuantityAnsewrs() {
        return quantityAnsewrs;
    }

    public void addQuantityAnsewrs(int quantityAnsewrs) {
        this.quantityAnsewrs++;
    }

    @Override
    public String toString() {
        return "\n\nID: " + id + "\n" + header + ".\nAlternativas: " + alternatives + "\nTipo da questão: " +
                typeQuestion + "\nTotal de respostas: " + quantityAnsewrs + ", Corretas: " + quantityCorrectAnsewrs
                + ", Erradas: " + quantityWrongAnsewrs;
    }
}
