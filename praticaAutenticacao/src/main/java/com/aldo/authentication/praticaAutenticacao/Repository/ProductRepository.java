package com.aldo.authentication.praticaAutenticacao.Repository;

import com.aldo.authentication.praticaAutenticacao.domain.product.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDomain, Long> {
}
