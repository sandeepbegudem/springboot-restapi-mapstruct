package com.codingwith.sandeepb.nationalparks.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NationalParkDTO {

    @Id
    private Long parkId;
    private String parkName;
    private String state;
    private String country;
}
