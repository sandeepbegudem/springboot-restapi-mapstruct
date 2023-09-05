package com.codingwith.sandeepb.nationalparks.mapper;

import com.codingwith.sandeepb.nationalparks.entity.Traveller;
import com.codingwith.sandeepb.nationalparks.repository.TravellerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TravellerService {

    @Autowired
    private TravellerRepository travellerRepository;

    Logger logger = LoggerFactory.getLogger(TravellerService.class);


    public TravellerDTO modelToDto(Traveller traveller) {
        if ( traveller == null ) {
            return null;
        }

        TravellerDTO travellerDTO = new TravellerDTO();

        travellerDTO.setId(traveller.getId());
        travellerDTO.setName(traveller.getName());
        travellerDTO.setAge( traveller.getAge());
        travellerDTO.setEmail( traveller.getEmail());
        travellerDTO.setPhone(traveller.getPhone());

        return travellerDTO;
    }


    @Async
    public CompletableFuture<List<TravellerDTO>> getAllTravellers(){

        logger.info("get list of user by "+Thread.currentThread().getName().toUpperCase());
        List<TravellerDTO> collect = travellerRepository.findAll().stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(collect);
    }




    @Async
    public CompletableFuture<List<Traveller>> saveTraveller(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<Traveller> travellerList = parseCSVFile(file);
        logger.info("saving list of users of size {}, current thread: {}", file.getSize(), Thread.currentThread().getName());
        List<Traveller> savedTravellers = travellerRepository.saveAll(travellerList);
        long end = System.currentTimeMillis();
        logger.info("total time taken: {} milli seconds", (end - start));
        return CompletableFuture.completedFuture(savedTravellers);
    }
    private List<Traveller> parseCSVFile(final MultipartFile file) throws Exception {
        final List<Traveller> travellers = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final Traveller traveller = new Traveller();
                    traveller.setName(data[0]);
                    traveller.setAge(data[1]);
                    traveller.setEmail(data[2]);
                    traveller.setPhone(data[3]);
                    travellers.add(traveller);
                }
                return travellers;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse Json file {}", e);
            throw new Exception("Failed to parse Json file {}", e);
        }
    }
}
