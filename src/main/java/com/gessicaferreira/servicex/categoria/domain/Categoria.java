package com.gessicaferreira.servicex.categoria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gessicaferreira.servicex.servico.domain.Servico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
    @Entity
    @Table(name = "CATEGORIA")
    public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_CATEGORIA")
        private Long idCategoria;
        @Column(name = "NOME_CATEGORIA")
        private String nomeCategoria;
        @JsonIgnore
        @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
        private List<Servico> servicos;

        public Categoria(){
        }

        public Categoria(Long idCategoria, String nomeCategoria, List<Servico> servicos) {
            this.idCategoria = idCategoria;
            this.nomeCategoria = nomeCategoria;
            this.servicos = servicos;
        }
    }

