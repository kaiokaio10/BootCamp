package camp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import camp.dto.request.PessoaDTO;
import camp.dto.response.MensagemResponseDTO;
import camp.entity.Pessoas;
import camp.dto.mapper.PessoaMapper;
import camp.repositories.PessoasRepository;
import camp.services.PessoaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static camp.util.PessoaUtils.createFakeDTO;
import static camp.util.PessoaUtils.createFakeEntity;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoasRepository pessoasRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PessoaDTO pessoaDTO = createFakeDTO();
        Pessoas expectedSavedPerson = createFakeEntity();

        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(expectedSavedPerson);
        when(pessoasRepository.save(any(Pessoas.class))).thenReturn(expectedSavedPerson);

        MensagemResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MensagemResponseDTO successMessage = pessoaService.create(pessoaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MensagemResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MensagemResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }

}
