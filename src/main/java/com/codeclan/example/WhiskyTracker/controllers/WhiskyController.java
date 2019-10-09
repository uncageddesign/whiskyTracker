package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "year/{year}")
    public List<Whisky> getWhiskyByYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "distilleries/age/{age}")
    public List<Whisky> getWhiskyFromDistilleryAndAge(@PathVariable Long id,@PathVariable int age){
        return whiskyRepository.findWhiskyByDistilleryAndAge(id, age);
    }

    @GetMapping(value = "whiskies/age/{age}")
    public List<Distillery> getWhiskyFromDistilleryByAge(@PathVariable int age){
        return distilleryRepository.findWhiskiesFromDistilleryByAge(age);
    }

}