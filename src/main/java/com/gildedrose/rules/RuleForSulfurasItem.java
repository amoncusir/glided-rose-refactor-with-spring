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
@Order(0)
public class RuleForSulfurasItem
    extends SanitizeItemRule
{
    //~ Constants ======================================================================================================

    private static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Override
    protected void updateItem() { }

    @Override
    public Boolean canApply(Item item)
    {
        return ITEM_NAME.equals(item.name);
    }


    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
