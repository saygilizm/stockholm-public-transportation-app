package com.sametsaygili.repository;

import com.sametsaygili.dto.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class LineRepositoryImpl implements LineRepository {

  private Map<String, Line> lineStorage = new ConcurrentHashMap<>();

  @Override
  public Optional<Line> retrieveLine(String id) {

    return Optional.ofNullable(lineStorage.get(id));
  }

  @Override
  public Optional<List<Line>> listLines() {

    return Optional.of(new ArrayList<>(lineStorage.values()));
  }

  @Override
  public void persistLine(Line line) {

    lineStorage.put(line.getLineNumber(), line);
  }

}
