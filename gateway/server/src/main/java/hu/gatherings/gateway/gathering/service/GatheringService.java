package hu.gatherings.gateway.gathering.service;

import hu.gatherings.gateway.gathering.mapper.GatheringMapper;
import hu.gatherings.gathering.GatheringApiClient;
import hu.gatherings.gateway.model.GatheringDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GatheringService {

    private final GatheringMapper gatheringMapper;

    private final GatheringApiClient gatheringApiClient;

    public GatheringDto createGathering(GatheringDto gatheringDto) {
        return gatheringMapper.toReceiveGatheringDto(
                gatheringApiClient.createGathering(gatheringMapper.toSendGatheringDto(gatheringDto)).getBody());
    }

    public List<GatheringDto> getGatheringsByOwnerId(Long ownerId) {
        return gatheringApiClient.getGatheringsByOwnerId(ownerId).getBody().stream()
                .map(gatheringMapper::toReceiveGatheringDto).collect(Collectors.toList());
    }

    public List<GatheringDto> getGatherings() {
        return gatheringApiClient.getGatherings().getBody().stream()
                .map(gatheringMapper::toReceiveGatheringDto).collect(Collectors.toList());
    }
}
