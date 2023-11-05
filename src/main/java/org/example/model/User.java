package org.example.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String educationDegree;
    private String actualInstitution;
    private String email;
    private int id;
    private int quantityCorrectAnsewrs;
    private int quantityWrongAnsewrs;
    private int quantityAnsewrs;


    public User(String name, int age, String educationDegree, String actualInstitution, String email, int id) {
        this.name = name;
        this.age = age;
        this.educationDegree = educationDegree;
        this.actualInstitution = actualInstitution;
        this.email = email;
        this.id = id;
    }



    /// GET & SET:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getActualInstitution() {
        return actualInstitution;
    }

    public void setActualInstitution(String actualInstitution) {
        this.actualInstitution = actualInstitution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityCorrectAnsewrs() {
        return quantityCorrectAnsewrs;
    }

    public void setQuantityCorrectAnsewrs(int quantityCorrectAnsewrs) {
        this.quantityCorrectAnsewrs = quantityCorrectAnsewrs;
    }

    public int getQuantityWrongAnsewrs() {
        return quantityWrongAnsewrs;
    }

    public void setQuantityWrongAnsewrs(int quantityWrongAnsewrs) {
        this.quantityWrongAnsewrs = quantityWrongAnsewrs;
    }

    public int getQuantityAnsewrs() {
        return quantityAnsewrs;
    }

    public void setQuantityAnsewrs(int quantityAnsewrs) {
        this.quantityAnsewrs = quantityAnsewrs;
    }
    ///

    public void addCorrectAnsewrs() {
        this.quantityCorrectAnsewrs++;
        this.quantityAnsewrs++;
    }
    public void addWrongAnsewrs() {
        this.quantityWrongAnsewrs++;
        this.quantityAnsewrs++;
    }

    @Override
    public String toString() {
        return "\n\nID: " + id + ", nome: " + name + ", " + age + " anos" + ", email: " + email +"\nGrau de escolaridade: " + educationDegree + ", Instituição atual de ensino: " +
                actualInstitution + "\nQuantidade de perguntas respondidas: " + quantityAnsewrs + ", corretas: " + quantityCorrectAnsewrs
                + ", erradas: " + quantityWrongAnsewrs;
    }
}
