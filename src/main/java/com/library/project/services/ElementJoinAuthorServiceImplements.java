package com.library.project.services;

import com.library.project.dto.ElementJoinAuthorDto;
import com.library.project.mappers.BuilderToDto;
import com.library.project.models.ElementJoinAuthor;
import com.library.project.models.PrintedElement;
import com.library.project.repositories.ElementJoinAuthorRepository;
import com.library.project.mappers.BuilderToModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ElementJoinAuthorServiceImplements implements ElementJoinAuthorService{
    ElementJoinAuthorRepository elementJoinAuthorRepository;

    @Override
    public List<ElementJoinAuthorDto> getAllData() {
        List<ElementJoinAuthor> elementJoinAuthors = elementJoinAuthorRepository.findAll();
        List<ElementJoinAuthorDto> elementJoinAuthorDtos = new ArrayList<>();
        elementJoinAuthors.forEach(elementJoinAuthor -> elementJoinAuthorDtos.add(BuilderToDto.toDto(elementJoinAuthor)));
        return elementJoinAuthorDtos;
    }

    @Override
    public void saveData(ElementJoinAuthorDto elementJoinAuthorDto) {
        elementJoinAuthorRepository.save(BuilderToModel.toModel(elementJoinAuthorDto));
    }

    @Override
    public void deleteDataById(int id) {
        elementJoinAuthorRepository.deleteById(id);
    }

    @Override
    public List<ElementJoinAuthorDto> getDataByPrintedElement(PrintedElement printedElement) {
        List<ElementJoinAuthor> elementJoinAuthors = elementJoinAuthorRepository.findAllByPrintedElementId(printedElement);
        List<ElementJoinAuthorDto> elementJoinAuthorDtos = new ArrayList<>();
        elementJoinAuthors.forEach(elementJoinAuthor -> elementJoinAuthorDtos.add(BuilderToDto.toDto(elementJoinAuthor)));
        return elementJoinAuthorDtos;
    }
}
