/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quinela;

import com.mycompany.quinela.Equipo;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sergio
 */
public class Mundial {
    private ArrayList<Equipo> equipos=new ArrayList<Equipo>();
    private Grupo[] gruposPrimeraFase=new Grupo[8];
    public Partido[] partidosPrimeraFase = new Partido[48];
    
    private Partido[] partidosOctavos= new Partido[8];
    private Equipo[] ganadoresOctavos= new Equipo[8];
    
    private Partido[] partidosCuartos= new Partido[4];
    private Equipo[] ganadoresCuartos=new Equipo[4];
    
    private Partido[] partidosSemis=new Partido[2];
    private Equipo[] ganadoresSemis=new Equipo[2];
    
    private Partido finalPartido;
    
    private Equipo qatar;
    private Equipo ecuador;
    private Equipo paises_bajos;
    private Equipo senegal;

    private Equipo inglaterra;
    private Equipo iran;
    private Equipo usa;
    private Equipo gales;

    private Equipo argentina;
    private Equipo arabia;
    private Equipo mexico;
    private Equipo polonia;

    private Equipo francia;
    private Equipo australia;
    private Equipo dinamarca;
    private Equipo tunez;

    private Equipo españa;
    private Equipo costa_rica;
    private Equipo alemania;
    private Equipo japon;

    private Equipo belgica;
    private Equipo canada;
    private Equipo marruecos;
    private Equipo croacia;

    private Equipo brasil;
    private Equipo serbia;
    private Equipo suiza;
    private Equipo camerun;

    private Equipo portugal;
    private Equipo ghana;
    private Equipo uruguay;
    private Equipo corea;
    
    public void init() {
        qatar = new Equipo("Qatar", 1441.97);
        ecuador = new Equipo("Ecuador", 1463.74);
        senegal = new Equipo("Senegal", 1584.59);
        paises_bajos = new Equipo("Paises Bajos", 1679.41);
        gruposPrimeraFase[0]= new Grupo('A', new ArrayList<Equipo>(Arrays.asList(qatar, ecuador, senegal, paises_bajos)));

        inglaterra = new Equipo("Inglaterra", 1737.46);
        iran = new Equipo("Iran", 1558.64);
        usa = new Equipo("Estados Unidos", 1635.01);
        gales = new Equipo("Gales", 1582.13);
        gruposPrimeraFase[1]= new Grupo('B', new ArrayList<Equipo>(Arrays.asList(inglaterra, iran, usa, gales)));

        argentina = new Equipo("Argentina", 1770.65);
        arabia = new Equipo("Arabia Saudi", 1435.74);
        mexico = new Equipo("Mexico", 1649.57);
        polonia = new Equipo("Polonia", 1546.18);
        gruposPrimeraFase[2]= new Grupo('C', new ArrayList<Equipo>(Arrays.asList(argentina, arabia, mexico, polonia)));

        francia = new Equipo("Francia", 1764.85);
        australia = new Equipo("Australia", 1483.73);
        dinamarca = new Equipo("Dinamarca", 1665.47);
        tunez = new Equipo("Tunez", 1507.86);
        gruposPrimeraFase[3]= new Grupo('D', new ArrayList<Equipo>(Arrays.asList(francia, australia, dinamarca, tunez)));

        españa = new Equipo("España", 1716.93);
        costa_rica = new Equipo("Costa Rica", 1500.06);
        alemania = new Equipo("Alemania", 1658.96);
        japon = new Equipo("Japon", 1554.69);
        gruposPrimeraFase[4]= new Grupo('E', new ArrayList<Equipo>(Arrays.asList(españa, costa_rica, alemania, japon)));

        belgica = new Equipo("Belgica", 1821.92);
        canada = new Equipo("Canada", 1473.82);
        marruecos = new Equipo("Marruecos", 1558.35);
        croacia = new Equipo("Croacia", 1632.15);
        gruposPrimeraFase[5]= new Grupo('F', new ArrayList<Equipo>(Arrays.asList(belgica, canada, marruecos, croacia)));

        brasil = new Equipo("Brasil", 1837.56);
        serbia = new Equipo("Serbia", 1549.53);
        suiza = new Equipo("Suiza", 1621.43);
        camerun = new Equipo("Camerun", 1484.95);
        gruposPrimeraFase[6]= new Grupo('G', new ArrayList<Equipo>(Arrays.asList(brasil, serbia, suiza, camerun)));

        portugal = new Equipo("Portugal", 1678.65);
        ghana = new Equipo("Ghana", 1393.47);
        uruguay = new Equipo("Uruguay", 1640.95);
        corea = new Equipo("Corea del Sur", 1526.02);
        gruposPrimeraFase[7]= new Grupo('H', new ArrayList<Equipo>(Arrays.asList(portugal, ghana, uruguay, corea)));
        
        for (Grupo grupo : gruposPrimeraFase) {
            for (Equipo equipo : grupo.getEquipos()) {
                equipos.add(equipo);
            }
        }
        
    }

