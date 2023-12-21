package com.stavaray.reactiveapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("productos")
public class Product {

    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal precio;

}
