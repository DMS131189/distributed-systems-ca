/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package education;

import education.AITutorOuterClass.*;
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
                        .build(),
                QuizQuestion.newBuilder()
                        .setQuestion("What is the chemical symbol for gold?")
                        .addAllOptions(Arrays.asList("Au", "Ag", "Fe"))
                        .setCorrectAnswer("Au")
                        .build()
        );
        TOPIC_QUIZZES.put("2", scienceQuestions);

        // History Questions
        List<QuizQuestion> historyQuestions = Arrays.asList(
                QuizQuestion.newBuilder()
                        .setQuestion("In which year did World War II end?")
                        .addAllOptions(Arrays.asList("1945", "1939", "1941"))
                        .setCorrectAnswer("1945")
                        .build(),
                QuizQuestion.newBuilder()
                        .setQuestion("Who was the first president of the United States?")
                        .addAllOptions(Arrays.asList("George Washington", "Thomas Jefferson", "Abraham Lincoln"))
                        .setCorrectAnswer("George Washington")
                        .build()
        );
        TOPIC_QUIZZES.put("3", historyQuestions);
    }
    
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
            .addTopics(Topic.newBuilder().setId("3").setTitle("History").build())
            .build();
        
        // set the return value
        responseObserver.onNext(response);
        // finishing the service reponse
        responseObserver.onCompleted();
    }

    @Override
    public void generateQuiz(GenerateQuizRequest request, StreamObserver<QuizQuestion> responseObserver) {
        List<QuizQuestion> questions = TOPIC_QUIZZES.get("1");
        
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

    @Override
    public StreamObserver<AnswerRequest> submitAnswers(StreamObserver<QuizResultResponse> responseObserver) {
        return new StreamObserver<AnswerRequest>() {
            private final List<AnswerRequest> answers = new ArrayList<>();
            private int score = 0;
            private int totalQuestions = 0;

            @Override
            public void onNext(AnswerRequest answer) {
                answers.add(answer);
                // In a real implementation, you would validate the answer against the correct one
                // For simplicity, we'll just count all answers as correct in this example
                score++;
                totalQuestions++;
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in submitAnswers: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                QuizResultResponse response = QuizResultResponse.newBuilder()
                        .setScore(score)
                        .setFeedback(String.format("You scored %d out of %d", score, totalQuestions))
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    /*@Override
    public StreamObserver<ChatMessage> tutorChat(StreamObserver<ChatMessage> responseObserver) {
        return new StreamObserver<ChatMessage>() {
            @Override
            public void onNext(ChatMessage message) {
                String userMessage = message.getContent().toLowerCase();
                String responseText;

                if (userMessage.contains("hello") || userMessage.contains("hi")) {
                    responseText = "Hello! I'm your AI Tutor. How can I help you today?";
                } else if (userMessage.contains("math")) {
                    responseText = "For math help, I can explain concepts or provide practice problems. What topic?";
                } else if (userMessage.contains("science")) {
                    responseText = "I can help with various science topics. What specifically are you studying?";
                } else if (userMessage.contains("history")) {
                    responseText = "History is fascinating! What period or event are you interested in?";
                } else if (userMessage.contains("help")) {
                    responseText = "I can assist with:\n- Math problems\n- Science concepts\n- Historical facts\nWhat do you need?";
                } else {
                    responseText = "I'm here to help with your studies. Could you be more specific about what you need?";
                }

                ChatMessage reply = ChatMessage.newBuilder()
                        .setSender("AI Tutor")
                        .setContent(responseText)
                        .build();

                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in tutorChat: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }*/
}