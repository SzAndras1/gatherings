package hu.gatherings.gateway.gathering.controller;

import hu.gatherings.gateway.GatheringApi;
import hu.gatherings.gateway.gathering.service.GatheringService;
import hu.gatherings.gateway.model.GatheringDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GatheringController implements GatheringApi {

    private final GatheringService gatheringService;

    @Override
    public ResponseEntity<GatheringDto> createGathering(GatheringDto gatheringDto) {
        return ResponseEntity.ok(gatheringService.createGathering(gatheringDto));
    }

    @Override
    public ResponseEntity<List<GatheringDto>> getGatherings() {
        return ResponseEntity.ok(gatheringService.getGatherings());
    }

    @Override
    public ResponseEntity<List<GatheringDto>> getGatheringsByOwnerId(Long ownerId) {
        return ResponseEntity.ok(gatheringService.getGatheringsByOwnerId(ownerId));
    }
}
