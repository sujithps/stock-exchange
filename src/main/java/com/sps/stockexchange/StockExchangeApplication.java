package com.sps.stockexchange;

import java.util.Arrays;
import java.util.List;
import io.reactivex.rxjava3.core.*;

public class StockExchangeApplication {

	public static void main(String[] args) {

		List<String> symbols = Arrays.asList("TEL", "TCS", "IT", "FB");

		Observable<StockInfo> feed = StockServer.getFeed(symbols);
		
		feed.subscribe(System.out::println, System.out::println);
	}
}