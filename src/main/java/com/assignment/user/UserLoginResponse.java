package com.assignment.user;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserLoginResponse {
    @NonNull
    private String accessToken;
    private String tokenType = "Bearer";
}
