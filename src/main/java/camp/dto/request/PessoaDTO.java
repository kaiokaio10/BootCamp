package camp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String primeiroNome;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String sobrenome;
	
	@NotEmpty
	@CPF
	private String cpf;
	
    @NotNull
	private String dataDeNascimento;
    
    @Valid
    @NotEmpty
	private List<TelefoneDTO> telefones;
}