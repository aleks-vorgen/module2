package org.example.dao;

import org.example.dao.enums.DBType;
import org.example.dao.interfaces.DAOAccess;
import org.example.dao.oracle.OracleFactory;

public abstract class DBFactory {
    public abstract DAOAccess getDAO();

    public static DBFactory getDBFactory(DBType type) {
        switch (type) {
            case MYSQL:
                //return new MySQLFactory();
            case ORACLE:
                return new OracleFactory();
            default:
                return null;
        }
    }
}
