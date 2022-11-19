package br.com.cadastro.funcionarios.service;

import br.com.cadastro.funcionarios.bean.FuncionarioBean;
import br.com.cadastro.funcionarios.dto.FuncionarioDTO;
import br.com.cadastro.funcionarios.exception.UsuarioInvalidoException;
import br.com.cadastro.funcionarios.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FuncionarioService extends GenericService<FuncionarioBean, FuncionarioRepository> {

    @Autowired
    ValidacaoService validacaoService;

    public List<FuncionarioBean> findAll() {
        return convertIterableToList(getRepository().findAll());
    }

    public FuncionarioDTO getByIdDTO(Long id) {
        FuncionarioBean funcionario = getById(id);
        if (funcionario == null) {
            throw new UsuarioInvalidoException();
        }
        return new FuncionarioDTO(funcionario);
    }


    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        FuncionarioBean funcionario = new FuncionarioBean();

        validacaoService.validaEmail(dto.getEmail());

        funcionario.setNome(dto.getNome());
        funcionario.setSobrenome(dto.getSobrenome());
        funcionario.setEmail(dto.getEmail());

        // se o nis pis for nulo, será inserido o número 0
        if (validacaoService.validaInformacao(dto.getNisPis())) {
            funcionario.setNisPis(dto.getNisPis());
        }

        save(funcionario);

        return new FuncionarioDTO(funcionario);
    }


    public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
        if (id == null) {
            throw new UsuarioInvalidoException();
        }

        FuncionarioBean funcionario = getRepository().findById(id).get();

        if (validacaoService.validaInformacao(dto.getEmail()) && !dto.getEmail().equalsIgnoreCase(funcionario.getEmail())) {
            validacaoService.validaEmail(dto.getEmail());
            funcionario.setEmail(dto.getEmail());
        }
        if (validacaoService.validaInformacao(dto.getNome()) && !dto.getNome().equalsIgnoreCase(funcionario.getNome())) {
            funcionario.setNome(dto.getNome());
        }
        if (validacaoService.validaInformacao(dto.getSobrenome()) && !dto.getSobrenome().equalsIgnoreCase(funcionario.getSobrenome())) {
            funcionario.setSobrenome(dto.getSobrenome());
        }
        if (validacaoService.validaInformacao(dto.getNisPis()) && dto.getNisPis() != funcionario.getNisPis()) {
            funcionario.setNisPis(dto.getNisPis());
        }
        update(funcionario);

        return new FuncionarioDTO(funcionario);
    }


    public void delete(Long id) {
        if (id == null) {
            throw new UsuarioInvalidoException();
        }

        FuncionarioBean funcionario = getById(id);
        delete(funcionario);
    }
}


