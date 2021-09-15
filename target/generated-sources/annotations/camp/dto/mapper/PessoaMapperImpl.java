package camp.dto.mapper;

import camp.dto.request.PessoaDTO;
import camp.dto.request.PessoaDTO.PessoaDTOBuilder;
import camp.dto.request.TelefoneDTO;
import camp.dto.request.TelefoneDTO.TelefoneDTOBuilder;
import camp.entity.Pessoas;
import camp.entity.Pessoas.PessoasBuilder;
import camp.entity.Telefone;
import camp.entity.Telefone.TelefoneBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-14T14:52:28-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoas toModel(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PessoasBuilder pessoas = Pessoas.builder();

        if ( dto.getDataDeNascimento() != null ) {
            pessoas.dataDeNascimento( LocalDate.parse( dto.getDataDeNascimento(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        pessoas.cpf( dto.getCpf() );
        pessoas.id( dto.getId() );
        pessoas.primeiroNome( dto.getPrimeiroNome() );
        pessoas.sobrenome( dto.getSobrenome() );
        pessoas.telefones( telefoneDTOListToTelefoneList( dto.getTelefones() ) );

        return pessoas.build();
    }

    @Override
    public PessoaDTO toDTO(Pessoas dto) {
        if ( dto == null ) {
            return null;
        }

        PessoaDTOBuilder pessoaDTO = PessoaDTO.builder();

        pessoaDTO.cpf( dto.getCpf() );
        if ( dto.getDataDeNascimento() != null ) {
            pessoaDTO.dataDeNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( dto.getDataDeNascimento() ) );
        }
        pessoaDTO.id( dto.getId() );
        pessoaDTO.primeiroNome( dto.getPrimeiroNome() );
        pessoaDTO.sobrenome( dto.getSobrenome() );
        pessoaDTO.telefones( telefoneListToTelefoneDTOList( dto.getTelefones() ) );

        return pessoaDTO.build();
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if ( telefoneDTO == null ) {
            return null;
        }

        TelefoneBuilder telefone = Telefone.builder();

        telefone.id( telefoneDTO.getId() );
        telefone.numero( telefoneDTO.getNumero() );
        telefone.tipo( telefoneDTO.getTipo() );

        return telefone.build();
    }

    protected List<Telefone> telefoneDTOListToTelefoneList(List<TelefoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Telefone> list1 = new ArrayList<Telefone>( list.size() );
        for ( TelefoneDTO telefoneDTO : list ) {
            list1.add( telefoneDTOToTelefone( telefoneDTO ) );
        }

        return list1;
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if ( telefone == null ) {
            return null;
        }

        TelefoneDTOBuilder telefoneDTO = TelefoneDTO.builder();

        telefoneDTO.id( telefone.getId() );
        telefoneDTO.numero( telefone.getNumero() );
        telefoneDTO.tipo( telefone.getTipo() );

        return telefoneDTO.build();
    }

    protected List<TelefoneDTO> telefoneListToTelefoneDTOList(List<Telefone> list) {
        if ( list == null ) {
            return null;
        }

        List<TelefoneDTO> list1 = new ArrayList<TelefoneDTO>( list.size() );
        for ( Telefone telefone : list ) {
            list1.add( telefoneToTelefoneDTO( telefone ) );
        }

        return list1;
    }
}
