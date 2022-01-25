package com.myself.test;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicBoolean;

public class Test8 implements Serializable {
    private static VarHandle value;
    
    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            value = l.findVarHandle(AtomicBoolean.class, "value", int.class);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
    
    public final boolean compareAndSet(boolean expectedValue, boolean newValue) {
        return value.compareAndSet(this, expectedValue ? 1 : 0, newValue ? 1 : 0);
    }
}
