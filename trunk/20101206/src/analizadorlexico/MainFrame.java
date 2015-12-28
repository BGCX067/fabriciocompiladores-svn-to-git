/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 12/11/2010, 12:40:25 AM
 */
package analizadorlexico;

import analizador.sintactico.ErrorSintaxis;
import analizador.sintactico.Gramatica;
import analizador.lexico.Lexico;
import analizador.lexico.AnalizadorLexico;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.undo.UndoManager;

/**
 *
 * @author fabricio
 */
public class MainFrame extends javax.swing.JFrame {

    int num = 0;

    /** Creates new form MainFrame */
    public MainFrame() throws UnsupportedLookAndFeelException {
        initComponents();
        setLocationRelativeTo(null);
        BarraHorizontal bj = new BarraHorizontal();
        this.txtEntrada.setEditorKit(bj);

        this.txtNum.append(num + "\n");

        pielmac();
        nombre = null;
        documento = new DefaultStyledDocument();
        txtEntrada.setDocument(documento);
        txtEntrada.setDragEnabled(true);
        txtEntrada.requestFocus();
        documento.addDocumentListener(docList);
        undo = new UndoManager();
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivo Compilador Grupo 3 (*.cmp)", "cmp"));
        documento.addUndoableEditListener(undo);

        docList = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent t) {
                cambios = true;
            }

            @Override
            public void removeUpdate(DocumentEvent t) {
                cambios = true;
            }

