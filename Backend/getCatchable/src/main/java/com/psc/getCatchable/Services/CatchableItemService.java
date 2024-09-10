package com.psc.getCatchable.Services;

import com.psc.getCatchable.Entity.Catchable;
import com.psc.getCatchable.Entity.CatchableType;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CatchableItemService {




    // Map pour convertir les mois abrégés en objets Month
    private static final Map<String, Month> MONTH_MAP = new HashMap<>();

    static {
        MONTH_MAP.put("JAN", Month.JANUARY);
        MONTH_MAP.put("FEB", Month.FEBRUARY);
        MONTH_MAP.put("MAR", Month.MARCH);
        MONTH_MAP.put("APR", Month.APRIL);
        MONTH_MAP.put("MAY", Month.MAY);
        MONTH_MAP.put("JUN", Month.JUNE);
        MONTH_MAP.put("JUL", Month.JULY);
        MONTH_MAP.put("AUG", Month.AUGUST);
        MONTH_MAP.put("SEP", Month.SEPTEMBER);
        MONTH_MAP.put("OCT", Month.OCTOBER);
        MONTH_MAP.put("NOV", Month.NOVEMBER);
        MONTH_MAP.put("DEC", Month.DECEMBER);
    }

    // Méthode pour vérifier si l'heure actuelle est dans la plage
    private boolean isTimeWithinRange(String timeRange, LocalTime currentTime) {
        String[] parts = timeRange.split("–");
        if (parts.length == 2) {
            String start = parts[0].trim();
            String end = parts[1].trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h a");

            try {
                LocalTime startTime = LocalTime.parse(start, formatter);
                LocalTime endTime = LocalTime.parse(end, formatter);

                if (endTime.isBefore(startTime)) {
                    return !currentTime.isBefore(startTime) || !currentTime.isAfter(endTime);
                } else {
                    return !currentTime.isBefore(startTime) && !currentTime.isAfter(endTime);
                }
            } catch (DateTimeParseException e) {
                System.err.println("Error parsing timeRange: " + timeRange + " - " + e.getMessage());
            }
        }
        return false;
    }

    // Méthode pour vérifier si le mois actuel est dans la plage de mois
    private boolean isMonthWithinRange(String monthRange, LocalDate currentDate) {
        // Nettoyer le préfixe et extraire les mois
        String months = monthRange.replace("North: ", "").trim();
        String[] monthParts = months.split("–");
        if (monthParts.length == 2) {
            // Convertir les noms de mois abrégés en objets Month
            Month startMonth = parseMonth(monthParts[0].trim());
            Month endMonth = parseMonth(monthParts[1].trim());

            // Récupérer le mois actuel
            Month currentMonth = currentDate.getMonth();

            // Comparer les mois
            if (startMonth != null && endMonth != null) {
                if (startMonth.ordinal() <= endMonth.ordinal()) {
                    // La plage de mois ne traverse pas l'année
                    return currentMonth.ordinal() >= startMonth.ordinal() && currentMonth.ordinal() <= endMonth.ordinal();
                } else {
                    // La plage de mois traverse l'année
                    return currentMonth.ordinal() >= startMonth.ordinal() || currentMonth.ordinal() <= endMonth.ordinal();
                }
            }
        }
        return false;
    }

    // Méthode pour parser les mois à partir des abréviations
    private Month parseMonth(String monthAbbreviation) {
        return MONTH_MAP.get(monthAbbreviation.toUpperCase());
    }

    // Méthode pour filtrer les éléments capturables à l'instant T
    public List<Catchable> getFilteredItems(List<Catchable> items) {
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        return items.stream()
                .filter(item -> {
                    boolean timeMatch = isTimeWithinRange(String.valueOf(item.getTime()), currentTime);
                    String northMonths = item.getMonths().split("\n")[0].replace("North: ", "");
                    boolean monthMatch = isMonthWithinRange(northMonths, today);
                    return timeMatch && monthMatch;
                })
                .collect(Collectors.toList());
    }
}
