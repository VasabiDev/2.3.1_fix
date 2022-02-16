package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CarController {
    static List<Car> carsList = new ArrayList<>();
    static{
        carsList.add(new Car(183, "devyatka"));
        carsList.add(new Car(173, "devyatka"));
        carsList.add(new Car(193, "devyatka"));
        carsList.add(new Car(345, "devyatka"));
        carsList.add(new Car(234, "devyatka"));
        carsList.add(new Car(457, "devyatka"));
        carsList.add(new Car(234, "devyatka"));
        carsList.add(new Car(235, "devyatka"));
    }


    @GetMapping("/cars")
    public String getCars(ModelMap model, @RequestParam(value = "count") Optional<Integer> count) {



        model.addAttribute("carsList", getCarsCounted(count.orElse(0)));
        return "cars";

    }

    public List<Car> getCarsCounted(int count) {
        if (count == 0 || count >= 5) {
            return carsList;
        }
        return carsList.stream().limit(count).collect(Collectors.toList());


    }
}