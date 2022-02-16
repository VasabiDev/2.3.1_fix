package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private CarService carService = new CarServiceImpl();

    @GetMapping("/cars")
    public String getCars(ModelMap model, @RequestParam(value = "count") Optional<Integer> count) {


        model.addAttribute("carsList", getCarsCounted(count.orElse(0)));
        return "cars";

    }

    public List<Car> getCarsCounted(int count) {
        if (count == 0 || count >= 5) {
            return carService.getSomeDevyatki();
        }
        return carService.getSomeDevyatki().stream().limit(count).collect(Collectors.toList());


    }
}