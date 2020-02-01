package com.sametsaygili.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.sametsaygili.dto.Journey;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JourneyRepositoryTest {

  @InjectMocks
  private JourneyRepositoryImpl journeyRepository;

  private static final String ID = "1";

  @Test
  public void retrieveJourneySuccess() {

    assertFalse(journeyRepository.retrieveJourney(ID).isPresent());

    Journey journey = new Journey();
    journey.setLineNumber(ID);
    journeyRepository.persistJourney(journey);

    assertTrue(journeyRepository.retrieveJourney(ID).isPresent());
  }

  @Test
  public void persistJourneySucceess() {

    Optional<List<Journey>> actual = journeyRepository.retrieveJourney(ID);

    assertFalse(actual.isPresent());

    Journey journey = new Journey();
    journey.setLineNumber(ID);
    journeyRepository.persistJourney(journey);
    actual = journeyRepository.retrieveJourney(ID);

    assertTrue(actual.isPresent());
    assertEquals(actual.get().size(), 1);

    journeyRepository.persistJourney(journey);
    actual = journeyRepository.retrieveJourney(ID);

    assertEquals(actual.get().size(), 2);
  }
}