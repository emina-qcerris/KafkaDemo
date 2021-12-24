package com.kafkademo.kafkademo.controller;

import com.kafkademo.kafkademo.model.Box;
import com.kafkademo.kafkademo.repository.BoxRepository;
import com.kafkademo.kafkademo.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private KafkaService kafkaService;

    @PostMapping(value="/insert")
    public ResponseEntity<Box> insertBox(@RequestBody Box box){
        System.out.println("Pristup API-ju.");
        if(box!=null){
            boxRepository.save(box);
            System.out.println("Sacuvana kutija.");
            return new ResponseEntity<Box>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Box>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/send")
    public String sendKafkaMessage(){
        kafkaService.send("Mihajlo je moja beba.");
        return "Uspesno poslato na kafku.";
    }
}
