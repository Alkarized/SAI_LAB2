package com.company;

public class Main {

    public static void main(String[] args) {
        Integer dimension = 27;
        Graph graph = new Graph(dimension);

        Vertex kazan = new Vertex(0, "Казань");
        Vertex brest = new Vertex(0, "Брест");
        Vertex vilnius = new Vertex(0, "Вильнюс");
        Vertex tallinn = new Vertex(0, "Таллинн");
        Vertex riga = new Vertex(0, "Рига");
        Vertex stPeters = new Vertex(0, "С.Петербург");
        Vertex kaliningrad = new Vertex(0, "Калининград");
        Vertex murmansk = new Vertex(0, "Мурманск");
        Vertex daugavpils = new Vertex(0, "Даугавпилс");
        Vertex kaunas = new Vertex(0, "Каунас");
        Vertex vitebsk = new Vertex(0, "Витебска");
        Vertex minsk = new Vertex(0, "Минск");
        Vertex nijNovgorod = new Vertex(0, "Ниж.Новгород");
        Vertex kiev = new Vertex(0, "Киев");
        Vertex volgograd = new Vertex(0, "Волгоград");
        Vertex voronej = new Vertex(0, "Воронеж");
        Vertex moscow = new Vertex(0, "Москва");
        Vertex ufa = new Vertex(0, "Уфа");
        Vertex samara = new Vertex(0, "Самара");
        Vertex orel = new Vertex(0, "Орёл");
        Vertex zhytomyr = new Vertex(0, "Житомир");
        Vertex donetsk = new Vertex(0, "Донецк");
        Vertex odessa = new Vertex(0, "Одесса");
        Vertex harkov = new Vertex(0, "Харьков");
        Vertex kishinev = new Vertex(0, "Кишинев");
        Vertex simpheropol = new Vertex(0, "Симферополь");
        Vertex yarolsavl = new Vertex(0, "Ярославль");

        graph.addVertices(vilnius, brest, tallinn, riga, stPeters, kaliningrad,
                murmansk, daugavpils, kaunas, vitebsk, minsk, nijNovgorod, kiev, volgograd, voronej, moscow, kazan, ufa,
                samara, orel, zhytomyr, donetsk, odessa, harkov, kishinev, simpheropol, yarolsavl);

        graph.addEdge(vitebsk, vilnius, 360);
        graph.addEdge(vilnius, brest, 531);
        graph.addEdge(vitebsk, brest, 638);
        graph.addEdge(voronej, vitebsk, 869);
        graph.addEdge(voronej, volgograd, 581);
        graph.addEdge(volgograd, vitebsk, 1455);
        graph.addEdge(vitebsk, nijNovgorod, 911);
        graph.addEdge(vilnius, daugavpils, 211);
        graph.addEdge(kaliningrad, brest, 699);
        graph.addEdge(kaliningrad, vilnius, 333);
        graph.addEdge(kaunas, vilnius, 102);
        graph.addEdge(kiev, vilnius, 734);
        graph.addEdge(kiev, zhytomyr, 131);
        graph.addEdge(zhytomyr, donetsk, 863);
        graph.addEdge(zhytomyr, volgograd, 1493);
        graph.addEdge(kishinev, kiev, 467);
        graph.addEdge(kishinev, donetsk, 812);
        graph.addEdge(stPeters, vitebsk, 602);
        graph.addEdge(stPeters, kaliningrad, 739);
        graph.addEdge(stPeters, riga, 641);
        graph.addEdge(moscow, kazan, 815);
        graph.addEdge(moscow, nijNovgorod, 411);
        graph.addEdge(moscow, minsk, 690);
        graph.addEdge(moscow, donetsk, 1084);
        graph.addEdge(moscow, stPeters, 664);
        graph.addEdge(murmansk, stPeters, 1412);
        graph.addEdge(murmansk, minsk, 2238);
        graph.addEdge(orel, vitebsk, 522);
        graph.addEdge(orel, donetsk, 709);
        graph.addEdge(orel, moscow, 368);
        graph.addEdge(odessa, kiev, 487);
        graph.addEdge(riga, kaunas, 267);
        graph.addEdge(tallinn, riga, 308);
        graph.addEdge(harkov, kiev, 471);
        graph.addEdge(harkov, simpheropol, 639);
        graph.addEdge(yarolsavl, voronej, 739);
        graph.addEdge(yarolsavl, minsk, 940);
        graph.addEdge(ufa, kazan, 525);
        graph.addEdge(ufa, samara, 461);

        // graph.fillTheMatrix();
        // graph.startBFS(brest, kazan);
        // graph.startLimitDFS(brest, kazan, 10);
        // graph.startLimitRiseDFS(brest, kazan, 5);
        // graph.startDualBFS(brest, kazan);
    }
}
