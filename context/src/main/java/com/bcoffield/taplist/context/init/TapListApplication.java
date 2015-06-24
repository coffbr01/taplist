package com.bcoffield.taplist.context.init;

import com.google.inject.Guice;

import javax.ws.rs.core.Application;
import java.util.Set;

public class TapListApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<>
    }
    public void init() {
        Guice.createInjector(new RSInjectorModule());
        Guice.createInjector(new MgmtInjectorModule());
    }
}
