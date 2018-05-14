package lt.vcs.Remigijus;

import java.util.Scanner;

public class AparatasMain {
    static Scanner scanner = new Scanner(System.in);
    static KavosAparatasService service = new KavosAparatasService();

    public static void main(String[] args) {
        KavosAparatas aparatasKavai = new KavosAparatas(500, 1000, 3000, 50);

        boolean run = true;
        while (run) {
            try {
                System.out.println();
                spausdinaJeiPasiruoses(aparatasKavai);
                spausdinaMeniu(aparatasKavai);
                int userchoise = scanner.nextInt();

                if (userchoise == 0) {
                    rodoIrVykdoNustatymus(aparatasKavai);
                    continue;
                }
                if (userchoise == -1) {
                    return;
                }
                service.pagaminaGerima( aparatasKavai, userchoise - 1);
                Gerimas gerimas = aparatasKavai.getGerimai()[userchoise - 1];
                System.out.println("Pagamintas gerimas:" + gerimas.getPavadinimas());
            } catch (Exception e) {
                System.out.println("Klaida: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void spausdinaJeiPasiruoses(KavosAparatas aparatasKavai) {
        if (service.arPasiruoses(aparatasKavai)) {
            System.out.println("Kavos aparatas pasiruošęs");
        }
    }

    public static void spausdinaMeniu(KavosAparatas aparatas) {
        System.out.println("Pasirinkite iš Meniu: ");
        for (int index = 0; index < aparatas.getGerimai().length; index++) {
            Gerimas gerimas = aparatas.getGerimai()[index];
            System.out.println((index + 1) + ". " + gerimas.getPavadinimas());
        }
        System.out.println("0. Aparato nustatymai");
    }

    public static void rodoIrVykdoNustatymus(KavosAparatas aparatasKavai) {
        System.out.println("Pasirinkite norimą nustatymą:");
        System.out.println("1. Produktų likučiai");
        System.out.println("2. Aparato būsena");
        System.out.println("3. Papildyti produktus");
        System.out.println("4. Atlikti valymą");
        System.out.println("0. Grįžti į pagrindinį meniu.");
        System.out.println();

        int userSecondInput = scanner.nextInt();
        switch (userSecondInput) {
            case 0:
                break;
            case 1:
                spausdinaLikucius(aparatasKavai);
                break;
            case 2:
                parodoBusena(aparatasKavai);
                break;
            case 3:
                papildoLikucius(aparatasKavai);
                break;
            case 4:
                service.praplaunaAparata(aparatasKavai);
        }
    }


    public static void spausdinaLikucius(KavosAparatas aparatasKavai) {
        System.out.println("Produktų likučiai aparate: ");
        System.out.println("Pieno miltelių: " + aparatasKavai.getPienoMilteliai() + "g");
        System.out.println("Kavos pupelių: " + aparatasKavai.getKavospupeles() + "g");
        System.out.println("Vandens: " + aparatasKavai.getVanduo() + "ml");
    }

    public static void parodoBusena(KavosAparatas aparatasKavai) {
        System.out.println("Produktų likučiai aparate: ");
        System.out.println("Pieno miltelių: " + aparatasKavai.getPienoMilteliai() + "g");
        System.out.println("Kavos pupelių: " + aparatasKavai.getKavospupeles() + "g");
        System.out.println("Vandens: " + aparatasKavai.getVanduo() + "ml");
        System.out.println("Iki praplovimo liko: " + (aparatasKavai.getPanaudojimuSkLimitas() -
                aparatasKavai.getPanaudojimuSkaicius()) + " panaudojimų");
    }

    public static void papildoLikucius(KavosAparatas aparatas) {
        System.out.println("Pasirinkite, kurį produktą norite papildyti: ");
        System.out.println("1. Pieno miltelių");
        System.out.println("2. Kavos pupelių");
        System.out.println("3. Vandens");
        service.papildoLikucius(aparatas,scanner.nextInt());
        System.out.println("Likutis papildytas.");
    }

}
