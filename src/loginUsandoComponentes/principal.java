/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginUsandoComponentes;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon
 */
public class principal extends JFrame{

    Icon imagen;
    JLabel contener_imagen;
    JLabel lbbienvenido;
    int tamaño_font;
    
    Calendar calendario;
    Thread h1;
    
    int r = 0, g = 0, b = 0;
    int posx, posy;
    Random aleatorio;
    public principal() {
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        
        posx = 20;
        posy = getHeight()/4;
        aleatorio = new Random();
        h1 = new Thread((Runnable) this);
        h1.start();
        
        imagen = new ImageIcon(getClass().getResource("logo.png"));
        
             
        contener_imagen = new JLabel(imagen);
        contener_imagen.setBounds(405, 10, 600, 700);
        add(contener_imagen);
        
        tamaño_font = 70;   
        lbbienvenido = new JLabel("Bienvenido");
        lbbienvenido.setFont(new Font("Arial Black", Font.BOLD, tamaño_font));
        
        
        add(lbbienvenido);
        
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                        "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                    login.open_close(true);
                }
            }
        });
    }
          
    public static void main(String[] args) {
        new principal().setVisible(true);
    }
}
