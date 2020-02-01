package com.sametsaygili.service;

import com.sametsaygili.dto.Journey;
import com.sametsaygili.dto.Line;
import com.sametsaygili.dto.Stop;
import com.sametsaygili.error.LineNotFoundException;
import com.sametsaygili.repository.JourneyRepository;
import com.sametsaygili.repository.LineRepository;
import com.sametsaygili.repository.StopRepository;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

  private LineRepository lineRepository;

  private JourneyRepository journeyRepository;

  private StopRepository stopRepository;

  @Autowired
  public BusService(LineRepository lineRepository, JourneyRepository journeyRepository,
      StopRepository stopRepository) {

    this.lineRepository = lineRepository;
    this.journeyRepository = journeyRepository;
    this.stopRepository = stopRepository;
  }

  public List<Line> getTop10BusLinesWithMostBusStops() {

    List<Line> lineList = new ArrayList<>();

    Queue<SimpleEntry<Line, Integer>> linePQ = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());

    for (Line line : lineRepository.listLines().get()) {
      int stopCount = journeyRepository.retrieveJourney(line.getLineNumber()).get().size();
      linePQ.add(new SimpleEntry<>(line, stopCount));
    }

    while (lineList.size() < 10 && !linePQ.isEmpty()) {
      lineList.add(linePQ.remove().getKey());
    }

    return lineList;

  }

  public List<Stop> getAllBusStops(String id) {

    List<Stop> stopList = new ArrayList<>();

    List<Journey> routeList = journeyRepository.retrieveJourney(id).orElseThrow(LineNotFoundException::new);

    for (Journey journey : routeList) {
      Optional<Stop> stop = stopRepository.retrieveStop(journey.getJourneyPatternPointNumber());
      if(stop.isPresent())
        stopList.add(stop.get());
    }

    return stopList;
  }


}
