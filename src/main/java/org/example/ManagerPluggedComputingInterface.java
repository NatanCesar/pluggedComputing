package org.example;

import org.example.exceptions.EmptyQuestionsException;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.Question;
import org.example.model.User;

import java.io.Serializable;


public interface ManagerPluggedComputingInterface extends Serializable {

        void addQuestion(Question question);
        void removeQuestion(int idQuestion) throws QuestionNoExistException;
        Question alterQuestion(int idQuestion) throws QuestionNoExistException;
        Question searchQuestion(int idQuestion) throws QuestionNoExistException;
        Question sortQuestion() throws EmptyQuestionsException;


        void addUser(User user);
        void removeUser(int idUser) throws UserNoExistException;
        User alterUser(int idUser) throws UserNoExistException;
        User searchUser(int idUser) throws UserNoExistException;


        int getCounterIdUsers();
        int getCounterIdQuestions();

}
