package ru.panteleeva.dictionary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.panteleeva.dictionary.dto.CreateUpdateDataDto;
import ru.panteleeva.dictionary.dto.DataDto;
import ru.panteleeva.dictionary.exception.DataNotFoundException;
import ru.panteleeva.dictionary.exception.DictionaryNotFoundException;
import ru.panteleeva.dictionary.model.DataEntity;
import ru.panteleeva.dictionary.repository.DataRepository;
import ru.panteleeva.dictionary.repository.DictionaryRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;

    private final DictionaryService dictionaryService;

    @Transactional
    public DataDto save(CreateUpdateDataDto createUpdateDataDto){
        var dictionary = dictionaryService.getDictionaryEntityById(createUpdateDataDto.getDictionaryId());

        var entity = new DataEntity(
                UUID.randomUUID().toString(),
                dictionary,
                createUpdateDataDto.getCode(),
                createUpdateDataDto.getValue()
        );
        var savedEntity = dataRepository.save(entity);
        return new DataDto(
                savedEntity.getUuid(),
                savedEntity.getDictionary().getUuid(),
                savedEntity.getCode(),
                savedEntity.getValue()
        );
    }

    public DataDto getById(String id) {
        var entity = dataRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException("Данные с id " + id + " не найдены!"));
        return new DataDto(
                entity.getUuid(),
                entity.getDictionary().getUuid(),
                entity.getCode(),
                entity.getValue()
        );
    }
}
