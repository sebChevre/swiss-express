package ch.sebooom.lignesservice.application;

import ch.sebooom.lignesservice.application.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("init")
public class DataInitialisation {

    @Autowired
    StationService stationService;


    @PostConstruct
    public void initData () {

        stationService.insertLigne1Data();
        stationService.insertLigne2Data();
        stationService.insertLigne4Data();
        stationService.insertLigne3Data();
        stationService.insertLigne5Data();
    }
}
