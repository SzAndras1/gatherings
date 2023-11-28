package hu.cowork.gathering.service;

import hu.cowork.gathering.fixture.GatheringFixtures;
import hu.gatherings.gathering.entity.Gathering;
import hu.gatherings.gathering.mapper.GatheringMapperImpl;
import hu.gatherings.gathering.model.GatheringDto;
import hu.gatherings.gathering.repository.GatheringRepository;
import hu.gatherings.gathering.service.GatheringService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GatheringServiceTest {
    GatheringService gatheringService;

    @Mock
    GatheringRepository gatheringRepository;


    @BeforeEach
    public void init() {
        gatheringService = new GatheringService(gatheringRepository, new GatheringMapperImpl());
    }

    @Test
    public void createGatheringShouldReturnWithTheCorrectResult() {
        Long id = 1L;
        Gathering gathering = GatheringFixtures.simpleGathering(id);
        GatheringDto expected = GatheringFixtures.simpleGatheringDto(id);
        given(gatheringRepository.save(gathering)).willReturn(gathering);

        GatheringDto result = gatheringService.createGathering(expected);

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    public void getGatheringsShouldReturnWithTheCorrectResult() {
        List<Gathering> gatheringList = List.of(
                GatheringFixtures.simpleGathering(1L),
                GatheringFixtures.simpleGathering(2L)
        );
        List<GatheringDto> expected = List.of(
                GatheringFixtures.simpleGatheringDto(1L),
                GatheringFixtures.simpleGatheringDto(2L)
        );
        when(gatheringRepository.findAll()).thenReturn(gatheringList);

        List<GatheringDto> result = gatheringService.getGatherings();

        assertThat(result, is(equalTo(expected)));
    }

    @Test
    public void getGatheringsByOwnerIdShouldReturnWithTheCorrectResult() {
        Long ownerId = 2L;
        List<Gathering> gatheringList = List.of(
                GatheringFixtures.simpleGathering(1L, ownerId),
                GatheringFixtures.simpleGathering(2L, ownerId)
        );
        List<GatheringDto> expected = List.of(
                GatheringFixtures.simpleGatheringDto(1L, ownerId),
                GatheringFixtures.simpleGatheringDto(2L, ownerId)
        );
        when(gatheringRepository.findAllByOwnerId(ownerId)).thenReturn(gatheringList);

        List<GatheringDto> result = gatheringService.getGatheringsByOwnerId(ownerId);

        assertThat(result, is(equalTo(expected)));
    }

}
