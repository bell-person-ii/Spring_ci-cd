package me.dev.cicd_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.dev.cicd_test.entity.User;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private String name;
    private Integer age;

    public User toEntity(){
        return User.builder()
                .name(name)
                .age(age)
                .build();
    }
}
