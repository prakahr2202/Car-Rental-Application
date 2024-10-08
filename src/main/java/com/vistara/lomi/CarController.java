package com.vistara.lomi;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        super();
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String listOfCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car1";
    }

    @GetMapping("/cars/new")
    public String createCarsForm(Model model) {
        Cars cars = new Cars();
        model.addAttribute("cars", cars);
        return "create_car";
    }

    @PostMapping("/cars")
    public String saveStudent(@ModelAttribute("cars") Cars cars) {
        carService.saveCar(cars);
        return "redirect:/cars";
    }

}
