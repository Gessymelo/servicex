package com.gessicaferreira.servicex.categoria.repositores;

import com.gessicaferreira.servicex.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>  {
}
