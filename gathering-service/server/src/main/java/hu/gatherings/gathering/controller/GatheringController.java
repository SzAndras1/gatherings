package hu.gatherings.gathering.controller;

import hu.gatherings.gathering.GatheringApi;
import hu.gatherings.gathering.model.GatheringDto;
import hu.gatherings.gathering.service.GatheringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class GatheringController implements GatheringApi {
    public static final String GATHERING_API_PATH = "/api/v1/gatherings";

    private final GatheringService gatheringService;

    @Override
    public ResponseEntity<GatheringDto> createGathering(GatheringDto gatheringDto) {
        GatheringDto savedGathering = gatheringService.createGathering(gatheringDto);

        URI location = ServletUriComponentsBuilder
                .fromPath(GATHERING_API_PATH)
                .path("/{id}")
                .buildAndExpand(gatheringDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedGathering);
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
