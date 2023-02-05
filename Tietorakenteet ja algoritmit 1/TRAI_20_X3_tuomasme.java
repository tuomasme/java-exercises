package com.company;
import java.util.ArrayList;


public class TRAI_20_X3_tuomasme implements TRAI_20_X3 {
    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * Algoritmi toimii täysin oikein valittuun tarkoitukseen, sillä algoritmi poistaa alkiota x pienemmät alkiot
     * listasta A ja lisää poistetut alkiot listaan U, jonka metodi siirraPienemmat palauttaa. Algoritmin aikavaativuus
     * on O(n) johtuen siitä, että ratkaisussa ei käytetä lainkaan remove -operaatiota, vaan sen sijaan while -silmukassa
     * lisätään add- operaatiolla listan A alkiot, jotka ovat yhtä suuria tai suurempia kuin x listaan B ja poistettavat
     * alkiot puolestaan lisätään listaan U. Kun lista A on käyty silmukassa läpi, lista A tyhjennetään.
     * Lopuksi listan B alkiot lisätään listaan A.
     *
     */


    /**
     * SiirrÃ¤ pienemmÃ¤t toiseen listaan.
     * Poistaa listasta kaikki sellaiset alkiot jotka edeltÃ¤vÃ¤t alkiota x.
     * (Ovat "pienempiÃ¤", eli ne alkiot a joille a.compareTo(x) < 0. Poistetut alkiot
     * siirretÃ¤Ã¤n uuteen listaan joka palautetaan.
     * Lista A sÃ¤ilyy muuten jÃ¤rjestyksessÃ¤.
     * @param A syÃ¶telista
     * @param x alkio jota pienemmÃ¤t siirretÃ¤Ã¤n
     * @return siirretyt alkiot listana
     */
    @Override
    public <E extends Comparable<? super E>>  ArrayList<E> siirraPienemmat(ArrayList<E> A, E x) {

        ArrayList<E> U = new ArrayList<>();

        // TODO
        ArrayList<E> B = new ArrayList<>();

        int i = 0;

        while(i < A.size()){
            E arvo = A.get(i);
            if(arvo.compareTo(x) >= 0){
                B.add(arvo);
            }
            else if(arvo.compareTo(x) < 0){
                U.add(arvo);
            }
            i++;
        }
        A.clear();

        for(E luku: B){
            A.add(luku);
        }
        return U;
    }
}
