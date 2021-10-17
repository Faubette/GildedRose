package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (isAgedBrie(item) || isBackstagePasses(item)) {
				incrementationQuality(item);
					if (isBackstagePasses(item)) {
						if (item.sellIn < 11) {
							incrementationQuality(item);
						}

						if (item.sellIn < 6) {
							incrementationQuality(item);
						}
					}
			} else {
				if (!isSulfuras(item)) {
					decrementationQuality(item);

				}
			}

			if (!isSulfuras(item)) {
				item.sellIn = item.sellIn - 1;
			}

			if (item.sellIn < 0) {
				if (isAgedBrie(item)) {
					incrementationQuality(item);
				} else {
					if (isBackstagePasses(item)) {
						item.quality = 0;
					} else {
						if (item.quality > 0) {
							if (!isSulfuras(item)) {
								decrementationQuality(item);
							}
						}
					}
				}
			}
		}
	}

	public void decrementationQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	public void incrementationQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}

	public boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	public boolean isBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	public boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}
}