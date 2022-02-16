package service;

import org.springframework.stereotype.Component;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    static List<Car> carsList = new ArrayList<>();

    static {
        carsList.add(new Car(183, "devyatka"));
        carsList.add(new Car(173, "devyatka"));
        carsList.add(new Car(193, "devyatka"));
        carsList.add(new Car(345, "devyatka"));
        carsList.add(new Car(234, "devyatka"));
        carsList.add(new Car(457, "devyatka"));
        carsList.add(new Car(234, "devyatka"));
        carsList.add(new Car(235, "devyatka"));
    }

    @Override
    public List<Car> getSomeDevyatki() {
        return carsList;
    }

}
