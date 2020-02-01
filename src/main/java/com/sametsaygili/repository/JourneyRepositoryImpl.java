package com.sametsaygili.repository;

import com.sametsaygili.dto.Journey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class JourneyRepositoryImpl implements JourneyRepository {

  private Map<String, List<Journey>> journeyStorage = new ConcurrentHashMap<>();

  @Override
  public Optional<List<Journey>> retrieveJourney(String id) {

    return Optional.ofNullable(journeyStorage.get(id));
  }

  @Override
  public void persistJourney(Journey journey) {

    Optional<List<Journey>> journeyList = this.retrieveJourney(journey.getLineNumber());
    if (!journeyList.isPresent()) {
      journeyList = Optional.of(new ArrayList<>());
    }
    journeyList.get().add(journey);
    journeyStorage.put(journey.getLineNumber(), journeyList.get());
  }

}
