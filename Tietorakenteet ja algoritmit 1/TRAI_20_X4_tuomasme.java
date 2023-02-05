package com.company;
import java.util.LinkedList;

public class TRAI_20_X4_tuomasme implements TRAI_20_X4 {
    //                  ^^^^^ oma tunnus tÃ¤hÃ¤n
    /**
     * ITSEARVIOINTI JA AIKAVAATIVUUS TÃ„HÃ„N:
     *
     * Algoritmi toimii täysin oikein valittuun tarkoitukseen, sillä palautettava lista sisältää vain alkioita, jotka
     * esiintyvät vain yhdessä parametrina tulevista listoista. Algoritmin aikavaativuus on n^2, joten algoritmi on hidas.
     * Algoritmin suurin heikkous lienee juurikin algoritmin hitaus. Algoritmin aikavaativuus johtuu siitä, että algoritmissa
     * käytetään listan läpikäyvien silmukoiden sisällä contains-metodia ja samoin LinkedListin indeksejä.
     *
     */

    /**
     * JÃ¤rjestettyjen listojen joko-tai-yhdiste.
     * Muodostaa uusen jÃ¤rjestetyn listan niistÃ¤ syÃ¶telistojen alkioista jotka esiintyvÃ¤t vain
     * toisessa syÃ¶telistoista.
     * Ei muuta syÃ¶telistoja.
     *
     * @param A   syÃ¶telista, kasvavassa jÃ¤rjestyksessÃ¤
     * @param B   syÃ¶telista, kasvavassa jÃ¤rjestyksessÃ¤
     * @param <E> alkiotyyppi, toteuttaa Comparable-rajapinnan
     * @return uusi lista jossa kasvavassa jÃ¤rjestyksessÃ¤ ne alkiot jotka ovat vain yhdessÃ¤ syÃ¶telistassa
     */
    @Override
    public <E extends Comparable<? super E>> LinkedList<E>
    jarjestettyjenVainToisessaYhdiste(LinkedList<E> A, LinkedList<E> B) {
        LinkedList<E> tulos = new LinkedList<E>();
        // TODO
          LinkedList<E> temp1 = new LinkedList<>();
          LinkedList<E> temp2 = new LinkedList<>();
          int a = 0;
          int b = 0;

          for (E luku : A) {
              if (!(B.contains(luku))) {
                  temp1.add(luku);
              }
          }
          for (E lukuB : B) {
              if (!(A.contains(lukuB))) {
                  temp2.add(lukuB);
              }
          }

          while(a < temp1.size() && b < temp2.size()){
              if(temp1.get(a).compareTo(temp2.get(b)) < 0){
                  tulos.add(temp1.get(a));
                  b--;
              }
              else if(temp1.get(a).compareTo(temp2.get(b)) > 0) {
                  tulos.add(temp2.get(b));
                  a--;
              }
              a++;
              b++;
          }

          while (a < temp1.size()){
              tulos.add(temp1.get(a));
             a++;
         }

         while (b < temp2.size()){
            tulos.add(temp2.get(b));
            b++;
         }
        return tulos;
    }
}