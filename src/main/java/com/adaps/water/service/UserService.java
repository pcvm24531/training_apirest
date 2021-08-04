package com.adaps.water.service;

import com.adaps.water.dto.UserDto;
import com.adaps.water.exception.BadRequestExceptionHandler;
import com.adaps.water.exception.NotFoundExceptionHandler;
import com.adaps.water.mapper.UserMapper;
import com.adaps.water.persistence.entity.UserEntity;
import com.adaps.water.persistence.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto create(UserDto userDto) {
        UserEntity newUserEntity = userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(userRepository.save(newUserEntity));
    }

    public ResponseEntity<?> read(Long id) {
        Optional<UserEntity> searchUserEntity = userRepository.findById(id);
        if (searchUserEntity.isEmpty()) throw new NotFoundExceptionHandler("USER with ID: " + id + " not found");
        return new ResponseEntity<>(userMapper.entityToDto(searchUserEntity.get()), HttpStatus.OK);
    }

    public ResponseEntity<?> update(UserDto userDto, Long id) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new NotFoundException("User with ID: " + id + " not found");
        }

        UserEntity updateUserEntity = new UserEntity();
        updateUserEntity.setId(id);
        updateUserEntity.setName(userDto.getName());
        updateUserEntity.setLastname(userDto.getLastname());
        updateUserEntity.setCi(userDto.getCi());
        updateUserEntity.setDateOfBirth(userDto.getDateOfBirth());
        updateUserEntity.setAge(userDto.getAge());
        userRepository.save(updateUserEntity);
        return new ResponseEntity<>(userMapper.entityToDto(updateUserEntity), HttpStatus.OK);
    }

    public void delete(Long id) throws NotFoundException {
        Optional<UserEntity> deleteUserEntity = userRepository.findById(id);
        if (deleteUserEntity.isEmpty()) {
            throw new NotFoundException("User with ID: " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public List<UserDto> list() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity user : users) userDtoList.add(userMapper.entityToDto(user));
        return userDtoList;
    }
}
