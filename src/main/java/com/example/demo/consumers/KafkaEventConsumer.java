package com.example.demo.consumers;

import com.example.demo.config.KafkaConfig;
import com.example.demo.events.ViewCountEvent;
import com.example.demo.repositories.QuestionRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class KafkaEventConsumer {

    private final QuestionRepository questionRepository;
    @KafkaListener(
            topics = KafkaConfig.TOPIC_NAME,
            groupId = "view-count-consumer",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleViewCountEvent(ViewCountEvent viewCountEvent){
        questionRepository.findById(viewCountEvent.getTargetId())
                .flatMap(question -> {
                    Integer views = question.getViewCount();
                    question.setViewCount(views + 1);
                    return questionRepository.save(question);
                })
                .subscribe(updatedQuestion -> {
                    System.out.println("Question updated successfully " + updatedQuestion);
                }, error -> {
                    System.out.println("Error updating question " + error.getMessage());
                });

    }

}
