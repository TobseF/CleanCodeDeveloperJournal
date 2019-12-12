package org.cleancode.journal.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ToStringUtil {
    public static String toString(LocalDate date) {
        return DateTimeFormatter.ofPattern("dd-MMM").withLocale(Locale.ENGLISH).format(date);
    }
}
