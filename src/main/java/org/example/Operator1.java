package org.example;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator1 {

    // map
    public Flux<Integer> fluxMap() {
        return Flux.range(1, 5)
                .map(i -> i * 2)
                .log();
    }

    // filter
    public Flux<Integer> fluxFilter() {
        return Flux.range(1, 10)
                .filter(i -> i > 5)
                .log();
    }

    // take
    public Flux<Integer> fluxFilterTake() {
        return Flux.range(1, 10)
                .filter(i -> i > 5)
                .take(3) // 3개만 가져와라
                .log();
    }

    // flatMap
    public Flux<Integer> fluxFlatMap() {
        return Flux.range(1, 10)
                .flatMap(i -> Flux.range(i * 10, 10)
                        .delayElements(Duration.ofMillis(100))
                )
                .log();
    }

    // flatMap2
    public Flux<Integer> fluxFlatMap2() {
        //for (int i=0; ... )
        //   for (int j=0; ... )
        return Flux.range(1, 9)
                .flatMap(i -> Flux.range(1, 9)
                        .map(j -> {
                            System.out.printf("%d * %d = %d\n", i, j, i * j);
                            return i * j;
                        })
                )
                .log();
    }

}
