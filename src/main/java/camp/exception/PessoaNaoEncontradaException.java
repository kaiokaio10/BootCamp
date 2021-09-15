package camp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends Exception {

	public PessoaNaoEncontradaException(Long id) {
        super(String.format("Pessoa com ID% s não encontrada", id));
    }
}
