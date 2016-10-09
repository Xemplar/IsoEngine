import com.xemplar.games.desktop.tapper.building.Building;
import com.xemplar.games.desktop.tapper.building.Church;
import com.xemplar.games.desktop.tapper.graphics.SpriteSheet;
import com.xemplar.games.desktop.tapper.tile.Entity;
import com.xemplar.games.desktop.tapper.tile.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel implements KeyListener{
    public static final Dimension d = new Dimension(1024, 512);

    private Entity test;
    private Building church;
    private SpriteSheet sheet;

    public Main(){
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
        this.setSize(d);
        this.addKeyListener(this);
        this.setFocusable(true);

        sheet = new SpriteSheet("res/textures.png");
        test = new Entity(sheet.getSprite(5, 5), -10, 5);
        church = new Church(sheet, 0, 0);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(d.getWidth() / 2, 0);
        church.render(g2);
        test.render(g2);
    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP){
            test.addY(-1);
        }
        if(code == KeyEvent.VK_DOWN){
            test.addY(1);
        }

        if(code == KeyEvent.VK_LEFT){
            test.addX(-1);
        }
        if(code == KeyEvent.VK_RIGHT){
            test.addX(1);
        }

        this.repaint();
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    public static final void main(String[] args){
        Main m = new Main();
        JFrame frame = new JFrame();
        frame.add(m);
        frame.pack();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        m.requestFocus();
    }
}
