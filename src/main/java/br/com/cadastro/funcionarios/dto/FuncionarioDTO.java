package br.com.cadastro.funcionarios.dto;

import br.com.cadastro.funcionarios.bean.FuncionarioBean;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    @Size(min = 2, max = 30, message = "Nome deve ter entre 2 e 30 caracteres")
    private String nome;

    @Size(min = 2, max = 50, message = "Sobrenome deve ter entre 2 e 50 caracteres")
    private String sobrenome;

    @Email(message = "Email precisa ser válido")
    private String email;

    @PositiveOrZero(message = "NIS/PIS precisa ser válido")
    private Integer nisPis;

    public FuncionarioDTO(FuncionarioBean bean) {
        id = bean.getId();
        nome = bean.getNome();
        sobrenome = bean.getSobrenome();
        email = bean.getEmail();
        nisPis = bean.getNisPis();
    }
}
