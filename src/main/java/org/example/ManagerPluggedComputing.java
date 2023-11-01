package org.example;
import org.example.exceptions.EmptyQuestionsException;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import java.util.HashMap;
import java.util.Random;


public class ManagerPluggedComputing implements ManagerPluggedComputingInterface {
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
        counterIdQuestions++;
        this.questionsMap.put(this.counterIdQuestions,question);
    }

    @Override
    public void removeQuestion(int idQuestion) throws QuestionNoExistException {
        counterIdQuestions--;
        questionsMap.remove(idQuestion);
    }

    @Override
    public Question alterQuestion(int idQuestion) throws QuestionNoExistException {
        return questionsMap.get(idQuestion);
    }

    @Override
    public Question searchQuestion(int idQuestion) throws QuestionNoExistException {
        return questionsMap.get(idQuestion);
    }

    @Override
    public Question sortQuestion() throws EmptyQuestionsException {
        Random random = new Random();
        return questionsMap.get(random.nextInt(1,counterIdQuestions));
    }




    /// USERS:
    @Override
    public void addUser(User user) {
        counterIdUsers++;
        usersMap.put(this.counterIdUsers,user);

    }

    @Override
    public void removeUser(int idUser) throws UserNoExistException {
        counterIdUsers--;
        usersMap.remove(idUser);
    }

    @Override
    public User alterUser(int idUser) throws UserNoExistException {
        return usersMap.get(idUser);
    }

    @Override
    public User searchUser(int idUser) throws UserNoExistException {
        return usersMap.get(idUser);
    }


    public int getCounterIdQuestions() {
        return counterIdQuestions;
    }

    public int getCounterIdUsers() {
        return counterIdUsers;
    }

    public HashMap<Integer, Question> getQuestionsMap() {
        return questionsMap;
    }

    public void setQuestionsMap(HashMap<Integer, Question> questionsMap) {
        this.questionsMap = questionsMap;
    }

    public HashMap<Integer, User> getUsersMap() {
        return usersMap;
    }

    public void setUsersMap(HashMap<Integer, User> usersMap) {
        this.usersMap = usersMap;
    }
}
