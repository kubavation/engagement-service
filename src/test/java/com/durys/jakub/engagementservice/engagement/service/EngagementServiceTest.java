package com.durys.jakub.engagementservice.engagement.service;

import com.durys.jakub.engagementservice.model.EngagementServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "grpc.server.inProcessName=test",
        "grpc.server.port=-1",
        "grpc.client.inProcess.address=in-process:test"
})
@DirtiesContext
class EngagementServiceTest {


    @GrpcClient("inProcess")
    EngagementServiceGrpc.EngagementServiceBlockingStub service;

}