/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package education;

import education.AITutorOuterClass.GenerateQuizRequest;
import education.AITutorOuterClass.GetTopicsRequest;
import education.AITutorOuterClass.GetTopicsResponse;
import education.AITutorOuterClass.QuizQuestion;
import education.AITutorOuterClass.Topic;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.*;

public class AITutorServiceImpl extends AITutorGrpc.AITutorImplBase {
    private static final Map<String, List<QuizQuestion>> TOPIC_QUIZZES = new HashMap<>();
    private static final String API_KEY = "secure123";

    static {
        // Math Questions
        List<QuizQuestion> mathQuestions = Arrays.asList(
            QuizQuestion.newBuilder()
                .setQuestion("What is 2 + 2?")
                .addAllOptions(Arrays.asList("3", "4", "5"))
                .setCorrectAnswer("4")
                .build(),
            QuizQuestion.newBuilder()
                .setQuestion("What is 3 × 7?")
                .addAllOptions(Arrays.asList("21", "24", "28"))
                .setCorrectAnswer("21")
                .build()
        );
        TOPIC_QUIZZES.put("1", mathQuestions);

        // Science Questions
        List<QuizQuestion> scienceQuestions = Arrays.asList(
            QuizQuestion.newBuilder()
                .setQuestion("What is H₂O?")
                .addAllOptions(Arrays.asList("Water", "Salt", "Oxygen"))
                .setCorrectAnswer("Water")
                .build()
        );
        TOPIC_QUIZZES.put("2", scienceQuestions);
    }

    /**
     * Purpuse: return by refence
     * @param request
     * @param responseObserver 
     */
    
    // (1) retornar diretamente o que vc precisa
    // public List<Topics> getTopics() {}
    
    // (2) retornar ou responder por referênia / devolver por referência / alterar por referência
    /*public void getTopics(T param) {
        param.response = "";
        param.setResponse("");
        param.callback();
        // e outros exemplos possíveis
    }*/
    
    @Override
    public void getTopics(GetTopicsRequest request, StreamObserver<GetTopicsResponse> responseObserver) {
        if (!request.getApiKey().equals(API_KEY)) {
            // handling error when API key is not correct
            responseObserver.onError(Status.PERMISSION_DENIED.asRuntimeException());
            return;
        }

        GetTopicsResponse response = GetTopicsResponse.newBuilder()
            .addTopics(Topic.newBuilder().setId("1").setTitle("Math").build())
            .addTopics(Topic.newBuilder().setId("2").setTitle("Science").build())
            .build();
        
        // set the return value
        responseObserver.onNext(response);
        // finishing the service reponse
        responseObserver.onCompleted();
    }

    @Override
    public void generateQuiz(GenerateQuizRequest request, StreamObserver<QuizQuestion> responseObserver) {
        List<QuizQuestion> questions = TOPIC_QUIZZES.getOrDefault(request.getExpression(), Collections.emptyList());
        
        for (QuizQuestion question : questions) {
            responseObserver.onNext(question);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        responseObserver.onCompleted();
    }

    // Implement other methods (setTopic, submitAnswers, tutorChat) similarly
}