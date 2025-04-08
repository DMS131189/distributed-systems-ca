/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package education;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Iterator;
import education.AITutorOuterClass.GenerateQuizRequest;
import education.AITutorOuterClass.GetTopicsRequest;
import education.AITutorOuterClass.GetTopicsResponse;
import education.AITutorOuterClass.QuizQuestion;


public class AITutorClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        AITutorGrpc.AITutorBlockingStub stub = AITutorGrpc.newBlockingStub(channel);

        // Example: Get topics
        GetTopicsResponse topics = stub.getTopics(
            GetTopicsRequest.newBuilder().setApiKey("secure123").build());
        
        System.out.println("Available Topics:");
        topics.getTopicsList().forEach(topic -> 
            System.out.println(topic.getId() + ": " + topic.getTitle()));

        // Example: Get Math quiz
        System.out.println("\nMath Quiz:");
        Iterator<QuizQuestion> questions = stub.generateQuiz(
            GenerateQuizRequest.newBuilder()
                .setExpression("1")
                .setApiKey("secure123")
                .build());
        
        while (questions.hasNext()) {
            QuizQuestion question = questions.next();
            System.out.println("\nQ: " + question.getQuestion());
            System.out.println("Options: " + question.getOptionsList());
        }

        channel.shutdown();
    }
}