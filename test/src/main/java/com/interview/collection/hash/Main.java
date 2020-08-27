package com.interview.collection.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        double balance = Double.parseDouble(in.readLine());
        List<Float> transactions = new ArrayList<>();
        int count = 0;
        while (Objects.nonNull(line = in.readLine())) {
            if (Objects.nonNull(line)) {
                transactions.add(Float.parseFloat(line));
                count++;
            }
            if (line.equals("0")) {
                break;
            }
        }
       balance = getFinalBalanceForTheDay(balance,transactions);
        System.out.println("New balance : "+balance);
        int fee = getFee(balance, transactions);
        System.out.println(fee);
    }

    private static int getFee(double balance, List<Float> transactions) {
        int fee = 0;
        List<Float> withdrawals = transactions.stream().filter(val -> val < 0).sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (Float withdrawal : withdrawals) {
            if(balance>0) {
                balance = balance - withdrawal;
            }
            if(balance<0){
                fee++;
            }
        }
        return fee;
    }

    private static double getFinalBalanceForTheDay(double balance, List<Float> transactions){
        balance += transactions.stream().filter(val->val>0).mapToDouble( val -> val).sum();
        return balance;
    }

}