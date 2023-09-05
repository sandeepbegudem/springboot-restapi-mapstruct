package com.codingwith.sandeepb.nationalparks.repository;

import com.codingwith.sandeepb.nationalparks.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {
}
