package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.dto.AuthenticationResponse;
import ifg.edu.rayhbank.dto.LoginRequest;
import ifg.edu.rayhbank.dto.RefreshTokenRequest;
import ifg.edu.rayhbank.dto.RegisterRequest;

public interface AuthService{
    public void signup(RegisterRequest registerRequest);

    void verifyAccount(String token);
    public AuthenticationResponse login(LoginRequest loginRequest);
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
