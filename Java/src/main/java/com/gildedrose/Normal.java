package com.gildedrose;

class Normal extends AbstractGildedRoseItem {
	public Normal(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		incrementationQuality();

		decrementationQuality();

		if (hasExpired()) {
			decrementationQuality();
		}
	}
}