    public void primeraFase() {
        partidosPrimeraFase[0] = new Partido(senegal, paises_bajos, 'A');
        partidosPrimeraFase[1] = new Partido(qatar, ecuador, 'A');
        partidosPrimeraFase[2] = new Partido(qatar, senegal, 'A');
        partidosPrimeraFase[3] = new Partido(ecuador, paises_bajos, 'A');
        partidosPrimeraFase[4] = new Partido(qatar, paises_bajos, 'A');
        partidosPrimeraFase[5] = new Partido(ecuador, senegal, 'A');

        partidosPrimeraFase[6] = new Partido(inglaterra, iran, 'B');
        partidosPrimeraFase[7] = new Partido(usa, gales, 'B');
        partidosPrimeraFase[8] = new Partido(iran, gales, 'B');
        partidosPrimeraFase[9] = new Partido(inglaterra, usa, 'B');
        partidosPrimeraFase[10] = new Partido(inglaterra, gales, 'B');
        partidosPrimeraFase[11] = new Partido(iran, usa, 'B');

        partidosPrimeraFase[12] = new Partido(arabia, arabia, 'C');
        partidosPrimeraFase[13] = new Partido(mexico, polonia, 'C');
        partidosPrimeraFase[14] = new Partido(arabia, polonia, 'C');
        partidosPrimeraFase[15] = new Partido(argentina, mexico, 'C');
        partidosPrimeraFase[16] = new Partido(argentina, polonia, 'C');
        partidosPrimeraFase[17] = new Partido(arabia, mexico, 'C');

        partidosPrimeraFase[18] = new Partido(dinamarca, tunez, 'D');
        partidosPrimeraFase[19] = new Partido(francia, australia, 'D');
        partidosPrimeraFase[20] = new Partido(australia, tunez, 'D');
        partidosPrimeraFase[21] = new Partido(francia, dinamarca, 'D');
        partidosPrimeraFase[22] = new Partido(australia, tunez, 'D');
        partidosPrimeraFase[23] = new Partido(francia, dinamarca, 'D');

        partidosPrimeraFase[24] = new Partido(alemania, japon, 'E');
        partidosPrimeraFase[25] = new Partido(españa, costa_rica, 'E');
        partidosPrimeraFase[26] = new Partido(costa_rica, japon, 'E');
        partidosPrimeraFase[27] = new Partido(españa, alemania, 'E');
        partidosPrimeraFase[28] = new Partido(españa, japon, 'E');
        partidosPrimeraFase[29] = new Partido(costa_rica, alemania, 'E');

        partidosPrimeraFase[30] = new Partido(marruecos, croacia, 'F');
        partidosPrimeraFase[31] = new Partido(belgica, canada, 'F');
        partidosPrimeraFase[32] = new Partido(belgica, marruecos, 'F');
        partidosPrimeraFase[33] = new Partido(canada, croacia, 'F');
        partidosPrimeraFase[34] = new Partido(belgica, croacia, 'F');
        partidosPrimeraFase[35] = new Partido(canada, marruecos, 'F');

        partidosPrimeraFase[36] = new Partido(suiza, camerun, 'G');
        partidosPrimeraFase[37] = new Partido(brasil, serbia, 'G');
        partidosPrimeraFase[38] = new Partido(serbia, camerun, 'G');
        partidosPrimeraFase[39] = new Partido(brasil, suiza, 'G');
        partidosPrimeraFase[40] = new Partido(brasil, camerun, 'G');
        partidosPrimeraFase[41] = new Partido(serbia, suiza, 'G');

        partidosPrimeraFase[42] = new Partido(uruguay, corea, 'H');
        partidosPrimeraFase[43] = new Partido(portugal, ghana, 'H');
        partidosPrimeraFase[44] = new Partido(ghana, corea, 'H');
        partidosPrimeraFase[45] = new Partido(portugal, uruguay, 'H');
        partidosPrimeraFase[46] = new Partido(portugal, corea, 'H');
        partidosPrimeraFase[47] = new Partido(ghana, uruguay, 'H');

    }

