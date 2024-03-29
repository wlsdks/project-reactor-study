package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator4Test {

    private Operator4 operator4 = new Operator4();

    @DisplayName("delaySequence는 지정된 시간만큼 대기 후 발행한다.")
    @Test
    void fluxDelayAndLimit() {
        StepVerifier.create(operator4.fluxDelayAndLimit())
                .expectNext(1, 2)
                .expectNext(3, 4)
                .expectNext(5, 6)
                .expectNext(7, 8)
                .expectNext(9, 10)
                .verifyComplete();
    }

    @DisplayName("sample는 샘플링한다. 300ms마다 샘플링했기 때문에 순차적으로 진행되지만 중간중간 빈 데이터가 있다.")
    @Test
    void fluxSample() {
        StepVerifier.create(operator4.fluxSample())
                .expectNextCount(35)
                .verifyComplete();
    }
}