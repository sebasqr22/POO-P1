/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.quinela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Collections;

/**
 *
 * @author sebastianqr.2208
 */
public class Quinela extends javax.swing.JFrame {

    int estado_password = 0;
    private String usuario_global;
    boolean configuracionFinalizada = false;
    boolean superUser = false;
    ManejadorArchivos manejadorArchivos = new ManejadorArchivos();
    String[] fases = {"Fase de Grupos", "8vos de Final", "4tos de Final", "Semifinal", "Final"};
    String[] grupos = {"A", "B", "C", "D", "E", "F", "G", "H"};
    Mundial mundial = new Mundial();
    ArrayList<String> fechas = mundial.fechas;
    ArrayList<java.awt.Panel> paneles = new ArrayList<>();
    ArrayList<Partido> todosLosPartidos = new ArrayList<>();
    String serie = "";
    int contadorFechas = 0;
    Partido partido1 = new Partido("saprissa");
    Partido partido2 = new Partido("saprissa");

    String ultimo_partido_consultado = "";

    /**
     * Creates new form Quinela
     */
    private void setJornada(String fecha) {

        if (fecha.equals("03-12-2022") || fecha.equals("04-12-2022") || fecha.equals("05-12-2022") || fecha.equals("06-12-2022")) {
            serie = "Octavos de Final";
        } else if (fecha.equals("09-12-2022") || fecha.equals("10-12-2022")) {
            serie = "Cuartos de Final";
        } else if (fecha.equals("13-12-2022") || fecha.equals("14-12-2022")) {
            serie = "Semifinales";
        } else if (fecha.equals("18-12-2022")) {
            serie = " Final";
        } else {
            serie = "Fase de Grupos";
        }
        jornada.setText(serie);
    }

    private void ocultarPaneles() {
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
    }

    private void setGanadores(boolean bandera) {
        ganador_1.setVisible(bandera);
        ganador_2.setVisible(bandera);
        ganador_3.setVisible(bandera);
        ganador_4.setVisible(bandera);

        ganador_combo_1.setVisible(bandera);
        ganador_combo_2.setVisible(bandera);
        ganador_combo_3.setVisible(bandera);
        ganador_combo_4.setVisible(bandera);
    }

    private void setFechaGanador(String fecha) {
        if (fecha.equals("03-12-2022") || fecha.equals("04-12-2022") || fecha.equals("05-12-2022") || fecha.equals("06-12-2022")) {
            setGanadores(true);
        } else if (fecha.equals("09-12-2022") || fecha.equals("10-12-2022")) {
            setGanadores(true);
        } else if (fecha.equals("13-12-2022") || fecha.equals("14-12-2022")) {
            setGanadores(true);
        } else if (fecha.equals("18-12-2022")) {
            setGanadores(true);
        } else {
            setGanadores(false);
        }
    }

    private void cambiarQuinela() {
        if (this.contadorFechas < 0) {
            this.contadorFechas = 21;
        } else if (this.contadorFechas > 21) {
            this.contadorFechas = 0;
        }
        ocultarPaneles();
        String fecha = fechas.get(contadorFechas);
        //Partido[] partidos = new Partido[4];
        ArrayList<Partido> partidosAux = new ArrayList<>();
        int c_aux = 0;

        for (Partido i : todosLosPartidos) {

            try {

                if (i.date.equals(fecha)) {
                    //partidos[c_aux] = i;
                    partidosAux.add(i);
                    c_aux++;
                }
            } catch (NullPointerException e) {

            }

        }

        c_aux = 0;
        boolean entro = false;
        for (Partido j : partidosAux) {
            if (j != null) {
                String local = j.local.pais.replace(" ", "_").replace("ñ", "n");
                String visita = j.visita.pais.replace(" ", "_").replace("ñ", "n");
                ImageIcon image1 = new ImageIcon("imagenes/escudos/" + local + ".png");
                ImageIcon image2 = new ImageIcon("imagenes/escudos/" + visita + ".png");
                entro = true;

                if (c_aux == 0) {
                    ganador_combo_1.removeAllItems();
                    fecha_1.setText(j.date);
                    panel1.setVisible(true);
                    logo1_1.setIcon(image1);
                    logo2_1.setIcon(image2);
                    j.setResultadoLocal(combo1_1);
                    combo1_1.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_1);
                    combo2_1.setSelectedIndex(j.getGolVisita());

                    if (contadorFechas > 12) {
                        this.partido1 = j;
                        ganador_combo_1.setVisible(true);
                        ganador_combo_1.addItem(j.getLocal().pais);
                        ganador_combo_1.addItem(j.getVisita().pais);

                    } else {
                        ganador_combo_1.setVisible(false);
                    }
                    c_aux++;
                } else if (c_aux == 1) {
                    ganador_combo_2.removeAllItems();
                    fecha_2.setText(j.date);
                    panel2.setVisible(true);
                    logo1_2.setIcon(image1);
                    logo2_2.setIcon(image2);
                    j.setResultadoLocal(combo1_2);
                    combo1_2.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_2);
                    combo2_2.setSelectedIndex(j.getGolVisita());

                    if (contadorFechas > 12) {
                        this.partido2 = j;
                        ganador_combo_2.setVisible(true);

                        ganador_combo_2.removeAllItems();
                        ganador_combo_2.addItem(j.getLocal().pais);
                        ganador_combo_2.addItem(j.getVisita().pais);
                    } else {
                        ganador_combo_2.setVisible(false);

                    }
                    c_aux++;
                } else if (c_aux == 2) {
                    fecha_3.setText(j.date);
                    panel3.setVisible(true);
                    logo1_3.setIcon(image1);
                    logo2_3.setIcon(image2);
                    j.setResultadoLocal(combo1_3);
                    combo1_3.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_3);
                    combo2_3.setSelectedIndex(j.getGolVisita());

                    ganador_combo_3.setVisible(false);

                    c_aux++;
                } else {
                    fecha_4.setText(j.date);
                    panel4.setVisible(true);
                    logo1_4.setIcon(image1);
                    logo2_4.setIcon(image2);
                    j.setResultadoLocal(combo1_4);
                    combo1_4.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_4);
                    combo2_4.setSelectedIndex(j.getGolVisita());

                    ganador_combo_4.setVisible(false);

