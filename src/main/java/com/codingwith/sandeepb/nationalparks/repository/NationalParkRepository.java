package com.codingwith.sandeepb.nationalparks.repository;

import com.codingwith.sandeepb.nationalparks.entity.NationalPark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalParkRepository extends JpaRepository<NationalPark, Long> {
}
