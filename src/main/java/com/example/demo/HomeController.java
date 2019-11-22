package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listFlights(Model model){
        model.addAttribute("flight", flightRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String flightForm(Model model){
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    @PostMapping("/add")
    public String processFlight(@ModelAttribute Flight flight,
                                 @RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return "redirect:/add";
        }
        try {
            Map uploadResult = cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            flight.setHeadshot(uploadResult.get("url").toString());
            flightRepository.save(flight);
        } catch (IOException e){
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }

    @PostMapping("/process")
    public String processForm(@Valid Flight flight,
                              BindingResult result){
        if (result.hasErrors()){
            return "flightform";
        }
        flightRepository.save(flight);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showFlight(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/edit/{id}")
    public String updateFlight(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "flightform";
    }

    @RequestMapping("/delete/{id}")
    public String delFlight(@PathVariable("id") long id, Model model)
    {
        flightRepository.deleteById(id);
        return "redirect:/";
    }
}
