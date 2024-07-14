package ru.panteleeva.dictionary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.panteleeva.dictionary.dto.CreateUpdateDataDto;
import ru.panteleeva.dictionary.dto.DataDto;
import ru.panteleeva.dictionary.service.DataService;

import java.util.UUID;

@Tag(name = "Data controller", description = "Creation and updating datas")
@RestController
@RequestMapping("dictionary/data")
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @Operation(summary = "Create new data")
    @PostMapping
    public DataDto save (@RequestBody @Parameter(description = "Params for data node") CreateUpdateDataDto createUpdateDataDto){
        return dataService.save(createUpdateDataDto);
    }

    @Operation(summary = "Get data by id")
    @GetMapping("/{id}")
    public DataDto getById(@PathVariable @Parameter(description = "Data id") UUID id){
        return dataService.getById(id.toString());
    }
}
