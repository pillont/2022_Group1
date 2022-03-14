package fr.tpillon.calculator_td1.models;

public class OperationModel extends BaseEntity {
    private String _firstValue;
    private String _secondValue;
    private String _operator;

    public OperationModel(
            String first,
            String second,
            String ope
    ){
        this._firstValue = first;
        this._secondValue = second;
        this._operator = ope;
    }

    public String getFirstValue() {
        return _firstValue;
    }

    public String getSecondValue() {
        return _secondValue;
    }

    public String getOperator() {
        return _operator;
    }
}
