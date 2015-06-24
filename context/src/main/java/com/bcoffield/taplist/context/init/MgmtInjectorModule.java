package com.bcoffield.taplist.context.init;

import com.bcoffield.taplist.api.ITapListMgmt;
import com.bcoffield.taplist.server.mgmt.TapListMgmt;
import com.google.inject.AbstractModule;

public class MgmtInjectorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ITapListMgmt.class).to(TapListMgmt.class);
    }
}
