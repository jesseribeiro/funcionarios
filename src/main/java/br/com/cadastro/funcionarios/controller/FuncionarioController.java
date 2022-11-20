package br.com.cadastro.funcionarios.controller;

import br.com.cadastro.funcionarios.bean.FuncionarioBean;
import br.com.cadastro.funcionarios.dto.FuncionarioDTO;
import br.com.cadastro.funcionarios.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/v1/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findAll() {
        List<FuncionarioBean> products = funcionarioService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(funcionarioService.getByIdDTO(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid @NotNull FuncionarioDTO dto, UriComponentsBuilder uriBuilder) {
        try {
            FuncionarioDTO funcionarioDTO = funcionarioService.salvar(dto);
            URI uri = uriBuilder.path("/topicos/" + funcionarioDTO.getId()).build().toUri();
            return ResponseEntity.created(uri).body(funcionarioDTO);
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid @NotNull FuncionarioDTO dto) {
        try {
            return ResponseEntity.ok(funcionarioService.update(id, dto));
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            funcionarioService.delete(id);
            return ResponseEntity.ok("Funcionário excluído com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível excluir - " + e.getMessage());
        }
    }
}
