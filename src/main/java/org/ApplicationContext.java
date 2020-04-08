package org;

import org.dao.DataAccessor;

public enum ApplicationContext {INSTANCE; // используем singleton
    private final DataAccessor dataAccessor = new DataAccessor();

    private ApplicationContext() {
    }
    public DataAccessor getDataAccessor(){
        return dataAccessor;
    }
}