                    c_aux++;
                }
                setJornada(fecha);
            }
        }
        if (!entro) {
            setJornada(fecha);
            if (configuracionFinalizada && contadorFechas > 12) {
                String serie = "";
                if (fecha.equals("03-12-2022") || fecha.equals("04-12-2022") || fecha.equals("05-12-2022") || fecha.equals("06-12-2022")) {
                    serie = "Octavos de Final";
                } else if (fecha.equals("09-12-2022") || fecha.equals("10-12-2022")) {
                    serie = "Cuartos de Final";
                } else if (fecha.equals("13-12-2022") || fecha.equals("14-12-2022")) {
                    serie = "Semifinales";
                } else {
                    serie = " la Final";
                }
                JOptionPane.showMessageDialog(pantallas, "No se encuentra infomación disponible para " + serie, "ERROR!", JOptionPane.ERROR_MESSAGE);
                if (contadorFechas == 21) {
                    contadorFechas = 0;
                } else {
                    this.contadorFechas--;
                }
                cambiarQuinela();
            }
        }

    }

    private void set_partidos_grupos(String grupo) {
        // partido_combo_quinela.removeAllItems();
        for (Partido partido : mundial.partidosPrimeraFase) {
            try {
                String group = String.valueOf(partido.grupo);
                if (group.equals(grupo)) {
                    //partido_combo_quinela.addItem(partido.local.pais + "-" + partido.visita.pais);
                }
            } catch (NullPointerException e) {
                System.out.println("a");
            }

        }
    }

    public Quinela() {
        mundial.init();
        mundial.primeraFase();
        //mundial.octavosDeFinal();
        //mundial.cuartosDeFinal();
        //mundial.finalMundial();
        initComponents();
        for (Partido partido : mundial.partidosPrimeraFase) {
            partido.setGenerarResultado(generarResultado_button_quinela);
        }
        todosLosPartidos = mundial.getTodos();
        cambiarQuinela();
        configuracionFinalizada = true;
        ocultarPaneles();
        setGanadores(false);
    }

    private String buscarEnLista(String num, ArrayList<String> lista) {
        int contador = 0;
        for (String i : lista) {
            System.out.println("PARTE-> " + i);
            String[] usrs = i.split("-");
            if (num.equals(usrs[1])) {
                lista.remove(contador);
                return i;
            }
            contador++;
        }
        return null;
    }

    private void ordenarRanking() {
        String data = manejadorArchivos.leer("archivos/ranking.txt");
        System.out.println("DAAATA---> " + data);
        String[] usrs = data.split("#");
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<String> correcta = new ArrayList<>();
        ArrayList<Integer> ordenamiento = new ArrayList<>();
        for (String i : usrs) {
            if (!i.equals("")) {
                String[] info = i.split("-");
                usuarios.add(i);
                ordenamiento.add(Integer.parseInt(info[1]));
            }
        }
        Collections.sort(ordenamiento, Collections.reverseOrder());
        for (int j : ordenamiento) {
            correcta.add(buscarEnLista(String.valueOf(j), usuarios));
        }
        String completo = "";
        for (String x : correcta) {
            completo += "#" + x;
        }
        manejadorArchivos.escribir("archivos/ranking.txt", completo);
    }

    private void generarRanking(Mundial mundialReal) {
        String info = manejadorArchivos.archivosEn("archivos");
        String[] rutas = info.split("-");
        int sumatoria = 0;
        String agregar = "";

        for (String user : rutas) {
            System.out.println("ANALIZANDO---> " + user);
            Mundial nuevo = manejadorArchivos.buscarMundial(user, false);
            int cont = 0;
            for (Partido p : nuevo.partidosPrimeraFase) {
                try {
                    Equipo ganadorReal = mundialReal.partidosPrimeraFase[cont].getGanador();
                    Equipo ganadorUser = nuevo.partidosPrimeraFase[cont].getGanador();

                    if (ganadorReal.pais.equals(ganadorUser.pais)) {
                        sumatoria += 5;
                    }

                    int marcadorLocalReal = mundialReal.partidosPrimeraFase[cont].golLocal;
                    int marcadorVisitaReal = mundialReal.partidosPrimeraFase[cont].golVisita;
                    int marcadorLocalUser = nuevo.partidosPrimeraFase[cont].golLocal;
                    int marcadorVisitaUser = nuevo.partidosPrimeraFase[cont].golLocal;

                    System.out.println("Local --> Real: " + marcadorLocalReal + "\t Puesto: " + marcadorLocalUser);
                    System.out.println("Visita --> Real: " + marcadorVisitaReal + "\t Puesto: " + marcadorVisitaUser);

                    if (marcadorLocalReal == marcadorLocalUser && marcadorVisitaReal == marcadorVisitaUser) {
                        sumatoria += 10;
                    }
                    cont++;
                } catch (NullPointerException e) {
                    System.out.println("Se cae en contador: " + cont);
                    System.out.println(nuevo.partidosPrimeraFase[cont]);
                    cont++;
                }

            }
            sumatoria += Integer.parseInt(manejadorArchivos.leer("archivos/" + user + "/ranking.txt"));
            System.out.println("Se suma a " + user + ": " + sumatoria);
            manejadorArchivos.escribir("archivos/" + user + "/ranking.txt", String.valueOf(sumatoria));
            agregar += "#" + user + "-" + sumatoria;

            sumatoria = 0;

        }
        manejadorArchivos.escribir("archivos/ranking.txt", agregar);
        ordenarRanking();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantallas = new javax.swing.JTabbedPane();
        login = new javax.swing.JPanel();
        iniciar_label = new javax.swing.JLabel();
        username_field_login = new javax.swing.JTextField();
        username_label_login = new javax.swing.JLabel();
        password_label_login = new javax.swing.JLabel();
        acceder_button_login = new javax.swing.JButton();
        registrarse_button_login = new javax.swing.JButton();
        password_field_login = new javax.swing.JPasswordField();
        mostrar_button_login = new javax.swing.JRadioButton();
        administrativo_button_login = new javax.swing.JToggleButton();
        registrar = new javax.swing.JPanel();
        registrarse_label_registrarse = new javax.swing.JLabel();
        username_field_registrarse = new javax.swing.JTextField();
        username_label_registrarse = new javax.swing.JLabel();
        password_field_registrarse = new javax.swing.JTextField();
        password_label_registrarse = new javax.swing.JLabel();
        registrar_button_registrarse = new javax.swing.JButton();
        login_button_registrarse = new javax.swing.JButton();
        quinela = new javax.swing.JPanel();
        quinela_label_quinela1 = new javax.swing.JLabel();
        logout_button_quinela1 = new javax.swing.JButton();
        guardar_button_quinela = new javax.swing.JButton();
        generarResultado_button_quinela = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        logo1_1 = new javax.swing.JLabel();
        logo2_1 = new javax.swing.JLabel();
        fecha_1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo1_1 = new javax.swing.JComboBox<>();
        combo2_1 = new javax.swing.JComboBox<>();
        ganador_1 = new javax.swing.JLabel();
        ganador_combo_1 = new javax.swing.JComboBox<>();
        panel3 = new java.awt.Panel();
        logo1_3 = new javax.swing.JLabel();
        logo2_3 = new javax.swing.JLabel();
        fecha_3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo1_3 = new javax.swing.JComboBox<>();
        combo2_3 = new javax.swing.JComboBox<>();
        ganador_3 = new javax.swing.JLabel();
        ganador_combo_3 = new javax.swing.JComboBox<>();
        panel2 = new java.awt.Panel();
        logo1_2 = new javax.swing.JLabel();
        logo2_2 = new javax.swing.JLabel();
        fecha_2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo1_2 = new javax.swing.JComboBox<>();
        combo2_2 = new javax.swing.JComboBox<>();
        ganador_2 = new javax.swing.JLabel();
        ganador_combo_2 = new javax.swing.JComboBox<>();
        panel4 = new java.awt.Panel();
        logo1_4 = new javax.swing.JLabel();
        logo2_4 = new javax.swing.JLabel();
        fecha_4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo1_4 = new javax.swing.JComboBox<>();
        combo2_4 = new javax.swing.JComboBox<>();
        ganador_combo_4 = new javax.swing.JComboBox<>();
        ganador_4 = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        jornada = new javax.swing.JLabel();
        ranking_quinela = new javax.swing.JButton();
        sumar_button = new javax.swing.JButton();
        administrativo = new javax.swing.JPanel();
        administrativo_label_administrativo = new javax.swing.JLabel();
        username_field_administrativo = new javax.swing.JTextField();
        username_label_administrativo = new javax.swing.JLabel();
        acceder_button_administrativo = new javax.swing.JButton();
        mostrar_button_administrativo = new javax.swing.JRadioButton();
        password_label_administrativo = new javax.swing.JLabel();
        password_field_administrativo = new javax.swing.JPasswordField();
        administrativo_button_administrativo = new javax.swing.JToggleButton();
        pantalla_administrativa = new javax.swing.JPanel();
        administrativo_label_padministrativa = new javax.swing.JLabel();
        logout_button_padministrativa = new javax.swing.JButton();
        editar_button = new javax.swing.JButton();
        ranking = new javax.swing.JPanel();
        quinela_label_quinela3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_ranking = new javax.swing.JTextArea();
        quienela_ranking = new javax.swing.JButton();
        logout_ranking = new javax.swing.JButton();
        comparacion = new javax.swing.JPanel();
        p1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciar_label.setFont(new java.awt.Font("Avenir", 1, 24)); // NOI18N
        iniciar_label.setText("Iniciar Sesión");

        username_field_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_field_loginActionPerformed(evt);
            }
        });

        username_label_login.setText("Username");

        password_label_login.setText("Password");

        acceder_button_login.setText("Acceder");
        acceder_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceder_button_loginActionPerformed(evt);
            }
        });

        registrarse_button_login.setText("Registrarse");
        registrarse_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarse_button_loginActionPerformed(evt);
            }
        });

        mostrar_button_login.setText("Mostrar Contraseña");
        mostrar_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_button_loginActionPerformed(evt);
            }
        });

        administrativo_button_login.setText("Admistrativo");
        administrativo_button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrativo_button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administrativo_button_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registrarse_button_login)
                .addGap(275, 275, 275))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(username_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 526, Short.MAX_VALUE)
                .addComponent(password_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(username_label_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password_label_login)
                .addGap(422, 422, 422))
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(acceder_button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(iniciar_label)))
                .addContainerGap(709, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mostrar_button_login)
                .addGap(379, 379, 379))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(username_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username_label_login))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(iniciar_label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(password_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password_label_login)))
                .addGap(18, 18, 18)
                .addComponent(mostrar_button_login)
                .addGap(45, 45, 45)
                .addComponent(acceder_button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addComponent(administrativo_button_login)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addComponent(registrarse_button_login)
                        .addGap(23, 23, 23))))
        );

        pantallas.addTab("tab1", login);

        registrarse_label_registrarse.setFont(new java.awt.Font("Avenir", 1, 24)); // NOI18N
        registrarse_label_registrarse.setText("Registrarse");

        username_label_registrarse.setText("Username");

        password_label_registrarse.setText("Password");

        registrar_button_registrarse.setText("Registrar");
        registrar_button_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_button_registrarseActionPerformed(evt);
            }
        });

        login_button_registrarse.setText("Login");
        login_button_registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_button_registrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registrarLayout = new javax.swing.GroupLayout(registrar);
        registrar.setLayout(registrarLayout);
        registrarLayout.setHorizontalGroup(
            registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(username_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 464, Short.MAX_VALUE)
                .addComponent(password_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
            .addGroup(registrarLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(username_label_registrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password_label_registrarse)
                .addGap(483, 483, 483))
            .addGroup(registrarLayout.createSequentialGroup()
                .addGroup(registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrarLayout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(registrarse_label_registrarse))
                    .addGroup(registrarLayout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(registrar_button_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login_button_registrarse)
                .addGap(351, 351, 351))
        );
        registrarLayout.setVerticalGroup(
            registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(registrarse_label_registrarse)
                .addGap(113, 113, 113)
                .addGroup(registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password_field_registrarse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_label_registrarse)
                    .addComponent(password_label_registrarse))
                .addGap(90, 90, 90)
                .addComponent(registrar_button_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(login_button_registrarse)
                .addGap(59, 59, 59))
        );

        pantallas.addTab("tab2", registrar);

        quinela.setBackground(new java.awt.Color(147, 25, 49));

        quinela_label_quinela1.setFont(new java.awt.Font("Noto Serif Myanmar", 1, 48)); // NOI18N
        quinela_label_quinela1.setForeground(new java.awt.Color(255, 255, 255));
        quinela_label_quinela1.setText("Quiniela");

        logout_button_quinela1.setText("Logout");
        logout_button_quinela1.setActionCommand("");
        logout_button_quinela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_button_quinela1ActionPerformed(evt);
            }
        });

        guardar_button_quinela.setText("Guardar");
        guardar_button_quinela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_button_quinelaActionPerformed(evt);
            }
        });

        generarResultado_button_quinela.setText("Generar Resultado");
        generarResultado_button_quinela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarResultado_button_quinelaActionPerformed(evt);
            }
        });

        jButton1.setText("Simular Heurística");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(119, 32, 32));
        panel1.setPreferredSize(new java.awt.Dimension(430, 279));

        logo1_1.setText("Logo 1");

        logo2_1.setText("Logo 2");

        fecha_1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_1.setForeground(new java.awt.Color(255, 255, 255));
        fecha_1.setText("22-11-2022");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VS");

        combo1_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo1_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1_1ItemStateChanged(evt);
            }
        });

        combo2_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo2_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo2_1ItemStateChanged(evt);
            }
        });

        ganador_1.setForeground(new java.awt.Color(255, 255, 255));
        ganador_1.setText("Ganador:");

        ganador_combo_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ganador_combo_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ganador_combo_1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(combo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(logo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(combo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(fecha_1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(ganador_1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(ganador_combo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(fecha_1)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ganador_1)
                .addGap(13, 13, 13)
                .addComponent(ganador_combo_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panel3.setBackground(new java.awt.Color(119, 32, 32));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo1_3.setText("Logo 1");
        panel3.add(logo1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 125, 137));

        logo2_3.setText("Logo 2");
        panel3.add(logo2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 52, 125, 137));

        fecha_3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_3.setForeground(new java.awt.Color(255, 255, 255));
        fecha_3.setText("22-11-2022");
        panel3.add(fecha_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VS");
        panel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 101, -1, -1));

        combo1_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo1_3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1_3ItemStateChanged(evt);
            }
        });
        panel3.add(combo1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 241, -1, -1));

        combo2_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo2_3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo2_3ItemStateChanged(evt);
            }
        });
        panel3.add(combo2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 241, -1, -1));

        ganador_3.setForeground(new java.awt.Color(255, 255, 255));
        ganador_3.setText("Ganador:");
        panel3.add(ganador_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 201, 61, -1));

        ganador_combo_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel3.add(ganador_combo_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 231, 116, -1));

        panel2.setBackground(new java.awt.Color(119, 32, 32));

        logo1_2.setText("Logo 1");

        logo2_2.setText("Logo 2");

        fecha_2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_2.setForeground(new java.awt.Color(255, 255, 255));
        fecha_2.setText("22-11-2022");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VS");

        combo1_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo1_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1_2ItemStateChanged(evt);
            }
        });

        combo2_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo2_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo2_2ItemStateChanged(evt);
            }
        });

        ganador_2.setForeground(new java.awt.Color(255, 255, 255));
        ganador_2.setText("Ganador:");

        ganador_combo_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ganador_combo_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ganador_combo_2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(combo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(logo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(70, 70, 70))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(ganador_2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addComponent(combo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(fecha_2))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(ganador_combo_2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(fecha_2)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(ganador_2)))
                .addGap(18, 18, 18)
                .addComponent(ganador_combo_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panel4.setBackground(new java.awt.Color(119, 32, 32));

        logo1_4.setText("Logo 1");

        logo2_4.setText("Logo 2");

        fecha_4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_4.setForeground(new java.awt.Color(255, 255, 255));
        fecha_4.setText("22-11-2022");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VS");

        combo1_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo1_4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1_4ItemStateChanged(evt);
            }
        });

        combo2_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        combo2_4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo2_4ItemStateChanged(evt);
            }
        });

        ganador_combo_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ganador_4.setForeground(new java.awt.Color(255, 255, 255));
        ganador_4.setText("Ganador:");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(combo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(logo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel4Layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(ganador_4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ganador_combo_4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fecha_4))
                                .addGap(18, 18, 18)))))
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addComponent(combo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(fecha_4)
                .addGap(69, 69, 69)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(ganador_4)
                .addGap(13, 13, 13)
                .addComponent(ganador_combo_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        siguiente.setText("Siguiente");
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                siguienteMouseReleased(evt);
            }
        });
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        anterior.setText("Anterior");
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                anteriorMouseReleased(evt);
            }
        });
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        jornada.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jornada.setForeground(new java.awt.Color(255, 255, 255));
        jornada.setText("Fase de Grupo");

        ranking_quinela.setText("Ranking");
        ranking_quinela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ranking_quinelaActionPerformed(evt);
            }
        });

        sumar_button.setText("Sumar Puntos");
        sumar_button.setToolTipText("");
        sumar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quinelaLayout = new javax.swing.GroupLayout(quinela);
        quinela.setLayout(quinelaLayout);
        quinelaLayout.setHorizontalGroup(
            quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quinelaLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(generarResultado_button_quinela)
                        .addGap(107, 107, 107)
                        .addComponent(logout_button_quinela1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(359, 359, 359))
                    .addGroup(quinelaLayout.createSequentialGroup()
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(quinelaLayout.createSequentialGroup()
                                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(quinelaLayout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(quinela_label_quinela1))
                                    .addGroup(quinelaLayout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(jornada))
                                    .addGroup(quinelaLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ranking_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sumar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54))
                            .addGroup(quinelaLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(273, Short.MAX_VALUE))))
        );
        quinelaLayout.setVerticalGroup(
            quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(quinelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                        .addComponent(quinela_label_quinela1)
                        .addGap(35, 35, 35)
                        .addComponent(jornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                        .addGap(0, 90, Short.MAX_VALUE)
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quinelaLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(quinelaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ranking_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(sumar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generarResultado_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout_button_quinela1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pantallas.addTab("tab3", quinela);

        administrativo_label_administrativo.setFont(new java.awt.Font("Avenir", 1, 24)); // NOI18N
        administrativo_label_administrativo.setText("Acceso Administrativo");

        username_field_administrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_field_administrativoActionPerformed(evt);
            }
        });

        username_label_administrativo.setText("Username");

        acceder_button_administrativo.setText("Acceder");
        acceder_button_administrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceder_button_administrativoActionPerformed(evt);
            }
        });

        mostrar_button_administrativo.setText("Mostrar Contraseña");
        mostrar_button_administrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_button_administrativoActionPerformed(evt);
            }
        });

        password_label_administrativo.setText("Password");

        administrativo_button_administrativo.setText("Login Común");
        administrativo_button_administrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrativo_button_administrativoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout administrativoLayout = new javax.swing.GroupLayout(administrativo);
        administrativo.setLayout(administrativoLayout);
        administrativoLayout.setHorizontalGroup(
            administrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, administrativoLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(username_field_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addComponent(password_field_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, administrativoLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(username_label_administrativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password_label_administrativo)
                .addGap(317, 317, 317))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, administrativoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mostrar_button_administrativo)
                .addGap(282, 282, 282))
            .addGroup(administrativoLayout.createSequentialGroup()
                .addGroup(administrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administrativo_button_administrativo)
                    .addGroup(administrativoLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(administrativo_label_administrativo))
                    .addGroup(administrativoLayout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(acceder_button_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        administrativoLayout.setVerticalGroup(
            administrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(administrativoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administrativo_label_administrativo)
                .addGap(135, 135, 135)
                .addGroup(administrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_field_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_field_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(administrativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_label_administrativo)
                    .addComponent(password_label_administrativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostrar_button_administrativo)
                .addGap(48, 48, 48)
                .addComponent(acceder_button_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(administrativo_button_administrativo)
                .addGap(17, 17, 17))
        );

        pantallas.addTab("tab4", administrativo);

        administrativo_label_padministrativa.setFont(new java.awt.Font("Avenir", 1, 24)); // NOI18N
        administrativo_label_padministrativa.setText("Pantalla Administrativa");

        logout_button_padministrativa.setText("Logout");
        logout_button_padministrativa.setActionCommand("");
        logout_button_padministrativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_button_padministrativaActionPerformed(evt);
            }
        });

        editar_button.setText("Editar Resultados");
        editar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pantalla_administrativaLayout = new javax.swing.GroupLayout(pantalla_administrativa);
        pantalla_administrativa.setLayout(pantalla_administrativaLayout);
        pantalla_administrativaLayout.setHorizontalGroup(
            pantalla_administrativaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                .addGroup(pantalla_administrativaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantalla_administrativaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout_button_padministrativa))
                    .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(administrativo_label_padministrativa)
                        .addGap(0, 810, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(editar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pantalla_administrativaLayout.setVerticalGroup(
            pantalla_administrativaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administrativo_label_padministrativa)
                .addGap(176, 176, 176)
                .addComponent(editar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(logout_button_padministrativa)
                .addGap(17, 17, 17))
        );

        pantallas.addTab("tab5", pantalla_administrativa);

        ranking.setBackground(new java.awt.Color(147, 25, 49));

        quinela_label_quinela3.setFont(new java.awt.Font("Noto Serif Myanmar", 1, 48)); // NOI18N
        quinela_label_quinela3.setForeground(new java.awt.Color(255, 255, 255));
        quinela_label_quinela3.setText("Quiniela");

        area_ranking.setBackground(new java.awt.Color(147, 25, 49));
        area_ranking.setColumns(20);
        area_ranking.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        area_ranking.setForeground(new java.awt.Color(255, 255, 255));
        area_ranking.setRows(5);
        area_ranking.setEnabled(false);
        jScrollPane1.setViewportView(area_ranking);

        quienela_ranking.setText("Quinela");
        quienela_ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quienela_rankingActionPerformed(evt);
            }
        });

        logout_ranking.setText("Logout");
        logout_ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_rankingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rankingLayout = new javax.swing.GroupLayout(ranking);
        ranking.setLayout(rankingLayout);
        rankingLayout.setHorizontalGroup(
            rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rankingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quinela_label_quinela3)
                .addGap(577, 577, 577))
            .addGroup(rankingLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quienela_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(logout_ranking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(132, 132, 132)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        rankingLayout.setVerticalGroup(
            rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rankingLayout.createSequentialGroup()
                .addComponent(quinela_label_quinela3)
                .addGroup(rankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rankingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rankingLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(quienela_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(logout_ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pantallas.addTab("tab6", ranking);

        comparacion.setBackground(new java.awt.Color(147, 25, 49));

        p1.setText("jLabel2");

        javax.swing.GroupLayout comparacionLayout = new javax.swing.GroupLayout(comparacion);
        comparacion.setLayout(comparacionLayout);
        comparacionLayout.setHorizontalGroup(
            comparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparacionLayout.createSequentialGroup()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1241, Short.MAX_VALUE))
        );
        comparacionLayout.setVerticalGroup(
            comparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(747, Short.MAX_VALUE))
        );

        pantallas.addTab("tab7", comparacion);

        getContentPane().add(pantallas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -31, -1, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_button_padministrativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_button_padministrativaActionPerformed
        // TODO add your handling code here:
        cerrar_sesion();
    }//GEN-LAST:event_logout_button_padministrativaActionPerformed

    private void administrativo_button_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrativo_button_administrativoActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(0);
    }//GEN-LAST:event_administrativo_button_administrativoActionPerformed

    private void mostrar_button_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_button_administrativoActionPerformed
        // TODO add your handling code here:
        if (estado_password == 0) {
            password_field_administrativo.setEchoChar((char) 0);
            estado_password = 1;
        } else {
            password_field_administrativo.setEchoChar('*');
            estado_password = 0;
        }
    }//GEN-LAST:event_mostrar_button_administrativoActionPerformed

    private void acceder_button_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceder_button_administrativoActionPerformed
        // TODO add your handling code here:
        String username = username_field_administrativo.getText();
        String password = password_field_administrativo.getText();
        if (!username.equals("") && !password.equals("")) {
            if (encontrar_usuario(username, password, true)) {
                usuario_global = username;
                pantallas.setSelectedIndex(4);
                username_field_administrativo.setText("");
                password_field_administrativo.setText("");
                superUser = true;
                Mundial guardado = manejadorArchivos.buscarMundial(username, true);
                todosLosPartidos.clear();
                todosLosPartidos = guardado.getTodos();
                System.out.println("GUARDADA: " + this.mundial.getTodos().get(0).getGolLocal());
                cambiarQuinela();
                sumar_button.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(pantallas, "Este Administrador no Existe!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceder_button_administrativoActionPerformed

    private void username_field_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_field_administrativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field_administrativoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anteriorActionPerformed

    private void anteriorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseReleased
        // TODO add your handling code here:
        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int c_aux = 0;

        for (Partido i : todosLosPartidos) {
            try {
                if (i.date.equals(fecha)) {
                    partidos[c_aux] = i;
                    c_aux++;
                }
            } catch (NullPointerException e) {

            }

        }
        c_aux = 0;
        for (Partido j : partidos) {
            if (j != null) {
                if (c_aux == 0) {
                    j.setGolLocal(combo1_1.getSelectedIndex());
                    j.setGolVisita(combo2_1.getSelectedIndex());
                    j.resultadoTemp();

                    /*if(serie!="Fase de Grupos" && serie!=""){
                        if(j.getGanador()==null){
                        ganador_combo_1.setVisible(true);
                    }
                    }
                    else{
                        ganador_combo_1.setVisible(false);
                    }*/
                    c_aux++;
                } else if (c_aux == 1) {
                    j.setGolLocal(combo1_2.getSelectedIndex());
                    j.setGolVisita(combo2_2.getSelectedIndex());
                    j.resultadoTemp();
                    /*
                    if(serie!="Fase de Grupos" && serie!=""){
                        if(j.getGanador()==null){
                        ganador_combo_2.setVisible(true);
                    }
                    }
                    else{
                        ganador_combo_2.setVisible(false);
                    }*/
                    c_aux++;
                } else if (c_aux == 2) {
                    j.setGolLocal(combo1_3.getSelectedIndex());
                    j.setGolVisita(combo2_3.getSelectedIndex());
                    j.resultadoTemp();

                    c_aux++;
                } else {
                    j.setGolLocal(combo1_4.getSelectedIndex());
                    j.setGolVisita(combo2_4.getSelectedIndex());
                    j.resultadoTemp();

                    c_aux++;
                }
            }/*
            else{
                System.out.println("CONTADOR----------> " + this.contadorFechas);
                if(configuracionFinalizada && contadorFechas > 13){
                    String serie = "";
                    if(fecha.equals("03-12-2022") || fecha.equals("04-12-2022") || fecha.equals("05-12-2022") || fecha.equals("06-12-2022")){
                        serie = "Octavos de Final";
                    }
                    else if(fecha.equals("09-12-2022") || fecha.equals("10-12-2022")){
                        serie = "Cuartos de Final";
                    }
                    else if(fecha.equals("13-12-2022") || fecha.equals("14-12-2022")){
                        serie = "Semifinales";
                    }
                    else{
                        serie = " la Final";
                    }
                    JOptionPane.showMessageDialog(pantallas, "No se cuentra infomación disponible para " + serie,"ERROR!", JOptionPane.ERROR_MESSAGE);
                    this.contadorFechas = 1;
                    cambiarQuinela();
                }
                
                
            }*/

        }

        c_aux = 0;
        this.contadorFechas--;
        cambiarQuinela();
        //System.out.println("CONTADOR----> " + this.contadorFechas);
    }//GEN-LAST:event_anteriorMouseReleased

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:

    }//GEN-LAST:event_none

    private void siguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseReleased
        // TODO add your handling code here:

        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int cont = 0;

        for (Partido i : todosLosPartidos) {
            try {
                if (i.date.equals(fecha)) {

                    partidos[cont] = i;
                    cont++;
                }
            } catch (NullPointerException e) {

            }

        }
        cont = 0;
        for (Partido j : partidos) {
            if (j != null) {
                if (cont == 0) {
                    j.setGolLocal(combo1_1.getSelectedIndex());
                    j.setGolVisita(combo2_1.getSelectedIndex());
                    j.resultadoTemp();
                    /*if(serie!="Fase de Grupos" || serie!=""){
                        if(j.getGanador()==null){
                        ganador_combo_1.setVisible(true);
                    }
                    }else{
                        ganador_combo_1.setVisible(false);
                    }*/

                    cont++;
                } else if (cont == 1) {
                    j.setGolLocal(combo1_2.getSelectedIndex());
                    j.setGolVisita(combo2_2.getSelectedIndex());
                    j.resultadoTemp();

                    /*if(serie!="Fase de Grupos" || serie!=""){
                        if(j.getGanador()==null){
                        ganador_combo_2.setVisible(true);
                    }
                    }
                    else{
                        ganador_combo_2.setVisible(false);
                    }*/
                    cont++;
                } else if (cont == 2) {
                    j.setGolLocal(combo1_3.getSelectedIndex());
                    j.setGolVisita(combo2_3.getSelectedIndex());
                    j.resultadoTemp();

                    /*if(serie!="Fase de Grupos" || serie!=""){
                        if(j.getGanador()==null){
                        ganador_combo_3.setVisible(true);
                    }
                    }
                    else{
                        ganador_combo_3.setVisible(false);
                    }*/
                    cont++;
                } else {
                    j.setGolLocal(combo1_4.getSelectedIndex());
                    j.setGolVisita(combo2_4.getSelectedIndex());
                    j.resultadoTemp();

                    ganador_combo_4.setVisible(false);
                    cont++;
                }
            }/*
            else{
                //System.out.println("CONTADOR----------> " + this.contadorFechas);
                if(configuracionFinalizada && contadorFechas > 13){
                    String serie = "";
                    if(fecha.equals("03-12-2022") || fecha.equals("04-12-2022") || fecha.equals("05-12-2022") || fecha.equals("06-12-2022")){
                        serie = "Octavos de Final";
                    }
                    else if(fecha.equals("09-12-2022") || fecha.equals("10-12-2022")){
                        serie = "Cuartos de Final";
                    }
                    else if(fecha.equals("13-12-2022") || fecha.equals("14-12-2022")){
                        serie = "Semifinales";
                    }
                    else{
                        serie = " la Final";
                    }
                    JOptionPane.showMessageDialog(pantallas, "No se cuentra infomación disponible para " + serie,"ERROR!", JOptionPane.ERROR_MESSAGE);
                    this.contadorFechas = 1;
                    cambiarQuinela();
                }
                
                
            }*/

        }
        cont = 0;
        this.contadorFechas++;

        cambiarQuinela();
        //System.out.println("CONTADOR----> " + this.contadorFechas);
    }//GEN-LAST:event_siguienteMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //String fase=(String)fase_combo_quinela.getSelectedItem();
        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int c_aux = 0;

        for (Partido i : todosLosPartidos) {
            try {
                if (i.date.equals(fecha)) {
                    partidos[c_aux] = i;
                    c_aux++;
                }
            } catch (NullPointerException e) {

            }

        }

        for (Partido partido : partidos) {
            if (partido != null) {
                partido.generarHeuristica();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void generarResultado_button_quinelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarResultado_button_quinelaActionPerformed
        //String fase=(String)fase_combo_quinela.getSelectedItem();
        String fase = "";
        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int c_aux = 0;

        for (Partido i : todosLosPartidos) {
            try {
                if (i.date.equals(fecha)) {
                    partidos[c_aux] = i;
                    c_aux++;
                }
            } catch (NullPointerException e) {

            }

        }

        for (Partido partido : partidos) {
            if (partido != null) {
                partido.generarResultado();
            }

        }

    }//GEN-LAST:event_generarResultado_button_quinelaActionPerformed
    /*
    * BOTON GUARDAR
     */
    private void guardar_button_quinelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_button_quinelaActionPerformed
        // TODO add your handling code here:
        Mundial aux = this.mundial;
        for (Partido p : todosLosPartidos) {
            p.resultadoTemp();
            p.getLocal().sumarGolAFavor(p.getGolLocal());
            p.getLocal().sumarGolEnContra(p.getGolVisita());

            p.getVisita().sumarGolAFavor(p.getGolVisita());
            p.getVisita().sumarGolEnContra(p.getGolLocal());
            
            if (p.getGanador() != null) {
                
                p.getGanador().sumarPuntos(3);
            } else {
                p.getLocal().sumarPuntos(1);
                p.getVisita().sumarPuntos(1);
            }
            
                
        }
        for (Partido p : mundial.partidosPrimeraFase) {
            p.getLocal().sumarPuntos(-p.getLocal().getPuntos());
            p.getVisita().sumarPuntos(-p.getVisita().getPuntos());
            p.getLocal().setGolAFavor(0);
            p.getLocal().setGolEnContra(0);
            
            p.getVisita().setGolAFavor(0);
            p.getVisita().setGolEnContra(0);
            
            System.out.println("RESET: " + p.getLocal().pais + " " + p.getLocal().getPuntos());
            System.out.println("RESET: " + p.getVisita().pais + " " + p.getVisita().getPuntos());
        }
        boolean grupos = false;
        int cont = 0;
        for (Partido p : todosLosPartidos) {
            if (cont <= 47) {

                

                p.resultadoTemp();
                p.getLocal().sumarGolAFavor(p.getGolLocal());
                p.getLocal().sumarGolEnContra(p.getGolVisita());

                p.getVisita().sumarGolAFavor(p.getGolVisita());
                p.getVisita().sumarGolEnContra(p.getGolLocal());
                System.out.println("PARTIDO: " + p.getLocal().pais + " VS " + p.getVisita().pais);
                System.out.println("MARCADOR: " + p.getGolLocal() + " VS " + p.getGolVisita());
                if (p.getGanador() != null) {

                    p.getGanador().sumarPuntos(3);
                } else {
                    p.getLocal().sumarPuntos(1);
                    p.getVisita().sumarPuntos(1);
                }
                System.out.println("PUNTAJE: " + p.getLocal().getPuntos() + " VS " + p.getVisita().getPuntos());

                if (p.getGolLocal() == -1 || p.getLocal().pais.equals("aux") || p.getVisita().pais.equals("aux")) {
                    grupos = false;
                    break;
                }

                grupos = true;
            }
            if (cont <= 55 && cont > 47) {

                if (p.getGolLocal() == -1 || p.getLocal().pais.equals("aux") || p.getVisita().pais.equals("aux")) {
                    grupos = true;
                    mundial.octavos = false;
                    break;
                }
                if (p.getGanador() == null) {
                    for (Equipo e : mundial.getEquipos()) {
                        if (e.pais == p.ganadorPenalesCB) {
                            p.setGanador(e);
                            grupos = false;
                            mundial.octavos = true;
                            break;
                        }
                    }

                }
                grupos = false;
                mundial.octavos = true;
            }
            if (cont <= 59 && cont > 55) {

                if (p.getGolLocal() == -1 || p.getLocal().pais.equals("aux") || p.getVisita().pais.equals("aux")) {
                    mundial.octavos = true;
                    mundial.cuartos = false;
                    break;
                }
                if (p.getGanador() == null) {
                    for (Equipo e : mundial.getEquipos()) {
                        if (e.pais == p.ganadorPenalesCB) {
                            p.setGanador(e);
                            grupos = false;
                            mundial.octavos = true;
                            break;
                        }
                    }

                }
                mundial.octavos = false;
                mundial.cuartos = true;
            }
            if (cont <= 61 && cont > 59) {
                System.out.println("PARTIDO SEMIS: " + p.getLocal().pais + " VS " + p.getVisita().pais);
                System.out.println("LLENO: " + p.getGolLocal());
                System.out.println("CONT: " + cont);
                if (p.getGolLocal() == -1 || p.getLocal().pais.equals("aux") || p.getVisita().pais.equals("aux")) {
                    mundial.cuartos = true;
                    mundial.semis = false;
                    break;
                }
                if (p.getGanador() == null) {
                    for (Equipo e : mundial.getEquipos()) {
                        if (e.pais == p.ganadorPenalesCB) {
                            p.setGanador(e);
                            grupos = false;
                            mundial.octavos = true;
                            break;
                        }
                    }

                }
                mundial.cuartos = false;
                mundial.semis = true;

            }
            if (cont > 61) {
                System.out.println("PARTIDO FINAL: " + p.getLocal().pais + " VS " + p.getVisita().pais);
                System.out.println("LLENO: " + p.getGolLocal());
                System.out.println("CONT: " + cont);
                if (p.getGolLocal() == -1) {
                    mundial.semis = true;
                    mundial.finalMundial = false;
                    break;
                }
                if (p.getGanador() == null) {
                    for (Equipo e : mundial.getEquipos()) {
                        if (e.pais == p.ganadorPenalesCB) {
                            p.setGanador(e);
                            grupos = false;
                            mundial.octavos = true;
                            break;
                        }
                    }

                }
                mundial.semis = false;
                mundial.finalMundial = true;
            }
            cont++;

        }
        System.out.println("GRUPOS: " + grupos);
        System.out.println("OCTAVOS: " + mundial.octavos);
        System.out.println("CUARTOS: " + mundial.cuartos);
        System.out.println("SEMIS: " + mundial.semis);
        System.out.println("FINAL: " + mundial.finalMundial);

        if (grupos) {

            mundial.ordenarGrupos();
            mundial.octavosDeFinal();
            todosLosPartidos.clear();
            todosLosPartidos = mundial.getTodos();
        }
        if (mundial.octavos) {
            mundial.ordenarOctavos();
            mundial.cuartosDeFinal();
            todosLosPartidos.clear();
            todosLosPartidos = mundial.getTodos();
        }
        if (mundial.cuartos) {
            mundial.ordenarCuartos();
            mundial.semifinales();
            todosLosPartidos.clear();
            todosLosPartidos = mundial.getTodos();
        }
        if (mundial.semis) {
            mundial.ordenarSemis();
            mundial.finalMundial();
            todosLosPartidos.clear();
            todosLosPartidos = mundial.getTodos();
        }
        manejadorArchivos.guardarMundial(aux, todosLosPartidos, usuario_global, superUser);
        JOptionPane.showMessageDialog(pantallas, "Se guardó correctamente!!!", "ERROR!", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_guardar_button_quinelaActionPerformed

    private void logout_button_quinela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_button_quinela1ActionPerformed
        // TODO add your handling code here:
        cerrar_sesion();
        ocultarPaneles();
    }//GEN-LAST:event_logout_button_quinela1ActionPerformed

    private void login_button_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_button_registrarseActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(0);
    }//GEN-LAST:event_login_button_registrarseActionPerformed

    private void registrar_button_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_button_registrarseActionPerformed
        // TODO add your handling code here:
        String username = username_field_registrarse.getText();
        String password = password_field_registrarse.getText();
        if (!username.equals("") && !password.equals("")) {
            if (!revisa_usuario(username)) {
                if (!username.contains(" ") && !username.contains("#") && !username.contains("-")) {
                    if (!password.contains(" ")) {
                        int opcion = JOptionPane.showConfirmDialog(pantallas, "Desea agregar al usuario -" + username + "- al sistema?");
                        switch (opcion) {
                            case JOptionPane.YES_OPTION:
                                if (manejadorArchivos.crear_carpeta("archivos/" + username) == 0) {
                                    Mundial nuevo = new Mundial();
                                    nuevo.init();
                                    nuevo.primeraFase();
                                    this.mundial = nuevo;
                                    manejadorArchivos.asignarMundial(this.mundial, username, "", password);

                                    escribir("archivos/usuarios.txt", "#" + username + "-" + password);
                                    JOptionPane.showMessageDialog(pantallas, "Se agregó a -" + username + "- al sistema!");
                                    username_field_login.setText(username);
                                    password_field_login.setText(password);
                                    pantallas.setSelectedIndex(0);
                                    username_field_registrarse.setText("");
                                    password_field_registrarse.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(pantallas, "Ocurrio un Error!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            case JOptionPane.NO_OPTION:
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(pantallas, "Esta Contraseña contiene Caractéres Inválidos (ESPACIO)!!!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(pantallas, "Este Usuario contiene Caractéres Inválidos (# o - o ESPACIO)!!!", "ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(pantallas, "Este Nombre de Usuario ya existe, prueba con otro!!!", "ERROR!", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrar_button_registrarseActionPerformed

    private void administrativo_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrativo_button_loginActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(3);
    }//GEN-LAST:event_administrativo_button_loginActionPerformed

    private void mostrar_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_button_loginActionPerformed
        // TODO add your handling code here:
        if (estado_password == 0) {
            password_field_login.setEchoChar((char) 0);
            estado_password = 1;
        } else {
            password_field_login.setEchoChar('*');
            estado_password = 0;
        }
    }//GEN-LAST:event_mostrar_button_loginActionPerformed

    private void registrarse_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarse_button_loginActionPerformed
        pantallas.setSelectedIndex(1);
    }//GEN-LAST:event_registrarse_button_loginActionPerformed

    private void acceder_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceder_button_loginActionPerformed
        // TODO add your handling code here
        String username = username_field_login.getText();
        String password = String.valueOf(password_field_login.getPassword());
        superUser = false;
        if (!username.equals("") && !password.equals("")) {
            if (encontrar_usuario(username, password, false)) {
                usuario_global = username;
                System.out.println("Se encuentra el usuario");

                Mundial guardado = manejadorArchivos.buscarMundial(username, false);
                this.mundial = guardado;
                todosLosPartidos.clear();
                this.todosLosPartidos = guardado.getTodos();
                System.out.println("GUARDADA: " + this.mundial.getTodos().get(3).getGolLocal());
                cambiarQuinela();

                pantallas.setSelectedIndex(2);
                username_field_login.setText("");
                password_field_login.setText("");
                sumar_button.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(pantallas, "No se encontro a este usuario!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceder_button_loginActionPerformed

    private void username_field_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_field_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field_loginActionPerformed

    private void editar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_buttonActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(2);
    }//GEN-LAST:event_editar_buttonActionPerformed

    private void ranking_quinelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ranking_quinelaActionPerformed
        // TODO add your handling code here:
        String info = manejadorArchivos.leer("archivos/ranking.txt");
        System.out.println(info);
        String[] data = info.split("#");
        area_ranking.setText("");
        String todo = "";
        int c = 0;
        for (String i : data) {
            if (!i.equals("")) {
                todo += c + ") " + i + " pts\n";
            }
            c++;
        }
        if (!todo.equals("")) {
            area_ranking.append(todo);
        } else {
            area_ranking.append("Sin informacion por el momento!");
        }
        pantallas.setSelectedIndex(5);
    }//GEN-LAST:event_ranking_quinelaActionPerformed

    private void quienela_rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quienela_rankingActionPerformed
        // TODO add your handling code here:
        Mundial guardado = manejadorArchivos.buscarMundial(usuario_global, superUser);
        System.out.println("GUARDADA: " + this.mundial.getTodos().get(0).getGolLocal());
        cambiarQuinela();
        pantallas.setSelectedIndex(2);
    }//GEN-LAST:event_quienela_rankingActionPerformed

    private void logout_rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_rankingActionPerformed
        // TODO add your handling code here:
        cerrar_sesion();
        ocultarPaneles();
    }//GEN-LAST:event_logout_rankingActionPerformed

    private void sumar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumar_buttonActionPerformed
        // TODO add your handling code here:
        Mundial aux = this.mundial;
        generarRanking(aux);
        JOptionPane.showMessageDialog(pantallas, "Se realizo la sumatoria correctamente!!!", "SUMATORIA", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_sumar_buttonActionPerformed

    private void combo1_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1_1ItemStateChanged
        // TODO add your handling code here:
        //cambiarQuinela();
        /*
        String fecha = fecha_1.getText();
        int selected = combo1_1.getSelectedIndex();
        int selected2 = combo2_1.getSelectedIndex();
        ganador_combo_1.setVisible(false);
        if(selected==selected2){
            //setFechaGanador(fecha);
            ganador_combo_1.setVisible(true);
            ganador_combo_1.removeAllItems();
            String pais1 = logo1_1.getIcon().toString().split("/")[2];
            String pais2 = logo2_1.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_1.addItem(pais1.replace("_", " "));
            ganador_combo_1.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_1.setVisible(false);
        }*/

    }//GEN-LAST:event_combo1_1ItemStateChanged

    private void combo2_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo2_1ItemStateChanged
        // TODO add your handling code here:
        //cambiarQuinela();
        /*String fecha = fecha_1.getText();
        int selected = combo1_1.getSelectedIndex();
        int selected2 = combo2_1.getSelectedIndex();
        ganador_combo_1.setVisible(false);
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_1.setVisible(true);
            ganador_combo_1.removeAllItems();
            String pais1 = logo1_1.getIcon().toString().split("/")[2];
            String pais2 = logo2_1.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_1.addItem(pais1.replace("_", " "));
            ganador_combo_1.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_1.setVisible(false);
        }*/
    }//GEN-LAST:event_combo2_1ItemStateChanged

    private void combo1_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1_2ItemStateChanged
        // TODO add your handling code here:
        //cambiarQuinela();
        /*String fecha = fecha_1.getText();
        int selected = combo1_2.getSelectedIndex();
        int selected2 = combo2_2.getSelectedIndex();
        ganador_combo_2.setVisible(false);
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_2.setVisible(true);
            ganador_combo_2.removeAllItems();
            String pais1 = logo1_2.getIcon().toString().split("/")[2];
            String pais2 = logo2_2.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_2.addItem(pais1.replace("_", " "));
            ganador_combo_2.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_2.setVisible(false);
        }*/
    }//GEN-LAST:event_combo1_2ItemStateChanged

    private void combo2_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo2_2ItemStateChanged
        // TODO add your handling code here:
        //cambiarQuinela();
        /*String fecha = fecha_1.getText();
        int selected = combo1_2.getSelectedIndex();
        int selected2 = combo2_2.getSelectedIndex();
        ganador_combo_2.setVisible(false);
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_2.setVisible(true);
            ganador_combo_2.removeAllItems();
            String pais1 = logo1_2.getIcon().toString().split("/")[2];
            String pais2 = logo2_2.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_2.addItem(pais1.replace("_", " "));
            ganador_combo_2.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_2.setVisible(false);
        }*/
    }//GEN-LAST:event_combo2_2ItemStateChanged

    private void combo1_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1_3ItemStateChanged
        // TODO add your handling code here:
        /*String fecha = fecha_1.getText();
        int selected = combo1_3.getSelectedIndex();
        int selected2 = combo2_3.getSelectedIndex();
        
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_3.setVisible(true);
            ganador_combo_3.removeAllItems();
            String pais1 = logo1_3.getIcon().toString().split("/")[2];
            String pais2 = logo2_3.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_3.addItem(pais1.replace("_", " "));
            ganador_combo_3.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_3.setVisible(false);
        }*/
    }//GEN-LAST:event_combo1_3ItemStateChanged

    private void combo2_3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo2_3ItemStateChanged
        // TODO add your handling code here:
        /* String fecha = fecha_1.getText();
        int selected = combo1_3.getSelectedIndex();
        int selected2 = combo2_3.getSelectedIndex();
        
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_3.setVisible(true);
            ganador_combo_3.removeAllItems();
            String pais1 = logo1_3.getIcon().toString().split("/")[2];
            String pais2 = logo2_3.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_3.addItem(pais1.replace("_", " "));
            ganador_combo_3.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_3.setVisible(false);
        }*/
    }//GEN-LAST:event_combo2_3ItemStateChanged

    private void combo1_4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1_4ItemStateChanged
        // TODO add your handling code here:
        /*String fecha = fecha_1.getText();
        int selected = combo1_4.getSelectedIndex();
        int selected2 = combo2_4.getSelectedIndex();
        
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_4.setVisible(true);
            ganador_combo_4.removeAllItems();
            String pais1 = logo1_4.getIcon().toString().split("/")[2];
            String pais2 = logo2_4.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_4.addItem(pais1.replace("_", " "));
            ganador_combo_4.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_4.setVisible(false);
        }*/
    }//GEN-LAST:event_combo1_4ItemStateChanged

    private void combo2_4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo2_4ItemStateChanged
        // TODO add your handling code here:
        /*String fecha = fecha_1.getText();
        int selected = combo1_4.getSelectedIndex();
        int selected2 = combo2_4.getSelectedIndex();
        
        if(selected == selected2){
            setFechaGanador(fecha);
            ganador_combo_4.setVisible(true);
            ganador_combo_4.removeAllItems();
            String pais1 = logo1_4.getIcon().toString().split("/")[2];
            String pais2 = logo2_4.getIcon().toString().split("/")[2];
            if(pais1.equals("espana")){
                pais1 = "España";
            }
            else if(pais2.equals("espana")){
                pais2 = "España";
            }
            ganador_combo_4.addItem(pais1.replace("_", " "));
            ganador_combo_4.addItem(pais2.replace("_", " "));
        }else{
            ganador_combo_4.setVisible(false);
        }*/
    }//GEN-LAST:event_combo2_4ItemStateChanged

    private void ganador_combo_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ganador_combo_1ItemStateChanged
        // TODO add your handling code here:
        try {
            partido1.ganadorPenalesCB = ganador_combo_1.getSelectedItem().toString();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_ganador_combo_1ItemStateChanged

    private void ganador_combo_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ganador_combo_2ItemStateChanged
        // TODO add your handling code here:
        try {
            partido2.ganadorPenalesCB = ganador_combo_2.getSelectedItem().toString();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_ganador_combo_2ItemStateChanged

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void escribir(String ruta, String data) {
        String info = manejadorArchivos.leer(ruta);
        int escribir = manejadorArchivos.escribir(ruta, info + data);

        if (escribir == 1) {
            JOptionPane.showMessageDialog(pantallas, "Ocurrio un error, intente de nuevo!!!!");
        }
    }

    private Boolean encontrar_usuario(String username, String password, Boolean admin) {
        String todos;
        if (!admin) {
            todos = manejadorArchivos.leer("archivos/usuarios.txt");
        } else {
            todos = manejadorArchivos.leer("archivos/admins.txt");
        }
        String[] usuarios = todos.split("#");
        String[] datos;

        for (String usuario : usuarios) {
            if (!usuario.equals("")) {
                datos = usuario.split("-");
                if (datos[0].equals(username) && datos[1].equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean revisa_usuario(String username) {
        String todos = manejadorArchivos.leer("archivos/usuarios.txt");
        String[] usuarios = todos.split("#");
        String[] datos;

        for (String usuario : usuarios) {
            if (!usuario.equals("")) {
                datos = usuario.split("-");
                if (datos[0].equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void cerrar_sesion() {
        int opcion = JOptionPane.showConfirmDialog(pantallas, "Desea cerrar la sesión activa?");
        switch (opcion) {
            case JOptionPane.YES_OPTION:
                usuario_global = null;
                superUser = false;
                ocultarPaneles();
                pantallas.setSelectedIndex(0);
                break;

            case JOptionPane.NO_OPTION:
                break;
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quinela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quinela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quinela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quinela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quinela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton acceder_button_administrativo;
    public javax.swing.JButton acceder_button_login;
    private javax.swing.JPanel administrativo;
    private javax.swing.JToggleButton administrativo_button_administrativo;
    private javax.swing.JToggleButton administrativo_button_login;
    private javax.swing.JLabel administrativo_label_administrativo;
    private javax.swing.JLabel administrativo_label_padministrativa;
    public javax.swing.JButton anterior;
    public javax.swing.JTextArea area_ranking;
    public javax.swing.JComboBox<String> combo1_1;
    public javax.swing.JComboBox<String> combo1_2;
    public javax.swing.JComboBox<String> combo1_3;
    public javax.swing.JComboBox<String> combo1_4;
    public javax.swing.JComboBox<String> combo2_1;
    public javax.swing.JComboBox<String> combo2_2;
    public javax.swing.JComboBox<String> combo2_3;
    public javax.swing.JComboBox<String> combo2_4;
    private javax.swing.JPanel comparacion;
    public javax.swing.JButton editar_button;
    public javax.swing.JLabel fecha_1;
    public javax.swing.JLabel fecha_2;
    public javax.swing.JLabel fecha_3;
    public javax.swing.JLabel fecha_4;
    public javax.swing.JLabel ganador_1;
    public javax.swing.JLabel ganador_2;
    public javax.swing.JLabel ganador_3;
    public javax.swing.JLabel ganador_4;
    public javax.swing.JComboBox<String> ganador_combo_1;
    public javax.swing.JComboBox<String> ganador_combo_2;
    public javax.swing.JComboBox<String> ganador_combo_3;
    public javax.swing.JComboBox<String> ganador_combo_4;
    private javax.swing.JButton generarResultado_button_quinela;
    public javax.swing.JButton guardar_button_quinela;
    private javax.swing.JLabel iniciar_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jornada;
    public javax.swing.JPanel login;
    public javax.swing.JButton login_button_registrarse;
    public javax.swing.JLabel logo1_1;
    public javax.swing.JLabel logo1_2;
    public javax.swing.JLabel logo1_3;
    public javax.swing.JLabel logo1_4;
    public javax.swing.JLabel logo2_1;
    public javax.swing.JLabel logo2_2;
    public javax.swing.JLabel logo2_3;
    public javax.swing.JLabel logo2_4;
    public javax.swing.JButton logout_button_padministrativa;
    public javax.swing.JButton logout_button_quinela1;
    private javax.swing.JButton logout_ranking;
    public javax.swing.JRadioButton mostrar_button_administrativo;
    public javax.swing.JRadioButton mostrar_button_login;
    public javax.swing.JLabel p1;
    public java.awt.Panel panel1;
    public java.awt.Panel panel2;
    public java.awt.Panel panel3;
    public java.awt.Panel panel4;
    private javax.swing.JPanel pantalla_administrativa;
    public javax.swing.JTabbedPane pantallas;
    public javax.swing.JPasswordField password_field_administrativo;
    public javax.swing.JPasswordField password_field_login;
    public javax.swing.JTextField password_field_registrarse;
    public javax.swing.JLabel password_label_administrativo;
    public javax.swing.JLabel password_label_login;
    public javax.swing.JLabel password_label_registrarse;
    public javax.swing.JButton quienela_ranking;
    public javax.swing.JPanel quinela;
    public javax.swing.JLabel quinela_label_quinela1;
    public javax.swing.JLabel quinela_label_quinela3;
    public javax.swing.JPanel ranking;
    public javax.swing.JButton ranking_quinela;
    private javax.swing.JPanel registrar;
    public javax.swing.JButton registrar_button_registrarse;
    public javax.swing.JButton registrarse_button_login;
    public javax.swing.JLabel registrarse_label_registrarse;
    public javax.swing.JButton siguiente;
    public javax.swing.JButton sumar_button;
    public javax.swing.JTextField username_field_administrativo;
    public javax.swing.JTextField username_field_login;
    public javax.swing.JTextField username_field_registrarse;
    public javax.swing.JLabel username_label_administrativo;
    public javax.swing.JLabel username_label_login;
    public javax.swing.JLabel username_label_registrarse;
    // End of variables declaration//GEN-END:variables
}
