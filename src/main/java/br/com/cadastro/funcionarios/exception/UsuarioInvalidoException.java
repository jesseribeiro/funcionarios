package br.com.cadastro.funcionarios.exception;

public class UsuarioInvalidoException extends RuntimeException {

    public UsuarioInvalidoException() {
        super("Funcionário não encontrado!");
    }
}
