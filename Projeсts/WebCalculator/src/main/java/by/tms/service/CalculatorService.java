package by.tms.service;

import by.tms.entity.Operation;
import by.tms.storage.InJDBCOperationStorage;

import java.util.List;
import java.util.Optional;


public class CalculatorService {
    private static final InJDBCOperationStorage jdbcOperationStorage = new InJDBCOperationStorage();
    public Optional<Operation> calculate(Operation operation) {

        String stringType = operation.getType().toUpperCase();
        TypesOfOperations type = TypesOfOperations.valueOf(stringType);

        switch (type){
            case SUM:
              operation.setResult(methodSum(operation.getNum1(), operation.getNum2()));
              jdbcOperationStorage.save(operation);
              return Optional.of(operation);
            case SUB:
              operation.setResult(methodSub(operation.getNum1(), operation.getNum2()));
              jdbcOperationStorage.save(operation);
              return Optional.of(operation);
            case MUL:
              operation.setResult(methodMul(operation.getNum1(), operation.getNum2()));
              jdbcOperationStorage.save(operation);
              return Optional.of(operation);
            case DIV:
              operation.setResult(methodDiv(operation.getNum1(), operation.getNum2()));
              jdbcOperationStorage.save(operation);
              return Optional.of(operation);
      }
      return  Optional.empty();
    }
    private double methodSum(double a, double b) {
        return a + b;
    }

    private double methodSub(double a, double b) {
        return a - b;
    }

    private double methodMul(double a, double b) {
        return a * b;
    }

    private double methodDiv(double a, double b) {
        return a / b;
    }

    public List<Operation> showHistoryInJDBC() {
        return jdbcOperationStorage.findAll();
    }

}
