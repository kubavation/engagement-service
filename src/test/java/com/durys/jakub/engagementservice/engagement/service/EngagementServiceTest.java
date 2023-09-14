package com.durys.jakub.engagementservice.engagement.service;

import com.durys.jakub.engagementservice.model.EngagementProto;
import com.durys.jakub.engagementservice.model.EngagementServiceGrpc;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "grpc.server.inProcessName=test",
        "grpc.server.port=-1",
        "grpc.client.testClient.address=in-process:test"
})
@DirtiesContext
class EngagementServiceTest {


    @GrpcClient("testClient")
    EngagementServiceGrpc.EngagementServiceBlockingStub service;

    @Test
    void shouldFindAllEngagementsOfUser() {
        EngagementProto.Engagements engagements = service.findAllByUser(Int64Value.newBuilder().setValue(11).build());

        assertNotNull(engagements);
        assertTrue(engagements.getEngagementList().isEmpty());
    }

    @Test
    void shouldFindEngagementById() {
        EngagementProto.Engagement engagement = service.findById(Int64Value.newBuilder().setValue(11).build());
        assertNotNull(engagement);
    }

}