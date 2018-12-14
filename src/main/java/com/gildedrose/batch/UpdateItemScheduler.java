package com.gildedrose.batch;

import com.gildedrose.service.ItemService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <!-- Documentation for: com.gildedrose.batch.UpdateItemScheduler on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Component
public class UpdateItemScheduler
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    private final ItemService service;

    //~ Constructors ===================================================================================================

    public UpdateItemScheduler(ItemService service)
    {
        this.service = service;
    }

    //~ Methods ========================================================================================================

    @Scheduled(cron = "0 0 * * * *") // Call at 00:00 every day
    public void updateItems()
    {
        service.updateAllItems()
                .subscribe();
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
