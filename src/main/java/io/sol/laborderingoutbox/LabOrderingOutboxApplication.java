package io.sol.laborderingoutbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * I've created this project to demonstrate Transactional Outbox pattern problem in business logic design
 */
@SpringBootApplication
public class LabOrderingOutboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabOrderingOutboxApplication.class, args);
    }

}
