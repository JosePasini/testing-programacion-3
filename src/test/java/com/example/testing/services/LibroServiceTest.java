package com.example.testing.services;

import com.example.testing.builder.LibroBuilder;
import com.example.testing.entities.Autor;
import com.example.testing.entities.Libro;
import com.example.testing.repositories.LibroRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LibroServiceTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroService libroService;

    @Mock
    private Libro libro;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libro = Libro.builder()
                .id(1L)
                .nombre("La casa de Bernarda Alba")
                .isbn("BA 123")
                .autor(new Autor(1L, "Federico García Lorca", "fgl@gmail.com"))
                .build();

        libro2 = Libro.builder()
                .id(2L)
                .nombre("Babilonia")
                .isbn("BB 654")
                .autor(new Autor(2L, "Armando Discépolo", " ad@gmail.com"))
                .build();
    }

    @Test
    void findByIdTest() throws Exception {
        when(libroRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(libro));
        Assertions.assertAll("findByIdTest", ()-> Assertions.assertEquals("La casa de Bernarda Alba", libroService.findById(1L).getNombre()),
                ()-> Assertions.assertNotNull(libroService.findById(1L)));
    }

    @Test
    void findAllTest() throws Exception {
        when(libroRepository.findAll()).thenReturn(Arrays.asList(libro, libro2));
        Assertions.assertEquals(libroService.findAll(), Arrays.asList(libro, libro2));
        Assertions.assertNotNull(libroService.findAll());
    }

    @Test
    void saveTest() throws Exception {
        when(libroRepository.save(any(Libro.class))).thenReturn(libro);
        Assertions.assertNotNull(libroService.save(libro2));
    }

    @Test
    void updateTest() throws Exception {
    }

    @Test
    void delete() throws Exception {
        System.out.println(libro.getNombre() + "\n" + libro.getId());
    }

}