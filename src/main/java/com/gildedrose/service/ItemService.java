package com.gildedrose.service;

import com.gildedrose.entity.Item;
import reactor.core.publisher.Flux;

/**
 * <!-- Documentation for: com.gildedrose.service.ItemService on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
public interface ItemService
{
    //~ Constants ======================================================================================================

    //~ Getters & Setters ==============================================================================================

    //~ Methods ========================================================================================================

    //~ Default Methods ================================================================================================

    Flux<Item> getAllItems();

    Flux<Item> updateAllItems();

    //~ Static Methods =================================================================================================

}
