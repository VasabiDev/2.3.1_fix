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

        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm car page");
        messages.add(new Car(145, "devyatka").toString());
        messages.add(new Car(745, "devyatka1").toString());
        messages.add(new Car(234, "devyatka2").toString());
        messages.add(new Car(534, "devyatka3").toString());
        messages.add(new Car(643, "devyatka4").toString());

        model.addAttribute("messages", messages);
        return "cars";

    }


}