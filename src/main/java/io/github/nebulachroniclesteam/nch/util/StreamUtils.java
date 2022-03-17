package io.github.nebulachroniclesteam.nch.util;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StreamUtils {

    public static <T> Collector<T, List<T>, Optional<T>> random(Random random) {
        return new Collector<>() {
            @Override
            public Supplier<List<T>> supplier() {
                return ArrayList::new;
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return List::add;
            }

            @Override
            public BinaryOperator<List<T>> combiner() {
                return (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                };
            }

            @Override
            public Function<List<T>, Optional<T>> finisher() {
                return list -> {
                    if (list.isEmpty()) {
                        return Optional.empty();
                    }
                    if (list.size() == 1) {
                        return Optional.ofNullable(list.get(0));
                    }
                    return Optional.ofNullable(list.get(random.nextInt(list.size())));
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Set.of();
            }
        };
    }
}
