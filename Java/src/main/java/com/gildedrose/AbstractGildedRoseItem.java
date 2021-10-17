package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem{
	private final Item item;
	
	AbstractGildedRoseItem(Item item){
		this.item = item;
	}
	
	@Override
	public void updateQuality(){
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

		if (!isSulfuras()) {
			decrementationSellIn();
		}

		if (hasExpired()) {
			if (isAgedBrie()) {
				incrementationQuality();
			} else {
				if (isBackstagePasses()) {
					setNoQuality();
				} else {
					if (!isSulfuras()) {
						decrementationQuality();
					}
				}
			}
		}
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

	public boolean isSulfuras() {
		return GildedRoseItem.isSulfuras(item);
	}


	public boolean isBackstagePasses() {
		return GildedRoseItem.isBackstagePasses(item);
	}


	public boolean isAgedBrie() {
		return GildedRoseItem.isAgedBrie(item);
	}
}