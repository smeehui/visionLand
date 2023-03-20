package com.hah.model;

import com.hah.model.enums.EDirection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_direction")
public class ProductDirection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private EDirection direction;
}
