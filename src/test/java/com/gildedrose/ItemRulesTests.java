package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.configuration.RepositoryConfiguration;
import com.gildedrose.entity.Item;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.rules.ItemRule;
import com.gildedrose.rules.StandardItemRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class ItemRulesTests
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    @Autowired
    public ItemRepository repository;

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Test
    public void testStandardItemRules()
    {
        final ItemRule rule = new StandardItemRule();

        final Item standardItem = new Item("Apple", 10, 20);
        final Item olderItem = new Item("Banana", 0, 2);
        final Item zeroQualityItem = new Item("Pomelo", -2, 0);
        final Item noneSellDays = new Item("Pomelo", -5, 10);

        Assert.isTrue(rule.canApply(standardItem), "StandardRule must accept any rule");

        Item updatedItem = rule.update(standardItem);

        assertEquals(updatedItem.sellIn, 9);
        assertEquals(updatedItem.quality, 19);

        updatedItem = rule.update(olderItem);

        assertEquals(updatedItem.sellIn, -1);
        assertEquals(updatedItem.quality, 0);

        updatedItem = rule.update(zeroQualityItem);

        assertEquals(updatedItem.sellIn, -3);
        assertEquals(updatedItem.quality, 0);

        updatedItem = rule.update(noneSellDays);

        assertEquals(updatedItem.sellIn, -6);
        assertEquals(updatedItem.quality, 8);
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
