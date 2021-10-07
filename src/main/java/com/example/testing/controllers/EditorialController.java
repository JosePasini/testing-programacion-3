package com.example.testing.controllers;

import com.example.testing.dto.EditorialDto;
import com.example.testing.entities.Editorial;
import com.example.testing.entities.Libro;
import com.example.testing.repositories.EditorialRepository;
import com.example.testing.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() throws Exception{
        try{
            List<Editorial> editorialList = this.editorialService.findAll();
            List<EditorialDto> editorialDtoList = EditorialDto.mapToDtoList(editorialList);
            return ResponseEntity.status(HttpStatus.OK).body(editorialDtoList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Editorial editorial) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(editorialService.save(editorial));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

}
