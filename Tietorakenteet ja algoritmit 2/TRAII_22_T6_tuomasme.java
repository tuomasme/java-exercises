package com.company;

import java.util.*;

public class TRAII_22_T6_tuomasme implements TRAII_22_T6 {
    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * Prioriteettijonon alkioiden kymmenkertaistuessa, contains-operaation suorittamiseen kuluva aika kymmenkertaistuu
     * eli prioriteettijonon contains-operaation aikavaativuus on O(n).
     *
     * Mittaa annetun kokoelman contains -operaation aikavaativuuden nanosekunteina.
     * Mittaa ns. normaalin onnistuneen suorituksen tilanteessa jossa alkiota ei lÃ¶ydy
     * kokoelmasta.
     * Ei muuta kokoelmaa (lisÃ¤Ã¤ tai poista alkioita).
     *
     * @param PQ testattava kokoelma
     * @return contains-operaation normikesto nanosekunteina
     */
    @Override
    public long priorityQueueContainsAika(PriorityQueue<Double> PQ) {

        Random rnd = new Random();
        double luku;
        boolean sisaltaako = false;
        ArrayList<Long> ajat = new ArrayList<>();

        // Ensimmäiset 20 kertaa 20 contains-operaation mittausta
        for(int i = 0; i < 20; i++){
            luku = rnd.nextDouble();
            long alku = System.nanoTime();
            for(int j = 0; i < 20; i++){
                sisaltaako = PQ.contains(luku);
            }
            long loppu = System.nanoTime();
            ajat.add((loppu - alku) / 20);
        }

        // Toiset 20 kertaa 20 contains-operaation mittausta
        for(int k = 0; k < 20; k++){
            luku = rnd.nextDouble();
            long alku2 = System.nanoTime();
            for(int l = 0; l < 20; l++){
                sisaltaako = PQ.contains(luku);
            }
            long loppu2 = System.nanoTime();
            ajat.add((loppu2 - alku2) / 20);
        }

        // Lajitellaan mitatut ajat sisältävä lista
        Collections.sort(ajat);

        // Tallennetaan mittaustulosten mediaaniaika palautettavaan muuttujaan
        long aika = ajat.get(ajat.size() / 2);

        return aika;
    }
}
