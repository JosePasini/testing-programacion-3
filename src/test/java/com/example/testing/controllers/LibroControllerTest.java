package com.example.testing.controllers;

import com.example.testing.dto.LibroDto;
import com.example.testing.entities.Autor;
import com.example.testing.entities.Libro;
import com.example.testing.services.LibroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class LibroControllerTest {


    @Mock
    private LibroService libroService;
    @InjectMocks
    private LibroController libroController;

    private Libro libro;
    private Libro libro2;

    private LibroDto libroDto;

    private List<Libro> libroList;
    private List<LibroDto> libroDtoList;

    @BeforeEach
    void setUp() throws Exception {
        //libroService = mock(LibroService.class);
        //libroController = new LibroController(libroService);

        libro = Libro.builder()
                .id(1L)
                .nombre("La casa de Bernarda Alba")
                .isbn("1234")
                .autor(new Autor(1L, "Federico García Lorca", "fgl@gmail.com"))
                .build();

        libro2 = new Libro(2L, "Babilonia", "999" , new Autor());

        libroDto = LibroDto.mapToDto(libro);

        libroList = Arrays.asList(libro, libro2);

        libroDtoList = LibroDto.mapToDtoList(libroList);

    }


    @Test
    void getOne() throws Exception {
        when(libroService.findById(any(Long.class))).thenReturn(libro);
        ResponseEntity<?> ok = libroController.getOne(1L);
        assertEquals(ok, new ResponseEntity<>(libro, HttpStatus.OK));
    }

    @Test
    void getAll() throws Exception {
        when(libroService.findAll()).thenReturn(libroList);
        ResponseEntity<?> ok = libroController.getAll();
        assertEquals(ok, new ResponseEntity<>(libroDtoList, HttpStatus.OK));
    }

    @Test
    void create() throws Exception {
        when(libroService.save(any(Libro.class))).thenReturn(libro2);
        ResponseEntity<?> ok = libroController.create(libro2);
        assertEquals(ok, new ResponseEntity<>(libro2, HttpStatus.OK));
    }

    @Test
    void create_dto() throws Exception {
        when(libroService.save(any(Libro.class))).thenReturn(libro2);
        ResponseEntity<?> ok = libroController.create_dto(libroDto);
        assertEquals(ok, new ResponseEntity<>(libroDto, HttpStatus.OK));
    }

    @Test
    void delete() throws Exception {
        when(libroService.findById(any(Long.class))).thenReturn(libro);
        when(libroService.delete(libro.getId())).thenReturn(true);
        ResponseEntity<?> ok = libroController.delete(1L);
        assertEquals(ok, new ResponseEntity<>(true, HttpStatus.OK));
    }

    @Test
    void updateTest() throws Exception {
        when(libroService.update(libro.getId(), libro)).thenReturn(libro2);
        ResponseEntity<?> ok = libroController.update(1L, libro);
        assertAll("updateTest", ()-> assertEquals(ok, new ResponseEntity<>(libro2, HttpStatus.OK)),
                ()-> assertEquals("Babilonia", libro2.getNombre()));
    }


}