package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.daytime.Daytime;

// BEGIN
@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {
    @Autowired
    private Daytime daytime;

    @GetMapping(path = "")
    public String welcome() {
        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }
}
// END
