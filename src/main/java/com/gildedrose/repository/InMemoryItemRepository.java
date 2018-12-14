package com.gildedrose.repository;

import com.gildedrose.entity.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <!-- Documentation for: com.gildedrose.repository.InMemoryItemRepository on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
public class InMemoryItemRepository
    implements ItemRepository
{
    //~ Constants ======================================================================================================

    private static final HashSet<Item> items = fromItems(
            new Item("Apple", 10, 30),
            new Item("Apple", 5, 20),

            new Item("Banana", 30, 45),
            new Item("Banana", 30, 10),
            new Item("Banana", 20, 45),

            new Item("Aged Brie", 20, 10),
            new Item("Aged Brie", 10, 20),
            new Item("Aged Brie", 40, 5),

            new Item("Backstage passes to a TAFKAL80ETC concert", 18, 16),
            new Item("Backstage passes to a TAFKAL80ETC concert", 18, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 18, 35),
            new Item("Backstage passes to a TAFKAL80ETC concert", 18, 5),

            new Item("Sulfuras, Hand of Ragnaros", 50, 40),
            new Item("Sulfuras, Hand of Ragnaros", 50, 50),
            new Item("Sulfuras, Hand of Ragnaros", 50, 30),
            new Item("Sulfuras, Hand of Ragnaros", 50, 18)
    );

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Override
    public Flux<Item> getAllItems()
    {
        return Flux.fromStream(items.stream());
    }

    @Override
    public Mono<Void> updateOrAddItem(Item item)
    {
        items.add(item);

        return Mono.empty();
    }


    //~ Static Methods =================================================================================================

    private static HashSet<Item> fromItems(Item... items)
    {
        return new HashSet<>(Arrays.asList(items));
    }

    //~ Implementations ================================================================================================
}
