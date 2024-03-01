package klg.backend.lukasz.controller;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landlords")
public class LandlordController {

    @Autowired
    LandlordRepository landlordRepository;

    @GetMapping
    List<Landlord> getLandlords() {
        return landlordRepository.findAll();
    }

    @PostMapping
    Landlord createLandlord(@RequestBody Landlord landlord) {
        return landlordRepository.save(landlord);
    }

}
