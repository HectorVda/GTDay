/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtday;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * JFrame principal del proyecto
 *
 * @author Hector Valentin <hectorvda@gmail.com>
 */
public class GTDay extends javax.swing.JFrame {

    private ArrayList<Proyecto> proyectos;
    private int index;
    private AbstractTableModel tableModel;

    /**
     * Creates new form GTDay
     */
    public GTDay() {
        initComponents();
        inicializar();
    }

    /**
     * Se encarga de arrancar el programa iniciando correctamente los datos ya
     * sea desde cero o desde un archivo anterior del usuario
     */
    private void inicializar() {
        index = 0;
        boolean cargado=false;
        JDIniciar jdi = new JDIniciar(this, true);
        jdi.setVisible(true);
        if (jdi.getOpcion() == 0) {
            this.proyectos = new ArrayList<>();
            JDNuevoProyecto jdnp = new JDNuevoProyecto(this, true);
            jdnp.disableCandelar();
            jdnp.setVisible(true);
            if (jdnp.haPulsadoAceptar()) {
                this.proyectos.add(new Proyecto(jdnp.getNombre()));
            } else {
                JOptionPane.showMessageDialog(this, "ATENCIÓN: para poder usar esta aplicación debe de crear un proyecto o cargar una cuenta", null, JOptionPane.ERROR_MESSAGE);
            }

        } else {
            cargado=cargar();
        }
        //Una vez cargados los datos modificamos la etiqueta del nombre de Proyecto
        if (cargado && !this.proyectos.isEmpty()) {
            jLproyecto.setText(this.proyectos.get(index).getNombre());
            rellenarTabla();
        }

    }
    /**
     * Se encarga de rellenar el modelo de la Tabla indicada
     */
    private void rellenarTabla(){
        jBMSEstado.setEnabled(true);
        switch(jCBEstado.getSelectedIndex()){
            case 0:
                tableModel = new TableModel(this.proyectos.get(index).getEspera());
                break;
            case 1:
                tableModel = new TableModel(this.proyectos.get(index).getProximo());
                break;
            case 2:
                tableModel = new TableModel(this.proyectos.get(index).getHaciendo());
                break;
            case 3:
                tableModel = new TableModel(this.proyectos.get(index).getHecho());
                jBMSEstado.setEnabled(false);
                break;
        }
        jTabla.setModel(tableModel);
        jTabla.updateUI();
    }

