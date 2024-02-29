package klg.backend.lukasz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
