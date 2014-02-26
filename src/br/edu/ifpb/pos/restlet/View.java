package br.edu.ifpb.pos.restlet;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.restlet.engine.util.Base64;

public class View extends Frame implements ViewObserver{
  private JPanel panel = new JPanel();
  private Label imglabel = new Label("Imagem Aqui");

    public View() {
      panel.add(imglabel);
      add(panel);
    }
    
    @Override
    public void update(AGImage image) {
      panel.removeAll();
      //
      System.out.println(image.getImage());
      byte[] b = Base64.decode(image.getImage());
      //
      Toolkit tk = Toolkit.getDefaultToolkit();
      Image img = tk.createImage(b);
      //
      
      //
      ImageIcon icon = new ImageIcon(
          img.getScaledInstance(200, 200, Image.SCALE_DEFAULT)
      );
      //
      JLabel l = new JLabel();
      l.setIcon(icon);
      l.setSize(600, 400);
      l.setLayout(new FlowLayout());
      panel.add(l);
      panel.doLayout();
    }
    
    
}
