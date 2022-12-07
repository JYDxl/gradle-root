package org.github.core.java;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;

@Slf4j
public class WaitAndNotify {
  public static void main(String[] args) {
    new Thread(WaitAndNotify::consume).start();
    new Thread(WaitAndNotify::consume).start();
    new Thread(WaitAndNotify::produce).start();
    new Thread(WaitAndNotify::produce).start();
  }

  private static void consume() {
    while (true) {
      synchronized (QUEUE) {
        log.info("当前队列大小: {}", QUEUE.size());
        if (QUEUE.isEmpty()) {
          log.info("队列空了");
          wait0();
        }
//                    String element;
//                    while ((element = QUEUE.poll()) != null) log.info("consume: {}", element);
        if (!QUEUE.isEmpty()) {
          log.info("consume: {}", QUEUE.poll());
        }
        QUEUE.notify();
      }
    }
  }

  private static void produce() {
    while (true) {
      synchronized (QUEUE) {
        log.info("当前队列大小: {}", QUEUE.size());
        if (QUEUE.size() == MAX_SIZE) {
          log.info("队列满了");
          wait0();
        }
//                    while (QUEUE.size() < MAX_SIZE) {
        if (QUEUE.size() < MAX_SIZE) {
          val element = valueOf(currentTimeMillis());
          log.info("produce: {}", element);
          QUEUE.add(element);
        }
//                    }
        QUEUE.notify();
      }
    }
  }

  private static void wait0() {
    try {
      QUEUE.wait();
    } catch (InterruptedException e) {
      log.error(e.getMessage(), e);
    }
  }

  private static final Queue<String> QUEUE    = new LinkedList<>();
  private static final int           MAX_SIZE = 10;
}
