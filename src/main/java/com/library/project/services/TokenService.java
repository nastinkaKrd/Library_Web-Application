package com.library.project.services;

import com.library.project.dto.TokenDto;
import com.library.project.dto.UserDto;
import java.util.List;

public interface TokenService {
    List<TokenDto> getAllTokens();
    void saveToken(TokenDto tokenDto);
    List<TokenDto> getTokenByUser(UserDto userDto);
    void updateTokens(List<TokenDto> tokenDtos);
}
