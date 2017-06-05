package biz.paluch.clean.architecture.commons;

import java.time.LocalDate;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 08:01
 */
public class DateProvider {
    private static DateProvider dateProvider = new DateProvider();

    public static LocalDate get() {
        return dateProvider.getCurrentDate();
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static void setDateProvider(DateProvider dateProvider) {
        DateProvider.dateProvider = dateProvider;
    }
}
