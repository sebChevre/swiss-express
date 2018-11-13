package ch.sebooom.lignesservice.application;

import ch.sebooom.lignesservice.infra.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Collection findAll () {
        return (Collection) stationRepository.findAll();
    }
}
