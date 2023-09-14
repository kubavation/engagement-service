package com.durys.jakub.engagementservice.engagement.service;

import com.durys.jakub.engagementservice.engagement.repository.EngagementRepository;
import com.durys.jakub.engagementservice.model.EngagementProto;
import com.durys.jakub.engagementservice.model.EngagementServiceGrpc;
import com.google.protobuf.Int32Value;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class EngagementService extends EngagementServiceGrpc.EngagementServiceImplBase {

    private final EngagementRepository engagementRepository;

    @Override
    public void findAllByUser(Int32Value request, StreamObserver<EngagementProto.Engagements> responseObserver) {
        EngagementProto.Engagements engagements = EngagementProto.Engagements.newBuilder()
                .addAllEngagement(engagementRepository.engagements(request))
                .build();
        responseObserver.onNext(engagements);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(Int32Value request, StreamObserver<EngagementProto.Engagement> responseObserver) {
        EngagementProto.Engagement engagement = engagementRepository.byId(request);
        responseObserver.onNext(engagement);
        responseObserver.onCompleted();
    }
}
