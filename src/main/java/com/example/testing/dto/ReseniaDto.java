package com.example.testing.dto;
import com.example.testing.entities.Autor;
import com.example.testing.entities.Libro;
import com.example.testing.entities.Resenia;
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
public class ReseniaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    @JsonIgnoreProperties
    private Libro libro;


    private static ModelMapper modelMapper = new ModelMapper();

    public static ReseniaDto mapToDto(Resenia resenia) throws Exception{
        try {
            ReseniaDto reseniaDto = modelMapper.map(resenia, ReseniaDto.class);
            return reseniaDto;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<ReseniaDto> mapToDtoList(List<Resenia> resenias) throws Exception{
        try {
            List<ReseniaDto> reseniaDtosList = new ArrayList<>();
            for (Resenia r:resenias) {
                reseniaDtosList.add(mapToDto(r));
            }
            return reseniaDtosList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
