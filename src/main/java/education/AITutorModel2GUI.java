/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package education;

/**
 *
 * @author deyse
 */
/*public class AITutorModel2GUI {

    /**
     * @param args the command line arguments
     * /
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}*/


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

import education.AITutorOuterClass.GenerateQuizRequest;
import education.AITutorOuterClass.GetTopicsRequest;
import education.AITutorOuterClass.GetTopicsResponse;
import education.AITutorOuterClass.SetTopicResponse;
import education.AITutorOuterClass.SetTopicRequest;
import education.AITutorOuterClass.QuizQuestion;
import education.AITutorOuterClass.Topic;

public class AITutorModel2GUI {
    private static AITutorGrpc.AITutorBlockingStub stub;

    public static void main(String[] args) {
        // Setup gRPC connection
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();
        stub = AITutorGrpc.newBlockingStub(channel);

        // Create GUI
        JFrame frame = new JFrame("AI Tutor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JButton btnMath = new JButton("Start Math Quiz");
        btnMath.addActionListener(e -> startQuiz("1"));

        frame.add(btnMath, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void startQuiz(String topicId) {
        Iterator<QuizQuestion> questions = stub.generateQuiz(
            GenerateQuizRequest.newBuilder()
                .setExpression(topicId)
                .setApiKey("secure123")
                .build());
        
        while (questions.hasNext()) {
            QuizQuestion question = questions.next();
            String answer = JOptionPane.showInputDialog(
                null, 
                question.getQuestion() + "\n\nOptions: " + question.getOptionsList());
            
            if (answer != null && answer.equals(question.getCorrectAnswer())) {
                JOptionPane.showMessageDialog(null, "Correct!");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect! The answer was: " + 
                    question.getCorrectAnswer());
            }
        }
    }
}