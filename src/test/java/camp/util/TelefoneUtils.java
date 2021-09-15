package camp.util;

import camp.dto.request.TelefoneDTO;
import camp.entity.Telefone;
import camp.enums.TipoDeTelefone;

public class TelefoneUtils {

    private static final String NUMERO_TELEFONE = "1199999-9999";
    private static final TipoDeTelefone TIPO_TELEFONE = TipoDeTelefone.MOBILE;
    private static final long TELEFONE_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(TELEFONE_ID)
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }
}