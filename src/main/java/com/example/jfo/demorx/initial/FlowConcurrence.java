package com.example.jfo.demorx.initial;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowConcurrence {

    public static void run(){
        int topCount = 10000;
        //Concurrency within a flow
        Long time = System.currentTimeMillis();
        Flowable.range(1, topCount)
                .observeOn(Schedulers.computation())
                .map(v-> v*v)
                .blockingSubscribe(System.out::println);
        Long timeConcurrency = System.currentTimeMillis()-time;

        //Parallel processing
        time = System.currentTimeMillis();
        Flowable.range(1, topCount)
                .flatMap(v->
                    Flowable.just(v)
                            .subscribeOn(Schedulers.io())
                            .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);
        Long timeParallel = System.currentTimeMillis()-time;

        //Parallel processing 2
        time = System.currentTimeMillis();
        Flowable.range(1, topCount)
                .parallel()
                .runOn(Schedulers.io())
                .map(v->v*v)
                .sequential()
                .blockingSubscribe(System.out::println);
        Long timeParallel2 = System.currentTimeMillis()-time;

        System.out.println(String.format("Concurrency within a flow (%d ms)", timeConcurrency));
        System.out.println(String.format("Parallel processing (%d ms)", timeParallel));
        System.out.println(String.format("Parallel processing 2 (%d ms)", timeParallel2));

    }

}
