package com.gildedrose;

public class GildedRoseItem {
	final Item item;
	
	private GildedRoseItem(Item item) {
		this.item = item;
	}
	public static void decrementationQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}

	public static void incrementationQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}

	public static boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	public static boolean isBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	public static boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}
	
	public static GildedRoseItem gildedRoseItem(Item item) {
		return new GildedRoseItem(item);
	}
	
	public void updateQuality(GildedRose gildedRose) {
		if (isAgedBrie() || isBackstagePasses()) {
			incrementationQuality();
				if (isBackstagePasses()) {
					if (expireBy(11)) {
						incrementationQuality();
					}
	
					if (expireBy(6)) {
						incrementationQuality();
					}
				}
		} else {
			if (!isSulfuras()) {
				decrementationQuality();
	
			}
		}
	
		if (!isSulfuras(item)) {
			item.sellIn = item.sellIn - 1;
		}
	
		if (hasExpired()) {
			if (isAgedBrie()) {
				incrementationQuality();
			} else {
				if (isBackstagePasses()) {
					item.quality = 0;
				} else {
					if (!isSulfuras()) {
						decrementationQuality();
					}
				}
			}
		}
	}
	public boolean hasExpired() {
		return expireBy(0);
	}
	
	public boolean expireBy(int expireTime) {
		return item.sellIn < expireTime;
	}
	public boolean isSulfuras() {
		return isSulfuras(item);
	}
	public boolean isBackstagePasses() {
		return isBackstagePasses(item);
	}
	public void decrementationQuality() {
		decrementationQuality(item);
	}
	
	public void incrementationQuality() {
		incrementationQuality(item);
	}
	public boolean isAgedBrie() {
		return isAgedBrie(item);
	}
}
