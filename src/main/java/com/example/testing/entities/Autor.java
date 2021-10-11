package com.example.testing.entities;

import com.example.testing.dto.AutorDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor implements Serializable {

    @Id
    private Long id;

    private String nombre;

    private String email;

    @ToString.Exclude
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Autor mapToEntity(AutorDto autorDto) throws Exception{
        try {
            Autor autor = modelMapper.map(autorDto, Autor.class);
            return autor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<Autor> mapToEntityList(List<AutorDto> autorDtoList) throws Exception{
        List<Autor> autores = new ArrayList<>();
        try {
            for (AutorDto a : autorDtoList) {
                autores.add(mapToEntity(a));
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return autores;
    }

    public Autor(Long id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }


}
