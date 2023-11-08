import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.gravadorDeDados.gravadorDeDados;
import org.example.model.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ManagerPluggedComputingTest {

    @BeforeEach
    public void deleteFiles(){
        File fd = new File(gravadorDeDados.FILE_QUESTIONS);
        File fr = new File(gravadorDeDados.FILE_USERS);
        if (fr.exists() && fd.exists() ){
            fr.delete();
            fd.delete();
        }
    }

    /// QUESTIONS TEST:
    @Test
    public void testAddQuestion() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        List<String> ansewrs = new ArrayList<>(List.of("7", "3", "4","8","10"));
        Question q = new Question("Qual número é primo?",ansewrs,1, TypeQuestions.MULTIPLE_CHOICE,manager.getCounterIdQuestions());
        manager.addQuestion(q);

        assertTrue(manager.getAllQuestions().size() == 1);
        try {
            assertTrue(manager.searchQuestion(q.getId()).getAlternatives() == ansewrs);
        }catch (QuestionNoExistException a){
            fail();
        }

        Question q2 = new Question("Qual número é multiplo de 5?",ansewrs,5, TypeQuestions.MULTIPLE_CHOICE,manager.getCounterIdQuestions());
        manager.addQuestion(q2);
        assertTrue(manager.getAllQuestions().size() == 2);
        try {
            assertTrue(manager.searchQuestion(2).getAlternatives() == ansewrs);
        }catch (QuestionNoExistException a){
            fail();
        }
    }
    @Test
    public void testRemoveQuestion() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        List<String> ansewrs = new ArrayList<>(List.of("7", "3", "4", "8", "10"));
        Question q = new Question("Qual número é primo?", ansewrs, 1, TypeQuestions.MULTIPLE_CHOICE, manager.getCounterIdQuestions());
        manager.addQuestion(q);

        assertTrue(manager.getAllQuestions().size() == 1);
        try {
            manager.removeQuestion(1);
            assertTrue(manager.getAllQuestions().size() == 0);
        } catch (QuestionNoExistException a){
            fail();
        }

    }
        @Test
        public void testAlterQuestion() {
            ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
            List<String> ansewrs = new ArrayList<>(List.of("7", "3", "4","8","10"));
            Question q = new Question("Qual número é primo?",ansewrs,1, TypeQuestions.MULTIPLE_CHOICE,manager.getCounterIdQuestions());
            manager.addQuestion(q);
            try {
                assertTrue(manager.searchQuestion(1).getTypeQuestion() == TypeQuestions.MULTIPLE_CHOICE);
                manager.searchQuestion(q.getId()).setTypeQuestion(TypeQuestions.DISCURSIVE);
                assertTrue(manager.searchQuestion(1).getTypeQuestion() == TypeQuestions.DISCURSIVE);
            }catch (QuestionNoExistException a){
                fail();
            }
        }



    /// USERS TEST:
    @Test
    public void testAddUser() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        User user = new User("Natan", 20,"Graduando","UFPB","natan.br",manager.getCounterIdUsers());
        manager.addUser(user);
        assertTrue(manager.getAllUsers().size() == 1);
        try {
            assertTrue(manager.searchUser(user.getId()).getAge() == 20);
        }catch (UserNoExistException u){
            fail();
        }

        User user2 = new User("Natan", 23,"Graduando","UFPB","natan.br",manager.getCounterIdUsers());
        manager.addUser(user2);
        assertTrue(manager.getAllUsers().size() == 2);
        try {
            assertTrue(manager.searchUser(2).getAge() == 23);
        }catch (UserNoExistException u){
            fail();
        }
    }
    @Test
    public void testRemoveUser() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        User user = new User("Natan", 20,"Graduando","UFPB","natan.br",manager.getCounterIdUsers());
        manager.addUser(user);
        assertTrue(manager.getAllUsers().size() == 1);
        try {
            manager.removeUser(1);
            assertTrue(manager.getAllUsers().size() == 0);
        } catch (UserNoExistException u){
            fail();
        }
        try {
            manager.addUser(user);;
            assertTrue(manager.getAllUsers().size() == 1);
            assertTrue(manager.searchUser(1).getAge() == 20);
        } catch (UserNoExistException u){
            fail();
        }

    }
    @Test
    public void testAlterUser() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        User user = new User("Natan", 20,"Graduando","UFPB","natan.br",manager.getCounterIdUsers());
        manager.addUser(user);
        try {
            assertTrue(manager.searchUser(1).getName() == "Natan");
            manager.searchUser(1).setName("Ayla");
            assertTrue(manager.searchUser(1).getName() == "Ayla");
        }catch (UserNoExistException a){
            fail();
        }
    }

}

