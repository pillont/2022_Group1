package fr.tpillon.calculator_td1.services.dao;

import android.content.ContentValues;
import android.database.Cursor;

import fr.tpillon.calculator_td1.models.OperationModel;

public class OperationDao extends BaseDao<OperationModel> {

    public final static String FIRST_CONST = "FIRST";
    public final static String SECOND_CONST = "SECOND";
    public final static String OPE_CONST = "OPERATOR";

    public OperationDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "Operation";
    }

    @Override
    protected void putValues(ContentValues values, OperationModel entity) {
        values.put(
                // nom de colonne en base
                FIRST_CONST,
                // la valeur à pousser en base
                entity.getFirstValue()
        );
        values.put(
                // nom de colonne en base
                SECOND_CONST,
                // la valeur à pousser
                entity.getSecondValue()
        );
        values.put(
                // nom de colonne en base
                OPE_CONST,
                // la valeur à pousser
                entity.getOperator()
        );
    }

    @Override
    protected OperationModel getEntity(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(FIRST_CONST);
        String first = cursor.getString(columnIndex);

        columnIndex = cursor.getColumnIndex(SECOND_CONST);
        String second = cursor.getString(columnIndex);

        columnIndex = cursor.getColumnIndex(OPE_CONST);
        String operator = cursor.getString(columnIndex);

        OperationModel model = new OperationModel(first, second, operator);
        return model;
    }
}













