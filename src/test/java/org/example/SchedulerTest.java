package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {

    private Scheduler scheduler = new Scheduler();

    @DisplayName("subscribeOn을 사용하면 어느 스레드에서 실행될지 결정할 수 있다.")
    @Test
    void fluxMapWithSubscribeOn() {
        StepVerifier.create(scheduler.fluxMapWithSubscribeOn())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void fluxMapWithPublishOn() {
        StepVerifier.create(scheduler.fluxMapWithPublishOn())
                .expectNextCount(10)
                .verifyComplete();
    }
}