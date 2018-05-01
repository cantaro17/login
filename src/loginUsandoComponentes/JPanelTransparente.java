/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginUsandoComponentes;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javafx.scene.paint.Color;

/**
*
* @author Edisoncor
*/
public class JPanelTransparente extends JPanelRound{


private float tran= 0.8f;

public JPanelTransparente(){
super();
}

@Override
protected void paintComponent(Graphics g) {
Graphics2D g2 = (Graphics2D) g;
g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
RenderingHints.VALUE_INTERPOLATION_BILINEAR);
AlphaComposite old = (AlphaComposite) g2.getComposite();
g2.setComposite(AlphaComposite.SrcOver.derive(getTran()));
super.paintComponent(g);
g2.setComposite(old);
}

public float getTran() {
return tran;
}

public void setTran(float tran) {
this.tran = tran;
}

}