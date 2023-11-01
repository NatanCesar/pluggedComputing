package org.example.model;

public class User {
    private String nome;
    private int idade;
    private String grauEscolaridade;
    private String insistuicaoAtual;
    private String email;
    private int id;


    public User(String nome, int idade, String grauEscolaridade, int id) {
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.id = id;
    }

    public User(String nome, int idade, String grauEscolaridade, String insistuicaoAtual, int id) {
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.insistuicaoAtual = insistuicaoAtual;
        this.id = id;
    }

    public User(String nome, int idade, String grauEscolaridade, String insistuicaoAtual, String email, int id) {
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.insistuicaoAtual = insistuicaoAtual;
        this.email = email;
        this.id = id;
    }



    /// GET & SET:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public String getInsistuicaoAtual() {
        return insistuicaoAtual;
    }

    public void setInsistuicaoAtual(String insistuicaoAtual) {
        this.insistuicaoAtual = insistuicaoAtual;
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
}
