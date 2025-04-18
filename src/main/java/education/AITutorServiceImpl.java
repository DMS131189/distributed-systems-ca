package education;

import education.AITutorOuterClass.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AITutorServiceImpl extends AITutorGrpc.AITutorImplBase {
    private static final Logger logger = LoggerFactory.getLogger(AITutorServiceImpl.class);
    private static final Map<String, List<QuizQuestion>> TOPIC_QUIZZES = new HashMap<>();
    private static final String API_KEY = "sk-grpc-4a9f9e1b2c3d4e5f6a7b8c9d0e1f2a3b";

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
        if (!API_KEY.equals(request.getApiKey())) {
            logger.error("Invalid API key in getTopics request.");
            responseObserver.onError(Status.PERMISSION_DENIED.asRuntimeException());
            return;
        }

        logger.info("getTopics request received.");

        GetTopicsResponse response = GetTopicsResponse.newBuilder()
                .addTopics(Topic.newBuilder().setId("1").setTitle("Math").build())
                .addTopics(Topic.newBuilder().setId("2").setTitle("Science").build())
                .addTopics(Topic.newBuilder().setId("3").setTitle("History").build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generateQuiz(GenerateQuizRequest request, StreamObserver<QuizQuestion> responseObserver) {
        if (!API_KEY.equals(request.getApiKey())) {
            logger.error("Invalid API key in generateQuiz request.");
            responseObserver.onError(Status.PERMISSION_DENIED.asRuntimeException());
            return;
        }

        logger.info("generateQuiz request received for topic: {}", request.getExpression());

        List<QuizQuestion> questions = TOPIC_QUIZZES.getOrDefault(request.getExpression(), Collections.emptyList());

        for (QuizQuestion question : questions) {
            responseObserver.onNext(question);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Thread interrupted during quiz generation.", e);
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
                score++;
                totalQuestions++;
                logger.info("Received answer for question: {}", answer.getQuestionId());
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error in submitAnswers", t);
            }

            @Override
            public void onCompleted() {
                logger.info("All answers received. Total: {}, Score: {}", totalQuestions, score);
                QuizResultResponse response = QuizResultResponse.newBuilder()
                        .setScore(score)
                        .setFeedback(String.format("You scored %d out of %d", score, totalQuestions))
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<ChatMessage> tutorChat(StreamObserver<ChatMessage> responseObserver) {
        return new StreamObserver<ChatMessage>() {
            @Override
            public void onNext(ChatMessage message) {
                logger.info("Received chat message: {}", message.getContent());

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
                logger.error("Error in tutorChat", t);
            }

            @Override
            public void onCompleted() {
                logger.info("Chat session completed.");
                responseObserver.onCompleted();
            }
        };
    }
}
