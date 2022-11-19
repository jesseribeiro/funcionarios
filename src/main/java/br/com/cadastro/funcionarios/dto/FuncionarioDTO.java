package br.com.cadastro.funcionarios.dto;

import br.com.cadastro.funcionarios.bean.FuncionarioBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer nisPis;

    public FuncionarioDTO(FuncionarioBean bean) {
        id = bean.getId();
        nome = bean.getNome();
        sobrenome = bean.getSobrenome();
        email = bean.getEmail();
        nisPis = bean.getNisPis();
    }
}
