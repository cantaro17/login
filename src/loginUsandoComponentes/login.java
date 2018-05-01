/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginUsandoComponentes;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jhon
 */
public class login extends JFrame implements Runnable {

    //contenedores
    JPanel form;

    //componentes

    JTextField txtuser, txtverificar;
    JTextArea txterror, txtvacio;
    JPasswordField password;
    JComboBox<Object> combobox;
    JLabel etiqueta;
    Icon imagenfondo1, imagenfondo2, iconcabecera, iconuser, iconpassword, iconselect, iconverificar, iconingresar, iconvacio, iconerror;
    JLabel lbfondo, lbsistema, lbverificar, lbuniversidad, lbautor;
    JLabel iconUser, iconPass, iconSelect, iconConfirm;
    JButton btningresar;
    Separator separador_superior, separador_inferior;

    //componentes para captcha
    JLabel lbfondoverificar, lb1, lb2, lb3, lb4, lb5, lb6, lbvacio, lberror;
    Random aleatorio = new Random();

    //placeholder
    PlaceHolder phuser, phpass, phver;

    //cambio de imagen
    Calendar calendario;
    Thread h1;

    float x_frame, x_form_frame = 1366, width_frame;
    float x_form, width_form;

    String texto_vacio = "";
    int alturaTransparente = 502;
    int alturaVacio = 385;

    int validarCaptcha;
    int t1, t2, t3;
    String texto_user, texto_password, texto_verificar;
    String codigo;
    String[] lines;

    int altura_btningresar = 385;
    int altura_lbvacio = 0;

    int altura_separador1 = 445;
    int altura_lbuniversidad = 455;
    int altura_lbautor = 475;

    public login() {

        setSize(1366, 768);
        setLayout(null);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(460, 768));

        imagenfondo1 = new ImageIcon(getClass().getResource("primero.jpg"));
        imagenfondo2 = new ImageIcon(getClass().getResource("segundo.jpg"));
        h1 = new Thread((Runnable) this);
        h1.start();

        lbfondo = new JLabel();
        lbfondo.setBounds(0, 0, 1366, 768);
        lberror = new JLabel();
        lbvacio = new JLabel();
        lbvacio.setOpaque(true);
        lbvacio.setBackground(new Color(236, 0, 0, 20));

        lbsistema = new JLabel("Sistema de Gestión Académica");
        lbsistema.setForeground(Color.WHITE);
        lbsistema.setFont(new Font("Calibri", Font.PLAIN, 25));
        form = new JPanel();
        form.setLayout(null);
        form.setBackground(new Color(243, 250, 248, 220));

