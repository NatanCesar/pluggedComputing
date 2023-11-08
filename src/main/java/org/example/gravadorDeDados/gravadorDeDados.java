package org.example.gravadorDeDados;

import org.example.model.Question;
import org.example.model.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class gravadorDeDados {
    public static final String FILE_QUESTIONS = "questions.dat";
    public static final String FILE_USERS = "users.dat";



    /// RECOVER QUESTIONS
    public HashMap<Integer, Question> recoverQuestions() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(FILE_QUESTIONS));
            return (HashMap<Integer, Question>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar as questões");
            throw new IOException("Não foi possível recuperar as questões do arquivo: "+ FILE_QUESTIONS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }
    public void saveQuestions(Map<Integer, Question> questions) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILE_QUESTIONS));
            out.writeObject(questions);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar as questões no arquivo "+ FILE_QUESTIONS);
        }
    }





    /// RECOVER USERS
    public HashMap<Integer, User> recoverUsers() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(FILE_USERS));
            return (HashMap<Integer, User>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os usuários");
            throw new IOException("Não foi possível recuperar os usuários do arquivo: "+ FILE_QUESTIONS);

        } finally {
            if (in!=null){
                in.close();
            }
        }
    }
    public void saveUsers(Map<Integer, User> users) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILE_USERS));
            out.writeObject(users);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os usuários no arquivo "+ FILE_QUESTIONS);
        }
    }
}
