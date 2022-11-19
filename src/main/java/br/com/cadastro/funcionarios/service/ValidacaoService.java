package br.com.cadastro.funcionarios.service;

import br.com.cadastro.funcionarios.exception.EmailCadastradoException;
import br.com.cadastro.funcionarios.repository.FuncionarioRepository;
import br.com.cadastro.funcionarios.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class ValidacaoService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public void validaEmail(String email) {
        if (!StringUtils.isEmailvalido(email)) {
            throw new RuntimeException("Email inválido!!! Por favor, insira outro");
        }

        // para aparecer uma mensagem melhor que já tem esse email cadastrado
        if (funcionarioRepository.existFuncionarioEmail(email)) {
            throw new EmailCadastradoException();
        }
    }

    public boolean validaInformacao(Object dado) {
        return (dado == null) ? false : true;
    }
}


