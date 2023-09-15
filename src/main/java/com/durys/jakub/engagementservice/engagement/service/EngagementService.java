package com.durys.jakub.engagementservice.engagement.service;

import com.durys.jakub.engagementservice.engagement.domain.Engagement;
import com.durys.jakub.engagementservice.engagement.domain.EngagementRepository;
import com.durys.jakub.engagementservice.model.EngagementProto;
import com.durys.jakub.engagementservice.model.EngagementServiceGrpc;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Set;
import java.util.stream.Collectors;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class EngagementService extends EngagementServiceGrpc.EngagementServiceImplBase {

    private final EngagementRepository engagementRepository;

    @Override
    public void findAllByUser(Int64Value request, StreamObserver<EngagementProto.Engagements> responseObserver) {

        log.info("findAllByUser | (USER_ID: {})", request);

        EngagementProto.Engagements engagements = EngagementProto.Engagements.newBuilder()
                .addAllEngagement(
                        engagementRepository.userEngagements(request.getValue())
                                .stream()
                                .map(EngagementService::to).toList()).build();

        responseObserver.onNext(engagements);
        responseObserver.onCompleted();
    }

    @Override
    public void findById(Int64Value request, StreamObserver<EngagementProto.Engagement> responseObserver) {

        log.info("findById | (ID: {})", request);

        EngagementProto.Engagement engagement = to(engagementRepository.engagementById(request.getValue()));
        responseObserver.onNext(engagement);
        responseObserver.onCompleted();
    }

    private static EngagementProto.Engagement to(Engagement engagement) {
        return EngagementProto.Engagement
                .newBuilder()
                .setId(engagement.id())
                .setUserId(engagement.userId())
                .setFrom(Timestamp.newBuilder().setNanos(0).build())
                .setTo(Timestamp.newBuilder().setNanos(0).build())
                .build(); //todo
    }
}
