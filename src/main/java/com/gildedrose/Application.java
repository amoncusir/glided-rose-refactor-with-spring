package com.gildedrose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <!-- Documentation for: com.gildedrose.Application on 13/12/18 -->
 *
 * @author Aran Moncusí Ramírez
 */
@EnableScheduling
@SpringBootApplication
public class Application
{
    //~ Constants ======================================================================================================

    //~ Properties =====================================================================================================

    //~ Constructors ===================================================================================================

    //~ Methods ========================================================================================================

    public static void main(String... args)
    {
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }

    //~ Static Methods =================================================================================================

    //~ Implementations ================================================================================================
}
