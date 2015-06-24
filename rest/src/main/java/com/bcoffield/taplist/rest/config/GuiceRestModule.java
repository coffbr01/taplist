package com.bcoffield.taplist.rest.config;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.function.Consumer;

public class GuiceRestModule extends ServletModule {
    @Override
    protected void configureServlets() {
        ResourceConfig config = new PackagesResourceConfig("com.bcoffield.taplist.rest");
        Consumer<Class<?>> binder = getBinder();
        config.getClasses().stream().forEach(binder);
        config = new PackagesResourceConfig("com.bcoffield.taplist.rest.provider");
        config.getClasses().stream().forEach(binder);
        config = new PackagesResourceConfig("com.bcoffield.taplist.entity.config");
        config.getClasses().stream().forEach(binder);

        serve("/*").with(GuiceContainer.class);
    }

    public Consumer<Class<?>> getBinder() {
        return new Consumer<Class<?>>() {
            @Override
            public void accept(Class<?> aClass) {
                bind(aClass);
            }
        };
    }
}
