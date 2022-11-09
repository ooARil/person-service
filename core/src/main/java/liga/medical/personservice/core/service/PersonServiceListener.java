package liga.medical.personservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.model.dto.QueueNames;
import liga.medical.model.dto.RabbitMessageDTO;
import liga.medical.personservice.core.annotation.DbLog;
import liga.medical.personservice.core.mapper.api.SignalsMapper;
import liga.medical.personservice.core.service.api.SignalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceListener {

    private final ObjectMapper objectMapper;
    private final SignalsService signalsService;
    private final SignalsMapper signalsMapper;

    @DbLog
    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void listenDailyQueue(String message) throws JsonProcessingException {
        RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(message, RabbitMessageDTO.class);
        signalsService.save(signalsMapper.toEntity(rabbitMessageDTO));
    }

    @DbLog
    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void listenAlertQueue(String message) throws JsonProcessingException {
        RabbitMessageDTO rabbitMessageDTO = objectMapper.readValue(message, RabbitMessageDTO.class);
        signalsService.save(signalsMapper.toEntity(rabbitMessageDTO));
    }
}
