package com.gildedrose.rules;

import com.gildedrose.entity.Item;

/**
 * <!-- Documentation for: com.gildedrose.rules.ItemRule on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
public interface ItemRule
{
    //~ Constants ======================================================================================================

    //~ Getters & Setters ==============================================================================================

    //~ Methods ========================================================================================================

    Boolean canApply(Item item);

    Item update(Item item);

    //~ Default Methods ================================================================================================

    //~ Static Methods =================================================================================================

}
