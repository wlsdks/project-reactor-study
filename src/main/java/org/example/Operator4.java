package org.example;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator4 {

    // limit (delay를 주고 받을 개수에 limit을 걸어준다.)
    public Flux<Integer> fluxDelayAndLimit() {
        return Flux.range(1, 10)
                .delaySequence(Duration.ofSeconds(1))
                .log()
                .limitRate(2);
    }

    // sample (샘플링)
    public Flux<Integer> fluxSample() {
        return Flux.range(1, 100)
                .delayElements(Duration.ofMillis(100)) // 약간의 딜레이 주기
                .sample(Duration.ofMillis(300)) // 샘플링 시간 설정 (선별적으로 데이터를 샘플링)
                .log();
    }

}
