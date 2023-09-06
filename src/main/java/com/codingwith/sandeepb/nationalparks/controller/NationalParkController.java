package com.codingwith.sandeepb.nationalparks.controller;

import com.codingwith.sandeepb.nationalparks.dto.NationalParkDTO;
import com.codingwith.sandeepb.nationalparks.entity.NationalPark;
import com.codingwith.sandeepb.nationalparks.mapper.NationalParkMapper;
import com.codingwith.sandeepb.nationalparks.repository.NationalParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/national-parks")
public class NationalParkController {


    @Autowired
    private NationalParkMapper mapper;

    @Autowired
    private NationalParkRepository repository;

    @GetMapping("/all-parks")
    public ResponseEntity<List<NationalParkDTO>> allNationalParks(){
        return new ResponseEntity<>(mapper.allNationalParksToDto(repository.findAll()), HttpStatus.OK);
    }
    @PostMapping("/insert-park")
    public ResponseEntity<NationalPark> insertPark(@RequestBody NationalParkDTO nationalParkDTO){
      //return null;
       return new ResponseEntity<>(repository.save(mapper.dtoToModel(nationalParkDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/get-park/{id}")
    public ResponseEntity<NationalParkDTO> fetchParkByPK(@PathVariable Long id){
        return new ResponseEntity<>
                (mapper.modelToDto(repository.findById(id).orElse(null)), HttpStatus.OK);
    }

    @PutMapping("/update-park")
    public ResponseEntity<NationalPark> updatePark(@RequestBody NationalParkDTO nationalParkDTO){
        NationalParkDTO parkInfo = mapper.modelToDto(repository.findById(nationalParkDTO.getParkId()).orElse(null));

        NationalPark nationalPark = repository.save(mapper.dtoToModel(nationalParkDTO));
        return new ResponseEntity<>
                (nationalPark, HttpStatus.OK);
    }

    @DeleteMapping("/delete-park/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkByPK(@PathVariable Long id){
        NationalParkDTO parkId = mapper.modelToDto(repository.findById(id).orElse(null));

        repository.deleteById(parkId.getParkId());
    }


}
