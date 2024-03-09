package com.gessicaferreira.servicex.categoria.resources;

import com.gessicaferreira.servicex.categoria.domain.Categoria;
import com.gessicaferreira.servicex.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;

    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){

        Categoria novaCategoria = categoriaService.criarCategoria(categoria);
        return  new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }
}