            @Override
            public void changedUpdate(DocumentEvent t) {
                //	System.out.println(undo.getUndoPresentationName());
                //	System.out.println(undo.getRedoPresentationName());
            }
        };
        documento.addDocumentListener(docList);

    }

    public void pielmac() throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            SwingUtilities.updateComponentTreeUI(MainFrame.this);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextPane();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnRedo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtBuild = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNum = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menNuevo = new javax.swing.JMenuItem();
        menAbrir = new javax.swing.JMenuItem();
        menGuardar = new javax.swing.JMenuItem();
        menGuardarcomo = new javax.swing.JMenuItem();
        menSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menDeshacer = new javax.swing.JMenuItem();
        menRehacer = new javax.swing.JMenuItem();
        menCopiar = new javax.swing.JMenuItem(new DefaultEditorKit.CopyAction());
        menCortar = new javax.swing.JMenuItem(new DefaultEditorKit.CutAction());
        menPegar = new javax.swing.JMenuItem(new DefaultEditorKit.PasteAction());
        jMenu3 = new javax.swing.JMenu();
        menEjecutar = new javax.swing.JMenuItem();
        menCompilar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico Grupo 3");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tokens", "Lexema"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        txtEntrada.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEntradaCaretUpdate(evt);
            }
        });
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtEntrada);

        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlexico/imagenes/nuevo.gif"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(40, 40));
        btnNuevo.setMinimumSize(new java.awt.Dimension(40, 40));
        btnNuevo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlexico/imagenes/abrir.png"))); // NOI18N
        btnAbrir.setToolTipText("Abrir");
        btnAbrir.setFocusable(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setMaximumSize(new java.awt.Dimension(40, 40));
        btnAbrir.setMinimumSize(new java.awt.Dimension(40, 40));
        btnAbrir.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlexico/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMaximumSize(new java.awt.Dimension(40, 40));
        btnGuardar.setMinimumSize(new java.awt.Dimension(40, 40));
        btnGuardar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlexico/imagenes/deshacer.png"))); // NOI18N
        btnUndo.setToolTipText("Deshacer");
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUndo.setMaximumSize(new java.awt.Dimension(40, 40));
        btnUndo.setMinimumSize(new java.awt.Dimension(40, 40));
        btnUndo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUndo);

        btnRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analizadorlexico/imagenes/rehacer.png"))); // NOI18N
        btnRedo.setToolTipText("Rehacer");
        btnRedo.setFocusable(false);
        btnRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRedo.setMaximumSize(new java.awt.Dimension(40, 40));
        btnRedo.setMinimumSize(new java.awt.Dimension(40, 40));
        btnRedo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRedo);

        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane4.setViewportView(txtOutput);

        jTabbedPane1.addTab("Output", jScrollPane4);

        txtBuild.setColumns(20);
        txtBuild.setRows(5);
        jScrollPane5.setViewportView(txtBuild);

        jTabbedPane1.addTab("Build", jScrollPane5);

        txtNum.setColumns(20);
        txtNum.setRows(5);
        jScrollPane3.setViewportView(txtNum);

        jMenu1.setText("Archivo");

        menNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menNuevo.setText("Nuevo");
        menNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menNuevo);

        menAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menAbrir.setText("Abrir");
        menAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menAbrir);

        menGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menGuardar.setText("Guardar");
        menGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(menGuardar);

        menGuardarcomo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menGuardarcomo.setText("Guardar como");
        menGuardarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menGuardarcomoActionPerformed(evt);
            }
        });
        jMenu1.add(menGuardarcomo);

        menSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menSalir.setText("Salir");
        menSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        menDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menDeshacer.setText("Deshacer");
        menDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menDeshacerActionPerformed(evt);
            }
        });
        jMenu2.add(menDeshacer);

        menRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menRehacer.setText("Rehacer");
        menRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRehacerActionPerformed(evt);
            }
        });
        jMenu2.add(menRehacer);

        menCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menCopiar.setText("Copiar");
        jMenu2.add(menCopiar);

        menCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menCortar.setText("Cortar");
        menCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCortarActionPerformed(evt);
            }
        });
        jMenu2.add(menCortar);

        menPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menPegar.setText("Pegar");
        jMenu2.add(menPegar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ejecutar");

        menEjecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.SHIFT_MASK));
        menEjecutar.setText("Ejecutar");
        menEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menEjecutarActionPerformed(evt);
            }
        });
        jMenu3.add(menEjecutar);

        menCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, java.awt.event.InputEvent.SHIFT_MASK));
        menCompilar.setText("Compilar");
        menCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCompilarActionPerformed(evt);
            }
        });
        jMenu3.add(menCompilar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                        .add(30, 30, 30))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 461, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 397, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 313, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane2, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Build");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenadoTabla() {
        analizadorLexico = new AnalizadorLexico();
        analizadorLexico.crearTokens(txtEntrada.getText());
        lista = analizadorLexico.getLexicos();

        Object datos[][] = new Object[lista.size()][2];
        for (int i = 0; i < datos.length; i++) {
            datos[i][0] = lista.get(i).getToken();
            datos[i][1] = lista.get(i).getLexema();
        }
        tabla.setModel(new DefaultTableModel(
                datos,
                new String[]{
                    "Tokens", "Lexema"
                }));

    }

    private void txtEntradaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEntradaCaretUpdate
        llenadoTabla();
    }//GEN-LAST:event_txtEntradaCaretUpdate

    private void menNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_menNuevoActionPerformed

    public void nuevo() {
        if (tieneCambios() == true) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea Guardar Los Cambios?");
            if (i == JOptionPane.OK_OPTION) {
                if (nombre == null) {
                    guardarComo();
                } else {
                    guardar();
                }
            }
        }
        txtEntrada.setText("");
        cambios = false;
        nombre = null;
        undo.discardAllEdits();
        this.txtEntrada.requestFocus();
        this.setTitle("Analizador Lexico Grupo 3");

    }

    private void guardar() {
        if (nombre == null) {
            guardarComo();
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));
                txtEntrada.write(bw);
                bw.close();
                cambios = false;
                setTitle(chooser.getSelectedFile().getName() + "-Analizador Lexico Grupo 3");


            } catch (IOException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Se ha producido un error");

            }
        }
    }

    public void guardarComo() {
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String filtro = "";
            if (chooser.getFileFilter() != chooser.getAcceptAllFileFilter()) {
                filtro = "." + ((FileNameExtensionFilter) chooser.getFileFilter()).getExtensions()[0];
            }
            nombre = chooser.getSelectedFile().getAbsolutePath() + filtro;
            this.guardar();
        }
    }

    public boolean abrir(String nombre) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombre));
            String texto = "";
            String linea = "";
            do {
                texto += linea;
                linea = br.readLine();
            } while (linea != null);

            br.close();
            txtEntrada.setText(texto);
            txtEntrada.getDocument().addDocumentListener(docList);
            cambios = false;
            this.nombre = nombre;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        actualizar();
        undo.discardAllEdits();
        return true;
    }

    private void abrir() {
        if (tieneCambios()) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea Guardar Los Cambios?");
            if (i == JOptionPane.OK_OPTION) {
                if (nombre == null) {
                    guardarComo();
                } else {
                    guardar();
                }
            }
        }
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (abrir(chooser.getSelectedFile().getAbsolutePath())) {
                setTitle(chooser.getSelectedFile().getName() + "-Analizador Lexico Grupo 3");
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        }
    }

    private void actualizarColores() {
        Integer idx = 0;
        for (Lexico lexico : lista) {

            MutableAttributeSet attributes = new SimpleAttributeSet();
            idx = txtEntrada.getText().indexOf(lexico.getLexema(), idx);
            AnalizadorLexico.TOKEN token = lexico.getToken();
            Color color = Color.BLACK;
            switch (token) {
                case IDENTIFICADOR:
                    color = Color.BLACK;
                    break;
                case RESERVADA:
                    color = Color.BLUE;
                    StyleConstants.setBold(attributes, true);
                    break;
                case NUMERO:
                case NOTACION_CIENTIFICA:
                    color = Color.GREEN;
                    break;
                case OPERACION:
                    color = Color.ORANGE.darker();
                    StyleConstants.setBold(attributes, true);
                    break;
                case ERROR:
                    color = Color.RED;
                    //StyleConstants.setUnderline(attributes, true);
                    break;
                default:
                    color = Color.BLACK;
            }
            StyleConstants.setForeground(attributes, color);
            txtEntrada.getStyledDocument().setCharacterAttributes(
                    idx,
                    lexico.getLexema().length(),
                    attributes, true);
        }
    }

    public void guardaFilas() {
        filas = new Vector<String>();
        StringTokenizer st = new StringTokenizer(txtEntrada.getText(), "\n");
        while (st.hasMoreTokens()) {
            filas.add(st.nextToken());
        }
    }

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyPressed
        llenadoTabla();
        actualizarColores();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            num++;
            txtNum.append(num + "\n");
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            guardaFilas();
            txtNum.setText("");
            num = 0;
            for (String s : filas) {
                txtNum.append(num + "\n");
                num++;
            }
            if (txtEntrada.getText().equals("")) {
                txtNum.append(0 + "\n");
            }
        }
    }//GEN-LAST:event_txtEntradaKeyPressed

    public String imprimirErrores() {
        String e = "";
        for (int i = 0; i < errores.size(); i++) {
            ErrorSintaxis z = (ErrorSintaxis) errores.get(i);
            e = e + z.getDescripcion() + "\n";
        }
        return e;
    }

    private void compilar() {
        if (lista.isEmpty() == false) {
            Gramatica g = new Gramatica((ArrayList<Lexico>) lista);
            errores = g.analiza();
            if (errores.isEmpty()) {
                this.txtBuild.setText("No hay errores");
            } else {
                this.txtBuild.setText(imprimirErrores());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay nada para compilar");
        }
    }

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        if (undo.canUndo()) {
            undo.undo();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede deshacer");
        }
    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedoActionPerformed
        if (undo.canRedo()) {
            undo.redo();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede rehacer");
        }
    }//GEN-LAST:event_btnRedoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void menGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_menGuardarActionPerformed

    private void menGuardarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menGuardarcomoActionPerformed
        guardarComo();
    }//GEN-LAST:event_menGuardarcomoActionPerformed

    private void menAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAbrirActionPerformed
        abrir();
    }//GEN-LAST:event_menAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void menDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menDeshacerActionPerformed
        if (undo.canUndo()) {
            undo.undo();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede deshacer");
        }
    }//GEN-LAST:event_menDeshacerActionPerformed

    private void menRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRehacerActionPerformed
        if (undo.canRedo()) {
            undo.redo();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede rehacer");
        }
    }//GEN-LAST:event_menRehacerActionPerformed

    private void menCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCortarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menCortarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        abrir();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void menSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSalirActionPerformed
        if (tieneCambios() == true) {
            int i = JOptionPane.showConfirmDialog(this, "¿Desea Guardar Los Cambios?");
            if (i == JOptionPane.OK_OPTION) {
                if (nombre == null) {
                    guardarComo();
                } else {
                    guardar();
                }
                System.exit(0);
            } else {
                System.exit(0);
            }

        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_menSalirActionPerformed

    private void menCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCompilarActionPerformed
        this.jTabbedPane1.setSelectedIndex(1);
        compilar();
    }//GEN-LAST:event_menCompilarActionPerformed

    private void menEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menEjecutarActionPerformed
        compilar();
        if (lista.isEmpty() == false) {
            if (errores.isEmpty()) {
                this.jTabbedPane1.setSelectedIndex(0);
                this.txtOutput.setText("No hay errores");
            } else {
                JOptionPane.showMessageDialog(this, "El programa tiene errores");
                this.jTabbedPane1.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_menEjecutarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private boolean tieneCambios() {
        return cambios;
    }

    private void actualizar() {
        analizadorLexico = new AnalizadorLexico();
        analizadorLexico.crearTokens(txtEntrada.getText());
        lista = analizadorLexico.getLexicos();
        Object datos[][] = new Object[lista.size()][2];
        for (int i = 0; i < datos.length; i++) {
            datos[i][0] = lista.get(i).getToken();
            datos[i][1] = lista.get(i).getLexema();
        }
        tabla.setModel(new DefaultTableModel(
                datos,
                new String[]{
                    "Tokens", "Lexema"
                }));

        actualizarColores();


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRedo;
    private javax.swing.JButton btnUndo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menAbrir;
    private javax.swing.JMenuItem menCompilar;
    private javax.swing.JMenuItem menCopiar;
    private javax.swing.JMenuItem menCortar;
    private javax.swing.JMenuItem menDeshacer;
    private javax.swing.JMenuItem menEjecutar;
    private javax.swing.JMenuItem menGuardar;
    private javax.swing.JMenuItem menGuardarcomo;
    private javax.swing.JMenuItem menNuevo;
    private javax.swing.JMenuItem menPegar;
    private javax.swing.JMenuItem menRehacer;
    private javax.swing.JMenuItem menSalir;
    private javax.swing.JTable tabla;
    private javax.swing.JTextArea txtBuild;
    private javax.swing.JTextPane txtEntrada;
    private javax.swing.JTextArea txtNum;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
    AnalizadorLexico analizadorLexico;
    private DocumentListener docList;
    private DefaultStyledDocument documento;
    private UndoManager undo;
    private boolean cambios;
    private JFileChooser chooser;
    String nombre;
    List<Lexico> lista;
    ArrayList errores;
    Vector<String> filas;
}
