package com.example.testing.entities;

import com.example.testing.dto.EditorialDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libroList = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public static Editorial mapToEntity(EditorialDto editorialDto) throws Exception{
        try {
            Editorial editorial = modelMapper.map(editorialDto, Editorial.class);
            return editorial;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<Editorial> mapToEntityList(List<EditorialDto> editorialDtos) throws Exception{
        List<Editorial> editoriales = new ArrayList<>();
        try {
            for (EditorialDto e : editorialDtos) {
                editoriales.add(mapToEntity(e));
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return editoriales;
    }

}
