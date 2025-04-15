package education;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.util.Iterator;


import education.AITutorOuterClass.*;

public class AITutorGUI extends JFrame {
    private static AITutorGrpc.AITutorBlockingStub blockingStub;
    private static AITutorGrpc.AITutorStub asyncStub;
    private JTextArea chatArea;
    private JTextField chatInput;
    private StreamObserver<ChatMessage> chatRequestObserver;

    public static void main(String[] args) {
        // Setup gRPC connection
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        blockingStub = AITutorGrpc.newBlockingStub(channel);
        asyncStub = AITutorGrpc.newStub(channel);

        SwingUtilities.invokeLater(() -> new AITutorGUI().setVisible(true));
    }

    public AITutorGUI() {
        setTitle("AI Tutor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // Welcome panel
        JPanel welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.add(new JLabel("<html><h1>Welcome to AI Tutor</h1><p>Select a topic to start learning:</p></html>"),
                BorderLayout.NORTH);

        // Get available topics
        GetTopicsResponse topics = blockingStub.getTopics(
                GetTopicsRequest.newBuilder().setApiKey("secure123").build());

        JPanel topicPanel = new JPanel(new GridLayout(0, 1));
        for (Topic topic : topics.getTopicsList()) {
            JButton topicBtn = new JButton(topic.getId() + ". " + topic.getTitle());
            topicBtn.addActionListener(e -> startQuiz(topic.getId()));
            topicPanel.add(topicBtn);
        }

        // Chat button
        JButton chatBtn = new JButton("Start Chat with Tutor");
        chatBtn.addActionListener(e -> showChatWindow());

        welcomePanel.add(topicPanel, BorderLayout.CENTER);
        welcomePanel.add(chatBtn, BorderLayout.SOUTH);

        add(welcomePanel, BorderLayout.CENTER);
    }

//    private void startQuiz(String topicId) {
//        JFrame quizFrame = new JFrame("Quiz");
//        quizFrame.setSize(400, 300);
//        quizFrame.setLayout(new BorderLayout());
//
//        JTextArea questionArea = new JTextArea();
//        questionArea.setEditable(false);
//        quizFrame.add(new JScrollPane(questionArea), BorderLayout.CENTER);
//
//        JPanel optionsPanel = new JPanel(new GridLayout(0, 1));
//        quizFrame.add(optionsPanel, BorderLayout.SOUTH);
//
//        Iterator<QuizQuestion> questions = blockingStub.generateQuiz(
//                GenerateQuizRequest.newBuilder()
//                        .setExpression(topicId)
//                        .setApiKey("secure123")
//                        .build());
//
//        /*new Thread(() -> {*/
//            while (questions.hasNext()) {
//                QuizQuestion question = questions.next();
//                //SwingUtilities.invokeLater(() -> {
//                    questionArea.setText(question.getQuestion());
//                    optionsPanel.removeAll();
//
//                    for (String option : question.getOptionsList()) {
//                        JButton optionBtn = new JButton(option);
//                        // TODO: neste ponto, quando escolher a opção correta, deve seguir para a próxima questão
//                        optionBtn.addActionListener(e -> {
//                            boolean correct = option.equals(question.getCorrectAnswer());
//                            JOptionPane.showMessageDialog(quizFrame,
//                                    correct ? "Correct!" : "Incorrect! The right answer is: " + question.getCorrectAnswer());
//                        });
//                        optionsPanel.add(optionBtn);
//                    }
//
//                    optionsPanel.revalidate();
//                    optionsPanel.repaint();
//                //});
//
//                /*try {
//                    Thread.sleep(3000); // Wait for user to answer
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }*/
//            }
//
//            /*SwingUtilities.invokeLater(() -> {
//                JOptionPane.showMessageDialog(quizFrame, "Quiz completed!");
//                quizFrame.dispose();
//            });
//        }).start();*/
//
//
//        quizFrame.setVisible(true);
//
//        // JOptionPane.showMessageDialog(quizFrame, "Quiz completed!");
//        // quizFrame.dispose();
//    }
private void startQuiz(String topicId) {
    JFrame quizFrame = new JFrame("Quiz");
    quizFrame.setSize(500, 400);
    quizFrame.setLayout(new BorderLayout());
    quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JTextArea questionArea = new JTextArea();
    questionArea.setEditable(false);
    questionArea.setLineWrap(true);
    questionArea.setWrapStyleWord(true);
    questionArea.setFont(new Font("Arial", Font.PLAIN, 16));

    JPanel optionsPanel = new JPanel();
    optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(new JScrollPane(questionArea), BorderLayout.CENTER);
    mainPanel.add(optionsPanel, BorderLayout.SOUTH);
    quizFrame.add(mainPanel, BorderLayout.CENTER);

    JButton nextButton = new JButton("Next Question");
    nextButton.setEnabled(false);
    quizFrame.add(nextButton, BorderLayout.SOUTH);

    Iterator<QuizQuestion> questions = blockingStub.generateQuiz(
            GenerateQuizRequest.newBuilder()
                    .setExpression(topicId)
                    .setApiKey("secure123")
                    .build());

    // Substitui AtomicInteger por um array simples
    final int[] score = {0};
    final int[] totalQuestions = {0};

    nextButton.addActionListener(e -> {
        if (questions.hasNext()) {
            showNextQuestion(questions.next(), questionArea, optionsPanel, nextButton, score);
        } else {
            JOptionPane.showMessageDialog(quizFrame,
                    "Quiz completed!\nYour score: " + score[0] + "/" + totalQuestions[0]);
            quizFrame.dispose();
        }
    });

    if (questions.hasNext()) {
        totalQuestions[0] = getQuestionCount(topicId); // Novo método para contar questões
        showNextQuestion(questions.next(), questionArea, optionsPanel, nextButton, score);
    }

    quizFrame.setVisible(true);
}

