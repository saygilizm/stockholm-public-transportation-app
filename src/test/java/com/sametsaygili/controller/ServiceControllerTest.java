package com.sametsaygili.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.sametsaygili.dto.Line;
import com.sametsaygili.dto.Stop;
import com.sametsaygili.handler.error.LineNotFoundException;
import com.sametsaygili.service.BusService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceControllerTest {

  @Mock
  private BusService busService;

  @InjectMocks
  private ServiceController serviceController;

  private static final String ID = "1";

  @Test
  public void top10BusLinesWithMostBusStopsSuccess() {

    List<Line> lineList = new ArrayList<>();
    for(int i = 0; i < 10; i++)
      lineList.add(new Line());
    when(busService.getTop10BusLinesWithMostBusStops()).thenReturn(lineList);

    List<Line> actual = serviceController.top10BusLinesWithMostBusStops();

    assertFalse(actual.isEmpty());
    assertEquals(actual.size(), 10);
  }

  @Test
  public void getAllBusStopsSuccess() {
    List<Stop> stopList = new ArrayList<>();
    for(int i = 0; i < 15; i++)
      stopList.add(new Stop());

    when(busService.getAllBusStops(ID)).thenReturn(stopList);

    List<Stop> actual = serviceController.getAllBusStops(ID);

    assertFalse(actual.isEmpty());
    assertEquals(actual.size(), 15);
  }

  @Test(expected = LineNotFoundException.class)
  public void getAllBusStopsFailure() {
    List<Stop> stopList = new ArrayList<>();
    for(int i = 0; i < 15; i++)
      stopList.add(new Stop());

    when(busService.getAllBusStops(ID)).thenThrow(new LineNotFoundException());

    serviceController.getAllBusStops(ID);
  }
}