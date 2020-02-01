package com.sametsaygili.repository;

import com.sametsaygili.dto.Stop;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class StopRepositoryImpl implements StopRepository {

  private Map<String, Stop> stopStorage = new ConcurrentHashMap<>();

  @Override
  public Optional<Stop> retrieveStop(String id) {

    return Optional.ofNullable(stopStorage.get(id));
  }

  @Override
  public void persistStop(Stop stop) {

    stopStorage.put(stop.getStopPointNumber(), stop);
  }
}
