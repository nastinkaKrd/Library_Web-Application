package com.library.project.services;

import com.library.project.dto.MovementDto;
import com.library.project.dto.ReaderDto;
import com.library.project.mappers.BuilderToDto;
import com.library.project.models.Movement;
import com.library.project.repositories.MovementRepository;
import com.library.project.dto.PrintedElementDto;
import com.library.project.mappers.BuilderToModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovementServiceImplements implements MovementService{
    MovementRepository movementRepository;
    @Override
    public List<MovementDto> getElementsAndReaders() {
        List<MovementDto> movementDtos = new ArrayList<>();
        List<Movement> movements = movementRepository.findAll();
        movements.forEach(movement -> movementDtos.add(BuilderToDto.toDto(movement)));
        return movementDtos;
    }

    @Override
    public List<MovementDto> getDataByReader(ReaderDto reader) {
        List<MovementDto> movementDtos = new ArrayList<>();
        List<Movement> movements =  movementRepository.findAllByReader(BuilderToModel.toModel(reader));
        movements.forEach(movement -> movementDtos.add(BuilderToDto.toDto(movement)));
        return movementDtos;
    }

    @Override
    public List<MovementDto> getDataByElements(PrintedElementDto printedElement) {
        List<MovementDto> movementDtos = new ArrayList<>();
        List<Movement> movements =  movementRepository.findAllByPrintedElement(BuilderToModel.toModel(printedElement));
        movements.forEach(movement -> movementDtos.add(BuilderToDto.toDto(movement)));
        return movementDtos;
    }

    @Override
    public MovementDto getDataById(int id) {
        return BuilderToDto.toDto(movementRepository.findById(id).get());
    }

    @Override
    public void saveData(MovementDto movement) {
        movementRepository.save(BuilderToModel.toModel(movement));
    }

    @Override
    public void deleteById(int id) {
        movementRepository.deleteById(id);
    }
}
