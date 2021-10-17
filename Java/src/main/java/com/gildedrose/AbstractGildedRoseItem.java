package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem{
	protected final Item item;
	
	AbstractGildedRoseItem(Item item){
		this.item = item;
	}
	
	public void setNoQuality() {
		item.quality = 0;
	}
	
	public void decrementationSellIn() {
		item.sellIn = item.sellIn - 1;
	}

	public boolean hasExpired() {
		return expireBy(0);
	}

	public boolean expireBy(int expireTime) {
		return item.sellIn < expireTime;
	}

	public void decrementationQuality() {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
	
	public void incrementationQuality() {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
}