package ru.panteleeva.dictionary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "dictionary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryEntity {
    @Id
    @Column(name = "id")
    private String uuid;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "dictionary")
    private List<DataEntity> datas;
}
