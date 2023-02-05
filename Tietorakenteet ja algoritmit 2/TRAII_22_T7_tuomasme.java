package com.company;

import java.util.*;

public class TRAII_22_T7_tuomasme implements TRAII_22_T7 {
    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * TreeSetin subSet-operaation aikavaativuus vaikuttaa olevan O(1).
     *
     * @param TS testattava TreeSet
     * @return subSet operaation normikesto nanosekunteina
     */
    @Override
    public long treeSetSubSetAika(TreeSet<Double> TS) {

        Random rnd = new Random();
        ArrayList<Long> ajat = new ArrayList<>();
        double alaraja, ylaraja;
        double luku1, luku2, luku3, luku4;

        // Ensimmäiset 20 kertaa 20 subSet-operaation mittausta
        for(int i = 0; i < 20; i++){

            luku1 = rnd.nextDouble();
            luku2 = rnd.nextDouble();

            if(luku1 < luku2){
                alaraja = luku1;
                ylaraja = luku2;
            }
            else{
                alaraja = luku2;
                ylaraja = luku1;
            }

            long alku = System.nanoTime();
            for(int j = 0; j < 20; j++){
                TS.subSet(alaraja, ylaraja);
            }
            long loppu = System.nanoTime();
            ajat.add((loppu - alku) / 20);
        }

        // Toiset 20 kertaa 20 subSet-operaation mittausta
        for(int k = 0; k < 20; k++){

            luku3 = rnd.nextDouble();
            luku4 = rnd.nextDouble();

            if(luku3 < luku4){
                alaraja = luku3;
                ylaraja = luku4;
            }
            else{
                alaraja = luku4;
                ylaraja = luku3;
            }

            long alku = System.nanoTime();
            for(int l = 0; l < 20; l++){
                TS.subSet(alaraja, ylaraja);
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
