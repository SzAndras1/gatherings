package hu.cowork.gathering.fixture;

import hu.gatherings.gathering.entity.Gathering;
import hu.gatherings.gathering.model.GatheringDto;

public class GatheringFixtures {

    public static Gathering simpleGathering(Long id) {
        return new Gathering(id, 1L, "test");
    }

    public static Gathering simpleGathering(Long id, Long ownerId) {
        return new Gathering(id, ownerId, "test");
    }

    public static GatheringDto simpleGatheringDto(Long id) {
        return new GatheringDto(1L)
                .id(id)
                .description("test");
    }

    public static GatheringDto simpleGatheringDto(Long id, Long ownerId) {
        return new GatheringDto(ownerId)
                .id(id)
                .description("test");
    }
}
