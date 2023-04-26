package com.example.realEstate.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String firstName;
    private long id;

    public LoginResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public LoginResponse(String accessToken, String refreshToken, String firstName, long userId) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.firstName = firstName;
        this.id = userId;
    }
}
