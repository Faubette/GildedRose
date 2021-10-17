package com.gildedrose;

class AgedBrie extends AbstractGildedRoseItem {
	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		incrementationQuality();

		decrementationQuality();

		if (hasExpired()) {
			incrementationQuality();
		}
	}
}