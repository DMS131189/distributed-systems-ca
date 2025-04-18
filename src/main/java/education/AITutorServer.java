/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package education;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import io.grpc.TlsServerCredentials;
import java.io.File;
import java.io.IOException;
//import org.slf4j.*;

public class AITutorServer {
    //private static final Logger logger = LoggerFactory.getLogger(AITutorServiceImpl.class);
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new AITutorServiceImpl())
                .build();

        server.start();
        System.out.println("Server running on port 8080");
        server.awaitTermination();
    }
}
