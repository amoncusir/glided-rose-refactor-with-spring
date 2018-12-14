package com.gildedrose.rules;

import com.gildedrose.entity.Item;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <!-- Documentation for: com.gildedrose.rules.RuleForAgedBrieItem on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Component
@Order(110)
public class RuleForBackstageItem
    extends SanitizeItemRule
{
    //~ Constants ======================================================================================================

    private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    private static final int PAST_CONCERT = 0;

    private static final int TEN_DAYS_BEFORE_CONCERT = 2;

    private static final int FIVE_DAYS_BEFORE_CONCERT = 3;

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Override
    protected void updateItem()
    {
        subtractItemSellIn();

        if (getItemSellIn() < 0)
            setItemQuality(PAST_CONCERT);
        else if (getItemSellIn() <= 5)
            addItemQuality(FIVE_DAYS_BEFORE_CONCERT);
        else if (getItemSellIn() <= 10)
            addItemQuality(TEN_DAYS_BEFORE_CONCERT);
        else
            addItemQuality(1);
    }

    @Override
    public Boolean canApply(Item item)
    {
        return ITEM_NAME.equals(item.name);
    }


    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
