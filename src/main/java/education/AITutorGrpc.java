package education;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AI_tutor.proto")
public final class AITutorGrpc {

  private AITutorGrpc() {}

  public static final String SERVICE_NAME = "education.AITutor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<education.AITutorOuterClass.GetTopicsRequest,
      education.AITutorOuterClass.GetTopicsResponse> getGetTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTopics",
      requestType = education.AITutorOuterClass.GetTopicsRequest.class,
      responseType = education.AITutorOuterClass.GetTopicsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<education.AITutorOuterClass.GetTopicsRequest,
      education.AITutorOuterClass.GetTopicsResponse> getGetTopicsMethod() {
    io.grpc.MethodDescriptor<education.AITutorOuterClass.GetTopicsRequest, education.AITutorOuterClass.GetTopicsResponse> getGetTopicsMethod;
    if ((getGetTopicsMethod = AITutorGrpc.getGetTopicsMethod) == null) {
      synchronized (AITutorGrpc.class) {
        if ((getGetTopicsMethod = AITutorGrpc.getGetTopicsMethod) == null) {
          AITutorGrpc.getGetTopicsMethod = getGetTopicsMethod = 
              io.grpc.MethodDescriptor.<education.AITutorOuterClass.GetTopicsRequest, education.AITutorOuterClass.GetTopicsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "education.AITutor", "getTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.GetTopicsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.GetTopicsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AITutorMethodDescriptorSupplier("getTopics"))
                  .build();
          }
        }
     }
     return getGetTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<education.AITutorOuterClass.SetTopicRequest,
      education.AITutorOuterClass.SetTopicResponse> getSetTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setTopic",
      requestType = education.AITutorOuterClass.SetTopicRequest.class,
      responseType = education.AITutorOuterClass.SetTopicResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<education.AITutorOuterClass.SetTopicRequest,
      education.AITutorOuterClass.SetTopicResponse> getSetTopicMethod() {
    io.grpc.MethodDescriptor<education.AITutorOuterClass.SetTopicRequest, education.AITutorOuterClass.SetTopicResponse> getSetTopicMethod;
    if ((getSetTopicMethod = AITutorGrpc.getSetTopicMethod) == null) {
      synchronized (AITutorGrpc.class) {
        if ((getSetTopicMethod = AITutorGrpc.getSetTopicMethod) == null) {
          AITutorGrpc.getSetTopicMethod = getSetTopicMethod = 
              io.grpc.MethodDescriptor.<education.AITutorOuterClass.SetTopicRequest, education.AITutorOuterClass.SetTopicResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "education.AITutor", "setTopic"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.SetTopicRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.SetTopicResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AITutorMethodDescriptorSupplier("setTopic"))
                  .build();
          }
        }
     }
     return getSetTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<education.AITutorOuterClass.GenerateQuizRequest,
      education.AITutorOuterClass.QuizQuestion> getGenerateQuizMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateQuiz",
      requestType = education.AITutorOuterClass.GenerateQuizRequest.class,
      responseType = education.AITutorOuterClass.QuizQuestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<education.AITutorOuterClass.GenerateQuizRequest,
      education.AITutorOuterClass.QuizQuestion> getGenerateQuizMethod() {
    io.grpc.MethodDescriptor<education.AITutorOuterClass.GenerateQuizRequest, education.AITutorOuterClass.QuizQuestion> getGenerateQuizMethod;
    if ((getGenerateQuizMethod = AITutorGrpc.getGenerateQuizMethod) == null) {
      synchronized (AITutorGrpc.class) {
        if ((getGenerateQuizMethod = AITutorGrpc.getGenerateQuizMethod) == null) {
          AITutorGrpc.getGenerateQuizMethod = getGenerateQuizMethod = 
              io.grpc.MethodDescriptor.<education.AITutorOuterClass.GenerateQuizRequest, education.AITutorOuterClass.QuizQuestion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "education.AITutor", "generateQuiz"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.GenerateQuizRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.QuizQuestion.getDefaultInstance()))
                  .setSchemaDescriptor(new AITutorMethodDescriptorSupplier("generateQuiz"))
                  .build();
          }
        }
     }
     return getGenerateQuizMethod;
  }

  private static volatile io.grpc.MethodDescriptor<education.AITutorOuterClass.AnswerRequest,
      education.AITutorOuterClass.QuizResultResponse> getSubmitAnswersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "submitAnswers",
      requestType = education.AITutorOuterClass.AnswerRequest.class,
      responseType = education.AITutorOuterClass.QuizResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<education.AITutorOuterClass.AnswerRequest,
      education.AITutorOuterClass.QuizResultResponse> getSubmitAnswersMethod() {
    io.grpc.MethodDescriptor<education.AITutorOuterClass.AnswerRequest, education.AITutorOuterClass.QuizResultResponse> getSubmitAnswersMethod;
    if ((getSubmitAnswersMethod = AITutorGrpc.getSubmitAnswersMethod) == null) {
      synchronized (AITutorGrpc.class) {
        if ((getSubmitAnswersMethod = AITutorGrpc.getSubmitAnswersMethod) == null) {
          AITutorGrpc.getSubmitAnswersMethod = getSubmitAnswersMethod = 
              io.grpc.MethodDescriptor.<education.AITutorOuterClass.AnswerRequest, education.AITutorOuterClass.QuizResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "education.AITutor", "submitAnswers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.AnswerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.QuizResultResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AITutorMethodDescriptorSupplier("submitAnswers"))
                  .build();
          }
        }
     }
     return getSubmitAnswersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<education.AITutorOuterClass.ChatMessage,
      education.AITutorOuterClass.ChatMessage> getTutorChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "tutorChat",
      requestType = education.AITutorOuterClass.ChatMessage.class,
      responseType = education.AITutorOuterClass.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<education.AITutorOuterClass.ChatMessage,
      education.AITutorOuterClass.ChatMessage> getTutorChatMethod() {
    io.grpc.MethodDescriptor<education.AITutorOuterClass.ChatMessage, education.AITutorOuterClass.ChatMessage> getTutorChatMethod;
    if ((getTutorChatMethod = AITutorGrpc.getTutorChatMethod) == null) {
      synchronized (AITutorGrpc.class) {
        if ((getTutorChatMethod = AITutorGrpc.getTutorChatMethod) == null) {
          AITutorGrpc.getTutorChatMethod = getTutorChatMethod = 
              io.grpc.MethodDescriptor.<education.AITutorOuterClass.ChatMessage, education.AITutorOuterClass.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "education.AITutor", "tutorChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  education.AITutorOuterClass.ChatMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new AITutorMethodDescriptorSupplier("tutorChat"))
                  .build();
          }
        }
     }
     return getTutorChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AITutorStub newStub(io.grpc.Channel channel) {
    return new AITutorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AITutorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AITutorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AITutorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AITutorFutureStub(channel);
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static abstract class AITutorImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTopics(education.AITutorOuterClass.GetTopicsRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.GetTopicsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTopicsMethod(), responseObserver);
    }

    /**
     */
    public void setTopic(education.AITutorOuterClass.SetTopicRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.SetTopicResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetTopicMethod(), responseObserver);
    }

    /**
     */
    public void generateQuiz(education.AITutorOuterClass.GenerateQuizRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizQuestion> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateQuizMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<education.AITutorOuterClass.AnswerRequest> submitAnswers(
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizResultResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSubmitAnswersMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<education.AITutorOuterClass.ChatMessage> tutorChat(
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.ChatMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getTutorChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTopicsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                education.AITutorOuterClass.GetTopicsRequest,
                education.AITutorOuterClass.GetTopicsResponse>(
                  this, METHODID_GET_TOPICS)))
          .addMethod(
            getSetTopicMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                education.AITutorOuterClass.SetTopicRequest,
                education.AITutorOuterClass.SetTopicResponse>(
                  this, METHODID_SET_TOPIC)))
          .addMethod(
            getGenerateQuizMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                education.AITutorOuterClass.GenerateQuizRequest,
                education.AITutorOuterClass.QuizQuestion>(
                  this, METHODID_GENERATE_QUIZ)))
          .addMethod(
            getSubmitAnswersMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                education.AITutorOuterClass.AnswerRequest,
                education.AITutorOuterClass.QuizResultResponse>(
                  this, METHODID_SUBMIT_ANSWERS)))
          .addMethod(
            getTutorChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                education.AITutorOuterClass.ChatMessage,
                education.AITutorOuterClass.ChatMessage>(
                  this, METHODID_TUTOR_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class AITutorStub extends io.grpc.stub.AbstractStub<AITutorStub> {
    private AITutorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AITutorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AITutorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AITutorStub(channel, callOptions);
    }

    /**
     */
    public void getTopics(education.AITutorOuterClass.GetTopicsRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.GetTopicsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setTopic(education.AITutorOuterClass.SetTopicRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.SetTopicResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetTopicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateQuiz(education.AITutorOuterClass.GenerateQuizRequest request,
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizQuestion> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGenerateQuizMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<education.AITutorOuterClass.AnswerRequest> submitAnswers(
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizResultResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSubmitAnswersMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<education.AITutorOuterClass.ChatMessage> tutorChat(
        io.grpc.stub.StreamObserver<education.AITutorOuterClass.ChatMessage> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTutorChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class AITutorBlockingStub extends io.grpc.stub.AbstractStub<AITutorBlockingStub> {
    private AITutorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AITutorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AITutorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AITutorBlockingStub(channel, callOptions);
    }

    /**
     */
    public education.AITutorOuterClass.GetTopicsResponse getTopics(education.AITutorOuterClass.GetTopicsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public education.AITutorOuterClass.SetTopicResponse setTopic(education.AITutorOuterClass.SetTopicRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetTopicMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<education.AITutorOuterClass.QuizQuestion> generateQuiz(
        education.AITutorOuterClass.GenerateQuizRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGenerateQuizMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service Definition
   * </pre>
   */
  public static final class AITutorFutureStub extends io.grpc.stub.AbstractStub<AITutorFutureStub> {
    private AITutorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AITutorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AITutorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AITutorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<education.AITutorOuterClass.GetTopicsResponse> getTopics(
        education.AITutorOuterClass.GetTopicsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTopicsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<education.AITutorOuterClass.SetTopicResponse> setTopic(
        education.AITutorOuterClass.SetTopicRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetTopicMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOPICS = 0;
  private static final int METHODID_SET_TOPIC = 1;
  private static final int METHODID_GENERATE_QUIZ = 2;
  private static final int METHODID_SUBMIT_ANSWERS = 3;
  private static final int METHODID_TUTOR_CHAT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AITutorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AITutorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOPICS:
          serviceImpl.getTopics((education.AITutorOuterClass.GetTopicsRequest) request,
              (io.grpc.stub.StreamObserver<education.AITutorOuterClass.GetTopicsResponse>) responseObserver);
          break;
        case METHODID_SET_TOPIC:
          serviceImpl.setTopic((education.AITutorOuterClass.SetTopicRequest) request,
              (io.grpc.stub.StreamObserver<education.AITutorOuterClass.SetTopicResponse>) responseObserver);
          break;
        case METHODID_GENERATE_QUIZ:
          serviceImpl.generateQuiz((education.AITutorOuterClass.GenerateQuizRequest) request,
              (io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizQuestion>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBMIT_ANSWERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.submitAnswers(
              (io.grpc.stub.StreamObserver<education.AITutorOuterClass.QuizResultResponse>) responseObserver);
        case METHODID_TUTOR_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tutorChat(
              (io.grpc.stub.StreamObserver<education.AITutorOuterClass.ChatMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AITutorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AITutorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return education.AITutorOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AITutor");
    }
  }

  private static final class AITutorFileDescriptorSupplier
      extends AITutorBaseDescriptorSupplier {
    AITutorFileDescriptorSupplier() {}
  }

  private static final class AITutorMethodDescriptorSupplier
      extends AITutorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AITutorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AITutorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AITutorFileDescriptorSupplier())
              .addMethod(getGetTopicsMethod())
              .addMethod(getSetTopicMethod())
              .addMethod(getGenerateQuizMethod())
              .addMethod(getSubmitAnswersMethod())
              .addMethod(getTutorChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
