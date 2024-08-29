package org.example.keycloakintegration.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String username;
    private String password;
    private String role;
}