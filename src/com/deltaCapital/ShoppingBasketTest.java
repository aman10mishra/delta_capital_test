package com.deltaCapital;

import static org.junit.Assert.*;

import org.junit.Test;
public class ShoppingBasketTest {

	
	 @Test
	    public void testCalculateTotalPrice() {
	        String[] basket1 = {"Apple", "Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime"};
	        assertEquals(170, ShoppingBasket.calculatePrice(basket1)); // 2 Apples = 70p, 1 Banana = 20p, 2 Melons = 50p, 3 Limes = 30p
	        
	        String[] basket2 = {"Apple", "Banana", "Banana", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime"};
	        assertEquals(205, ShoppingBasket.calculatePrice(basket2)); // 1 Apple = 35p, 2 Bananas = 40p, 3 Melons = 50p, 3 Limes = 30p
	        
	        String[] basket3 = {"Apple", "Banana", "Melon", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime"};
	        assertEquals(185, ShoppingBasket.calculatePrice(basket3)); // 1 Apple = 35p, 1 Banana = 20p, 3 Melons = 50p, 3 Limes = 30p
	        
	        String[] basket4 = {"Apple", "Apple", "Apple"};
	        assertEquals(105, ShoppingBasket.calculatePrice(basket4)); // 3 Apples = 105p
	        
	        String[] basket5 = {"Apple", "Apple", "Banana", "Banana", "Banana", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime"};
	        assertEquals(260, ShoppingBasket.calculatePrice(basket5)); // 2 Apples = 70p, 4 Bananas = 80p, 2 Melons = 50p, 6 Limes = 90p
	    }
}
