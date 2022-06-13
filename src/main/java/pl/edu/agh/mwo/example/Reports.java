package pl.edu.agh.mwo.example;

import java.util.*;
import java.util.stream.Collectors;

import static pl.edu.agh.mwo.example.Parser.parser;

public class Reports {

    public static void raport1 (String filePath) {

        List<Employee> employees = parser(filePath);

        Map<String, Double> raport1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.summingDouble(Employee::getHour)));

        for (Map.Entry<String, Double> entry : raport1.entrySet()) {
            System.out.println("Pracownik: " + entry.getKey() + " przepracował w projektach: " + entry.getValue() + " godzin");
        }
    }

    public static void raport2 (String filePath) {

        List<Employee> employees = parser(filePath);

        Map<String, Double> raportPerMonth = new HashMap<>();

        for(Employee employee: employees) {
            String month1 = employee.getDate().toString();
            month1 = month1.substring(4,7);

            Double hour1 = employee.getHour();
            if (raportPerMonth.containsKey(month1)) {
                raportPerMonth.put(month1, raportPerMonth.get(month1) + hour1);
            } else {
                raportPerMonth.put(month1, hour1);
            }
        }

        for (Map.Entry<String, Double> entry : raportPerMonth.entrySet()) {
            System.out.println("W miessiącu: " + entry.getKey() + " przepracowano: " + entry.getValue()+ " godzin");
        }
    }

    public static void raport3 (String filePath) {
        List<Employee> employees = parser(filePath);

        Map<Date, Double> raport3 = employees.stream()
                .sorted((e1, e2) ->e1.getHour().equals(e2.getHour()) ? 0 : (e1.getHour() > e2.getHour() ? -1 : 1))
                .limit(10)
                .collect(Collectors.toMap(
                        Employee::getDate,
                        Employee::getHour,
                        (previous, next) -> previous,
                        LinkedHashMap::new
                ));

        for (Map.Entry<Date, Double> entry : raport3.entrySet()) {
            System.out.printf("%s %tF %s %s %s \n", "Dnia: ", entry.getKey(), " przepracowano: ", entry.getValue(), " godzin");
        }
    }
}
