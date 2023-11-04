package org.example;

import org.example.exceptions.EmptyQuestionsException;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public interface ManagerPluggedComputingInterface extends Serializable {

        void addQuestion(Question question);
        void removeQuestion(int idQuestion) throws QuestionNoExistException;
        Question searchQuestion(int idQuestion) throws QuestionNoExistException;
        HashMap<Integer, Question> getAllQuestions();

        void addUser(User user);
        void removeUser(int idUser) throws UserNoExistException;
        User searchUser(int idUser) throws UserNoExistException;
        HashMap<Integer,User> filterUserName(String name) throws UserNoExistException;
        HashMap<Integer,User> filterUserAge(int age) throws UserNoExistException;
        HashMap<Integer, User> getAllUsers();

        int getCounterIdUsers();
        int getCounterIdQuestions();

}
