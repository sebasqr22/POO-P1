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

/**
 *
 * @author sebastianqr.2208
 */
public class Quinela extends javax.swing.JFrame {
    int estado_password = 0;
    private String usuario_global;
    boolean configuracionFinalizada = false;
    ManejadorArchivos manejadorArchivos = new ManejadorArchivos();
    String[] fases = {"Fase de Grupos", "8vos de Final", "4tos de Final", "Semifinal", "Final"};
    String[] grupos = {"A", "B", "C", "D", "E", "F", "G", "H"};
    Mundial mundial =new Mundial();
    ArrayList<String> fechas = mundial.fechas;
    ArrayList<java.awt.Panel> paneles= new ArrayList<>();
    ArrayList<Partido> todosLosPartidos = new ArrayList<>();
    
    int contadorFechas = 0;
    
    String ultimo_partido_consultado = "";
    /**
     * Creates new form Quinela
     */
    
    private void ocultarPaneles(){
        panel1.setVisible(false);
        panel2.setVisible(false);
        panel3.setVisible(false);
        panel4.setVisible(false);
    }
    private void cambiarQuinela(){
        if(this.contadorFechas < 0){
            this.contadorFechas = 21;
        }
        else if(this.contadorFechas > 21){
            this.contadorFechas = 0;
        }
        ocultarPaneles();
        
        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int c_aux = 0;
        
        
        for(Partido i: todosLosPartidos){
            
            try{
                if(i.date.equals(fecha)){
                System.out.println("PARTIDO: "+i.getLocal().pais+" VS "+i.getVisita().pais);
                System.out.println("C_AUX: "+c_aux);
                partidos[c_aux] = i;
                c_aux++;
                }
            }
            catch(NullPointerException e){
                
            }
            
        }
        
        c_aux = 0;
        for(Partido j : partidos){
            if(j != null){
               String local = j.local.pais.replace(" ", "_").replace("ñ", "n");
                String visita = j.visita.pais.replace(" ", "_").replace("ñ", "n");
                ImageIcon image1 = new ImageIcon("imagenes/escudos/" + local + ".png");
                ImageIcon image2 = new ImageIcon("imagenes/escudos/" + visita + ".png");

                if(c_aux == 0){
                    fecha_1.setText(j.date);
                    panel1.setVisible(true);
                    logo1_1.setIcon(image1);
                    logo2_1.setIcon(image2);
                    j.setResultadoLocal(combo1_1);
                    combo1_1.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_1);
                    combo2_1.setSelectedIndex(j.getGolVisita());
                    c_aux++; 
                }
                else if(c_aux == 1){
                    fecha_2.setText(j.date);
                    panel2.setVisible(true);
                    logo1_2.setIcon(image1);
                    logo2_2.setIcon(image2);
                    j.setResultadoLocal(combo1_2);
                    combo1_2.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_2);
                    combo2_2.setSelectedIndex(j.getGolVisita());
                    c_aux++; 
                }
                else if(c_aux == 2){
                    fecha_3.setText(j.date);
                    panel3.setVisible(true);
                    logo1_3.setIcon(image1);
                    logo2_3.setIcon(image2);
                    j.setResultadoLocal(combo1_3);
                    combo1_3.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_3);
                    combo2_3.setSelectedIndex(j.getGolVisita());
                    c_aux++; 
                }
                else{
                    fecha_4.setText(j.date);
                    panel4.setVisible(true);
                    logo1_4.setIcon(image1);
                    logo2_4.setIcon(image2);
                    j.setResultadoLocal(combo1_4);
                    combo1_4.setSelectedIndex(j.getGolLocal());
                    j.setResultadoVisita(combo2_4);
                    combo2_4.setSelectedIndex(j.getGolVisita());
                    c_aux++; 
                }
            }
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
                
                
            }
            
        }
        
        
    }
    
    private void crear_lista_goles(int maximo){
        for(int i=0; i<=maximo; i++){
            //resultado1_combo_quinela.addItem(String.valueOf(i));
            //resultado2_combo_quinela.addItem(String.valueOf(i));
        }
    }

    private void crear_fases(){
        //fase_combo_quinela.removeAllItems();
        for(String fase : fases){
           // fase_combo_quinela.addItem(fase);
        }
        //grupo_combo_quinela.removeAllItems();
        for(String i : grupos){
            //grupo_combo_quinela.addItem(i);
        }
    }

    private void set_partidos_grupos(String grupo){
       // partido_combo_quinela.removeAllItems();
        for(Partido partido : mundial.partidosPrimeraFase){
            try{
                String group = String.valueOf(partido.grupo);
                if(group.equals(grupo)){
                    //partido_combo_quinela.addItem(partido.local.pais + "-" + partido.visita.pais);
                }
            }catch (NullPointerException e){
                System.out.println("a");
            }

        }
    }

    private void cambiar_escudos(String e1, String e2){
        ImageIcon image1 = new ImageIcon("imagenes/escudos/" + e1 + ".png");
        ImageIcon image2 = new ImageIcon("imagenes/escudos/" + e2 + ".png");
        //escudo1.setIcon(image1);
        //escudo2.setIcon(image2);
    }

    private void seleccionar_escudos(String partido){
        if(partido != null){
            String[] equipos = partido.split("-");
            String e1 = equipos[0].replace(" ", "_").replace("ñ", "n");
            String e2 = equipos[1].replace(" ", "_").replace("ñ", "n");
            System.out.println(e1);
            System.out.println(e2);
            cambiar_escudos(e1.toLowerCase(), e2.toLowerCase());
        }

    }


    public Quinela() {
        mundial.init();
        mundial.primeraFase();
        //mundial.octavosDeFinal();
        //mundial.cuartosDeFinal();
        //mundial.finalMundial();
        initComponents();
    
        cambiar_escudos("senegal", "paises_bajos");
        ImageIcon logo = new ImageIcon("imagenes/escudos/costa_rica.png");
        ImageIcon logo2 = new ImageIcon("imagenes/escudos/alemania.png");
        //borrar_resultados();
        logo1_1.setIcon(logo);
        logo2_1.setIcon(logo2);
        logo1_3.setIcon(logo);
        crear_lista_goles(15);
        crear_fases();
        for (Partido partido : mundial.partidosPrimeraFase) {
            partido.setGenerarResultado(generarResultado_button_quinela);
        }
        todosLosPartidos = mundial.getTodos();
        cambiarQuinela();
        configuracionFinalizada = true;
        //mundial.partidosPrimeraFase[0].generarResultado();
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
        panel3 = new java.awt.Panel();
        logo1_3 = new javax.swing.JLabel();
        logo2_3 = new javax.swing.JLabel();
        fecha_3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo1_3 = new javax.swing.JComboBox<>();
        combo2_3 = new javax.swing.JComboBox<>();
        panel2 = new java.awt.Panel();
        logo1_2 = new javax.swing.JLabel();
        logo2_2 = new javax.swing.JLabel();
        fecha_2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo1_2 = new javax.swing.JComboBox<>();
        combo2_2 = new javax.swing.JComboBox<>();
        panel4 = new java.awt.Panel();
        logo1_4 = new javax.swing.JLabel();
        logo2_4 = new javax.swing.JLabel();
        fecha_4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo1_4 = new javax.swing.JComboBox<>();
        combo2_4 = new javax.swing.JComboBox<>();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGap(15, 15, 15))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(username_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                .addComponent(password_field_login, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(username_label_login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password_label_login)
                .addGap(316, 316, 316))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mostrar_button_login)
                .addGap(284, 284, 284))
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(acceder_button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(iniciar_label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarse_button_login)
                    .addComponent(administrativo_button_login))
                .addGap(15, 15, 15))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                .addComponent(password_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(registrarLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(username_label_registrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password_label_registrarse)
                .addGap(281, 281, 281))
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
                .addGap(14, 14, 14))
        );
        registrarLayout.setVerticalGroup(
            registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(registrarse_label_registrarse)
                .addGap(113, 113, 113)
                .addGroup(registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_field_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_label_registrarse)
                    .addComponent(password_label_registrarse))
                .addGap(90, 90, 90)
                .addComponent(registrar_button_registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(login_button_registrarse)
                .addContainerGap())
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

        logo1_1.setText("Logo 1");

        logo2_1.setText("Logo 2");

        fecha_1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_1.setForeground(new java.awt.Color(255, 255, 255));
        fecha_1.setText("22-11-2022");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VS");

        combo1_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        combo2_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(combo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(logo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(combo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(fecha_1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panel3.setBackground(new java.awt.Color(119, 32, 32));

        logo1_3.setText("Logo 1");

        logo2_3.setText("Logo 2");

        fecha_3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        fecha_3.setForeground(new java.awt.Color(255, 255, 255));
        fecha_3.setText("22-11-2022");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("VS");

        combo1_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        combo2_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(combo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(logo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(64, 64, 64)))
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addComponent(combo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fecha_3)
                .addGap(164, 164, 164))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(fecha_3)
                .addGap(18, 18, 18)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

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

        combo2_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(combo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(logo1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(70, 70, 70)))
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(combo2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(fecha_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
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

        combo2_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

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
                                .addComponent(fecha_4)
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
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(fecha_4)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

        javax.swing.GroupLayout quinelaLayout = new javax.swing.GroupLayout(quinela);
        quinela.setLayout(quinelaLayout);
        quinelaLayout.setHorizontalGroup(
            quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(generarResultado_button_quinela)
                .addGap(237, 237, 237)
                .addComponent(guardar_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(359, 359, 359))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout_button_quinela1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(quinelaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quinela_label_quinela1)
                .addGap(573, 573, 573))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(487, 487, 487))
        );
        quinelaLayout.setVerticalGroup(
            quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(quinelaLayout.createSequentialGroup()
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(quinelaLayout.createSequentialGroup()
                        .addComponent(quinela_label_quinela1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addGroup(quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quinelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(generarResultado_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guardar_button_quinela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logout_button_quinela1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
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
                    .addGroup(administrativoLayout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(administrativo_label_administrativo))
                    .addGroup(administrativoLayout.createSequentialGroup()
                        .addGap(457, 457, 457)
                        .addComponent(acceder_button_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(administrativo_button_administrativo))
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
                .addGap(54, 54, 54)
                .addComponent(acceder_button_administrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pantalla_administrativaLayout = new javax.swing.GroupLayout(pantalla_administrativa);
        pantalla_administrativa.setLayout(pantalla_administrativaLayout);
        pantalla_administrativaLayout.setHorizontalGroup(
            pantalla_administrativaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(administrativo_label_padministrativa)
                .addContainerGap(679, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantalla_administrativaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout_button_padministrativa)
                .addContainerGap())
        );
        pantalla_administrativaLayout.setVerticalGroup(
            pantalla_administrativaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantalla_administrativaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(administrativo_label_padministrativa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 762, Short.MAX_VALUE)
                .addComponent(logout_button_padministrativa)
                .addGap(17, 17, 17))
        );

        pantallas.addTab("tab5", pantalla_administrativa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pantallas, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantallas)
        );

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
        if(estado_password == 0){
            password_field_administrativo.setEchoChar((char)0);
            estado_password = 1;
        }else{
            password_field_administrativo.setEchoChar('*');
            estado_password = 0;
        }
    }//GEN-LAST:event_mostrar_button_administrativoActionPerformed

    private void acceder_button_administrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceder_button_administrativoActionPerformed
        // TODO add your handling code here:
        String username = username_field_administrativo.getText();
        String password = password_field_administrativo.getText();
        if(!username.equals("") && !password.equals("")){
            if(encontrar_usuario(username, password, true)){
                usuario_global = username;
                pantallas.setSelectedIndex(4);
                username_field_administrativo.setText("");
                password_field_administrativo.setText("");
            }
            else{
                JOptionPane.showMessageDialog(pantallas, "Este Administrador no Existe!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
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
        
        for(Partido i: todosLosPartidos){
            try{
                if(i.date.equals(fecha)){
                partidos[c_aux] = i;
                c_aux++;
                }
            }
            catch(NullPointerException e){
                
            }
            
        }
        c_aux = 0;
        for(Partido j : partidos){
            if(j != null){
                if(c_aux == 0){
                    j.setGolLocal(combo1_1.getSelectedIndex());
                    j.setGolVisita(combo2_1.getSelectedIndex());
                    c_aux++; 
                }
                else if(c_aux == 1){
                    j.setGolLocal(combo1_2.getSelectedIndex());
                    j.setGolVisita(combo2_2.getSelectedIndex());
                    c_aux++; 
                }
                else if(c_aux == 2){
                    j.setGolLocal(combo1_3.getSelectedIndex());
                    j.setGolVisita(combo2_3.getSelectedIndex());
                    c_aux++; 
                }
                else{
                    j.setGolLocal(combo1_4.getSelectedIndex());
                    j.setGolVisita(combo2_4.getSelectedIndex());
                    c_aux++; 
                }
            }
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
                
                
            }
            
        }
        
        c_aux=0;
        this.contadorFechas --;
        cambiarQuinela();
        System.out.println("CONTADOR----> " + this.contadorFechas);
    }//GEN-LAST:event_anteriorMouseReleased

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:

    }//GEN-LAST:event_none

    private void siguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseReleased
        // TODO add your handling code here:
        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int cont = 0;
        
        for(Partido i: todosLosPartidos){
            try{
                if(i.date.equals(fecha)){
                partidos[cont] = i;
                cont++;
                }
            }
            catch(NullPointerException e){
                
            }
            
        }
        cont = 0;
        for(Partido j : partidos){
            if(j != null){
                if(cont == 0){
                    j.setGolLocal(combo1_1.getSelectedIndex());
                    j.setGolVisita(combo2_1.getSelectedIndex());
                    cont++; 
                }
                else if(cont == 1){
                    j.setGolLocal(combo1_2.getSelectedIndex());
                    j.setGolVisita(combo2_2.getSelectedIndex());
                    cont++; 
                }
                else if(cont == 2){
                    j.setGolLocal(combo1_3.getSelectedIndex());
                    j.setGolVisita(combo2_3.getSelectedIndex());
                    cont++; 
                }
                else{
                    j.setGolLocal(combo1_4.getSelectedIndex());
                    j.setGolVisita(combo2_4.getSelectedIndex());
                    cont++; 
                }
            }
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
                
                
            }
            
        }
        cont=0;
        this.contadorFechas ++;
        cambiarQuinela();
        System.out.println("CONTADOR----> " + this.contadorFechas);
    }//GEN-LAST:event_siguienteMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //String fase=(String)fase_combo_quinela.getSelectedItem();

        String fecha = fechas.get(contadorFechas);
        Partido[] partidos = new Partido[4];
        int c_aux = 0;

        for(Partido i: todosLosPartidos){
            try{
                if(i.date.equals(fecha)){
                    partidos[c_aux] = i;
                    c_aux++;
                }
            }
            catch(NullPointerException e){

            }

        }

        for (Partido partido : partidos) {
            if(partido!=null){
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

        for(Partido i: todosLosPartidos){
            try{
                if(i.date.equals(fecha)){
                    partidos[c_aux] = i;
                    c_aux++;
                }
            }
            catch(NullPointerException e){

            }

        }

        for (Partido partido : partidos) {
            if(partido!=null){
                partido.generarResultado();
            }

        }

    }//GEN-LAST:event_generarResultado_button_quinelaActionPerformed

    private void guardar_button_quinelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_button_quinelaActionPerformed
        // TODO add your handling code here:
        
        Mundial aux=this.mundial;
        /*
        int cont=0;
        for(Partido p:todosLosPartidos){
            System.out.println("PARTIDO A GUARDAR: "+p.getLocal().pais+" VS "+p.getVisita().pais);
            System.out.println(p.getGolLocal()+" VS "+p.getGolVisita());
            System.out.println("DATE:  "+p.getDate());
            System.out.println("----------------------------------------------------");
            aux.getTodos().set(cont, p);
            cont++;
        }*/
        
        manejadorArchivos.guardarMundial(aux,todosLosPartidos, usuario_global);
    }//GEN-LAST:event_guardar_button_quinelaActionPerformed

    private void logout_button_quinela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_button_quinela1ActionPerformed
        // TODO add your handling code here:
        cerrar_sesion();
    }//GEN-LAST:event_logout_button_quinela1ActionPerformed

    private void login_button_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_button_registrarseActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(0);
    }//GEN-LAST:event_login_button_registrarseActionPerformed

    private void registrar_button_registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_button_registrarseActionPerformed
        // TODO add your handling code here:
        String username = username_field_registrarse.getText();
        String password = password_field_registrarse.getText();
        if(!username.equals("") && !password.equals("")){
            if(!revisa_usuario(username)){
                if(!username.contains(" ") && !username.contains("#") && !username.contains("-")){
                    if(!password.contains(" ")){
                        int opcion = JOptionPane.showConfirmDialog(pantallas, "Desea agregar al usuario -" + username + "- al sistema?");
                        switch (opcion){
                            case JOptionPane.YES_OPTION:
                            if(manejadorArchivos.crear_carpeta("archivos/" + username) == 0){
                                manejadorArchivos.asignarMundial(this.mundial,username,"",password);

                                escribir("archivos/usuarios.txt", "#" + username + "-" + password);
                                JOptionPane.showMessageDialog(pantallas,"Se agregó a -" + username + "- al sistema!");
                                username_field_login.setText(username);
                                password_field_login.setText(password);
                                pantallas.setSelectedIndex(0);
                                username_field_registrarse.setText("");
                                password_field_registrarse.setText("");
                            }
                            else{
                                JOptionPane.showMessageDialog(pantallas, "Ocurrio un Error!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                            case JOptionPane.NO_OPTION:
                            break;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(pantallas, "Esta Contraseña contiene Caractéres Inválidos (ESPACIO)!!!","ERROR!", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(pantallas, "Este Usuario contiene Caractéres Inválidos (# o - o ESPACIO)!!!","ERROR!", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(pantallas, "Este Nombre de Usuario ya existe, prueba con otro!!!","ERROR!", JOptionPane.WARNING_MESSAGE);
            }

        }
        else{
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registrar_button_registrarseActionPerformed

    private void administrativo_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrativo_button_loginActionPerformed
        // TODO add your handling code here:
        pantallas.setSelectedIndex(3);
    }//GEN-LAST:event_administrativo_button_loginActionPerformed

    private void mostrar_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_button_loginActionPerformed
        // TODO add your handling code here:
        if(estado_password == 0){
            password_field_login.setEchoChar((char)0);
            estado_password = 1;
        }else{
            password_field_login.setEchoChar('*');
            estado_password = 0;
        }
    }//GEN-LAST:event_mostrar_button_loginActionPerformed

    private void registrarse_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarse_button_loginActionPerformed
        pantallas.setSelectedIndex(1);
    }//GEN-LAST:event_registrarse_button_loginActionPerformed

    private void acceder_button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceder_button_loginActionPerformed
        // TODO add your handling code here:
        String username = username_field_login.getText();
        String password = String.valueOf(password_field_login.getPassword());

        if(!username.equals("") && !password.equals("")){
            if(encontrar_usuario(username, password, false)){
                usuario_global = username;
                System.out.println("Se encuentra el usuario");
                Mundial guardado=manejadorArchivos.buscarMundial(username);
                int cont=0;
                for (Partido p : todosLosPartidos) {
                    System.out.println("PARTIDO GUARDADO: "+
                            guardado.getTodos().get(cont).getLocal().pais+
                            " VS "+guardado.getTodos().get(cont).getVisita().pais);
                    
                    System.out.println(guardado.getTodos().get(cont).getGolLocal()+" VS "+guardado.getTodos().get(cont).getGolVisita());
                    p.setGolLocal(guardado.getTodos().get(cont).getGolLocal());
                    p.setGolVisita(guardado.getTodos().get(cont).getGolVisita());
                    cont++;
                }
                System.out.println("GUARDADA: "+this.mundial.getTodos().get(0).getGolLocal());
                cambiarQuinela();

                pantallas.setSelectedIndex(2);
                username_field_login.setText("");
                password_field_login.setText("");
            }
            else{
                JOptionPane.showMessageDialog(pantallas, "No se encontro a este usuario!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(pantallas, "Debe escribir un Usuario y una Constraseña!!!","ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceder_button_loginActionPerformed

    private void username_field_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_field_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_field_loginActionPerformed

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    private void escribir(String ruta, String data){
        String info = manejadorArchivos.leer(ruta);
        int escribir = manejadorArchivos.escribir(ruta, info + data);

        if(escribir == 1){
            JOptionPane.showMessageDialog(pantallas, "Ocurrio un error, intente de nuevo!!!!");
        }
    }

    private Boolean encontrar_usuario(String username, String password, Boolean admin){
        String todos;
        if(!admin){
            todos = manejadorArchivos.leer("archivos/usuarios.txt");
        }
        else{
            todos = manejadorArchivos.leer("archivos/admins.txt");
        }
        String[] usuarios = todos.split("#");
        String[] datos;

        for(String usuario : usuarios){
            if(!usuario.equals("")){
                datos = usuario.split("-");
                if(datos[0].equals(username) && datos[1].equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean revisa_usuario(String username){
        String todos = manejadorArchivos.leer("archivos/usuarios.txt");
        String[] usuarios = todos.split("#");
        String[] datos;

        for(String usuario : usuarios){
            if(!usuario.equals("")){
                datos = usuario.split("-");
                if(datos[0].equals(username)){
                    return true;
                }
            }
        }
        return false;
    }
    private void cerrar_sesion(){
        int opcion = JOptionPane.showConfirmDialog(pantallas, "Desea cerrar la sesión activa?");
        switch (opcion){
            case JOptionPane.YES_OPTION:
                usuario_global = null;
                pantallas.setSelectedIndex(0);

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
    private javax.swing.JButton acceder_button_administrativo;
    private javax.swing.JButton acceder_button_login;
    private javax.swing.JPanel administrativo;
    private javax.swing.JToggleButton administrativo_button_administrativo;
    private javax.swing.JToggleButton administrativo_button_login;
    private javax.swing.JLabel administrativo_label_administrativo;
    private javax.swing.JLabel administrativo_label_padministrativa;
    private javax.swing.JButton anterior;
    private javax.swing.JComboBox<String> combo1_1;
    private javax.swing.JComboBox<String> combo1_2;
    private javax.swing.JComboBox<String> combo1_3;
    private javax.swing.JComboBox<String> combo1_4;
    private javax.swing.JComboBox<String> combo2_1;
    private javax.swing.JComboBox<String> combo2_2;
    private javax.swing.JComboBox<String> combo2_3;
    private javax.swing.JComboBox<String> combo2_4;
    private javax.swing.JLabel fecha_1;
    private javax.swing.JLabel fecha_2;
    private javax.swing.JLabel fecha_3;
    private javax.swing.JLabel fecha_4;
    private javax.swing.JButton generarResultado_button_quinela;
    private javax.swing.JButton guardar_button_quinela;
    private javax.swing.JLabel iniciar_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel login;
    private javax.swing.JButton login_button_registrarse;
    private javax.swing.JLabel logo1_1;
    private javax.swing.JLabel logo1_2;
    private javax.swing.JLabel logo1_3;
    private javax.swing.JLabel logo1_4;
    private javax.swing.JLabel logo2_1;
    private javax.swing.JLabel logo2_2;
    private javax.swing.JLabel logo2_3;
    private javax.swing.JLabel logo2_4;
    private javax.swing.JButton logout_button_padministrativa;
    private javax.swing.JButton logout_button_quinela1;
    private javax.swing.JRadioButton mostrar_button_administrativo;
    private javax.swing.JRadioButton mostrar_button_login;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JPanel pantalla_administrativa;
    private javax.swing.JTabbedPane pantallas;
    private javax.swing.JPasswordField password_field_administrativo;
    private javax.swing.JPasswordField password_field_login;
    private javax.swing.JTextField password_field_registrarse;
    private javax.swing.JLabel password_label_administrativo;
    private javax.swing.JLabel password_label_login;
    private javax.swing.JLabel password_label_registrarse;
    private javax.swing.JPanel quinela;
    private javax.swing.JLabel quinela_label_quinela1;
    private javax.swing.JPanel registrar;
    private javax.swing.JButton registrar_button_registrarse;
    private javax.swing.JButton registrarse_button_login;
    private javax.swing.JLabel registrarse_label_registrarse;
    private javax.swing.JButton siguiente;
    private javax.swing.JTextField username_field_administrativo;
    private javax.swing.JTextField username_field_login;
    private javax.swing.JTextField username_field_registrarse;
    private javax.swing.JLabel username_label_administrativo;
    private javax.swing.JLabel username_label_login;
    private javax.swing.JLabel username_label_registrarse;
    // End of variables declaration//GEN-END:variables
}
