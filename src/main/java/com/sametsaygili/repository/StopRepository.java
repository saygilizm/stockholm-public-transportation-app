package com.sametsaygili.repository;

import com.sametsaygili.dto.Stop;
import java.util.Optional;

/**
 * An interface for handling the persistence of Stop data.
 */
public interface StopRepository {

  /**
   * Fetching Stop object for the given identifier.
   *
   * @param id the primary identifier of the Stop
   * @return the Stop object based on a given identifier
   */
  Optional<Stop> retrieveStop(String id);

  /**
   * Persisting Stop.
   *
   * @param stop Stop object to be saved
   */
  void persistStop(Stop stop);

}