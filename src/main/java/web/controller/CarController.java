package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String getCars(ModelMap model) throws ClassNotFoundException, SQLException {

        Car car = new Car(123123, "devyatka");
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm car page");
        messages.add(car.toString());
        model.addAttribute("messages", messages);
        return "cars";

    }
    @Resource
    private DataSource testDS;
    protected void goGet() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname","username", "password");
    }
}