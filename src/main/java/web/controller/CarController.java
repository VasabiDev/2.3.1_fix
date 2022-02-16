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
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(183,"devyatka"));
        carsList.add(new Car(173,"devyatka"));
        carsList.add(new Car(193,"devyatka"));
//        Car car = new Car(145, "devyatka");
//        Car car1 = new Car(145, "devyatka");
//        Car car2 = new Car(145, "devyatka");
//        Car car3 = new Car(145, "devyatka");
//        Car car4 = new Car(145, "devyatka");
//        List<Car> carsList = new ArrayList<>();
//        carsList.add(car);
//        carsList.add(car1);
//        carsList.add(car2);
//        carsList.add(car3);
//        carsList.add(car4);
        model.addAttribute("carsList", carsList);
        return "cars";

    }


}