package pl.edu.agh.mwo.example;


import java.util.*;

import static pl.edu.agh.mwo.example.Reports.*;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj katalog z plikami wyjściowymi do raportów np. reporter-dane");
        String dir = scanner.next();
        int wynik = 5;

        while (wynik != 4) {
            System.out.println("===============================================================");
            System.out.println("Wybierz 1 dla raportu pracownikow wg przepracowanych godzin we wszystkich projektach");
            System.out.println("Wybierz 2 dla raportu  przepracowanych gdzin w danym miesiącu");
            System.out.println("Wybierz 3 dla raportu 10-ciu najbardziej pracowitych dni");
            System.out.println("Wybierz 4 aby zakończyć program");
            System.out.println("===============================================================");

            wynik = scanner.nextInt();

            if (wynik == 1) {
                raport1(dir);
            } else if (wynik == 2) {
                raport2(dir);
            } else if (wynik == 3) raport3(dir);

//        raport1("reporter-dane");
//        raport2("reporter-dane");
//        raport3("reporter-dane");

        }
    }
}
