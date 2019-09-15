package com.assignment.user;

import lombok.*;

/**
 * @author shan
 * <p>
 * Successful login response
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserLoginResponse {
    @NonNull
    private String token;
}
