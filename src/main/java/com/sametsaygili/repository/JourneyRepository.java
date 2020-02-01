package com.sametsaygili.repository;

import com.sametsaygili.dto.Journey;
import java.util.List;
import java.util.Optional;

/**
 * An interface for handling the persistence of Journey data.
 */
public interface JourneyRepository {

  /**
   * Fetching Journey object for the given identifier.
   *
   * @param id the primary identifier of the Journey items of The line
   * @return the Journey object based on a given identifier
   */
  Optional<List<Journey>> retrieveJourney(String id);

  /**
   * Persisting Journey.
   *
   * @param journey Journey object to be saved
   */
  void persistJourney(Journey journey);

}