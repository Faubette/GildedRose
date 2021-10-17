package com.gildedrose;

class BackstagePasses extends AbstractGildedRoseItem {
	public BackstagePasses(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		incrementationQuality();
		if (expireBy(11)) {
			incrementationQuality();
		}
		if (expireBy(6)) {
			incrementationQuality();
		}

		decrementationSellIn();

		if (hasExpired()) {
			setNoQuality();
		}
	}
}