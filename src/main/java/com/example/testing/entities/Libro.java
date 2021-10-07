package com.example.testing.entities;

import com.example.testing.dto.LibroDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String isbn;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor")
    private Autor autor;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resenia> reseniaList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "editorial")
    private Editorial editorial;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Libro mapToEntity(LibroDto libroDto) throws Exception{
        try {
            Libro libro = modelMapper.map(libroDto, Libro.class);
            return libro;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<Libro> mapToEntityList(List<LibroDto> libroDtoList) throws Exception{
        List<Libro> libros = new ArrayList<>();
        try {
            for (LibroDto l : libroDtoList) {
                libros.add(mapToEntity(l));
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return libros;
    }

}
