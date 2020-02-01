package com.sametsaygili.controller;

import com.sametsaygili.dto.Line;
import com.sametsaygili.dto.Stop;
import com.sametsaygili.service.BusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

  @Autowired
  private BusService busService;

  @RequestMapping("top10BusLines/")
  public List<Line> top10busLinesWithMostBusStops() {

    return busService.getTop10BusLinesWithMostBusStops();
  }

  @RequestMapping("getAllStops/{id}")
  public List<Stop> getAllBusStops(@PathVariable String id) {

    return busService.getAllBusStops(id);
  }

}