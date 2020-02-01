package com.sametsaygili.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.sametsaygili.dto.Journey;
import com.sametsaygili.dto.Line;
import com.sametsaygili.repository.JourneyRepository;
import com.sametsaygili.repository.LineRepository;
import com.sametsaygili.repository.StopRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
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

  @BeforeEach
  private void init(){
    initMocks(this);
  }

  @Test
  void getTop10BusLinesWithMostBusStops() {

    List<Line> top10BusLineList = new ArrayList<>();
    for(int i = 0; i < 15; i++){
      Line line = new Line();
      line.setLineNumber(String.valueOf(i));
      top10BusLineList.add(line);
      List<Journey> journeyList = new ArrayList<>();
      for(int j=0; j < i; j++) journeyList.add(new Journey());
      when(journeyRepository.retrieveJourney(line.getLineNumber())).thenReturn(Optional.of(journeyList));
    }

    when(lineRepository.listLines()).thenReturn(Optional.of(top10BusLineList));

    List<Line> actual = busService.getTop10BusLinesWithMostBusStops();

    assertEquals(actual.size(), 10);
    assertTrue(actual.get(0).getLineNumber().equals("14"));
    assertTrue(actual.get(9).getLineNumber().equals("5"));
  }

  @Test
  void getAllBusStops() {

  }
}