package com.library.project.services;

import com.library.project.dto.TokenDto;
import com.library.project.dto.UserDto;
import com.library.project.mappers.BuilderToDto;
import com.library.project.mappers.BuilderToModel;
import com.library.project.models.Token;
import com.library.project.repositories.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TokenServiceImplements implements TokenService{
    TokenRepository tokenRepository;
    @Override
    public List<TokenDto> getAllTokens() {
        List<Token> tokens = tokenRepository.findAll();
        List<TokenDto> tokenDtos = new ArrayList<>();
        tokens.forEach(token -> tokenDtos.add(BuilderToDto.toDto(token)));
        return tokenDtos;
    }

    @Override
    public void saveToken(TokenDto tokenDto) {
        tokenRepository.save(BuilderToModel.toModel(tokenDto));
    }

    @Override
    public List<TokenDto> getTokenByUser(UserDto userDto) {
        List<Token> tokens = tokenRepository.findByUser(BuilderToModel.toModel(userDto));
        List<TokenDto> tokenDtos = new ArrayList<>();
        tokens.forEach(token -> tokenDtos.add(BuilderToDto.toDto(token)));
        return tokenDtos;
    }

    @Override
    public void updateTokens(List<TokenDto> tokenDtos) {
        List<Token> tokens = new ArrayList<>();
        tokenDtos.forEach(tokenDto -> tokens.add(BuilderToModel.toModel(tokenDto)));
        tokenRepository.saveAll(tokens);
    }
}
