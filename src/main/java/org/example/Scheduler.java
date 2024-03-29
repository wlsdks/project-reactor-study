package org.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Scheduler {

    // subscribeOn
    public Flux<Integer> fluxMapWithSubscribeOn() {
        return Flux.range(1, 10)
                .map(i -> i * 2)
                .subscribeOn(Schedulers.boundedElastic())
                .log();
    }

    // publishOn
    public Flux<Integer> fluxMapWithPublishOn() {
        return Flux.range(1, 10)
                .map(i -> i + 1)
                .publishOn(Schedulers.boundedElastic()) // 이 다음 구문부터 설정한 스케줄러로 실행됨 (아래줄 코드부터 적용)
                .log()
                .publishOn(Schedulers.parallel())
                .log()
                .map(i -> i * 2);
    }

}
