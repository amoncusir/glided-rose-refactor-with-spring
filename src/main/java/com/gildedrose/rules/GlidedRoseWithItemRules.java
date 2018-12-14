package com.gildedrose.rules;

import com.gildedrose.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <!-- Documentation for: com.gildedrose.rules.GlidedRoseWithItemRules on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Component
public class GlidedRoseWithItemRules
    implements GlidedRose
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    private final List<ItemRule> itemRules;

    //~ Constructors ===================================================================================================

    @Autowired
    public GlidedRoseWithItemRules(@NonNull List<ItemRule> itemRules)
    {
        this.itemRules = itemRules;
    }

    //~ Methods ========================================================================================================

    @Override
    public Item updateQuality(Item item)
    {
        return findFirstRuleForItem(item).update(item);
    }

    private ItemRule findFirstRuleForItem(Item item)
    {
        for (ItemRule rule : itemRules)
        {
            if (rule.canApply(item))
                return rule;
        }

        throw new IllegalStateException(String.format("Not find any rule for item %s", item.name));
    }


    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
