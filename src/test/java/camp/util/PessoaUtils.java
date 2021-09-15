package camp.util;


import java.time.LocalDate;
import java.util.Collections;

import camp.dto.request.PessoaDTO;
import camp.entity.Pessoas;

public class PessoaUtils {

    private static final String PRIMEIRO_NOME = "Rodrigo";
    private static final String SOBRENOME = "Peleias";
    private static final String NUMERO_CPF = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(2010, 10, 1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataDeNascimento("04-04-2010")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoas createFakeEntity() {
        return Pessoas.builder()
                .id(PERSON_ID)
                .primeiroNome(PRIMEIRO_NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataDeNascimento(DATA_NASCIMENTO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }




}