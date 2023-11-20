package socialledger.server;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

public class ServiceRegistry{
    private static ServiceRegistry INSTANCE = null;
    private final boolean isGlobal;
    private final ClassToInstanceMap<Object> services = MutableClassToInstanceMap.create();

    public ServiceRegistry() {
        this(false);
    }

    private ServiceRegistry(boolean isGlobalInstance) {
        this.isGlobal = isGlobalInstance;
    }

    public static <T> void configure(Class<T> svcType, T svcInstance) {
        if (INSTANCE == null) INSTANCE = new ServiceRegistry(true);
        if (!INSTANCE.isGlobal) throw new IllegalStateException("Non-global Lookups should not use static methods.");

        INSTANCE.putServiceImpl(svcType, svcInstance);
    }

    /**
     * The main access for finding application services.
     *
     * @param serviceType The class of a service the callers wants.
     * @return A non-null instance of the given class
     * @throws IllegalStateException if no instance of the requested class has been configured.
     */
    public static <K> K lookup(Class<K> serviceType) {
        if (INSTANCE == null) throw new IllegalStateException("Lookup not initialised");
        if (!INSTANCE.isGlobal) throw new IllegalStateException("Non-global Lookups should not use static methods.");

        K service = INSTANCE.getServiceImpl(serviceType);
        if (service == null) throw new IllegalStateException("No service configured for " + serviceType);
        return service;
    }

    public <T> T getService(Class<T> svcType) {
        if (isGlobal) {
            throw new IllegalStateException("Global Lookup should only be accessed using static methods.");
        }
        return getServiceImpl(svcType);
    }

    private <T> T getServiceImpl(Class<T> svcType) {
        return services.getInstance( svcType );
//        return services.get(svcType);
    }

    public <T> ServiceRegistry putService(Class<T> svcType, T svcInstance) {
        if (isGlobal) {
            throw new IllegalStateException("Global Lookup should only be accessed using static methods.");
        }
        putServiceImpl(svcType, svcInstance);
        return this;
    }

    private <T> void putServiceImpl(Class<T> svcType, T svcInstance) {
        services.putInstance( svcType, svcInstance );
    }
}