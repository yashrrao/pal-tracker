package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String message;


    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message) {
        // controller accepts a env variable as a constructor parameter
        // and sets it to the field variable of the controller
        this.message = message;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}
