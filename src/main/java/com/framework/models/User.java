package com.framework.models;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;

    public static User createRandomUser() {
        return User.builder()
                .username("user_" + System.currentTimeMillis())
                .email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123!")
                .firstName("Test")
                .lastName("User")
                .isActive(true)
                .build();
    }
}
