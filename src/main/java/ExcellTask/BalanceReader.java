package ExcellTask;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceReader {

    private static final String FILE_PATH = "E:\\programy w javie\\kurs\\ZadaniaProgramowanieII\\budzet_kowalskich.xls";


    BalanceData read() throws IOException {
        BalanceData balanceData = new BalanceData();
        try (InputStream inp = new FileInputStream(FILE_PATH)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                BigDecimal income = getCellValue(row, 1);
                BigDecimal outcome = getCellValue(row, 3);
                if(!income.equals(BigDecimal.ZERO))
                    balanceData.getIncomes().add(income);
                if (!outcome.equals(BigDecimal.ZERO))
                    balanceData.getOutcomes().add(outcome);

                //System.out.println("Dochód: " + income);
                //System.out.println("Wydatek: " + outcome);
            }
        }

        return balanceData;


    }

    private BigDecimal getCellValue(Row row, int columnNumber) {
        Cell cell = row.getCell(columnNumber);
        return !cell.toString().isEmpty() ?
                new BigDecimal(cell.toString()) : BigDecimal.ZERO;
    }
}
