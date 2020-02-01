package com.sametsaygili.service;

import com.sametsaygili.service.util.Model;
import com.sametsaygili.dto.Journey;
import com.sametsaygili.dto.Line;
import com.sametsaygili.dto.LineData;
import com.sametsaygili.dto.Stop;
import com.sametsaygili.provider.SLApiRestCaller;
import com.sametsaygili.repository.JourneyRepository;
import com.sametsaygili.repository.LineRepository;
import com.sametsaygili.repository.StopRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class InitializerService {


  LineRepository lineRepository;

  JourneyRepository journeyRepository;

  StopRepository stopRepository;

  SLApiRestCaller slApiRestCaller;

  private static final String MODEL = "model";
  private static final String STOP_AREA_TYPE_CODE = "StopAreaTypeCode";
  private static final String DEFAULT_TRANSFER_MODE_CODE = "DefaultTransportModeCode";
  private static final String BUSSTERM = "BUSSTERM";
  private static final String BUS = "BUS";

  @Autowired
  public InitializerService(LineRepository lineRepository, JourneyRepository journeyRepository,
      StopRepository stopRepository, SLApiRestCaller slApiRestCaller) {

    this.lineRepository = lineRepository;
    this.journeyRepository = journeyRepository;
    this.stopRepository = stopRepository;
    this.slApiRestCaller = slApiRestCaller;
  }

  @PostConstruct
  public void initialize(){

    Map<String, String> queryParams = new HashMap<>();
    queryParams.put(MODEL, Model.LINE.getValue());
    queryParams.put(DEFAULT_TRANSFER_MODE_CODE, BUS);

    LineData result = slApiRestCaller.retrieveLineData(queryParams, new ParameterizedTypeReference<LineData<Line>>() {	});

    List<Line> lineList = result.getResponseData().getResult();
    for(int i = 0 ; i < lineList.size(); i++){
      lineRepository.persistLine(lineList.get(i));
    }

    queryParams.remove(DEFAULT_TRANSFER_MODE_CODE);
    queryParams.put(MODEL, Model.STOP.getValue());
    queryParams.put(STOP_AREA_TYPE_CODE, BUSSTERM);

    result = slApiRestCaller.retrieveLineData(queryParams, new ParameterizedTypeReference<LineData<Stop>>() {	});
    List<Stop> stopList = result.getResponseData().getResult();

    for(Stop resultContent : stopList){
      stopRepository.persistStop(resultContent);
    }

    queryParams.remove(STOP_AREA_TYPE_CODE);
    queryParams.put(MODEL, Model.JOURNEY.getValue());

    result = slApiRestCaller.retrieveLineData(queryParams, new ParameterizedTypeReference<LineData<Journey>>() {	});
    List<Journey> journeyList = result.getResponseData().getResult();

    for(Journey resultContent : journeyList){
      journeyRepository.persistJourney(resultContent);
    }
  }
}
