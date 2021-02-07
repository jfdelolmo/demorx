package com.example.jfo.demorx.initial;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class InitialDemos {

    public static void run() {
        Flowable.just("Hello world").subscribe(System.out::println);

        //Assembly time
        Flowable<Integer> flow = Flowable.range(1, 20)
                .map(v -> v * v)
                .filter(v -> v % 3 == 0);

        //Subscription time
        flow.subscribe(System.out::println);

        //Runtime
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalAccessException("Odd milisecond!"));
                    break;
                }
            }
        })
        .subscribe(System.out::println, Throwable::printStackTrace);
    }
}
