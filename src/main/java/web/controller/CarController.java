package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String getCars(ModelMap model) {
        Car car = new Car(123123, "devyatka");
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm car page");
        messages.add(car.toString());
        model.addAttribute("messages", messages);
        return "cars";

    }
}