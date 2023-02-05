package com.company;

import java.util.HashSet;

public class TRAI_20_X1_tuomasme implements TRAI_20_X1 {
    //                  ^^^^^ OMA TUNNUS TÃ„HÃ„N
    // NimeÃ¤ tiedosto TRAI_20_X1_tunnus.java

    /**
     * Onko tuplaa.
     * Jos siis taulukon kaikki alkiot ovat eri lukuja, metodi
     * palauttaa false. Jos taas jokin (tai jotkin) luku esiintyy
     * kahdesti tai useammin, metodi palauttaa true.
     * Voit olettaa taulukossa olevan vain kelvollisia kokonaislukuja
     * (ei siis null:eja).
     *
     * Ratkaisuni on toimiva, sillä ratkaisussani metodi onkoTuplaa pyrkii lisäämään kokonaislukutaulukon A luvut "luku luvulta" luomaani
     * HashSettiin. HashSetin ominaisuuksiin kuuluu, ettei siihen voi lisätä lukua, jonka se jo sisältää, joten duplikaatin
     * osuessa kohdalle metodi palauttaa arvon true. Mikäli kaikki kokonaislukutaulukon luvut lisätään onnistuneesti HashSettiin
     * niin kokonaislukutaulukossa ei ole duplikaatteja ja täten onkoTuplaa -metodi palauttaa arvon false.
     * Ratkaisuni on kohtalaisen nopea, koska sen aikavaativuus on O(n).
     *
     * @param A SyÃ¶tetaulukko.
     * @return false jos kaikki alkiot ovat eri lukuja, muuten true.
     */


    @Override
    public boolean onkoTuplaa(Integer[] A) {
        HashSet<Integer> lisatyt = new HashSet<>();

        for (Integer luku : A) {
            if (!lisatyt.add(luku)) {
                return true;
            }
        }
        return false;
        }
    }


