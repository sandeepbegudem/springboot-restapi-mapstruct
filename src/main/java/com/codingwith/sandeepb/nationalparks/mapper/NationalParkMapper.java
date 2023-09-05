package com.codingwith.sandeepb.nationalparks.mapper;

import com.codingwith.sandeepb.nationalparks.dto.NationalParkDTO;
import com.codingwith.sandeepb.nationalparks.entity.NationalPark;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NationalParkMapper {

    NationalParkMapper NATIONAL_PARK_MAPPER = Mappers.getMapper(NationalParkMapper.class);

    NationalParkDTO modelToDto(NationalPark nationalPark);
    NationalPark dtoToModel(NationalParkDTO nationalParkDTO);

    List<NationalParkDTO> allNationalParksToDto(List<NationalPark> parks);


}
