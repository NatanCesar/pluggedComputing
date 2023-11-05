package org.example.model;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String header;
    private List<String> alternatives;
    private int indexCorrectQuestion;
    private TypeQuestions typeQuestion;
    private int id;
    private int quantityCorrectAnswers;
    private int quantityWrongAnswers;
    private int quantityAnswers;

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

    public int getQuantityCorrectAnswers() {
        return quantityCorrectAnswers;
    }

    public void addCorrectAnsewrs() {
        this.quantityCorrectAnswers++;
        this.quantityAnswers++;
    }
    public int getQuantityWrongAnswers() {
        return quantityWrongAnswers;
    }

    public void addWrongAnswers() {
        this.quantityAnswers++;
        this.quantityWrongAnswers++;
    }

    public int getQuantityAnswers() {
        return quantityAnswers;
    }


    @Override
    public String toString() {
        return "\n\nID: " + id + "\n" + header + ".\nAlternativas: " + alternatives + "\nTipo da questão: " +
                typeQuestion + "\nTotal de respostas: " + quantityAnswers + ", Corretas: " + quantityCorrectAnswers
                + ", Erradas: " + quantityWrongAnswers;
    }
    public String showQuestion(){
        String alternativesString = "";
        for (int i = 1; i <= this.alternatives.size(); i++){
            alternativesString += ("\n" + i + " - " + this.getAlternatives().get(i-1));
        }
        return header + "\n" + alternativesString;
    }
}