    public void octavosDeFinal() {
        for (int i = 0; i < gruposPrimeraFase.length-1; i+=2) {
            Equipo primero=gruposPrimeraFase[i].getClasificados()[0];
            Equipo segundo=gruposPrimeraFase[i+1].getClasificados()[1];
            partidosOctavos[i]=new Partido(primero, segundo);
            
            Equipo primeroGrupig =gruposPrimeraFase[i+1].getClasificados()[0];
            Equipo segundoGrupSig=gruposPrimeraFase[i].getClasificados()[1];
            partidosOctavos[i+1]=new Partido(primeroGrupig, segundoGrupSig);
        }
    }

    public void cuartosDeFinal() {
        partidosCuartos[0]=new Partido(ganadoresOctavos[0], ganadoresOctavos[2]);
        
        partidosCuartos[1]=new Partido(ganadoresOctavos[1], ganadoresOctavos[3]);
        
        partidosCuartos[2]=new Partido(ganadoresOctavos[4], ganadoresOctavos[6]);
        
        partidosCuartos[3]=new Partido(ganadoresOctavos[5], ganadoresOctavos[7]);
    }

    public void semifinales() {
        partidosSemis[0]=new Partido(ganadoresCuartos[0], ganadoresCuartos[2]);
        
        partidosSemis[1]=new Partido(ganadoresCuartos[1], ganadoresCuartos[3]);
    }

    public void finalMundial() {
        finalPartido=new Partido(ganadoresSemis[0] ,ganadoresSemis[1]);
        

    }
    
    public Partido buscarPartido(String local, String visita, String fase){
        
        switch(fase){
            case "Fase de Grupos":
                for (Partido partido : partidosPrimeraFase) {
                    if(partido.local.pais.equals(local) && partido.visita.pais.equals(visita)){
                        return partido;
                    }
                }
                break;
            case "8vos de Final":
                for (Partido partido : partidosOctavos) {
                    if(partido.local.pais.equals(local) && partido.visita.pais.equals(visita)){
                        return partido;
                    }
                }
                break;
            case "4tos de Final":
                for (Partido partido : partidosCuartos) {
                    if(partido.local.pais.equals(local) && partido.visita.pais.equals(visita)){
                        return partido;
                    }
                }
                break;
            case "Semifinal":
                for (Partido partido : partidosSemis) {
                    if(partido.local.pais.equals(local) && partido.visita.pais.equals(visita)){
                        return partido;
                    }
                }
                break;
            case "Final":
                if(finalPartido.local.pais.equals(local) && finalPartido.visita.pais.equals(visita)){
                        return finalPartido;
                    }
                break;
        }
        return null;
    }

    public Partido[] getPartidosPrimeraFase() {
        return partidosPrimeraFase;
    }

    public Partido[] getPartidosOctavos() {
        return partidosOctavos;
    }

    public Partido[] getPartidosCuartos() {
        return partidosCuartos;
    }

    public Partido[] getPartidosSemis() {
        return partidosSemis;
    }

    public Partido getFinalPartido() {
        return finalPartido;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    
    
    
}
