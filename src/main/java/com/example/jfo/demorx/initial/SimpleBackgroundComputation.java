package com.example.jfo.demorx.initial;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SimpleBackgroundComputation {

    public static void run() throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000);
    }

}
