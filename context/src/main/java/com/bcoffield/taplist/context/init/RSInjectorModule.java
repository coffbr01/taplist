package com.bcoffield.taplist.context.init;

import com.bcoffield.taplist.api.rs.IRSTapList;
import com.bcoffield.taplist.rest.RSTapList;
import com.google.inject.AbstractModule;

public class RSInjectorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IRSTapList.class).to(RSTapList.class);
    }
}
