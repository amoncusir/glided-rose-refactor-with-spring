package com.gildedrose.rules;

import com.gildedrose.entity.Item;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <!-- Documentation for: com.gildedrose.rules.StandardItemRule on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Order(Integer.MAX_VALUE)
@Component
public class StandardItemRule
    extends SanitizeItemRule
{
    //~ Constants ======================================================================================================

    private static final int DEGREE_QUALITY = -1;

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Override
    protected void updateItem()
    {
        subtractItemSellIn();

        if (!isSellInLessOrEqualThanZero())
            addItemQuality(DEGREE_QUALITY);
        else
            addItemQuality(DEGREE_QUALITY * 2);
    }

    @Override
    public Boolean canApply(Item item)
    {
        return true;
    }


    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
