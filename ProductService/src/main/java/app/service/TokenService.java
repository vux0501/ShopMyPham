package app.service;

import app.entity.Token;

public interface TokenService {

    Token findByToken(String token);
    
}
