package com.example.testing.dto;
import com.example.testing.entities.Editorial;
import com.example.testing.entities.Libro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorialDto {
    private Long id;
    private String nombre;
    @JsonIgnoreProperties(value = {"editorial"})
    private List<Libro> libroList = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public static EditorialDto mapToDto(Editorial editorial) throws Exception{
        try {
            EditorialDto editorialDto = modelMapper.map(editorial, EditorialDto.class);
            return editorialDto;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<EditorialDto> mapToDtoList(List<Editorial> editoriales) throws Exception{
        try {
            List<EditorialDto> editorialDtoList = new ArrayList<>();
            for (Editorial e:editoriales) {
                editorialDtoList.add(mapToDto(e));
            }
            return editorialDtoList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
