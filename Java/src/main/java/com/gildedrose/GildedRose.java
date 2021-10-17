package com.gildedrose;

import static com.gildedrose.GildedRoseItem.gildedRoseItem;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			gildedRoseItem(item).updateQuality();
		}
	}
}