package camp.services;

import java.util.stream.Collectors;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import camp.dto.mapper.PessoaMapper;
import camp.dto.request.PessoaDTO;
import camp.dto.response.MensagemResponseDTO;
import camp.entity.Pessoas;
import camp.exception.PessoaNaoEncontradaException;
import camp.repositories.PessoasRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {
	private final PessoasRepository pessoaRepository;

	private final PessoaMapper pessoaMapper;

	public MensagemResponseDTO create(PessoaDTO personDTO) {
		Pessoas person = pessoaMapper.toModel(personDTO);
		Pessoas savedPerson = pessoaRepository.save(person);

		MensagemResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ",
				savedPerson.getId());

		return messageResponse;
	}

	public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
		Pessoas person = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));

		return pessoaMapper.toDTO(person);
	}

	public List<PessoaDTO> listAll() {
		List<Pessoas> people = pessoaRepository.findAll();
		return people.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
	}

	public MensagemResponseDTO update(Long id, PessoaDTO personDTO) throws PessoaNaoEncontradaException {
		pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));

		Pessoas updatedPerson = pessoaMapper.toModel(personDTO);
		Pessoas savedPerson = pessoaRepository.save(updatedPerson);

		MensagemResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ",
				savedPerson.getId());

		return messageResponse;
	}

	public void delete(Long id) throws PessoaNaoEncontradaException {
		pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));

		pessoaRepository.deleteById(id);
	}

	private MensagemResponseDTO createMessageResponse(String s, Long id2) {
		return MensagemResponseDTO.builder().message(s + id2).build();
	}
}

