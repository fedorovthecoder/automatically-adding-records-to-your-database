package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CarController {
    @Autowired
    CarRepository carRepository;

    @RequestMapping("/listcars")
    public String listCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "carlist";
    }

    @GetMapping("/addcar")
    public String carForm(Model model) {
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/processcar")
    public String processForm(@Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "carform";
        }
        carRepository.save(car);
        return ("redirect:/listcars");
    }

    @RequestMapping("/car-detail/{id}")
    public String showCar(@PathVariable("id")  long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "showcar";
    }

    @RequestMapping("/car-update/{id}")
    public String updateCar(@PathVariable("id")  long id, Model model) {
        model.addAttribute("car", carRepository.findById(id).get());
        return "carform";
    }

    @RequestMapping("/car-delete/{id}")
    public String delCar(@PathVariable("id")  long id) {
        carRepository.deleteById(id);
        return "redirect:/listcars";
    }
}
