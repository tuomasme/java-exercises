import fi.uef.cs.tra.*;

public class TRAII_22_X1_tuomasme implements TRAII_22_X1 {
    //                   ^^^^^ oma tunnus tÃ¤hÃ¤n

    /**
     * Onko binÃ¤Ã¤ripuu esijÃ¤rjestyksessÃ¤ vai ei.
     * <p>
     * Jos puun solmujen alkiot puun esijÃ¤rjestyksessÃ¤ lueteltuna ovat kasvavassa jÃ¤rjestyksessÃ¤,
     * palautetaan true, muuten false.
     * <p>
     * Puun solmut esijÃ¤rjestyksessÃ¤ ovat juurisolmu ja sen jÃ¤lkelÃ¤iset esijÃ¤rjestyksessÃ¤.
     * Solmun v ja sen jÃ¤lkelÃ¤isten solmut esijÃ¤rjestyksessÃ¤ ovat ensin solmu v, sitten
     * solmun v mahdollisen vasemman lapsen ja sen jÃ¤lkelÃ¤isten solmut esijÃ¤rjestyksessÃ¤ ja lopuksi
     * solmun v mahdollisen oikean lapsen ja sen jÃ¤lkelÃ¤isten solmut esijÃ¤rjestyksessÃ¤.
     * <p>
     * ITSEARVIOINTI: Ratkaisun aikavaativuus on O(nlogn). Ratkaisu toimii oikein tyhjällä, yksisolmuisella
     * ja vähäsolmuisella binääripuulla. Ratkaisu toimii rajoitetusti binääripuulla jossa on paljon solmuja.
     *
     *
     * @param <E> puun alkioiden tyyppi
     * @param T   syÃ¶tepuu
     * @return true jos alkiot ovat esijÃ¤rjestyksessÃ¤, muuten false
     */
    @Override
    public <E extends Comparable<? super E>> boolean onkoEsijarjestyksessa(BTree<E> T) {

        BTreeNode n = T.getRoot();

        // Tarkistetaan onko puussa korkeintaan juurisolmu
        if (n != null && (n.getLeftChild() != null || n.getRightChild() != null)) {
            // Jos puussa useampi kuin yksi solmu, siirrytään juurisolmun lapsiin
            return tarkistaLapset(n);
        }
        // Palautetaan tosi jos puussa korkeintaan 1 solmu
        return true;
    }

    public <E extends Comparable<? super E>> boolean tarkistaLapset(BTreeNode<E> solmu) {

        // Tarkistetaan onko solmulla vasen lapsi
        if (solmu.getLeftChild() != null) {
            if (solmu.getElement().compareTo(solmu.getLeftChild().getElement()) > 0) {
                return false;
            }
            // Tarkistetaan onko solmulla myös oikea lapsi
            else if(solmu.getRightChild() != null) {
                if (solmu.getLeftChild().getElement().compareTo(solmu.getRightChild().getElement()) > 0) {
                    return false;
                } else if (solmu.getLeftChild().getRightChild() != null &&
                        solmu.getLeftChild().getRightChild().getElement().compareTo(solmu.getRightChild().getElement()) > 0) {
                    return false;
                } else if (solmu.getLeftChild().getLeftChild() != null &&
                        solmu.getLeftChild().getLeftChild().getElement().compareTo(solmu.getRightChild().getElement()) > 0) {
                    return false;
                }
            }
            tarkistaLapset(solmu.getLeftChild());
        }
        // Tarkistetaan onko solmulla edes oikea lapsi
        else if (solmu.getRightChild() != null){
            if((solmu.getElement().compareTo(solmu.getRightChild().getElement()) > 0)){
                return false;
            }
            tarkistaLapset(solmu.getRightChild());
        }
        return true;
    }


}






