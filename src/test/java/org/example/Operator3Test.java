package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator3Test {

    private Operator3 operator3 = new Operator3();

    @DisplayName("count는 Flux의 개수를 센다.")
    @Test
    void fluxCount() {
        StepVerifier.create(operator3.fluxCount())
                .expectNext(10L)
                .verifyComplete();
    }

    @DisplayName("distinct는 중복을 제거한다.")
    @Test
    void fluxDistinct() {
        StepVerifier.create(operator3.fluxDistinct())
                .expectNext("a", "b", "c")
                .verifyComplete();
    }

    @DisplayName("reduce는 모든 수를 더한다.")
    @Test
    void findReduce() {
        StepVerifier.create(operator3.findReduce())
                .expectNext(55)
                .verifyComplete();
    }

    @DisplayName("groupBy는 특정 조건에 따라 그룹화한다. 짝수의 합과 홀수의 합을 구한다.")
    @Test
    void fluxGroupBy() {
        StepVerifier.create(operator3.fluxGroupBy())
                .expectNext(30)
                .expectNext(25)
                .verifyComplete();
    }
}