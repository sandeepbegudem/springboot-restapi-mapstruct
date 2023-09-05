package com.codingwith.sandeepb.nationalparks.controller;

import com.codingwith.sandeepb.nationalparks.entity.Traveller;
import com.codingwith.sandeepb.nationalparks.mapper.TravellerDTO;
import com.codingwith.sandeepb.nationalparks.mapper.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/travellers")
public class TravellerController {

    @Autowired
    private TravellerService travellerService;

    @GetMapping(value = "/all-travellers", produces = "application/json")
    public ResponseEntity<List<Traveller>> allTravellers(){
        CompletableFuture<List<TravellerDTO>> traveller1= travellerService.getAllTravellers();
        CompletableFuture<List<TravellerDTO>> traveller2= travellerService.getAllTravellers();
        CompletableFuture<List<TravellerDTO>> traveller3= travellerService.getAllTravellers();
        CompletableFuture.allOf(traveller1,traveller2,traveller3).join();
        return  ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "/travel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity<String> saveBulkTravellers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            travellerService.saveTraveller(file);
        }
        return new ResponseEntity<>("travelers are successfully added! \uD83C\uDF89\n", HttpStatus.CREATED);
    }
}
