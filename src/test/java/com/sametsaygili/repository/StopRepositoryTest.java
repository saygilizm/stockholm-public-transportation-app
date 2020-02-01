package com.sametsaygili.repository;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import com.sametsaygili.dto.Stop;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StopRepositoryTest {

  private static final String ID = "1";

  @InjectMocks
  private StopRepositoryImpl stopRepository;

  @Test
  public void retrieveStopSuccess() {
    assertFalse(stopRepository.retrieveStop(ID).isPresent());

    Stop stop = new Stop();
    stop.setStopPointNumber(ID);
    stopRepository.persistStop(stop);

    assertTrue(stopRepository.retrieveStop(ID).isPresent());
  }

  @Test
  public void persistStopSuccess() {
    assertFalse(stopRepository.retrieveStop(ID).isPresent());

    Stop stop = new Stop();
    stop.setStopPointNumber(ID);
    stopRepository.persistStop(stop);

    Optional<Stop> actual = stopRepository.retrieveStop(ID);

    assertTrue(actual.isPresent());
    assertEquals(actual.get().getStopPointNumber(), ID);
  }
}