    // Novo método para contar questões
    private int getQuestionCount(String topicId) {
        switch(topicId) {
            case "1": return 2; // Math
            case "2": return 2; // Science
            case "3": return 2; // History
            default: return 0;
        }
    }

    private void showNextQuestion(QuizQuestion question, JTextArea questionArea,
                                  JPanel optionsPanel, JButton nextButton, int[] score) {
        questionArea.setText(question.getQuestion());
        optionsPanel.removeAll();

        for (String option : question.getOptionsList()) {
            JButton optionBtn = new JButton(option);
            optionBtn.addActionListener(e -> {
                boolean correct = option.equals(question.getCorrectAnswer());
                if (correct) {
                    score[0]++; // Incrementa a pontuação
                    JOptionPane.showMessageDialog(optionsPanel, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(optionsPanel,
                            "Incorrect! The correct answer is: " + question.getCorrectAnswer(),
                            "Result", JOptionPane.ERROR_MESSAGE);
                }
                for (Component comp : optionsPanel.getComponents()) {
                    comp.setEnabled(false);
                }
                nextButton.setEnabled(true);
            });
            optionsPanel.add(optionBtn);
        }

        nextButton.setEnabled(false);
        optionsPanel.revalidate();
        optionsPanel.repaint();
    }



    private void showChatWindow() {
        JFrame chatFrame = new JFrame("AI Tutor Chat");
        chatFrame.setSize(500, 400);
        chatFrame.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatFrame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        chatInput = new JTextField();
        JButton sendBtn = new JButton("Send");

        inputPanel.add(chatInput, BorderLayout.CENTER);
        inputPanel.add(sendBtn, BorderLayout.EAST);
        chatFrame.add(inputPanel, BorderLayout.SOUTH);

        // Setup bi-directional streaming
        chatRequestObserver = asyncStub.tutorChat(new StreamObserver<ChatMessage>() {
            @Override
            public void onNext(ChatMessage message) {
                SwingUtilities.invokeLater(() -> {
                    chatArea.append(message.getSender() + ": " + message.getContent() + "\n");
                });
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> {
                    chatArea.append("Error in chat: " + t.getMessage() + "\n");
                });
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> {
                    chatArea.append("Chat ended by server\n");
                });
            }
        });

        sendBtn.addActionListener(e -> sendChatMessage());
        chatInput.addActionListener(e -> sendChatMessage());

        chatFrame.setVisible(true);
    }

    private void sendChatMessage() {
        String message = chatInput.getText();
        if (!message.isEmpty()) {
            chatArea.append("You: " + message + "\n");
            chatRequestObserver.onNext(ChatMessage.newBuilder()
                    .setSender("User")
                    .setContent(message)
                    .build());
            chatInput.setText("");
        }
    }
}