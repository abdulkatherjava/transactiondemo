package org.example;

import org.example.config.DatasourceConfig;
import org.example.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(DatasourceConfig.class);
        context.registerShutdownHook();
        ProductService productService = context.getBean("productService", ProductService.class);
        productService.saveProductInfo();
        context.close();
    }
}
