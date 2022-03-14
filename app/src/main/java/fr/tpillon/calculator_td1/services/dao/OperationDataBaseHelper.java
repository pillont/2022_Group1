package fr.tpillon.calculator_td1.services.dao;

import android.content.Context;
import android.provider.BaseColumns;

public class OperationDataBaseHelper extends  DataBaseHelper {
    public OperationDataBaseHelper(Context context, String dataBaseName, int dataBaseVersion) {
        super(context, dataBaseName, dataBaseVersion);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS Operation (" +
            BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            OperationDao.FIRST_CONST + " TEXT NOT NULL," +
            OperationDao.SECOND_CONST + " TEXT NOT NULL," +
            OperationDao.OPE_CONST + " TEXT NOT NULL," +
        ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS Operation";
    }
}
