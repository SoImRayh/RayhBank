package ifg.edu.rayhbank.service;

import ifg.edu.rayhbank.domain.RefreshToken;

public interface RefreshTokenService {
    public RefreshToken generateRefreshToken();
    void validateRefreshToken(String token);
    public void deleteRefreshToken(String token);
}
