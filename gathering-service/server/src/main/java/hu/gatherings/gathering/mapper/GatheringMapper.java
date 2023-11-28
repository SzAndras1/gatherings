package hu.gatherings.gathering.mapper;

import hu.gatherings.gathering.model.GatheringDto;
import hu.gatherings.gathering.entity.Gathering;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface GatheringMapper extends Converter<Gathering, GatheringDto> {

    GatheringDto toDto(Gathering gathering);

    Gathering toEntity(GatheringDto gatheringDto);

}
