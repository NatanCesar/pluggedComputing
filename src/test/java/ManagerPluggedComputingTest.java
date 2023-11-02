import com.sun.source.tree.AssertTree;
import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;
import org.example.exceptions.QuestionNoExistException;
import org.example.exceptions.UserNoExistException;
import org.example.model.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class ManagerPluggedComputingTest {

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
        User user = new User("Natan", 20,"Graduando",manager.getCounterIdUsers());
        manager.addUser(user);
        assertTrue(manager.getAllUsers().size() == 1);
        try {
            assertTrue(manager.searchUser(user.getId()).getIdade() == 20);
        }catch (UserNoExistException u){
            fail();
        }

        User user2 = new User("Natan", 23,"Graduando",manager.getCounterIdUsers());
        manager.addUser(user2);
        assertTrue(manager.getAllUsers().size() == 2);
        try {
            assertTrue(manager.searchUser(2).getIdade() == 23);
        }catch (UserNoExistException u){
            fail();
        }
    }
    @Test
    public void testRemoveUser() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        User user = new User("Natan", 20,"Graduando",manager.getCounterIdUsers());
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
            assertTrue(manager.searchUser(1).getIdade() == 20);
        } catch (UserNoExistException u){
            fail();
        }

    }
    @Test
    public void testAlterUser() {
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        User user = new User("Natan", 20,"Graduando",manager.getCounterIdUsers());
        manager.addUser(user);
        try {
            assertTrue(manager.searchUser(1).getNome() == "Natan");
            manager.searchUser(1).setNome("Ayla");
            assertTrue(manager.searchUser(1).getNome() == "Ayla");
        }catch (UserNoExistException a){
            fail();
        }
    }

}

