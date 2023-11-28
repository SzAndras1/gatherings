package hu.gatherings.gathering.repository;

import hu.gatherings.gathering.entity.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GatheringRepository extends JpaRepository<Gathering, Long> {

    List<Gathering> findAllByOwnerId(Long ownerId);
}
