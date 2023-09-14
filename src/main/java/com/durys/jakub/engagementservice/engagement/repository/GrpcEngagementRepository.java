package com.durys.jakub.engagementservice.engagement.repository;

import com.durys.jakub.engagementservice.model.EngagementProto;
import com.google.protobuf.Int32Value;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class GrpcEngagementRepository {

    public List<EngagementProto.Engagement> engagements(Int32Value userId) {
        return Collections.emptyList();
    }

    public EngagementProto.Engagement byId(Int32Value id) {
        return null;
    }

}
