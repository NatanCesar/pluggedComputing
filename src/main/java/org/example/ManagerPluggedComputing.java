package org.example;
import org.example.exceptions.EmptyQuestionsException;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;


public class ManagerPluggedComputing implements ManagerPluggedComputingInterface, Serializable {
    HashMap<Integer, Question> questionsMap;
    HashMap<Integer, User> usersMap;

    int counterIdUsers = 1;
    int counterIdQuestions = 1;

    public ManagerPluggedComputing() {
        this.questionsMap = new HashMap<>();
        this.usersMap = new HashMap<>();
    }



    /// QUESTIONS:
    @Override
    public void addQuestion(Question question) {
        this.questionsMap.put(this.counterIdQuestions,question);
        this.counterIdQuestions++;

    }

    @Override
    public void removeQuestion(int idQuestion) throws QuestionNoExistException {
        questionsMap.remove(idQuestion);
        counterIdQuestions--;
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
        usersMap.remove(idUser);
        counterIdUsers--;
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


}
