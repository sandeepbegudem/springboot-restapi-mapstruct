package com.codingwith.sandeepb.nationalparks.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NonNull
@Data
@Entity
@NoArgsConstructor
public class NationalPark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;
    private String parkName;
    private String state;
    private String country;
}
