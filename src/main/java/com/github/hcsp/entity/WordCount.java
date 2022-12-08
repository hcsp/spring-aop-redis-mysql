package com.github.hcsp.entity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {


    public static Map<String, Long> Count(List<File> files) throws ExecutionException, InterruptedException {
        return new ForkJoinPool().submit(new CountWord(files)).get();
    }

    static class CountWord extends RecursiveTask<Map<String, Long>> {
        List<File> files;

        public CountWord(List<File> files) {
            this.files = files;
        }

        @Override
        protected Map<String, Long> compute() {
            if (files.isEmpty()) {
                return Collections.emptyMap();
            } else if (files.size() == 1) {
                return count(files.get(0));
            }

            CountWord leftCount = new CountWord(files.subList(0, files.size() / 2));
            CountWord rightCount = new CountWord(files.subList(files.size() / 2 + 1, files.size()));

            leftCount.fork();
            rightCount.fork();

            return merge(leftCount.join(), rightCount.join());
        }

        private Map<String, Long> count(File file) {
            Map<String, Long> map;
            try {
                String str = new String(Files.readAllBytes(file.toPath()));
                map = Stream.of(str.split("\\s+"))
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return map;

        }
    }

    private static Map<String, Long> merge(Map<String, Long> left, Map<String, Long> right) {
        Map<String, Long> map = new HashMap<>();
        left.forEach((word, count) -> {
            Long result = map.getOrDefault(word, 0L) + count;
            map.put(word, result);

        });
        right.forEach((word, count) -> {
            Long result = map.getOrDefault(word, 0L) + count;
            map.put(word, result);

        });
        return map;

    }

}
