package com.async.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1399);
            return input * input;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Future<Integer> future = new SquareCalculator().calculate(10);
        int count = 1;
        while (!future.isDone()) {
            System.out.println("Calculating..."+count++);
            Thread.sleep(100);
        }
        Integer result = future.get();
        System.out.println(result);
    }
}
