package automation.util;

import java.time.LocalDateTime;

public class ExpectedDate {
    public String now() {
        LocalDateTime date = LocalDateTime.now();
        return String.format("%d-%d-%d %d:%d:%d", date.getDayOfMonth(), date.getMonthValue(), date.getYear(), date.getHour(), date.getMinute(), date.getSecond());
    }
}
