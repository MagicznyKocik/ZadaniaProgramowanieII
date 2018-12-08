package ExcellTask;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.stream.Stream;

public class BalanceCalculator  {


    BigDecimal calculate(BalanceData data){
        BigDecimal incomesSum = BigDecimal.ZERO;
        BigDecimal outcomesSum = BigDecimal.ZERO;
        BigDecimal saldo = BigDecimal.ZERO;



        for (BigDecimal element: data.getIncomes()) {
            incomesSum = incomesSum.add(element);
        }
        for (BigDecimal element: data.getOutcomes()) {
            outcomesSum = outcomesSum.add(element);
        }


        saldo = incomesSum.subtract(outcomesSum);
//        System.out.println(incomesSum);
//        System.out.println(outcomesSum);
//        System.out.println(saldo);
        return saldo;
    }
}
