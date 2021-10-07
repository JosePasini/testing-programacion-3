package com.example.testing.entities;

import com.example.testing.dto.ReseniaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resenia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resenia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_libro")
    private Libro libro;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Resenia mapToEntity(ReseniaDto reseniaDto) throws Exception{
        try {
            Resenia resenia = modelMapper.map(reseniaDto, Resenia.class);
            return resenia;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public static List<Resenia> mapToEntityList(List<ReseniaDto> reseniaDtoList) throws Exception{
        List<Resenia> resenias = new ArrayList<>();
        try {
            for (ReseniaDto r : reseniaDtoList) {
                resenias.add(mapToEntity(r));
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return resenias;
    }

}
