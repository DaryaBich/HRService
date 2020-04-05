package org;

import org.dao.DataAccessor;

public class ApplicationContext { // используем singleton
    private static DataAccessor dataAccessor;

    private ApplicationContext() {
    }
    public static DataAccessor getDataAccessor(){
        if (dataAccessor == null){
            dataAccessor = new DataAccessor();
        }
        return dataAccessor;
    }
}
