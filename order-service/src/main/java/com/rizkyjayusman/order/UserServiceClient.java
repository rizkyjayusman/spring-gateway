package com.rizkyjayusman.order;

import com.rizkyjayusman.order.proto.UserServiceGrpc;
import com.rizkyjayusman.order.proto.UserServiceProto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceClient {

    private final UserServiceGrpc.UserServiceBlockingStub grpcStub;

    public String getUserById(Long userId) {
        UserServiceProto.UserRequest request = UserServiceProto.UserRequest.newBuilder().setUserId(userId).build();
        UserServiceProto.UserResponse response = grpcStub.getUserById(request);
        return response.getMessage();
    }
}
