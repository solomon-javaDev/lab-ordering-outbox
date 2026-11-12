package io.sol.laborderingoutbox.service;

import io.sol.laborderingoutbox.entity.LabOrder;
import io.sol.laborderingoutbox.entity.OutboxEvent;
import io.sol.laborderingoutbox.entity.Status;
import io.sol.laborderingoutbox.repository.LabOrderRepository;
import io.sol.laborderingoutbox.repository.OutboxEventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.beans.Transient;
import java.time.Instant;

@Service
public class OrderService {

    private final LabOrderRepository labOrderRepository;
    private final OutboxEventRepository outboxEventRepository;
    private final ObjectMapper objectMapper;

    public OrderService(LabOrderRepository labOrderRepository, OutboxEventRepository outboxEventRepository, ObjectMapper objectMapper) {
        this.labOrderRepository = labOrderRepository;
        this.outboxEventRepository = outboxEventRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public LabOrder createLabOrder(LabOrder labOrder){

        labOrder.setOrderDate(Instant.now());

        LabOrder savedOrder = labOrderRepository.save(labOrder);

        OutboxEvent  outboxEvent = new OutboxEvent();
        outboxEvent.setEventType("ORDER_CREATED");
        outboxEvent.setPayload(objectMapper.writeValueAsString(labOrder));

        outboxEventRepository.save(outboxEvent);
        return savedOrder;
    }
}
