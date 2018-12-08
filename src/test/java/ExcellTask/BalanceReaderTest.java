package ExcellTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BalanceReaderTest {

    @Test
    void shouldReadBalance() throws IOException {
        BalanceReader reader = new BalanceReader();
        BalanceData data = reader.read();

        assertEquals(3, data.getIncomes().size());

        assertTrue(data.getIncomes().contains(new BigDecimal("20000.0")));

        assertEquals(16, data.getOutcomes().size());

        assertTrue(data.getOutcomes().contains(new BigDecimal("126.0")));
    }
}