package com.deltaCapital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShoppingBasket {

	private static final Map<String, Integer> ITEM_PRICES = new HashMap<>();
	static {
		ITEM_PRICES.put("Apple", 35);
		ITEM_PRICES.put("Banana", 20);
		ITEM_PRICES.put("Melon", 50);
		ITEM_PRICES.put("Lime", 15);
	}

	public static void main(String[] args) {
		String[] basket = { "Apple", "Apple", "Banana" };
		int totalPrice = calculatePrice(basket);
		System.out.println("Total price of the basket: " + totalPrice + "p");
	}

	public static int calculatePrice(String[] basket) {
		return calculatePrice(List.of(basket));
	}

	public static int calculatePrice(List<String> items) {
		Map<String, Long> itemCount = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		int total = 0;

		for (String item : itemCount.keySet()) {
			int count = (int) (long) (itemCount.get(item));
			int price = ITEM_PRICES.get(item);

			if (item.equals("Melon")) {
				// Apply 'buy one get one free' for Melons
				total += (count / 2 + count % 2) * price;
			} else if (item.equals("Lime")) {
				// Apply 'three for the price of two' for Limes
				total += (count / 3 * 2 + count % 3) * price;
			} else {
				// No special offer, just multiply count with price
				total += count * price;
			}
		}
		return total;

	}
}
