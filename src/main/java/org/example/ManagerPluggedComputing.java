package org.example;

import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.gravadorDeDados.gravadorDeDados;
import org.example.model.Question;
import org.example.model.User;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;



public class ManagerPluggedComputing implements ManagerPluggedComputingInterface, Serializable {
    HashMap<Integer, Question> questionsMap;
    HashMap<Integer, User> usersMap;
    gravadorDeDados gravador= new gravadorDeDados();

    int counterIdUsers = 1;
    int counterIdQuestions = 1;

    public ManagerPluggedComputing() {
        this.questionsMap = new HashMap<>();
        this.usersMap = new HashMap<>();
        recoverData();
    }



    /// QUESTIONS:
    @Override
    public void addQuestion(Question question) {
        this.questionsMap.put(this.counterIdQuestions,question);
        this.counterIdQuestions++;

    }

    @Override
    public void removeQuestion(int idQuestion) throws QuestionNoExistException {
        if (questionsMap.containsKey(idQuestion)){
            questionsMap.remove(idQuestion);

        } else {
            throw new QuestionNoExistException("Não existe nenhuma Questão com esse ID");
        }

    }

    @Override
    public Question searchQuestion(int idQuestion) throws QuestionNoExistException {
        if (this.questionsMap.containsKey(idQuestion)){
            return questionsMap.get(idQuestion);
        } else{
            throw new QuestionNoExistException("Não existe nenhuma questão com esse ID");
        }


    }





    /// USERS:
    @Override
    public void addUser(User user) {
        usersMap.put(this.counterIdUsers,user);
        counterIdUsers++;
    }

    @Override
    public void removeUser(int idUser) throws UserNoExistException {
        if (usersMap.containsKey(idUser)) {
            usersMap.remove(idUser);
        } else{
            throw new UserNoExistException("Não existe nenhum usuário com esse ID");
        }

    }
    @Override
    public User searchUser(int idUser) throws UserNoExistException {
        if (this.usersMap.containsKey(idUser)){
            return usersMap.get(idUser);
        } else{
            throw new UserNoExistException("Não existe nenhum usuário com esse ID");
        }
    }

    @Override
    public HashMap<Integer,User> filterUserName(String name) throws UserNoExistException{
        HashMap<Integer,User> usersName = new HashMap<>();
        for (User u: usersMap.values()){
            if (u.getName().toLowerCase().equals(name.toLowerCase())){
                usersName.put(u.getId(),u);
            }
        }
        if (usersName == null){
            throw new UserNoExistException("Nenhum usuário com esse nome foi encontrado.");
        } else{
            return usersName;
        }
    }
    public HashMap<Integer,User> filterUserAge(int age) throws UserNoExistException{
        HashMap<Integer,User> allUsersAge = new HashMap<>();
        for (User u: usersMap.values()){
            if (u.getAge() == age){
                allUsersAge.put(u.getId(),u);
            }
        }
        if (allUsersAge == null){
            throw new UserNoExistException("Nenhum usuário com essa idade foi encontrado.");
        } else{
            return allUsersAge;
        }

    }


    public int getCounterIdQuestions() {
        return counterIdQuestions;
    }

    public int getCounterIdUsers() {
        return counterIdUsers;
    }

    public HashMap<Integer, Question> getAllQuestions() {
        return questionsMap;
    }

    public HashMap<Integer, User> getAllUsers() {
        return usersMap;
    }

    public void recoverData(){
        try {
            this.questionsMap = gravador.recoverQuestions();
            this.counterIdQuestions = questionsMap.size() + 1;

            this.usersMap = gravador.recoverUsers();
            this.counterIdUsers = usersMap.size() + 1;

        } catch (IOException i){
            i.fillInStackTrace();
        }
    }


}
