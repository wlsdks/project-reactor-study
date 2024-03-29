package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator2Test {

    private Operator2 operator2 = new Operator2();

    @DisplayName("concatMap은 순서가 지켜지고 동기로 처리됨")
    @Test
    void fluxConcatMap() {
        StepVerifier.create(operator2.fluxConcatMap())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator2.monoFlatMapMany())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void defaultIfEmpty1() {
        StepVerifier.create(operator2.defaultIfEmpty1())
                .expectNext(30)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty1() {
        StepVerifier.create(operator2.switchIfEmpty1())
                .expectNext(60)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty2() {
        StepVerifier.create(operator2.switchIfEmpty2())
                .expectError(Exception.class)
                .verify();
    }

    @DisplayName("merge를 사용해서 2가지 Flux를 합쳐준다.")
    @Test
    void fluxMerge() {
        StepVerifier.create(operator2.fluxMerge())
                .expectNext("1", "2", "3", "4")
                .verifyComplete();
    }

    @DisplayName("mono는 mergeWith를 사용한다. 합치면 단일값이 아니라 Flux가 된다.")
    @Test
    void monoMerge() {
        StepVerifier.create(operator2.monoMerge())
                .expectNext("1", "2", "3")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operator2.fluxZip())
                .expectNext("ad", "be" , "cf")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operator2.monoZip())
                .expectNext(6)
                .verifyComplete();
    }

}