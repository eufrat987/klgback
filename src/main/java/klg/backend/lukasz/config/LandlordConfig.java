package klg.backend.lukasz.config;

import klg.backend.lukasz.model.Landlord;
import klg.backend.lukasz.repository.LandlordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LandlordConfig {

    @Bean
    CommandLineRunner commandLineRunner(LandlordRepository repository) {
        return args -> {
            repository.save(new Landlord("test"));
            repository.save(new Landlord("test2"));
        };
    }

}
