package ch.sebooom.lignesservice.application;

import ch.sebooom.lignesservice.application.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("init")
public class DataInitialisation {

    @Autowired
    StationService stationService;

}
