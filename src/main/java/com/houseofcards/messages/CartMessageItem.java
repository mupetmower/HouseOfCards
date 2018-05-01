package com.houseofcards.messages;

public class CartMessageItem {
	
	private Integer itemId;
	private Integer productId;
	private Integer userId;
	private Integer quantity;
	
	public CartMessageItem() {};
	
	
	
	public CartMessageItem(Integer itemId, Integer productId, Integer userId, Integer quantity) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}



	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
