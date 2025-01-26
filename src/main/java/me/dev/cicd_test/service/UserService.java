package me.dev.cicd_test.service;

import lombok.RequiredArgsConstructor;
import me.dev.cicd_test.dto.JoinDto;
import me.dev.cicd_test.entity.User;
import me.dev.cicd_test.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@RequiredArgsConstructor

@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User join(JoinDto joinDto) {
        User entity = joinDto.toEntity();
        userRepository.save(entity);
        return entity;
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("조회불가"));
    }
}
