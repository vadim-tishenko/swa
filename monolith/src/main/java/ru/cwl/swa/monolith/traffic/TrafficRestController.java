package ru.cwl.swa.monolith.traffic;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController()
@RequestMapping("/v1/traffic")
public class TrafficRestController {
    final TrafficRepo trafficRepo;

    @PostMapping(path = "/add")
    public void addTrafficItem(@RequestBody Traffic traffic) {
        trafficRepo.addTrafficItem(traffic);
    }

    @GetMapping(path = "/find/{objId}/{from}/{to}")
    public List<Traffic> findTraffic(@PathVariable int objId, @PathVariable long from, @PathVariable long to) {
        List<Traffic> result = trafficRepo.findByObjId(objId, from, to);
        return result;
    }
}
