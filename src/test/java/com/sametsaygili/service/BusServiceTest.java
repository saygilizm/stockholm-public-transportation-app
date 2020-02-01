package com.sametsaygili.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.sametsaygili.dto.Journey;
import com.sametsaygili.dto.Line;
import com.sametsaygili.dto.Stop;
import com.sametsaygili.handler.error.LineNotFoundException;
import com.sametsaygili.repository.JourneyRepository;
import com.sametsaygili.repository.LineRepository;
import com.sametsaygili.repository.StopRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BusServiceTest {

  @Mock
  private LineRepository lineRepository;

  @Mock
  private JourneyRepository journeyRepository;

  @Mock
  private StopRepository stopRepository;

  @InjectMocks
  private BusService busService;

  @Test
  public void getTop10BusLinesWithMostBusStopsSuccess() {

    List<Line> top10BusLineList = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      Line line = new Line();
      line.setLineNumber(String.valueOf(i));
      top10BusLineList.add(line);
      List<Journey> journeyList = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        journeyList.add(new Journey());
      }
      when(journeyRepository.retrieveJourney(line.getLineNumber()))
          .thenReturn(Optional.of(journeyList));
    }

    when(lineRepository.listLines()).thenReturn(Optional.of(top10BusLineList));

    List<Line> actual = busService.getTop10BusLinesWithMostBusStops();

    assertEquals(actual.size(), 10);
    assertTrue(actual.get(0).getLineNumber().equals("14"));
    assertTrue(actual.get(9).getLineNumber().equals("5"));
  }

  @Test
  public void getAllBusStopsSuccess() {

    final String busId = "176";

    List<Journey> routeList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Journey journey = new Journey();
      journey.setJourneyPatternPointNumber(String.valueOf(i));
      routeList.add(journey);
      Stop stop = new Stop();
      stop.setStopPointNumber(String.valueOf(i));
      when(stopRepository.retrieveStop(journey.getJourneyPatternPointNumber()))
          .thenReturn(Optional.of(stop));
    }

    when(journeyRepository.retrieveJourney(busId)).thenReturn(Optional.of(routeList));
    List<Stop> actual = busService.getAllBusStops(busId);

    assertEquals(actual.size(), 5);
  }

  @Test(expected = LineNotFoundException.class)
  public void getAllBusStopsFailure() {

    final String busId = "176";

    List<Journey> routeList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Journey journey = new Journey();
      journey.setJourneyPatternPointNumber(String.valueOf(i));
      routeList.add(journey);
    }

    when(journeyRepository.retrieveJourney(busId)).thenReturn(Optional.empty());
    List<Stop> actual = busService.getAllBusStops(busId);
  }
}