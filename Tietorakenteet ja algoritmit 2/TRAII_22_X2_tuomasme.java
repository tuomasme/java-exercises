package com.company;
import java.util.*;

public class TRAII_22_X2_tuomasme implements TRAII_22_X2 {
    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * Mitatessani kokoelman contains-operaation nopeutta nanosekunteina, suljin kaikki ohjelmat tietokoneeltani
     * kehitysympäristöä lukuun ottamatta. Contains-operaation mittauksen aloitus- ja lopetushetken välissä oli
     * ainoastaan for-silmukka jossa toistettiin contains-operaatiota. Käytin jokaisessa contains-operaatiossa vaihtuvaa
     * satunnaista liukulukua, jotta mittaustulokset olisivat todenmukaisempia.
     *
     * Mittaa annetun kokoelman contains -operaation aikavaativuuden nanosekunteina.
     * Mittaa ns. normaalin onnistuneen suorituksen tilanteessa jossa alkiota ei lÃ¶ydy
     * kokoelmasta.
     * Ei muuta kokoelmaa (lisÃ¤Ã¤ tai poista alkioita).
     *
     * @param C testattava kokoelma
     * @return contains operaation normikesto nanosekunteina
     */
    @Override
    public long containsAika(Collection<Double> C) {

        Random rnd = new Random();
        boolean sisaltaako = false;
        ArrayList<Long> ajat = new ArrayList<>();

        // Ensimmäiset 20 kertaa 20 contains-operaation mittausta
        for(int i = 0; i < 20; i++){
            double luku = rnd.nextDouble();
            long alku = System.nanoTime();
            for(int j = 0; i < 20; i++){
                sisaltaako = C.contains(luku);
            }
            long loppu = System.nanoTime();
            ajat.add((loppu - alku) / 20);
        }

        // Toiset 20 kertaa 20 contains-operaation mittausta
        for(int k = 0; k < 20; k++){
            double luku = rnd.nextDouble();
            long alku = System.nanoTime();
            for(int l = 0; l < 20; l++){
                sisaltaako = C.contains(luku);
            }
            long loppu = System.nanoTime();
            ajat.add((loppu - alku) / 20);
        }

        // Lajitellaan mitatut ajat sisältävä lista
        Collections.sort(ajat);

        // Tallennetaan mittaustulosten mediaaniaika palautettavaan muuttujaan
        long aika = ajat.get(ajat.size() / 2);

        return aika;
    }
}
