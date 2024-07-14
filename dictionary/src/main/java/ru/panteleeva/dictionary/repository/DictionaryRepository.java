package ru.panteleeva.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.panteleeva.dictionary.model.DictionaryEntity;

public interface DictionaryRepository extends JpaRepository<DictionaryEntity, String> {
}
