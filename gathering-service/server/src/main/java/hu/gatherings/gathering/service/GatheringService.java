package hu.gatherings.gathering.service;

import hu.gatherings.gathering.entity.Gathering;
import hu.gatherings.gathering.mapper.GatheringMapper;
import hu.gatherings.gathering.model.GatheringDto;
import hu.gatherings.gathering.repository.GatheringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GatheringService {

    private final GatheringRepository gatheringRepository;

    private final GatheringMapper gatheringMapper;

    public GatheringDto createGathering(GatheringDto gatheringDto) {
        Gathering toSaveGathering = gatheringMapper.toEntity(gatheringDto);
        return gatheringMapper.toDto(gatheringRepository.save(toSaveGathering));
    }

    public List<GatheringDto> getGatheringsByOwnerId(Long ownerId) {
        return gatheringRepository.findAllByOwnerId(ownerId).stream()
                .map(gatheringMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GatheringDto> getGatherings() {
        return gatheringRepository.findAll().stream()
                .map(gatheringMapper::toDto)
                .collect(Collectors.toList());
    }
}
