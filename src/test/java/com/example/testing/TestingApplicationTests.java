package com.example.testing;

import com.example.testing.dto.AutorDto;
import com.example.testing.dto.LibroDto;
import com.example.testing.entities.Autor;
import com.example.testing.entities.Libro;
import com.example.testing.repositories.AutorRepository;
import com.example.testing.repositories.LibroRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestingApplicationTests {

    @Test
    public void A(){
        System.out.println("HOla");
    }

/*
    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LibroRepository libroRepository;

    @Test
    @Order(1)
    public void testCreate_autor() {
        Autor autor = Autor.builder()
                .id(1L)
                .nombre("Caballo")
                .build();

        autorRepository.save(autor);
        Assertions.assertNotNull(autorRepository.findById(1L).get());
    }


    @Test
    @Order(2)
    public void testReadAll_autor() {
        List<Autor> autores = autorRepository.findAll();
        org.assertj.core.api.Assertions.assertThat(autores).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void testReadSingle_autor() {
        Autor autor = autorRepository.findById(1L).get();
        Assertions.assertEquals("Caballo", autor.getNombre());
    }

    @Test
    @Order(4)
    public void testUpdate_autor() {
        Autor autor = autorRepository.findById(1L).get();
        autor.setNombre("Caballo");
        autorRepository.save(autor);
        Assertions.assertNotEquals("Pony", autorRepository.findById(1L).get().getNombre());
    }

    @Test
    @Order(11)
    public void testDelete_autor() {
        Autor autor = new Autor();
        autor.setId(1L);
        autorRepository.save(autor);
        autorRepository.deleteById(1L);
        org.assertj.core.api.Assertions.assertThat(autorRepository.existsById(1L)).isFalse();
    }


    @Test
    @Order(6)
    public void test_libro(){
        Libro libro = new Libro();
        libro.setId(1L);
        libro.setNombre("Harry Potter");
        libro.setIsbn("HH1234");
        libro.setAutor(autorRepository.findById(1L).get());
        System.out.println(libro);
        libroRepository.save(libro);
        System.out.println(libro);
        Assertions.assertNotNull(libroRepository.findById(1L).get());
    }

    @Test
    @Order(7)
    public void readAll_libro(){
        List<Libro> libros = libroRepository.findAll();
        org.assertj.core.api.Assertions.assertThat(libros).size().isGreaterThan(0);
    }

    @Test
    @Order(8)
    public void readOne_libro(){
        Libro libro = libroRepository.findById(1L).get();
        String libro_test = "Harry Potter";
        Assertions.assertEquals(libro_test, libro.getNombre());
    }

    @Test
    @Order(9)
    public void update_libro(){
        Libro libro = this.libroRepository.findById(1L).get();
        libro.setNombre("Pepe Lui");
        this.libroRepository.save(libro);
        Assertions.assertEquals("Pepe Lui", this.libroRepository.findById(1L).get().getNombre());
    }

    @Test
    @Order(10)
    public void delete_libro(){
        this.libroRepository.delete(libroRepository.getById(1L));
        Assertions.assertNotNull(libroRepository.getById(1L));
    }

    @Test
    @Order(12)
    public void test_mapeo_entidad_autor() throws Exception {
        AutorDto autorDto = new AutorDto();
        Autor autor = Autor.mapToEntity(autorDto);
        autor.setId(2L);
        autor.setNombre("Jose Pasini");
        Assertions.assertEquals("Jose Pasini", autor.getNombre());
    }

    @Test
    @Order(13)
    public void test_mapeo_lista_entidad() throws Exception{
        List<AutorDto> autoresDto = new ArrayList<>();
        List<Autor> autores = Autor.mapToEntityList(autoresDto);
        autores.add(new Autor());
        org.assertj.core.api.Assertions.assertThat(autores).size().isGreaterThan(0);
    }

    @Test
    @Order(14)
    public void test_mapeo_entidad_libro() throws Exception {
        LibroDto libroDto = new LibroDto();
        Libro libro = Libro.mapToEntity(libroDto);
        libroDto.setId(2L);
        libroDto.setNombre("El se??or de los anillos");
        Assertions.assertEquals("El se??or de los anillos", libroDto.getNombre());
    }

*/
}