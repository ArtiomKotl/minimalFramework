package com.framework.models;

public class UserModel {
    public static UserDto createUser() {
        return UserDto.builder()
                .username("user_" + System.currentTimeMillis())
                .email("test" + System.currentTimeMillis() + "@test.com")
                .password("Test123!")
                .firstName("Test")
                .lastName("User")
                .isActive(true)
                .build();
    }
}
