package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    FlightRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Flight flight;
        flight = new Flight("iad", "bwi", "one way", "1300", "november 21", "1309", "american airlines");
        repository.save(flight);

        flight = new Flight("bwi", "iad", "one way", "2400", "november 22", "1308", "united airlines");
        repository.save(flight);
    }
}
