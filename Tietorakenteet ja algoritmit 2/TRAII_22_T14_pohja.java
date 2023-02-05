package com.company;

import fi.uef.cs.tra.DiGraph;
import fi.uef.cs.tra.Edge;
import fi.uef.cs.tra.Graph;
import fi.uef.cs.tra.Vertex;

import java.util.LinkedList;


public class TRAII_22_t14_pohja {

    public static void main(String[] args) {

        // defaults
        int vertices = 5;
        int edges = 7;

        if (args.length > 0)
            vertices = Integer.parseInt(args[0]);

        if (args.length > 1)
            edges = Integer.parseInt(args[1]);

        int seed = vertices+edges;

        if (args.length > 2)
            seed = Integer.parseInt(args[2]);


        int print = 1;

        if (args.length > 3)
            print = Integer.parseInt(args[3]);


        Vertex v1;

        DiGraph graph = GraphMaker.createDiGraph(vertices, edges, seed, 10);
        System.out.println("\nSatunnainen verkko");
        v1 = GraphMaker.randomVertex(graph);
        GraphMaker.setWeights(graph, 10, 0.1f, seed);
        System.out.println("v1=" + v1);
        if (print > 0) System.out.println(GraphMaker.toString(graph, 2));


        LinkedList<LinkedList<Vertex>> polut;

        polut = kaikkiKPolut(graph, 5, v1);
        System.out.println("\nKaikki max 5 polut solmusta " + v1 + " alkaen");
        tulostaPolut(polut, print);
        System.out.println(polut.size() + " polkua");

        polut = kaikkiKPolut(graph, 15, v1);
        System.out.println("\nKaikki max 15 polut solmusta " + v1 + " alkaen");
        tulostaPolut(polut, print);
        System.out.println(polut.size() + " polkua");


        if (vertices < 20) {

            polut = kaikkiKPolut(graph, 15, v1);
            System.out.println("\nKaikki max 15 polut solmusta " + v1 + " alkaen");
            tulostaPolut(polut, print);
            System.out.println(polut.size() + " polkua");

        }


        graph = GraphMaker.createCompleteDiGraph(vertices);
        GraphMaker.setWeights(graph, 5, 0.1f, seed);
        System.out.println("\nTÃ¤ydellinen verkko");
        if (print > 0) System.out.println(GraphMaker.toString(graph, 1));
        v1 = GraphMaker.randomVertex(graph);
        System.out.println("v1=" + v1);

        if (vertices < 7) {

            polut = kaikkiKPolut(graph, 5, v1);
            System.out.println("\nKaikki max 5 polut solmusta \" + v1 + \" alkaen");
            tulostaPolut(polut, print);

            System.out.println(polut.size() + " polkua");

            polut = kaikkiKPolut(graph, 10, v1);
            System.out.println("\nKaikki max 10 polut solmusta \" + v1 + \" alkaen");
            tulostaPolut(polut, print);
            System.out.println(polut.size() + " polkua");
        }


    }


    /**
     * TehtÃ¤vÃ¤ 14.
     * Kaikki korkeintaan maxPituus mittaiset yksinkertaiset polut annetusta solmusta lÃ¤htien.
     * @param g syoteverkko
     * @param maxPituus maksimi polun pituus
     * @param start lÃ¤htÃ¶solmu
     * @return polkujen lista (polku on solmujen lista)
     */
    static LinkedList<LinkedList<Vertex>> kaikkiKPolut(DiGraph g, float maxPituus, Vertex start) {

        GraphMaker.varita(g, DiGraph.WHITE);


        LinkedList<LinkedList<Vertex>> polut = new LinkedList<>();

        // TODO

        // ota mallia kaikkiPolut -algorimista

        // huomioi polun pituus
        tutkiPolut(start, maxPituus, polut, tulos);
        return polut;
    }

    static void tutkiPolut(Vertex v, float p, LinkedList<Vertex> polku, LinkedList<LinkedList<Vertex>> tulos){
        if(p < 0 || v.getColor() != DiGraph.WHITE){
            return;

            v.setColor(DiGraph.GRAY);
            polku.add(v);

            if(polku.size() > 1)
                tulos.add(new LinkedList<>(polku));

            for(Edge e : v.edges())
                tutkiPolut(e.getEndPoint(v), p - e.getWeight(), polku, tulos);

            v.setColor(DiGraph.WHITE);
            polku.remove(polku.size() - 1);
        }
    }







    static void tulostaPolut(LinkedList<LinkedList<Vertex>> polut, int print) {
        if (print > 0)
            for (LinkedList<Vertex> p : polut)
                System.out.println(p);
    }

    /**
     * Kaikki yksinkertaiset polut kahden solmun vÃ¤lillÃ¤.
     * @param g syoteverkko
     * @param start lÃ¤htÃ¶solmu
     * @param end maalisolmu
     * @return polkujen lista (polku on solmujen lista)
     */
    LinkedList<LinkedList<Vertex>> kaikkiPolut(DiGraph g, Vertex start, Vertex end) {

        GraphMaker.varita(g, DiGraph.WHITE);


        LinkedList<LinkedList<Vertex>> polut = new LinkedList<>();
        LinkedList<Vertex> pino = new LinkedList<>();

        pino.add(start);

        if (start != end)
            start.setColor(Graph.BLACK);

        for (Vertex v : start.neighbors()) {
            kaikkiPolut_r(polut, pino, v, end);
        }

        start.setColor(Graph.WHITE);

        return polut;
    }

    /**
     * Varsinainen rekursiivinen polkujen haku-algoritmi.
     * @param polut tuloslista johon kerÃ¤tÃ¤Ã¤n lÃ¶ytyneet polut.
     * @param pino nykyinen polku lÃ¤htÃ¶solmusta alkaen
     * @param start nykyinen solmu
     * @param end maalisolmu
     */
    void kaikkiPolut_r(LinkedList<LinkedList<Vertex>> polut, LinkedList<Vertex> pino,
                       Vertex start, Vertex end) {
        pino.add(start);

        if (start == end) {
            polut.add(new LinkedList<>(pino));
            pino.removeLast();
            return;
        }

        start.setColor(Graph.BLACK);

        for (Vertex v : start.neighbors()) {
            if (v.getColor() == Graph.WHITE)
                kaikkiPolut_r(polut, pino, v, end);
        }

        start.setColor(Graph.WHITE);
        pino.removeLast();
    }






}
