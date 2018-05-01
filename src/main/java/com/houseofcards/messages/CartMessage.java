package com.houseofcards.messages;

import java.util.ArrayList;
import java.util.List;

public class CartMessage {
	
	private List<CartMessageItem> cartMessageItems = new ArrayList<>();
	
	public CartMessage() {}

	public List<CartMessageItem> getCartMessageItems() {
		return cartMessageItems;
	}

	public void setCartMessageItems(List<CartMessageItem> cartMessageItems) {
		this.cartMessageItems = cartMessageItems;
	}
	
	public void addCartMessageItem(CartMessageItem cartMessageItem) {
		cartMessageItems.add(cartMessageItem);
	}
	
}
