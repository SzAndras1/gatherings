package hu.gatherings.gateway.gathering.mapper;

import hu.gatherings.gateway.model.GatheringDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GatheringMapper {
    hu.gatherings.gathering.model.GatheringDto toSendGatheringDto(GatheringDto gatheringDto);
    GatheringDto toReceiveGatheringDto(hu.gatherings.gathering.model.GatheringDto gatheringDto);
}
