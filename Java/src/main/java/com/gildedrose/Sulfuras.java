package com.gildedrose;

class Sulfuras extends AbstractGildedRoseItem {
	public Sulfuras(Item item) {super(item);}

	@Override
	public void updateQuality() {
		hasExpired();
	}
}