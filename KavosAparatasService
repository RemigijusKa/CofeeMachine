package lt.vcs.Remigijus;

public class KavosAparatasService {

    public KavosAparatasService() {

    }

    public boolean arPasiruoses(KavosAparatas aparatas) {
        boolean praplovimai = aparatas.getPanaudojimuSkLimitas() > aparatas.getPanaudojimuSkaicius();
        boolean pienoM = aparatas.getPienoMilteliai() > 80;
        boolean kavosPup = aparatas.getKavospupeles() > 50;
        boolean vandens = aparatas.getVanduo() > 180;
        return (praplovimai && pienoM && kavosPup && vandens);
    }

    public void pagaminaGerima(KavosAparatas aparatas, int gerimoIndex) throws Exception {

        if (aparatas.getPanaudojimuSkaicius() >= aparatas.getPanaudojimuSkLimitas()) {
            throw new Exception("Reikia praplauti aparata.");
        }
        Gerimas gerimas = aparatas.getGerimai()[gerimoIndex];
        if (gerimas.getKavosPupeles() > aparatas.getKavospupeles() || gerimas.getPienoMilteliai() > aparatas.getPienoMilteliai() ||
                gerimas.getVanduo() > aparatas.getVanduo()) {
            throw new Exception("Reikia papildyti produktų likučius.");
        }
        aparatas.setPienoMilteliai(aparatas.getPienoMilteliai() - gerimas.getPienoMilteliai());
        aparatas.setKavospup(aparatas.getKavospupeles() - gerimas.getKavosPupeles());
        aparatas.setVanduo(aparatas.getVanduo() - gerimas.getVanduo());
        aparatas.setPanaudojimuSkaicius(aparatas.getPanaudojimuSkaicius() + 1);
    }

    public void papildoLikucius(KavosAparatas aparatas, int userChoise) {
        switch (userChoise) {
            case 1:
                aparatas.setPienoMilteliai(500);
                break;
            case 2:
                aparatas.setKavospup(1000);
                break;
            case 3:
                aparatas.setVanduo(3000);
        }
    }

    public void praplaunaAparata(KavosAparatas aparatas) {
        aparatas.setPanaudojimuSkaicius(0);
    }
}


