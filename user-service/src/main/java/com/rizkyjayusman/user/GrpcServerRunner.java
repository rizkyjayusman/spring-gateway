package com.rizkyjayusman.user;

import io.grpc.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GrpcServerRunner implements CommandLineRunner {

    private final Server grpcServer;

    public GrpcServerRunner(Server grpcServer) {
        this.grpcServer = grpcServer;
    }

    @Override
    public void run(String... args) throws Exception {
        grpcServer.start();
        log.info("gRPC Server started on port 9090");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutting down gRPC Server");
            grpcServer.shutdown();
        }));
    }
}