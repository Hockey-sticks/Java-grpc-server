package com.grpc.server.service.server;


import com.grpc.server.service.PrintMessageRequest;
import com.grpc.server.service.PrintMessageServiceGrpc;
import com.grpc.server.service.ServerResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class PrintMessageServiceImpl extends PrintMessageServiceGrpc.PrintMessageServiceImplBase {

    @Override
    public void printMessage(PrintMessageRequest printMessageRequest, StreamObserver<ServerResponse> responseObserver){
        log.info("Received message : {}",printMessageRequest.getMessage());
        String message = "Server received the message : " + printMessageRequest.getMessage();
        log.info("Sending message : {}",message);
        ServerResponse serverResponse = ServerResponse.newBuilder().setServerResponse(message).build();
        responseObserver.onNext(serverResponse);
        responseObserver.onCompleted();
    }
}
