package biz.paluch.clean.architecture.commons;

import java.time.LocalDate;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 01.08.13 08:03
 */
public class StaticDateProvider extends DateProvider {

    private LocalDate currentDate;

    public static void initialize(LocalDate currentDate) {
        StaticDateProvider instance = new StaticDateProvider();
        instance.setCurrentDate(currentDate);
        DateProvider.setDateProvider(instance);
    }

    @Override
    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
