package com.bcoffield.taplist.context.init;

import com.bcoffield.taplist.api.mgmt.IBeerMgmt;
import com.bcoffield.taplist.api.mgmt.ITapListMgmt;
import com.bcoffield.taplist.server.mgmt.BeerMgmt;
import com.bcoffield.taplist.server.mgmt.TapListMgmt;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(IBeerMgmt.class).to(BeerMgmt.class);
        bind(ITapListMgmt.class).to(TapListMgmt.class);

        ResourceConfig config = new PackagesResourceConfig("com.bcoffield.taplist.rest");
        config.getClasses().stream().forEach(this::bind);

        serve("/*").with(GuiceContainer.class);
    }
}
