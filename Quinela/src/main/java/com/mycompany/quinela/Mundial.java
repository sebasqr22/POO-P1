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

    Partido[] primeraFase = new Partido[48];

    private Equipo qatar = new Equipo("Qatar", 1441.97);
    private Equipo ecuador = new Equipo("Ecuador", 1463.74);
    private Equipo senegal = new Equipo("Senegal", 1584.59);
    private Equipo paises_bajos = new Equipo("Paises Bajos", 1679.41);
    private Grupo A = new Grupo('A', new ArrayList<Equipo>(Arrays.asList(qatar, ecuador, senegal, paises_bajos)));

    private Equipo inglaterra = new Equipo("Inglaterra", 1737.46);
    private Equipo iran = new Equipo("Iran", 1558.64);
    private Equipo usa = new Equipo("Estados Unidos", 1635.01);
    private Equipo gales = new Equipo("Gales", 1582.13);
    private Grupo B = new Grupo('B', new ArrayList<Equipo>(Arrays.asList(inglaterra, iran, usa, gales)));

    private Equipo argentina = new Equipo("Argentina", 1770.65);
    private Equipo arabia = new Equipo("Arabia Saudi", 1435.74);
    private Equipo mexico = new Equipo("Mexico", 1649.57);
    private Equipo polonia = new Equipo("Polonia", 1546.18);
    private Grupo C = new Grupo('C', new ArrayList<Equipo>(Arrays.asList(argentina, arabia, mexico, polonia)));

    private Equipo francia = new Equipo("Francia", 1764.85);
    private Equipo australia = new Equipo("Australia", 1483.73);
    private Equipo dinamarca = new Equipo("Dinamarca", 1665.47);
    private Equipo tunez = new Equipo("Tunez", 1507.86);
    private Grupo D = new Grupo('D', new ArrayList<Equipo>(Arrays.asList(francia, australia, dinamarca, tunez)));

    private Equipo españa = new Equipo("España", 1716.93);
    private Equipo costa_rica = new Equipo("Costa Rica", 1500.06);
    private Equipo alemania = new Equipo("Alemania", 1658.96);
    private Equipo japon = new Equipo("Japon", 1554.69);
    private Grupo E = new Grupo('E', new ArrayList<Equipo>(Arrays.asList(españa, costa_rica, alemania, japon)));

    private Equipo belgica = new Equipo("Belgica", 1821.92);
    private Equipo canada = new Equipo("Canada", 1473.82);
    private Equipo marruecos = new Equipo("Marruecos", 1558.35);
    private Equipo croacia = new Equipo("Croacia", 1632.15);
    private Grupo F = new Grupo('F', new ArrayList<Equipo>(Arrays.asList(belgica, canada, marruecos, croacia)));

    private Equipo brasil = new Equipo("Brasil", 1837.56);
    private Equipo serbia = new Equipo("Serbia", 1549.53);
    private Equipo suiza = new Equipo("Suiza", 1621.43);
    private Equipo camerun = new Equipo("Camerun", 1484.95);
    private Grupo G = new Grupo('G', new ArrayList<Equipo>(Arrays.asList(brasil, serbia, suiza, camerun)));

    private Equipo portugal = new Equipo("Portugal", 1678.65);
    private Equipo ghana = new Equipo("Ghana", 1393.47);
    private Equipo uruguay = new Equipo("Uruguay", 1640.95);
    private Equipo corea = new Equipo("Corea del Sur", 1526.02);
    private Grupo H = new Grupo('H', new ArrayList<Equipo>(Arrays.asList(portugal, ghana, uruguay, corea)));

    public void primeraFase() {
        primeraFase[0] = new Partido(senegal, paises_bajos, 'A');
        primeraFase[1] = new Partido(qatar, ecuador, 'A');
        primeraFase[2] = new Partido(qatar, senegal, 'A');
        primeraFase[3] = new Partido(ecuador, paises_bajos, 'A');
        primeraFase[4] = new Partido(qatar, paises_bajos, 'A');
        primeraFase[5] = new Partido(ecuador, senegal, 'A');

        primeraFase[6] = new Partido(inglaterra, iran, 'B');
        primeraFase[7] = new Partido(usa, gales, 'B');
        primeraFase[8] = new Partido(iran, gales, 'B');
        primeraFase[9] = new Partido(inglaterra, usa, 'B');
        primeraFase[10] = new Partido(inglaterra , gales, 'B');
        primeraFase[11] = new Partido(iran, usa, 'B');
        
        primeraFase[12]= new Partido(arabia, arabia, 'C');
        primeraFase[13] = new Partido(mexico, polonia, 'C');
        primeraFase[14] = new Partido(arabia, polonia, 'C');
        primeraFase[15] = new Partido(argentina, mexico, 'C');
        primeraFase[16] = new Partido(argentina, polonia, 'C');
        primeraFase[17] = new Partido(arabia, mexico, 'C');
        
        primeraFase[18] = new Partido(dinamarca, tunez, 'D');
        primeraFase[19] = new Partido(francia, australia, 'D');
        primeraFase[20] = new Partido(australia, tunez, 'D');
        primeraFase[21] = new Partido(francia, dinamarca, 'D');
        primeraFase[22] = new Partido(australia, tunez, 'D');
        primeraFase[23] = new Partido(francia, dinamarca, 'D');
        
        primeraFase[24] = new Partido(alemania, japon, 'E');
        primeraFase[25] = new Partido(españa, costa_rica, 'E');
        primeraFase[26] = new Partido(costa_rica,japon, 'E');
        primeraFase[27] = new Partido(españa, alemania, 'E');
        primeraFase[28] = new Partido(españa, japon, 'E');
        primeraFase[29] = new Partido(costa_rica, alemania, 'E');
        
        primeraFase[30] = new Partido(marruecos, croacia, 'F');
        primeraFase[31] = new Partido(belgica, canada, 'F');
        primeraFase[32] = new Partido(belgica, marruecos, 'F');
        primeraFase[33] = new Partido(canada, croacia, 'F');
        primeraFase[34] = new Partido(belgica, croacia, 'F');
        primeraFase[35] = new Partido(canada, marruecos, 'F');
        
        primeraFase[36] = new Partido(suiza, camerun, 'G');
        primeraFase[37] = new Partido(brasil, serbia, 'G');
        primeraFase[38] = new Partido(serbia, camerun, 'G');
        primeraFase[39] = new Partido(brasil, suiza, 'G');
        primeraFase[40] = new Partido(brasil, camerun, 'G');
        primeraFase[41] = new Partido(serbia, suiza, 'G');
        
        primeraFase[42] = new Partido(uruguay, corea, 'H');
        primeraFase[43] = new Partido(portugal, ghana, 'H');
        primeraFase[44] = new Partido(ghana, corea, 'H');
        primeraFase[45] = new Partido(portugal, uruguay, 'H');
        primeraFase[46] = new Partido(portugal, corea, 'H');
        primeraFase[47] = new Partido(ghana, uruguay, 'H');
        
    }

    
    public void octavosDeFinal(){
        
    }
    
    public void cuartosDeFinal(){
        
    }
    
    public void semifinales(){
        
    }
    public void finalMundial(){
        
    }
}
