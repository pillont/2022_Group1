package fr.tpillon.calculator_td1.services;

import fr.tpillon.calculator_td1.models.OperationModel;
import fr.tpillon.calculator_td1.models.exceptions.DiviseException;
import fr.tpillon.calculator_td1.models.exceptions.OperatorException;
import fr.tpillon.calculator_td1.models.exceptions.ResultException;
import fr.tpillon.calculator_td1.services.dao.DataBaseHelper;
import fr.tpillon.calculator_td1.services.dao.OperationDao;
import fr.tpillon.calculator_td1.services.dao.OperationDataBaseHelper;

public class OperationsService {

    private OperationDao operationDao;

    public OperationsService() {
        // TODO : récupérera le context + le nom de la DB
        // TODO : utilisera ce helper !
        DataBaseHelper helper = new OperationDataBaseHelper();
        operationDao = new OperationDao(helper);
    }

    public double computeResult(OperationModel operation)
            throws ResultException, DiviseException, OperatorException {
        String firstValueAsString = operation.getFirstValue();
        String secondValueAsString = operation.getSecondValue();
        String operator = operation.getOperator();

        double firstValue;
        double secondValue;

        try {
            firstValue = Double.parseDouble(firstValueAsString);
            secondValue = Double.parseDouble(secondValueAsString);
        } catch(NumberFormatException ex){
            throw new ResultException("values are not numbers", ex);
        }

        double result;
        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                if(secondValue == 0) {
                    throw new DiviseException("divise by 0");
                }

                result = firstValue / secondValue;
                break;
            default:
                throw new OperatorException("operator invalid");
        }

        return result;
    }

    public void saveOperation(OperationModel operation) {
    }
}
