package com.rizkyjayusman.user.config;

import com.rizkyjayusman.user.proto.UserServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {

    @Value(value = "${grpc.server.port:9090}")
    private Integer grpcServerPort;

    @Bean
    public Server grpcServer(UserServiceGrpcImpl userServiceGrpcImpl) {
        return ServerBuilder.forPort(grpcServerPort)
                .addService(userServiceGrpcImpl)
                .build();
    }
}