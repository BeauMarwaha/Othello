
package othello;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class whiteChip implements chip{
    
    private ImageIcon Pic = new ImageIcon("src\\Images\\wcircle.png");
    private int points = 0;
    
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
        return "White: " + Integer.toString(points);
    }

    
}
