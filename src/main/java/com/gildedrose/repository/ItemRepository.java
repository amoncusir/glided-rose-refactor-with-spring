package com.gildedrose.repository;

import com.gildedrose.entity.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <!-- Documentation for: com.gildedrose.repository.ItemRepository on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
public interface ItemRepository
{
    //~ Constants ======================================================================================================

    //~ Getters & Setters ==============================================================================================

    //~ Methods ========================================================================================================

    Flux<Item> getAllItems();

    Mono<Void> updateOrAddItem(Item item);

    //~ Default Methods ================================================================================================

    //~ Static Methods =================================================================================================

}
