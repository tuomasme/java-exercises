

import fi.uef.cs.tra.DiGraph;
import fi.uef.cs.tra.Vertex;

import java.util.*;

/**
 * ITSEARVIOINTI TÃ„HÃ„N:
 * Algoritmi toimii täysin oikein kehättömillä verkoilla, mutta algoritmi toimii vain osittain verkoilla, joissa on kehä.
 * Välillä kaikki ajetut testit menivät läpi, välillä kaikki ajetut testit eivät menneet läpi. Algoritmin aikavaativuus
 * on O(n + e).
 *
 */

public class TRAII_22_X4_tuomasme implements TRAII_22_X4 {
    /**
     * Etsii ja palauttaa verkossa G kehÃ¤n joka kulkee solmun n kautta.
     * KehÃ¤ palautetaan listana jossa ensimmÃ¤isenÃ¤ ja viimeisenÃ¤ alkiona on solmu n
     * ja vÃ¤lillÃ¤ ne solmut siinÃ¤ jÃ¤rjestyksessÃ¤ jotka muodostavat kehÃ¤n polun.
     *
     * @param G syÃ¶teverkko
     * @param n vaadittava solmu
     * @return kehÃ¤n solmut listana tai null jollei vaadittavaa kehÃ¤Ã¤ ole.
     */
    @Override
    public List<Vertex> kehaSolmulla(DiGraph G, Vertex n) {

        GraphMaker.varita(G, DiGraph.WHITE);
        List<Vertex> kehanSolmut = new ArrayList<>();
        GraphMaker.varita(G, DiGraph.WHITE);
        if(!kehainen(G)){
            return null;
        }
        return palautettavatSolmut(G, n, n);
    }

    public boolean kehainen(DiGraph g) {
        for (Vertex v : g.vertices())
            if (v.getColor() == DiGraph.WHITE)
                if (kehadfs(v))
                    return true;
        return false;
    }

    boolean kehadfs(Vertex start) {

        start.setColor(DiGraph.GRAY);
        for (Vertex vertex : start.neighbors()) {
            if (vertex.getColor() == DiGraph.GRAY)
                return true;
            else if (vertex.getColor() == DiGraph.WHITE)
                if (kehadfs(vertex))
                    return true;

        }
        start.setColor(DiGraph.BLACK);
        return false;
    }

    static List<Vertex> palautettavatSolmut(DiGraph G, Vertex alku, Vertex loppu) {

        GraphMaker.varita(G, DiGraph.WHITE);
        List<Vertex> tulos = new ArrayList<>();
        List<Vertex> temp = new ArrayList<>();

        for(Vertex v : alku.neighbors()){
            if(v.getColor() == DiGraph.WHITE && !tulos.contains(loppu)){
                tulos.add(v);
                dfsPalautettavatSolmut(v, loppu, tulos);
            }
            if(!tulos.contains(loppu)){
                return null;
            }
        }
        if(tulos.size() != 0){
            temp.add(alku);
            temp.addAll(tulos);
            tulos.clear();
            tulos.addAll(temp);
        }
        return tulos;
    }

    static void dfsPalautettavatSolmut(Vertex solmu, Vertex loppu, List<Vertex> lista){

        solmu.setColor(DiGraph.GRAY);
        if(solmu == loppu)
            return;
        for(Vertex v : solmu.neighbors()){
            if (v.getColor() == DiGraph.WHITE && !lista.contains(loppu)){
                lista.add(v);
                dfsPalautettavatSolmut(v, loppu, lista);
            }
        }
    }
}
