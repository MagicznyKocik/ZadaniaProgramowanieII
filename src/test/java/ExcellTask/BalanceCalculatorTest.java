package ExcellTask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class BalanceCalculatorTest {

//    @Test
//    void shouldCalculateBalance() {
//        // given
//        BalanceCalculator balanceCalculator = new BalanceCalculator();
//        // when
//        BigDecimal balance = balanceCalculator.calculate(new BalanceData());
//        //then
//        assertEquals(BigDecimal.ZERO,balance);
//    }

    @ParameterizedTest
    @MethodSource("shouldCalculateBalanceParameter")
    void shouldCalculateBalance(BalanceData data, BigDecimal result) {
        // given
        BalanceCalculator balanceCalculator = new BalanceCalculator();
        // when
        BigDecimal balance = balanceCalculator.calculate(data);
        //then
        assertEquals(result,balance);
    }

    static Stream<Arguments> shouldCalculateBalanceParameter(){
        return Stream.of(
                arguments(new BalanceData(), BigDecimal.ZERO),
                arguments(new BalanceData(Arrays.asList(BigDecimal.ONE, new BigDecimal("120")),
                        Arrays.asList(new BigDecimal("50"))),
                        new BigDecimal("71"))

        );



    }


}