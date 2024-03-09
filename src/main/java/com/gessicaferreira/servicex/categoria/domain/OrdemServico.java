package com.gessicaferreira.servicex.categoria.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


    @Data
    @Entity
    @Table(name = "ORDEMSERVICO")
    public class OrdemServico {
        @Id
        @GeneratedValue
        @Column(name = "ID_ORDEM_SERVICO")
        private Long idOrdemServico;
        @Column(name = "VALOR")
        private Double valorOrdemServico;
        @Column(name = "DATA_SOLICITACAO")
        private Date dataSolicitacao;

        public OrdemServico() {
        }

        public OrdemServico(Long idOrdemServico, Double valorOrdemServico, Date dataSolicitacao) {
            this.idOrdemServico = idOrdemServico;
            this.valorOrdemServico = valorOrdemServico;
            this.dataSolicitacao = dataSolicitacao;
        }
    }

