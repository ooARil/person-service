package liga.medical.personservice.core.mapper.api;

import liga.medical.model.dto.RabbitMessageDTO;
import liga.medical.personservice.core.model.Signals;

public interface SignalsMapper {

    Signals toEntity(RabbitMessageDTO rabbitMessageDTO);
}