        iconcabecera = new ImageIcon(getClass().getResource("iconcabecera.png"));
        etiqueta = new JLabel("Iniciar Sesión");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 25));
        etiqueta.setForeground(new Color(61, 131, 203));
        etiqueta.setIcon(iconcabecera);
        form.add(etiqueta);

        separador_superior = new Separator();
        separador_superior.setBackground(new Color(221, 216, 219));
        form.add(separador_superior);

        iconuser = new ImageIcon(getClass().getResource("iconUser.png"));
        iconUser = new JLabel();
        iconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconUser.setOpaque(true);
        iconUser.setBackground(new Color(231, 236, 233));
        iconUser.setIcon(iconuser);
        iconUser.setHorizontalAlignment(0);
        txtuser = new JTextField();
        phuser = new PlaceHolder(txtuser, new Color(161, 154, 155), new Color(101, 102, 99), "Usuario", false, "SansSerif", 17);
        form.add(iconUser);
        form.add(txtuser);

        iconpassword = new ImageIcon(getClass().getResource("iconpassword.png"));
        iconPass = new JLabel();
        iconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconPass.setOpaque(true);
        iconPass.setBackground(new Color(231, 236, 233));
        iconPass.setIcon(iconpassword);
        iconPass.setHorizontalAlignment(0);
        password = new JPasswordField();
        phpass = new PlaceHolder(password, new Color(161, 154, 155), new Color(101, 102, 99), "Contraseña", false, "SansSerif", 17);
        password.setEchoChar((char) 0);
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (password.getForeground().equals(new Color(101, 102, 99))) {
                    password.setEchoChar('*');
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (password.getText().length() == 0) {
                    password.setEchoChar((char) 0);
                }
            }
        });
        form.add(iconPass);
        form.add(password);

        iconselect = new ImageIcon(getClass().getResource("iconselect.png"));
        iconSelect = new JLabel();
        iconSelect.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconSelect.setOpaque(true);
        iconSelect.setBackground(new Color(231, 236, 233));
        iconSelect.setIcon(iconselect);
        iconSelect.setHorizontalAlignment(0);
        combobox = new JComboBox<>();
        combobox.setFont(new Font("SansSerif", Font.PLAIN, 15));
        combobox.setForeground(new Color(101, 102, 99));
        combobox.addItem("Alumno");
        combobox.addItem("Docente");
        combobox.addItem("Funcionario");
        combobox.addItem("Egresado");
        form.add(combobox);
        form.add(iconSelect);

        lbverificar = new JLabel();
        lbverificar.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.GRAY));
        form.add(lbverificar);

        String letra;
        letra = "0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T X Y Z";
        String arrayletra[] = letra.split(" ");
        //captcha

        lb1 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb1.setBounds((int) (125 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb1.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb1.setForeground(new Color(36, 179, 150));

        lb2 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb2.setBounds((int) (145 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb2.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb2.setForeground(new Color(36, 179, 150));

        lb3 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb3.setBounds((int) (165 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb3.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb3.setForeground(new Color(36, 179, 150));

        lb4 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb4.setBounds((int) (185 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb4.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb4.setForeground(new Color(36, 179, 150));

        lb5 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb5.setBounds((int) (205 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb5.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb5.setForeground(new Color(36, 179, 150));

        lb6 = new JLabel(arrayletra[aleatorio.nextInt(32)]);
        lb6.setBounds((int) (225 - x_form), 250 + aleatorio.nextInt(15), 25, 60);
        lb6.setFont(new Font("SansSerif", Font.BOLD, 24));
        lb6.setForeground(new Color(36, 179, 150));

        form.add(lb1);
        form.add(lb2);
        form.add(lb3);
        form.add(lb4);
        form.add(lb5);
        form.add(lb6);

        lbfondoverificar = new JLabel();
        lbfondoverificar.setIcon(new ImageIcon(getClass().getResource("imagecaptcha.png")));
        lbfondoverificar.setToolTipText("Codigo de Verificacion");
        form.add(lbfondoverificar);
        //fin captcha

        iconverificar = new ImageIcon(getClass().getResource("iconcodigo.png"));
        iconConfirm = new JLabel();
        iconConfirm.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, Color.GRAY));
        iconConfirm.setOpaque(true);
        iconConfirm.setBackground(new Color(231, 236, 233));
        iconConfirm.setIcon(iconverificar);
        iconConfirm.setHorizontalAlignment(0);
        txtverificar = new JTextField();
        phver = new PlaceHolder(txtverificar, new Color(161, 154, 155), new Color(101, 102, 99), "Cod. Verificacion", false, "SansSerif", 17);
        txtverificar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (txtverificar.getText().length() == 6) {
                    ke.consume();
                }
            }
        });
        form.add(iconConfirm);
        form.add(txtverificar);

        iconingresar = new ImageIcon(getClass().getResource("iconingresar.png"));
        btningresar = new JButton("Ingresar");
        btningresar.setFont(new Font("inherit", Font.BOLD, 16));
        btningresar.setBackground(new Color(51, 119, 177));
        btningresar.setForeground(Color.WHITE);
        btningresar.setHorizontalTextPosition(2);
        btningresar.setIcon(iconingresar);
        form.add(btningresar);

        separador_inferior = new Separator();
        separador_inferior.setBackground(new Color(221, 216, 219));
        form.add(separador_inferior);

        lbuniversidad = new JLabel("Universidad Nacional Agraria de la Selva");
        lbuniversidad.setForeground(new Color(63, 131, 210));
        form.add(lbuniversidad);

        lbautor = new JLabel("Hecho por: programmer");
        lbautor.setForeground(new Color(63, 131, 210));
        form.add(lbautor);

        add(form);
        add(lbfondo);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                width_frame = getWidth();
                x_frame = (float) ((x_form_frame - width_frame) * 0.51);

                lbsistema.setBounds((int) (525 - x_frame), 50, 370, 50);
                form.setBounds((int) (498 - x_frame), 100, 370, alturaTransparente);

                width_form = form.getWidth();
                x_form = (float) ((498 - width_form) * 0.05);
                etiqueta.setBounds((int) (100 - x_form), 20, 299, 30);
                separador_superior.setBounds((int) (0 - x_form), 70, form.getWidth() + 10, 2);
                iconUser.setBounds((int) (27 - x_form), 85, 50, 39);
                txtuser.setBounds((int) (77 - x_form), 85, form.getWidth() - 90, 39);
                iconPass.setBounds((int) (27 - x_form), 140, 50, 39);
                password.setBounds((int) (77 - x_form), 140, form.getWidth() - 90, 39);
                iconSelect.setBounds((int) (27 - x_form), 200, 50, 39);
                combobox.setBounds((int) (77 - x_form), 200, form.getWidth() - 90, 39);
                lbverificar.setBounds((int) (27 - x_form), 255, form.getWidth() - 40, 60);

                lbfondoverificar.setBounds((int) (122 - x_form), 255, 140, 60);
                iconConfirm.setBounds((int) (27 - x_form), 330, 50, 39);
                txtverificar.setBounds((int) (77 - x_form), 330, form.getWidth() - 90, 39);
                btningresar.setBounds((int) (27 - x_form), altura_btningresar, form.getWidth() - 40, 40);
                separador_inferior.setBounds((int) (0 - x_form), altura_separador1, form.getWidth() + 10, 2);
                lbuniversidad.setBounds((int) (77 - x_form), altura_lbuniversidad, form.getWidth() - 120, 15);
                lbautor.setBounds((int) (117 - x_form), altura_lbautor, form.getWidth() - 160, 15);
                lbvacio.setBounds(20, alturaVacio, form.getWidth() - 40, altura_lbvacio);

            }
        });

        btningresar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                texto_vacio = "";
                if (!(txtuser.getText().equals("Usuario") && txtuser.getForeground().equals(new Color(161, 154, 155)))
                        && !(password.getText().equals("Contraseña") && password.getForeground().equals(new Color(161, 154, 155)))
                        && !(txtverificar.getText().equals("Cod. Verificacion") && txtverificar.getForeground().equals(new Color(161, 154, 155)))) {

                    codigo = lb1.getText() + lb2.getText() + lb3.getText() + lb4.getText() + lb5.getText() + lb6.getText();
                    if (!(txtverificar.getText().equalsIgnoreCase(codigo))) {

                        activar_desactivar(false, true);
                        mostrar_error("Código de Verificación Incorrecto");

                        modificar_altura(445, 45, 495, 505, 525, 571);
                    } else {

                        if (txtuser.getText().equals("0020140224") && password.getText().equals("8315080")) {
                            activar_desactivar(false, false);
                            new principal().setVisible(true);
                            open_close(false);
                            setVisible(false);
                        } else {
                            mostrar_error("Usuario y/o contraseña invalidos!");

                            modificar_altura(445, 45, 495, 505, 525, 571);
                        }

                    }

                } else {
                    activar_desactivar(true, false);
                }
                if (txtuser.getText().equals("Usuario") && txtuser.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_usererror("error_iconuser.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_usererror("iconUser.png", new Color(231, 236, 233), Color.GRAY, 1);
                }

                if (password.getText().equals("Contraseña") && password.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_passerror("error_iconpassword.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_passerror("iconpassword.png", new Color(231, 236, 233), Color.GRAY, 1);
                }
                if (txtverificar.getText().equals("Cod. Verificacion") && txtverificar.getForeground().equals(new Color(161, 154, 155))) {
                    mostrar_verificacionerror("error_iconverificar.png", new Color(230, 205, 206), new Color(170, 84, 79), 0);
                } else {
                    mostrar_verificacionerror("iconcodigo.png", new Color(231, 236, 233), Color.GRAY, 1);
                }
                String sep1, sep2;
                if (t1 == 0) {
                    texto_user = "Debe ingresar su nombre de usuario.";
                    sep1 = "<br>";

                } else {
                    texto_user = "";
                    sep1 = "";
                }
                if (t2 == 0) {
                    texto_password = "Debe ingresar su contraseña.";
                    sep2 = "<br>";
                } else {
                    texto_password = "";
                    sep2 = "";
                }
                if (t3 == 0) {
                    texto_verificar = "Debe ingresar el Código de Verificación.";
                } else {
                    texto_verificar = "";
                }

                if (t1 == 0 && t2 == 0 && t3 == 0) {
                    modificar_altura(475, 75, 525, 535, 555, 601);
                } else if ((t1 == 0 && t2 == 0) || (t1 == 0 && t3 == 0) || (t2 == 0 && t3 == 0)) {
                    modificar_altura(460, 60, 510, 520, 540, 586);
                } else if (t1 == 0 || t2 == 0 || t3 == 0) {
                    modificar_altura(445, 45, 495, 505, 525, 571);
                }

                texto_vacio = "<html><font size=+0>Campos Vacios:</font><br>" + texto_user + "" + sep1 + "" + texto_password + "" + sep2 + "" + texto_verificar + "</html>";

                form.setBounds((int) (498 - x_frame), 100, 370, alturaTransparente);
                btningresar.setBounds((int) (27 - x_form), altura_btningresar, form.getWidth() - 40, 40);
                separador_inferior.setBounds((int) (0 - x_form), altura_separador1, form.getWidth() + 10, 2);
                lbuniversidad.setBounds((int) (70 - x_form), altura_lbuniversidad, form.getWidth() - 120, 15);
                lbautor.setBounds((int) (110 - x_form), altura_lbautor, form.getWidth() - 160, 15);

                iconvacio = new ImageIcon(getClass().getResource("iconvacio.png"));
                lbvacio.setBounds(20, alturaVacio, form.getWidth() - 40, altura_lbvacio);
                lbvacio.setIcon(iconvacio);
                lbvacio.setText(texto_vacio);
                lbvacio.setForeground(new Color(149, 121, 73));
                lbvacio.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, new Color(237, 222, 194)));
                form.add(lbvacio);
            }
        }));

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                        "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    public void modificar_altura(int alt_btningresar, int alt_lbvacio, int alt_separador, int alt_lbuni, int alt_lbautor, int alt_form) {
        altura_btningresar = alt_btningresar;
        altura_lbvacio = alt_lbvacio;
        altura_separador1 = alt_separador;
        altura_lbuniversidad = alt_lbuni;
        altura_lbautor = alt_lbautor;
        alturaTransparente = alt_form;
    }

    public void mostrar_usererror(String icon, Color colorfondo, Color colorborder, int valor) {
        iconuser = new ImageIcon(getClass().getResource(icon));
        iconUser.setIcon(iconuser);
        iconUser.setBackground(colorfondo);
        iconUser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        txtuser.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
        t1 = valor;
    }

    public void mostrar_verificacionerror(String icon, Color colorfondo, Color colorborder, int valor) {
        iconverificar = new ImageIcon(getClass().getResource(icon));
        iconConfirm.setIcon(iconverificar);
        iconConfirm.setBackground(colorfondo);
        iconConfirm.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        txtverificar.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
        t3 = valor;
    }

    public void mostrar_passerror(String icon, Color colorfondo, Color colorborder, int valor) {
        iconpassword = new ImageIcon(getClass().getResource(icon));
        iconPass.setIcon(iconpassword);
        iconPass.setBackground(colorfondo);
        iconPass.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 0, colorborder));
        password.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, colorborder));
        t2 = valor;
    }

    public void mostrar_error(String error) {
        iconerror = new ImageIcon(getClass().getResource("iconerror.png"));

        lberror.setBounds(20, 385, form.getWidth() - 40, 45);
        lberror.setIcon(iconerror);
        lberror.setForeground(new Color(149, 121, 73));
        lberror.setBackground(new Color(229, 210, 210));
        lberror.setOpaque(true);
        lberror.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, new Color(235, 205, 207)));
        lberror.setText("<html><font size=+0>Error:</font><br>" + error + "</html>");
        form.add(lberror);
    }

    public void activar_desactivar(boolean vacio, boolean error) {
        lbvacio.setVisible(vacio);
        lberror.setVisible(error);
    }

    public static void open_close(boolean opcion) {
        new login().setVisible(opcion);
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            Calendar calendar = new GregorianCalendar();
            try {
                lbfondo.setIcon(imagenfondo1);
                Thread.sleep(6000);
                lbfondo.setIcon(imagenfondo2);
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        open_close(true);
    }

}
