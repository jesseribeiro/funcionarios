package br.com.cadastro.funcionarios.exception;

public class EmailCadastradoException extends RuntimeException {

    public EmailCadastradoException() {
        super("Esse email já foi cadastrado. Tente outro!");
    }
}
