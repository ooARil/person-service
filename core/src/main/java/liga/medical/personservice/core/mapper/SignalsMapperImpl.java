package liga.medical.personservice.core.mapper;

import liga.medical.model.dto.RabbitMessageDTO;
import liga.medical.personservice.core.mapper.api.SignalsMapper;
import liga.medical.personservice.core.model.Signals;
import org.springframework.stereotype.Repository;

@Repository
public class SignalsMapperImpl implements SignalsMapper {

    @Override
    public Signals toEntity(RabbitMessageDTO rabbitMessageDTO) {
        Signals signals = new Signals();
        signals.setPersonDataId(rabbitMessageDTO.getId());
        signals.setDescription(rabbitMessageDTO.getContent());
        signals.setType(String.valueOf(rabbitMessageDTO.getMessageType()));
        return signals;
    }
}