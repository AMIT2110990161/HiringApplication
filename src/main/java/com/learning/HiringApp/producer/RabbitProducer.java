//    package com.learning.HiringApp.producer;
//
//    import com.learning.HiringApp.enums.CandidateStatus;
//    import com.learning.HiringApp.security.config.RabbitMQMail;
//    import com.learning.HiringApp.dtos.CandidateDTO;
//    import lombok.extern.slf4j.Slf4j;
//    import org.springframework.amqp.rabbit.core.RabbitTemplate;
//    import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.stereotype.Service;
//
//    import java.util.EnumSet;
//
//    @Slf4j
//    @Service
//    public class RabbitProducer {
//        @Autowired
//        private RabbitTemplate rabbitTemplate;
//
//        public void sendCandidate(CandidateDTO dto) {
//            if (EnumSet.of(CandidateStatus.OFFERED, CandidateStatus.REJECTED)
//                    .contains(dto.getStatus())) {
//
//                log.info("Sending candidate: {}", dto);
//                rabbitTemplate.convertAndSend(
//                        RabbitMQMail.EXCHANGE,
//                        RabbitMQMail.ROUTING_KEY,
//                        dto
//                );
//            }
//        }
//
//    }