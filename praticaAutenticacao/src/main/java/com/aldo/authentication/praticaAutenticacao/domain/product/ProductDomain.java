package com.aldo.authentication.praticaAutenticacao.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "tb_product")
@Table(name = "tb_product")
public class ProductDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;

    public ProductDomain(ProductRequestDTO productData){
        this.name = productData.name();
        this.price = productData.price();
    }

}
