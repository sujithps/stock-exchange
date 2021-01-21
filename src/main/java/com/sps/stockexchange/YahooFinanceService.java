package com.sps.stockexchange;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class YahooFinanceService {
  public static double getPrice(final String ticker) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try (java.io.InputStream is = new java.net.URL(
        "https://priceapi.moneycontrol.com/pricefeed/bse/equitycash/" + ticker).openStream()) {
      String contents = new String(is.readAllBytes());
      JsonElement stockInfo = JsonParser.parseString(contents);
      JsonObject stockInfoObj = stockInfo.getAsJsonObject();
      double price = stockInfoObj.get("data").getAsJsonObject().get("pricecurrent").getAsDouble();

      return price;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
