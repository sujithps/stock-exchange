package com.sps.stockexchange;

import io.reactivex.rxjava3.core.*;

import java.util.List;

public class StockServer {
  public static Observable<StockInfo> getFeed(List<String> symbols) {
    return Observable.create(emitter -> emit(emitter, symbols));
  }

  private static void emit(ObservableEmitter<StockInfo> emitter, List<String> symbols) {
    while (true) {
      symbols.stream()
          .map(StockInfo::fetch)
          .forEach(emitter::onNext);

      sleep(1000);
    }
  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}