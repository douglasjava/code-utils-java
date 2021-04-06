package com.example.demo.performance;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(batchSize = 10000, iterations = 10)
@Warmup(batchSize = 10000, iterations = 10)
public class StringPerformance {

	@Benchmark
	public String benchmarkStringConstructor() {
		return new String("baeldung");
	}

	@Benchmark
	public String benchmarkStringLiteral() {
		return "baeldung";
	}

}
