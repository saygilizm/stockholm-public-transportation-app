package com.sametsaygili.repository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.sametsaygili.dto.Line;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LineRepositoryTest {

  private static final String ID = "1";
  private static final String ID_2 = "2";
  @InjectMocks
  private LineRepositoryImpl lineRepository;

  @Test
  public void retrieveLineSuccess() {

    assertFalse(lineRepository.retrieveLine(ID).isPresent());

    Line line = new Line();
    line.setLineNumber(ID);
    lineRepository.persistLine(line);

    assertTrue(lineRepository.retrieveLine(ID).isPresent());
  }

  @Test
  public void listLinesSuccess() {

    Optional<List<Line>> actual = lineRepository.listLines();
    assertTrue(actual.isPresent());
    assertTrue(actual.get().isEmpty());

    Line line = new Line();
    line.setLineNumber(ID);
    lineRepository.persistLine(line);

    actual = lineRepository.listLines();
    assertFalse(actual.get().isEmpty());
    assertEquals(actual.get().size(), 1);

    line = new Line();
    line.setLineNumber(ID_2);
    lineRepository.persistLine(line);
    actual = lineRepository.listLines();

    assertEquals(actual.get().size(), 2);


  }

  @Test
  public void persistLineSuccess() {
    assertFalse(lineRepository.retrieveLine(ID_2).isPresent());

    Line line = new Line();
    line.setLineNumber(ID_2);
    lineRepository.persistLine(line);

    assertTrue(lineRepository.retrieveLine(ID_2).isPresent());
  }
}