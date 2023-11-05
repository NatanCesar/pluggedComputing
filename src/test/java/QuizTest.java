import org.example.ManagerPluggedComputing;
import org.example.ManagerPluggedComputingInterface;
import org.example.model.Question;
import org.example.model.TypeQuestions;
import org.example.model.User;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class QuizTest {

    @Test
    public void QuestionTest(){
        ManagerPluggedComputingInterface manager = new ManagerPluggedComputing();
        /// create question
        List<String> ansewrs = new ArrayList<>(List.of("7", "3", "4","8","10"));
        Question question = new Question("Qual número é primo?",ansewrs,1, TypeQuestions.MULTIPLE_CHOICE,manager.getCounterIdQuestions());
        manager.addQuestion(question);

        /// create user
        User user = new User("Natan", 20,"Graduando","UFPB","natan.br",manager.getCounterIdUsers());
        manager.addUser(user);


        // test user
        assertTrue(user.getQuantityAnsewrs() == 0);
        assertTrue(user.getQuantityCorrectAnsewrs() == 0);
        user.addWrongAnsewrs();
        assertTrue(user.getQuantityWrongAnsewrs() == 1);
        assertTrue(user.getQuantityAnsewrs() == 1);

        // test question
        assertTrue(question.getQuantityAnswers() == 0);
        assertTrue(question.getQuantityCorrectAnswers() == 0);
        question.addCorrectAnsewrs();
        assertTrue(question.getQuantityAnswers() == 1);
        assertTrue(question.getQuantityCorrectAnswers() == 1);


    }
}
