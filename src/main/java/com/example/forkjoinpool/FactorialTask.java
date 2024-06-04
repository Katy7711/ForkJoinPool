package com.example.forkjoinpool;

import java.util.concurrent.RecursiveTask;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class FactorialTask extends RecursiveTask<Long> {

  private final long n;

  public FactorialTask(long n) {
    this.n = n;
  }

  @Override
  public Long compute() {
    if (n <= 1) {
      return 1L;
    } else {
      FactorialTask task = new FactorialTask(n-1);
      task.fork();
      return n * task.join();
    }
  }
}

