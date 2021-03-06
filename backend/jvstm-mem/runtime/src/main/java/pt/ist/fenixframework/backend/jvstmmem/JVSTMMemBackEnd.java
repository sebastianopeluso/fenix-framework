package pt.ist.fenixframework.backend.jvstmmem;

import pt.ist.fenixframework.DomainObject;
import pt.ist.fenixframework.DomainRoot;
import pt.ist.fenixframework.TransactionManager;
import pt.ist.fenixframework.backend.BackEnd;
import pt.ist.fenixframework.core.SharedIdentityMap;

public class JVSTMMemBackEnd implements BackEnd {
    protected static final String BACKEND_NAME = "jvstmmem";

    private final TransactionManager transactionManager;

    public JVSTMMemBackEnd() {
        transactionManager = new JVSTMMemTransactionManager();
    }

    @Override
    public <T extends DomainObject> T fromOid(Object oid) {
        return (T) SharedIdentityMap.getCache().lookup(oid);

    }

    @Override
    public <T extends DomainObject> T getDomainObject(String externalId) {
        return fromOid(Long.parseLong(externalId));
    }

    @Override
    public DomainRoot getDomainRoot() {
        DomainRoot root = fromOid(1L);
        if (root == null) {
            root = new DomainRoot(); // which automatically caches this instance, but does not
            // ensure that it is the first, as a concurrent request
            // might create another

            // so we get it again from the cache before returning it
            root = fromOid(1L);
            assert root != null;
        }
        return root;
    }

    @Override
    public String getName() {
        return BACKEND_NAME;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    public void shutdown() {
    }
}
