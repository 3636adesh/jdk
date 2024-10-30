package com.mountain_dew.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;


@Slf4j
public class UsingLambda {

    static Predicate<String> p = s -> s.startsWith("a");
    static Consumer<String> print = s -> System.out.println("value = " + s);

   static List<String> retainStringsOfStartWithA(List<String> strings) {
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            if (p.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main1(String[] args) {
        List<String> strings = retainStringsOfStartWithA(List.of("adesh", "yash", "anil"));
        strings.forEach(print);
    }

    static void usingProducer(){
        Random random = new Random(314L);
        Supplier<Integer> newRandom = () -> random.nextInt(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(newRandom.get());
        }
    }

    public static void main(String[] args) {
        intSupplier();
    }

    static void intSupplier(){
//       Random random = new Random(314L);
//        IntSupplier intSupplier = () -> random.nextInt(100);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(intSupplier.getAsInt());
//        }

        Stream.of("a", "b", "c")
                .filter(Predicate.not(s -> s.startsWith("a"))).forEach(print);
    }


}
