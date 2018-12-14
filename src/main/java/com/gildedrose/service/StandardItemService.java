package com.gildedrose.service;

import com.gildedrose.entity.Item;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.rules.GlidedRose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * <!-- Documentation for: com.gildedrose.service.StandardItemService on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Service
public class StandardItemService
    implements ItemService
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    private final ItemRepository repository;

    private final GlidedRose glidedRose;

    //~ Constructors ===================================================================================================

    @Autowired
    public StandardItemService(@NonNull ItemRepository repository, @NonNull GlidedRose glidedRose)
    {
        this.repository = repository;
        this.glidedRose = glidedRose;
    }

    //~ Methods ========================================================================================================

    @Override
    public Flux<Item> getAllItems()
    {
        return repository.getAllItems();
    }

    @Override
    public Flux<Item> updateAllItems()
    {
        return repository.getAllItems()
                .map(glidedRose::updateQuality);
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
