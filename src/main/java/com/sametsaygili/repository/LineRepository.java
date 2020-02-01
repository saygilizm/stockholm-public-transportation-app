package com.sametsaygili.repository;

import com.sametsaygili.dto.Line;
import java.util.List;
import java.util.Optional;

/**
 * An interface for handling the persistence of Line data.
 */
public interface LineRepository {

  /**
   * Fetching Line object for the given identifier.
   *
   * @param id the primary identifier of the Line
   * @return the Line object based on a given identifier
   */
  Optional<Line> retrieveLine(String id);

  /**
   * Fetching all Line objects
   *
   * @return the List of Line objects
   */
  Optional<List<Line>> listLines();

  /**
   * Persisting Line.
   *
   * @param line Line object to be saved
   */
  void persistLine(Line line);

}