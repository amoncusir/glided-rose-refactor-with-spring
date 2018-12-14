package com.gildedrose.configuration;

import com.gildedrose.repository.InMemoryItemRepository;
import com.gildedrose.repository.ItemRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <!-- Documentation for: com.gildedrose.configuration.RepositoryConfiguration on 14/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@Configuration
public class RepositoryConfiguration
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ItemRepository itemRepositoryFromMemory()
    {
        return new InMemoryItemRepository();
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
