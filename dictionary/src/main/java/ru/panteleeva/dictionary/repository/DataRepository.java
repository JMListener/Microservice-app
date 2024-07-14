package ru.panteleeva.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.panteleeva.dictionary.model.DataEntity;
import ru.panteleeva.dictionary.model.DictionaryEntity;

import java.util.List;

public interface DataRepository extends JpaRepository<DataEntity, String> {

    List<DataEntity> findByDictionary(DictionaryEntity dictionaryEntity);
}
