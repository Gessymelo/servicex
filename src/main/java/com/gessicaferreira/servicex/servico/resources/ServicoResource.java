package com.gessicaferreira.servicex.servico.resources;




import com.gessicaferreira.servicex.servico.domain.Servico;
import com.gessicaferreira.servicex.servico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/servico")
public class ServicoResource {
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){
        Servico novoServico = servicoService.criarServico(servico);
        return  new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarServico(){
        List<Servico> servicos = servicoService.listarServico();
        return new ResponseEntity<>(servicos,HttpStatus.OK);
    }
    @GetMapping("/{idServico}")
    public ResponseEntity<Servico> buscarServico(@PathVariable Long idServico){
        return servicoService.buscarServico(idServico)
                .map(servico -> new ResponseEntity(servico, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException("Servico nao encontrado."));

    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long idServico){
        servicoService.deletarServico(idServico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{idServico}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Long idServico, @RequestBody Servico servico){
        if (!servicoService.buscarServico(idServico).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servico.setIdServico(idServico);
        Servico novoServico = servicoService.atualizarServico(servico);
        return new ResponseEntity<>(novoServico,HttpStatus.OK);
    }






}
