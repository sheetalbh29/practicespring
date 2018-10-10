package com.infogain.beans;

public class Product {
	private int pId;
	private int pCost;
	private int quantityInHand;

	public Product() {
		super();
	}

	public Product(int pId, int pCost, int quantityInHand) {
		super();
		this.pId = pId;
		this.pCost = pCost;
		this.quantityInHand = quantityInHand;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getpCost() {
		return pCost;
	}

	public void setpCost(int pCost) {
		this.pCost = pCost;
	}

	public int getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(int quantityInHand) {
		this.quantityInHand = quantityInHand;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCost=" + pCost + ", quantityInHand=" + quantityInHand
				+ "]";
	}

	public boolean isValidquantityInHand() throws InvalidQuantityInHandException {
		if (quantityInHand < 1) {
			throw new InvalidQuantityInHandException();
		}
		else {
			return true;
		}
	}
}