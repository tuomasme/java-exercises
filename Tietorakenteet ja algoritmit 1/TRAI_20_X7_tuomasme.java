
import java.util.*;


public class TRAI_20_X7_tuomasme implements TRAI_20_X7 {

    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     * aikavaativuuden parametrit: m = syÃ¶tejoukkojen mÃ¤Ã¤rÃ¤, n = syÃ¶tejoukkojen yhteinen alkiomÃ¤Ã¤rÃ¤.
     *
     * Algoritmi toimii täysin oikein haluttuun tarkoitukseen. Algoritmin aikavaativuus on m * n ^ 2 eli algoritmi on
     * hidas. Algoritmin heikkous on algoritmin hitaus. Tehtävän tekemiseen minulla kului eniten aikaa tähänastisista
     * X-tehtävistä. Erityisesti leikkaavien joukkojen saaminen kuvaukseen vei minulta paljon aikaa.
     */

    /**
     * Palauttaa tiedon siitÃ¤ mitkÃ¤ joukot leikkaavat keskenÃ¤Ã¤n (siis millÃ¤ on yhteisiÃ¤ alkioita).
     * Tulos palautetaan kuvauksena siten, ettÃ¤ jos syÃ¶tteen joukolla Si on yhteisiÃ¤ alkioita
     * jonkun muun syÃ¶tteen joukon Sj kanssa, niin kuvauksen avaimeen Si liittyvÃ¤ssÃ¤ arvossa (joukossa) on
     * viittaus joukkoon Sj (ja pÃ¤invastoin). Kuvaus sisÃ¤ltÃ¤Ã¤ avaimenaan kunkin joukon SS sisÃ¤ltÃ¤mÃ¤n
     * joukon Si ja kunkin avaimen arvona on joukko niistÃ¤ joukoista Sj joilla on vÃ¤hintÃ¤Ã¤n yhteinen alkio
     * joukon Si kanssa.
     *
     * @param SS syÃ¶te (joukkojen joukko)
     * @return kuvaus joukkojen leikkaavuuksista
     */
    @Override
    public <E> Map<Set<E>, Set<Set<E>>> leikkaavatJoukot(Set<Set<E>> SS) {
        Map<Set<E>, Set<Set<E>>> tulos = new HashMap<>();

        // TODO
        for(Set<E> joukko: SS){
            Set<Set<E>> temp = new HashSet<>();
            for (Set<E> jjoukko: SS){
                  Set<E> jjjoukko = new HashSet<>(jjoukko);
                    jjjoukko.retainAll(joukko);
                  if(!jjjoukko.isEmpty()){
                      temp.add(jjoukko);
                  }
                  if (jjoukko.equals(joukko)){
                      temp.remove(jjoukko);
                  }
            }
            tulos.put(joukko, temp);
        }
        return tulos;
    }
}



