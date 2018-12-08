package ExcellTask;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BalanceReader reader = new BalanceReader();
        BalanceCalculator calculator = new BalanceCalculator();

        BalanceData balanceData = reader.read();
        BigDecimal saldo = calculator.calculate(balanceData);

        System.out.println(saldo);

    }

}
