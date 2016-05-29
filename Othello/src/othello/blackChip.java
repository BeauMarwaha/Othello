
package othello;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class blackChip implements chip{
    
    private ImageIcon Pic = new ImageIcon("src\\Images\\bcircle.png");
    private int points = 0;
    
    public blackChip (){
        
    }
    
    @Override
    public void removeFromBoard() {
        points --;
    }

    @Override
    public JLabel addPicToBoard() {
        points ++;
        return new JLabel(Pic);
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public String getPointsWord() {
        return "Black: " + Integer.toString(points);
    }
    
    
    
}
