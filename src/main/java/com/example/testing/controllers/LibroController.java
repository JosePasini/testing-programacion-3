package com.example.testing.controllers;

import com.example.testing.dto.LibroDto;
import com.example.testing.entities.Libro;
import com.example.testing.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws Exception{
        try{
            Libro libro = this.libroService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(libro);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() throws Exception{
        try{
            List<Libro> libroList = this.libroService.findAll();
            List<LibroDto> libroDtoList = LibroDto.mapToDtoList(libroList);
            return ResponseEntity.status(HttpStatus.OK).body(libroDtoList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Libro libro) throws Exception{
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.save(libro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @PostMapping("/create-dto")
    public ResponseEntity<?> create_dto(@RequestBody LibroDto libroDto) throws Exception{
        try{
            Libro libro = Libro.mapToEntity(libroDto);
            this.libroService.save(libro);
            LibroDto libroDto1 = LibroDto.mapToDto(libro);
            return ResponseEntity.status(HttpStatus.OK).body(libroDto1);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            if(this.libroService.findById(id) != null) {
                return ResponseEntity.status(HttpStatus.OK).body(this.libroService.delete(id));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro libro ){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(libroService.update(id, libro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor itente nuevamente.\"}");
        }
    }


}