    /**
     * Este método se encarga de cargar correctamente los datos a partir de un
     * fichero origen indicado por el usuario
     *
     * @return true si los datos han sido correctamente guardados || false en
     * caso de excepción
     */
    private boolean cargar() {
        int opcion;
        boolean cargado = true;
        JFileChooser jfc = new JFileChooser();
        opcion = jfc.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = jfc.getSelectedFile();
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
                this.proyectos = (ArrayList<Proyecto>) ois.readObject();
                if (this.proyectos.size() > 1) {
                    elegirProyecto();
                }
            } catch (IOException | ClassNotFoundException e) {
                cargado = false;
                JOptionPane.showMessageDialog(this, "Error en la carga, archivo corrupto", null, JOptionPane.ERROR_MESSAGE);
            }

        }
        return cargado;
    }

    /**
     * Este método se encarga de gestionar qué proyecto de todos los cargados es
     * el deseado por el usuario para trabajar en ese instante
     */
    private void elegirProyecto() {
        
    }

    /**
     * Este método se encarga del guardado de los objetos en un fichero de datos
     * elegido por el usuario
     */
    private void guardar() {
        int opcion;
        JFileChooser jfc = new JFileChooser();
        opcion = jfc.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = jfc.getSelectedFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
                oos.writeObject(this.proyectos);
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAdd = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPEspera = new javax.swing.JPanel();
        jBMSEstado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jPProximo = new javax.swing.JPanel();
        jPHaciendo = new javax.swing.JPanel();
        jPHecho = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLproyecto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCBEstado = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GTDay");

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gtday/añadir.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gtday/editar.png"))); // NOI18N
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gtday/eliminar.png"))); // NOI18N

        jLayeredPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLayeredPane2.setLayout(new java.awt.CardLayout());

        jBMSEstado.setText("Mover tarea al siguiente estado");

        jTabla.setAutoCreateRowSorter(true);
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "",  new Boolean(false), null},
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título", "Fecha límite", "Subtareas", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabla);

        javax.swing.GroupLayout jPEsperaLayout = new javax.swing.GroupLayout(jPEspera);
        jPEspera.setLayout(jPEsperaLayout);
        jPEsperaLayout.setHorizontalGroup(
            jPEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEsperaLayout.createSequentialGroup()
                        .addComponent(jBMSEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPEsperaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        jPEsperaLayout.setVerticalGroup(
            jPEsperaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEsperaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jBMSEstado)
                .addContainerGap())
        );

        jLayeredPane2.add(jPEspera, "card4");

        javax.swing.GroupLayout jPProximoLayout = new javax.swing.GroupLayout(jPProximo);
        jPProximo.setLayout(jPProximoLayout);
        jPProximoLayout.setHorizontalGroup(
            jPProximoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPProximoLayout.setVerticalGroup(
            jPProximoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        jLayeredPane2.add(jPProximo, "card3");

        javax.swing.GroupLayout jPHaciendoLayout = new javax.swing.GroupLayout(jPHaciendo);
        jPHaciendo.setLayout(jPHaciendoLayout);
        jPHaciendoLayout.setHorizontalGroup(
            jPHaciendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPHaciendoLayout.setVerticalGroup(
            jPHaciendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        jLayeredPane2.add(jPHaciendo, "card2");

        javax.swing.GroupLayout jPHechoLayout = new javax.swing.GroupLayout(jPHecho);
        jPHecho.setLayout(jPHechoLayout);
        jPHechoLayout.setHorizontalGroup(
            jPHechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPHechoLayout.setVerticalGroup(
            jPHechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        jLayeredPane2.add(jPHecho, "card6");

        jLproyecto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLproyecto.setText("Proyecto");
        jPanel1.add(jLproyecto);

        jLabel3.setText("Estado:");
        jPanel2.add(jLabel3);

        jCBEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Espera", "Proximo", "Haciendo", "Hecho" }));
        jCBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBEstadoActionPerformed(evt);
            }
        });
        jPanel2.add(jCBEstado);

        jMenu1.setText("Archivo");

        jMenuItem3.setText("Nuevo Proyecto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Cambiar Proyecto");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cuenta");

        jMenuItem1.setText("Crear Cuenta");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Cambiar Cuenta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBEstadoActionPerformed
      rellenarTabla();
    }//GEN-LAST:event_jCBEstadoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JDNuevoProyecto jdnp = new JDNuevoProyecto(this, true);
        jdnp.setVisible(true);
        //Si ha pulsado aceptar, añade un proyecto a la lista con el nombre indicado
        if (jdnp.haPulsadoAceptar()) {
            this.proyectos.add(new Proyecto(jdnp.getNombre()));
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        JDNuevaTarea jdnt = new JDNuevaTarea(this, true);
        jdnt.setVisible(true);
        //Si ha pulsado aceptar se añadirá la tarea creada al estado actual
        if (jdnt.haPulsadoAceptar()) {
            switch (jCBEstado.getSelectedIndex()) {
                case 0:
                    this.proyectos.get(index).addEspera(jdnt.getTarea());
                    break;
                case 1:
                    this.proyectos.get(index).addProximo(jdnt.getTarea());
                    break;
                case 2:
                    this.proyectos.get(index).addHaciendo(jdnt.getTarea());
                    break;
                case 3:
                    this.proyectos.get(index).addHecho(jdnt.getTarea());
                    break;
            }
        }
        rellenarTabla();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        guardar();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(GTDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GTDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GTDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GTDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GTDay gtday = new GTDay();
                gtday.setVisible(true);
                gtday.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    class TableModel extends AbstractTableModel {

        ArrayList<Tarea> datos;

        public TableModel(ArrayList<Tarea> param) {
            datos=param;
        }

        @Override
        public int getRowCount() {
            return datos.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int i, int i1) {
            Object devuelto=null;
            switch(i1){
                case 0:
                    devuelto=datos.get(i).getTitulo();
                    break;
                case 1:
                    devuelto=datos.get(i).getFecha_Limite();
                    break;
                case 2:
                    if(datos.get(i).getSubtareas()==null){
                        devuelto=false;
                    }else{
                        devuelto=datos.get(i).getSubtareas().size()>0;
                    }
                    break;
                case 3:
                    devuelto=datos.get(i).getDescripcion();
                    break;
            }
            return devuelto;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBMSEstado;
    private javax.swing.JComboBox jCBEstado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel jLproyecto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPEspera;
    private javax.swing.JPanel jPHaciendo;
    private javax.swing.JPanel jPHecho;
    private javax.swing.JPanel jPProximo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
}
