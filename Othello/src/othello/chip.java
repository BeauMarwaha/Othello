
package othello;

import javax.swing.JLabel;

public interface chip {
    
    /*
     * Removes a chip picture from the board
     */
    public void removeFromBoard();
    
    /*
     * Adds a chip picture to the board
     */
    public JLabel addPicToBoard();
    
    /*
     * Gets the points scored for each item
     */
    public int getPoints();
    
    /*
     * Gets the points scored for each item in string format
     */
    public String getPointsWord();
}
