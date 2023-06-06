package com.library.project.mappers;

import com.library.project.dto.*;
import com.library.project.models.*;


public class BuilderToModel {
    public static Movement toModel(MovementDto movement){
        return Movement.builder()
                .moveId(movement.getMoveId())
                .status(movement.getStatus())
                .date(movement.getDate())
                .reader(toModel(movement.getReader()))
                .printedElement(toModel(movement.getPrintedElement())).build();
    }

    public static Reader toModel(ReaderDto reader){
        return Reader.builder()
                .readerId(reader.getReaderId())
                .name(reader.getName()).build();
    }

    public static PrintedElement toModel(PrintedElementDto printedElement){
        return PrintedElement.builder().elementId(printedElement.getElementId())
                .title(printedElement.getTitle())
                .type(printedElement.getType())
                .style(printedElement.getStyle())
                .amountOfElements(printedElement.getAmountOfElements())
                .yearOfPublish(printedElement.getYearOfPublish())
                .numOfPublish(printedElement.getNumOfPublish())
                .publishCompany(new PublishCompany(printedElement.getPublishCompanyId(), printedElement.getPublishCompanyName())).build();
    }

    public static Author toModel(AuthorDto authorDto){
        return Author.builder()
                .authorId(authorDto.getAuthorId())
                .name(authorDto.getName()).build();
    }

    public static PublishCompany toModel(PublishCompanyDto publishCompanyDto){
        return PublishCompany.builder()
                .publishCompanyId(publishCompanyDto.getPublishCompanyId())
                .nameOfCompany(publishCompanyDto.getNameOfCompany()).build();
    }

    public static ElementJoinAuthor toModel(ElementJoinAuthorDto elementJoinAuthor){
        PublishCompany publishCompany = new PublishCompany(elementJoinAuthor.getPublishCompanyId(),
                elementJoinAuthor.getPublishCompanyName());
        PrintedElement printedElement = new PrintedElement(elementJoinAuthor.getElementId(),
                elementJoinAuthor.getTitle(), elementJoinAuthor.getType(), elementJoinAuthor.getStyle(),
                elementJoinAuthor.getAmountOfElements(), elementJoinAuthor.getYearOfPublish(),
                elementJoinAuthor.getNumOfPublish(), publishCompany);
        Author author = new Author(elementJoinAuthor.getAuthorId(), elementJoinAuthor.getAuthorName());
        return ElementJoinAuthor.builder()
                .joinId(elementJoinAuthor.getJoinId())
                .printedElementId(printedElement)
                .authorId(author)
                .build();
    }

    public static User toModel(UserDto userDto){
        return User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .active(userDto.isActive()).build();
    }

    public static Token toModel(TokenDto tokenDto){
        return Token.builder()
                .tokenId(tokenDto.getTokenId())
                .value(tokenDto.getValue())
                .expired(tokenDto.isExpired())
                .revoked(tokenDto.isRevoked())
                .user(tokenDto.getUser()).build();}
}
