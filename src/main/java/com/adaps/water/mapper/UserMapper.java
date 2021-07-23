package com.adaps.water.mapper;

import com.adaps.water.dto.UserDto;
import com.adaps.water.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto entityToDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastname(entity.getLastname());
        dto.setCi(entity.getCi());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setAge(entity.getAge());
        return dto;
    }

    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLastname(dto.getLastname());
        entity.setCi(dto.getCi());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAge(dto.getAge());
        return entity;
    }

}
