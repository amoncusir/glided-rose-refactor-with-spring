package com.gildedrose.rules;

import com.gildedrose.entity.Item;

/**
 * <!-- Documentation for: com.gildedrose.rules.SanitizeItemRule on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
public abstract class SanitizeItemRule
    implements ItemRule
{
    //~ Constants ======================================================================================================

    private static final int MAX_QUALITY = 50;

    private static final int MIN_QUALITY = 0;

    private static final int SUBTRACT_SELL_IN = 1;

    //~ Properties =====================================================================================================

    private Item item;

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @SuppressWarnings("WeakerAccess")
    protected abstract void updateItem();

    @Override
    synchronized public final Item update(Item item)
    {
        if (this.item != null)
            throw new IllegalStateException("Not supports multi-threading execution in same instance");

        this.item = item;

        updateItem();

        try
        {
            return this.item;
        }
        finally
        {
            this.item = null;
        }
    }

    protected String getItemName()
    {
        return item.name;
    }

    protected int getItemSellIn()
    {
        return item.sellIn;
    }

    protected int getItemQuality()
    {
        return item.quality;
    }

    protected boolean isSellInLessOrEqualThanZero()
    {
        return getItemSellIn() <= 0;
    }

    protected void addItemQuality(int addQuality) {
        setItemQuality(item.quality + addQuality);
    }

    protected void setItemQuality(final int quality)
    {
        if (quality >= MAX_QUALITY)
            item.quality = MAX_QUALITY;
        else if (quality <= MIN_QUALITY)
            item.quality = MIN_QUALITY;
        else
            item.quality = quality;
    }

    protected void subtractItemSellIn()
    {
        item.sellIn -= SUBTRACT_SELL_IN;
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
