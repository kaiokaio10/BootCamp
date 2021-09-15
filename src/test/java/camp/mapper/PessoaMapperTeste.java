package camp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import camp.dto.mapper.PessoaMapper;
import camp.dto.request.PessoaDTO;
import camp.dto.request.TelefoneDTO;
import camp.entity.Pessoas;
import camp.entity.Telefone;
import camp.util.PessoaUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PessoaMapperTeste {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoas pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getPrimeiroNome(), pessoa.getPrimeiroNome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getTipo(), telefone.getTipo());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
    	Pessoas pessoa = PessoaUtils.createFakeEntity();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getPrimeiroNome(), pessoaDTO.getPrimeiroNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getTipo(), telefoneDTO.getTipo());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
    }
}