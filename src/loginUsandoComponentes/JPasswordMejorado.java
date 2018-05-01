/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginUsandoComponentes;

import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.GradientPaint; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.Image; 
import java.awt.Paint; 
import java.awt.geom.RoundRectangle2D; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
import javax.swing.border.EmptyBorder; 

/**
 *
 * @author Jhon
 */
public class JPasswordMejorado extends JPasswordField { 

    private int arcw=0; 
    private int arch=0; 
    private Image image=null; 
    private Icon icon; 

     
    public JPasswordMejorado() { 
        setOpaque(false); 
        setBorder(new EmptyBorder(0,5,0,2)); 
        setPreferredSize(new Dimension(100,20)); 
    } 

    @Override 
     protected void paintComponent(Graphics g) { 

        Graphics2D g2 = (Graphics2D) g; 
        Paint oldPaint = g2.getPaint(); 

        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float( 
                0,0,getWidth(),getHeight(),arcw,arch); 
        g2.clip(r2d); 

        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(), 
                0.0f, getHeight(), getBackground())); 
        g2.fillRect(0,0,getWidth(),getHeight()); 
        if(getImage()!=null){ 
            g2.drawImage(getImage(), 12, 8, getHeight()-16, getHeight()-16, null); 
            setBorder(new EmptyBorder(0,(int)(getHeight()*1.2),0,2)); 
        } 
        g2.setPaint(new GradientPaint(0.0f, 0.0f, Color.BLACK, 
                0.0f, getHeight(), Color.BLACK)); 
        g2.drawRoundRect(0, 0, getWidth(), getHeight(), arcw, arch); 

        g2.setPaint(oldPaint); 
        super.paintComponent(g); 

    } 

    public int getArcw() { 
        return arcw; 
    } 

    public void setArcw(int arcw) { 
        this.arcw = arcw; 
    } 

    public int getArch() { 
        return arch; 
    } 

    public void setArch(int arch) { 
        this.arch = arch; 
    } 

    public Image getImage() { 
        return image; 
    } 

    public void setImage(Image image) { 
        this.image = image; 
    } 

    public Icon getIcon() { 
        return icon; 
    } 

    public void setIcon(Icon icon){ 
        this.icon=icon; 
        setImage(((ImageIcon)icon).getImage()); 
    } 

}