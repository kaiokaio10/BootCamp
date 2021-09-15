package camp.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import camp.dto.request.PessoaDTO;
import camp.entity.Pessoas;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

 @Mapping(target = "dataDeNascimento", source = "dataDeNascimento", dateFormat = "dd-MM-yyyy")
 Pessoas toModel(PessoaDTO dto);

 PessoaDTO toDTO(Pessoas dto);
} 