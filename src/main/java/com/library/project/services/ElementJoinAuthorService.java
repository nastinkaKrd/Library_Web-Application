package com.library.project.services;

import com.library.project.dto.ElementJoinAuthorDto;
import com.library.project.models.PrintedElement;
import java.util.List;

public interface ElementJoinAuthorService {
    List<ElementJoinAuthorDto> getDataByPrintedElement(PrintedElement printedElement);
    List<ElementJoinAuthorDto> getAllData();
    void saveData(ElementJoinAuthorDto elementJoinAuthorDto);
    void deleteDataById(int id);
}
