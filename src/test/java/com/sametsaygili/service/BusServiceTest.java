package com.sametsaygili.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.sametsaygili.dto.Line;
import com.sametsaygili.repository.JourneyRepository;
import com.sametsaygili.repository.LineRepository;
import com.sametsaygili.repository.StopRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class BusServiceTest {

  @Mock
  private LineRepository lineRepository;

  @Mock
  private JourneyRepository journeyRepository;

  @Mock
  private StopRepository stopRepository;

  @InjectMocks
  private BusService busService;

  @Test
  void getTop10BusLinesWithMostBusStops() {

    List<Line> top10BusLineList = new ArrayList<>();
    for(int i = 0; i < 15; i++){
      Line line = new Line();
      line.setLineNumber(String.valueOf(i));
      top10BusLineList.add(line);
      when(journeyRepository.retrieveJourney(line.getLineNumber()).get().size()).thenReturn(Integer.valueOf(line.getLineNumber()));
    }

    when(lineRepository.listLines()).thenReturn(Optional.of(top10BusLineList));

    List<Line> actual = busService.getTop10BusLinesWithMostBusStops();

    assertEquals(actual.size(), 10);
  }

  @Test
  void getAllBusStops() {

  }
}