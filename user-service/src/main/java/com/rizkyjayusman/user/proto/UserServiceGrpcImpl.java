package com.rizkyjayusman.user.proto;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserById(UserServiceProto.UserRequest request, StreamObserver<UserServiceProto.UserResponse> responseObserver) {
        long userId = request.getUserId();
        log.info("Getting user by id: {}", userId);

        String message = "Hello World for user with ID: " + userId;

        UserServiceProto.UserResponse response = UserServiceProto.UserResponse.newBuilder()
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}