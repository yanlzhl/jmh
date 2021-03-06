package com.yanlz;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * 比较字符串直接相加和StringBuilder的效率
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2018/1/7
 */
@BenchmarkMode(Mode.All)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(6)
@Fork(2)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringBuilderBenchmark {

    @Benchmark
    public void testStringAdd() {
        String a = "";
        for (int i = 0; i < 100; i++) {
            a += i;
        }
        print(a);
    }

    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(i);
        }
        print(sb.toString());
    }

    private void print(String a) {
        System.out.println(a);
    }


}