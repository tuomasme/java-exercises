package com.company;

import java.util.*;

public class TRAII_22_X6_tuomasme implements TRAII_22_X6 {

    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * Algoritmi toimii erittäin hyvin pienillä syötteillä ja melko hyvin suurilla syötteillä. Algoritmin antama
     * tulos on aina pienempi tai yhtä suuri kuin tavoitesumma. Algoritmin aikavaativuus on O(n). Algoritmissa ei ole
     * satunnaisuutta, vaan algoritmin toiminta perustuu heuristiikkaan.
     *
     *
     * Valitsee kokonaislukulistan alkioista osan siten, ettÃ¤ osalistan summa on mahdollisimman lÃ¤hellÃ¤,
     * mutta ei yli luvun tavoite.
     * Koska tehtÃ¤vÃ¤ on NP vaikea, optimaalista tulosta ei yleensÃ¤
     * saavuteta, mutta pyritÃ¤Ã¤n kohtuullisessa ajassa jotenkin kohtuulliseen tulokseen.
     * Algoritmin on suoriuduttava tehtÃ¤vÃ¤stÃ¤ maxAika sekunnissa.
     * @param syote syÃ¶telista, tÃ¤tÃ¤ ei saa muuttaa mitenkÃ¤Ã¤n
     * @param tavoite tavoitesumma
     * @param maxAika suurin kÃ¤ytettÃ¤vissÃ¤ oleva aika (sekunteja)
     * @return osakokoelma jonka alkioiden summa on korkeintaan tavoite
     */
    @Override
    public Collection<Long> osajoukonSumma(Collection<Long> syote,
                                           long tavoite, int maxAika) {

        List<Long> tulos = new LinkedList<>();

        ArrayList<Long> syoteKopio = new ArrayList<>();
        syoteKopio.addAll(syote);
        long summa = 0;

        Collections.sort(syoteKopio);
        // Poistetaan tavoitesummaa suuremmat alkiot ja
        // lisätään palautettavaan listaan mahdollinen tavoitesumman suuruinen alkio
        for (int i = syoteKopio.size() - 1; i > 0; i--) {
            if(syoteKopio.get(i) > tavoite){
                syoteKopio.remove(i);
            }
            else if (syoteKopio.get(i) == tavoite) {
                tulos.add(syoteKopio.get(i));
                return tulos;
            }
            else{
                break;
            }
        }
        // Lisätään palautettavaan listaan suurin syötelistan alkio
        tulos.add(syoteKopio.get(syoteKopio.size() - 1));
        if(syoteKopio.size() == 1){
            return tulos;
        }
        summa = syoteKopio.get(syoteKopio.size() - 1);

        long alku = System.currentTimeMillis();

        while (System.currentTimeMillis() <= alku + maxAika * 1000L) {
            for (int i = syoteKopio.size() - 2; i >= 0; i--) {
                if ((syoteKopio.get(i) + summa) < tavoite) {
                    tulos.add(syoteKopio.get(i));
                    summa += syoteKopio.get(i);
                    syoteKopio.remove(i);
                } else if ((syoteKopio.get(i) + summa) == tavoite) {
                    tulos.add(syoteKopio.get(i));
                    return tulos;
                }
            }
        }
        return tulos;
    }


        // TODO: tee siis tilalle oma versio joka tekee valinnan
        // fiksummin jotta pÃ¤Ã¤set lÃ¤hemmÃ¤s tavoitetta

        // vihjeitÃ¤:
        // (a) mieti missÃ¤ jÃ¤rjestyksessÃ¤ alkiot kannattaa lisÃ¤tÃ¤ ja ehkÃ¤ myÃ¶s sitÃ¤
        //     mikÃ¤ alkio kannattaa milloinkin lisÃ¤tÃ¤
        // (b) kÃ¤ytÃ¤ (sopivasti) satunnaisuutta ja kokeile useita erilaisia valintoja
        //     ja lopuksi (ajan loputtua) lisÃ¤Ã¤ paras niistÃ¤ palautettavaksi tulokseksi

}