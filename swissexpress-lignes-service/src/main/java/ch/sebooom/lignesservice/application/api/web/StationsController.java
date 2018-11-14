package ch.sebooom.lignesservice.application.api.web;

import ch.sebooom.lignesservice.application.service.StationService;
import ch.sebooom.lignesservice.infra.entity.Segment;
import ch.sebooom.lignesservice.infra.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stations")
public class StationsController {

    @Autowired
    StationService stationService;

    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getById(@PathVariable("stationId") String stationId){

        Optional<Station> station = stationService.findById(stationId);

        if(station.isPresent()){
            Station stationRes = station.get();
            return ResponseEntity.ok().body(stationRes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Station>> getAll(){

        Collection stations = stationService.findAll();

        return ResponseEntity.ok().body(stations);

    }

    @GetMapping("/from/{start}/to/{end}")
    public ResponseEntity<Collection<Segment>> trajet(@PathVariable("start") String start,
                                                      @PathVariable("end") String end){

        Collection stations = stationService.trajet(start,end);

        return ResponseEntity.ok().body(stations);

    }

}
