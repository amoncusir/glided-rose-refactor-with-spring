package com.gildedrose.endpoint;

import com.gildedrose.entity.Item;
import com.gildedrose.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * <!-- Documentation for: com.gildedrose.endpoint.ItemController on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@RestController
@RequestMapping("/item")
public class ItemController
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    private final ItemService service;

    //~ Constructors ===================================================================================================

    @Autowired
    public ItemController(ItemService service)
    {
        this.service = service;
    }

    //~ Methods ========================================================================================================

    @GetMapping("/all")
    public Flux<Item> getAllItems()
    {
        return service.getAllItems();
    }

    @PutMapping("/update")
    public Flux<Item> updateAllItems()
    {
        return service.updateAllItems();
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
