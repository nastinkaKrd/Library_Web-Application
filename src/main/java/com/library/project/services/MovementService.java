package com.library.project.services;

import com.library.project.dto.MovementDto;
import com.library.project.dto.ReaderDto;
import com.library.project.dto.PrintedElementDto;
import java.util.List;
public interface MovementService {
    List<MovementDto> getElementsAndReaders();
    List<MovementDto> getDataByReader(ReaderDto reader);
    List<MovementDto> getDataByElements(PrintedElementDto printedElement);
    MovementDto getDataById(int id);
    void saveData(MovementDto movement);
    void deleteById(int id);
}
