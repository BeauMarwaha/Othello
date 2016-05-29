
package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/*
 * TO DO:
 */

public class window implements ActionListener, MouseListener{
    
    JFrame window  = new JFrame("Othello");
    
    blackChip bChip = new blackChip();
    whiteChip wChip = new whiteChip();
    
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel leftPanel = new JPanel(new GridLayout(8,8,2,2));
    roundedPanel gamePanel = new roundedPanel();
    JPanel optionsPanel = new JPanel(new GridLayout(10,1));
    JPanel empty = new JPanel();
    JPanel emptyUp = new JPanel();
    JPanel emptyDown = new JPanel();
    JPanel emptyLeft = new JPanel();
    JPanel emptyRight = new JPanel();
    
    boolean blacksTurn = true;
    
    JPanel[][] gameGrid = new JPanel[8][8];
    int[][] locations = new int[8][8];
    
    JPanel spot = new JPanel();
    JPanel spot1 = new JPanel();
    JPanel spot2 = new JPanel();
    JPanel spot3 = new JPanel();
    JPanel spot4 = new JPanel();
    JPanel spot5 = new JPanel();
    JPanel spot6 = new JPanel();
    JPanel spot7 = new JPanel();
    JPanel spot8 = new JPanel();
    JPanel spot9 = new JPanel();
    
    JButton newGame = new JButton("New Game");
    JButton exit = new JButton("Exit");
    JButton skip = new JButton("Skip Turn");
    
    Color myColor = new Color(192,192,192);
    Color myColor2 = new Color(44,97,42);
    Color myColor3 = new Color(128,128,128);
    
    JLabel oNameUp = new JLabel("Othello");
    JLabel oNameDown = new JLabel("Othello");
    JLabel turn = new JLabel("Turn:");
    JLabel score = new JLabel("Score:"); 
    
    JLabel wScore = new JLabel("White: 2");
    JLabel bScore = new JLabel("Black: 2");
    JLabel turnWord = new JLabel("Black");
    
    public window(){
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setSize(700, 700);
        window.setLocationRelativeTo(null);
        window.setIconImage(new ImageIcon("src\\Images\\logo.png").getImage());
        window.add(mainPanel);
        gamePanel.setLayout(new BorderLayout());
    
        mainPanel.add(BorderLayout.WEST, empty);
        mainPanel.add(BorderLayout.CENTER, gamePanel);
        mainPanel.add(BorderLayout.EAST, optionsPanel);
        empty.setBackground(myColor3);
        mainPanel.setBackground(myColor3);
        optionsPanel.setBackground(myColor);
        gamePanel.add(BorderLayout.CENTER, leftPanel);
        gamePanel.add(BorderLayout.NORTH, emptyUp);
        gamePanel.add(BorderLayout.SOUTH, emptyDown);
        gamePanel.add(BorderLayout.WEST, emptyLeft);
        gamePanel.add(BorderLayout.EAST, emptyRight);
        gamePanel.setBackground(Color.black);
        leftPanel.setBackground(Color.black);
        
        emptyUp.setOpaque(false);
        emptyDown.setOpaque(false);
        emptyLeft.setOpaque(false);
        emptyRight.setOpaque(false);
        empty.setPreferredSize(new Dimension(5, window.HEIGHT));
        optionsPanel.setPreferredSize(new Dimension(120, window.HEIGHT));
        leftPanel.setPreferredSize(new Dimension(500, 100));
        emptyUp.setPreferredSize(new Dimension(100, 50));
        emptyDown.setPreferredSize(new Dimension(100, 50));
        emptyLeft.setPreferredSize(new Dimension(10, 100));
        emptyRight.setPreferredSize(new Dimension(10, 100));
        
        oNameUp.setForeground(Color.WHITE);
        oNameUp.setFont(new Font("Times", Font.BOLD, 30));
        emptyUp.add(oNameUp);
        oNameDown.setForeground(Color.WHITE);
        oNameDown.setFont(new Font("Times", Font.BOLD, 30));
        emptyDown.add(oNameDown);
        
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                gameGrid[row][col] = new JPanel();
                leftPanel.add(gameGrid[row][col]);
                gameGrid[row][col].setBackground(myColor2);
                gameGrid[row][col].addMouseListener(this);
                locations[row][col] = 0;
            }
        }
        
        optionsPanel.add(spot);
        optionsPanel.add(spot1);
        optionsPanel.add(spot2);
        optionsPanel.add(spot3);
        optionsPanel.add(spot4);
        optionsPanel.add(spot5);
        optionsPanel.add(spot6);
        optionsPanel.add(spot7);
        optionsPanel.add(spot8);
        optionsPanel.add(spot9);
        
        spot.setBackground(myColor);
        spot1.setBackground(myColor);
        spot2.setBackground(myColor);
        spot3.setBackground(myColor);
        spot4.setBackground(myColor);
        spot5.setBackground(myColor);
        spot6.setBackground(myColor);
        spot7.setBackground(myColor);
        spot8.setBackground(myColor);
        spot9.setBackground(myColor);
        
        spot.add(turn);
        spot1.add(turnWord);
        spot2.add(score);
        spot3.add(wScore);
        spot4.add(bScore);
        spot7.add(skip);
        spot8.add(newGame);
        spot9.add(exit);
        
        newGame.setPreferredSize(new Dimension(100, 50));
        exit.setPreferredSize(new Dimension(100, 50));
        skip.setPreferredSize(new Dimension(100, 50));
        
        turnWord.setFont(new Font("Times", Font.BOLD, 20));
        
        wScore.setFont(new Font("Times", Font.BOLD, 20));
        
        bScore.setFont(new Font("Times", Font.BOLD, 20));
        
        turn.setFont(new Font("Times", Font.BOLD, 28));
        score.setFont(new Font("Times", Font.BOLD, 28));
        
        newGame.addActionListener(this);
        exit.addActionListener(this);
        skip.addActionListener(this);
        
        gameGrid[3][3].add(bChip.addPicToBoard());
        gameGrid[4][4].add(bChip.addPicToBoard());
        locations[3][3] = 1;
        locations[4][4] = 1;
        gameGrid[3][4].add(wChip.addPicToBoard());
        gameGrid[4][3].add(wChip.addPicToBoard());
        locations[3][4] = 2;
        locations[4][3] = 2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame){
            window.dispose();
            window gui = new window();
        }
        
        if (e.getSource() == exit){
            window.dispose();
        }
        
        if (e.getSource() == skip){
            if (blacksTurn){
                JOptionPane.showMessageDialog(null, "White's Turn");
                blacksTurn = false;
                turnWord.setText("White");
            }else{
                JOptionPane.showMessageDialog(null, "Black's Turn");
                blacksTurn = true;
                turnWord.setText("Black");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if (e.getSource() == gameGrid[row][col] && locations[row][col] == 0){
                    if (blacksTurn){
                        makeTurnBlack(row,col);
                    }else{
                        makeTurnWhite(row,col);
                    }
                    
                    if(bChip.getPoints() + wChip.getPoints() == 64){
                        if(bChip.getPoints() > wChip.getPoints()){
                            JOptionPane.showMessageDialog(null, "Black wins, Final Score: " + bChip.getPoints() + " to " + wChip.getPoints());
                        }else if(bChip.getPoints() < wChip.getPoints()){
                            JOptionPane.showMessageDialog(null, "White wins, Final Score: " + wChip.getPoints() + " to " + bChip.getPoints());
                        }else{
                            JOptionPane.showMessageDialog(null, "It's a Tie, Final Score: " + wChip.getPoints() + " to " + bChip.getPoints());
                        }
                        window.dispose();
                    }  
                    
                    if(bChip.getPoints() == 0){
                        JOptionPane.showMessageDialog(null, "White wins, Final Score: " + wChip.getPoints() + " to " + bChip.getPoints());
                        window.dispose();
                    }
                    
                    if(wChip.getPoints() == 0){
                        JOptionPane.showMessageDialog(null, "Black wins, Final Score: " + bChip.getPoints() + " to " + wChip.getPoints());
                        window.dispose();
                    }
                } 
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if (e.getSource() == gameGrid[row][col] && locations[row][col] == 0){
                    if (blacksTurn){
                        gameGrid[row][col].add(bChip.addPicToBoard());
                        bChip.removeFromBoard();
                        mainPanel.updateUI();
                    }else{
                        gameGrid[row][col].add(wChip.addPicToBoard());
                        wChip.removeFromBoard();
                        mainPanel.updateUI();
                    }
                }
            }
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                if (e.getSource() == gameGrid[row][col] && locations[row][col] == 0){
                    gameGrid[row][col].removeAll();
                    mainPanel.updateUI();
                }
            }
        }
    }
    
    public void makeTurnBlack(int row, int col){
        boolean canDo = false;
        
        //EAST CHECK
        if(col+2<8 && locations[row][col+1] == 2){
            int a = 0;
            int b = 1;
            for(int c = col+2; c < 8; c++){
                a++;
                if (locations[row][c] == 2){
                    b++;
                }
                if(locations[row][c] == 1 && a==b){
                    for(int c1 = c-1; c1 > col; c1--){
                        wChip.removeFromBoard();
                        gameGrid[row][c1].removeAll();
                        gameGrid[row][c1].add(bChip.addPicToBoard());
                        locations[row][c1] = 1;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //WEST CHECK
        if(col-2>=0 && locations[row][col-1] == 2){
            int a = 0;
            int b = 1;
            for(int c = col-2; c >= 0; c--){
                a++;
                if (locations[row][c] == 2){
                    b++;
                }
                if(locations[row][c] == 1 && a==b){
                    for(int c1 = c+1; c1 < col; c1++){
                        wChip.removeFromBoard();
                        gameGrid[row][c1].removeAll();
                        gameGrid[row][c1].add(bChip.addPicToBoard());
                        locations[row][c1] = 1;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //NORTH CHECK
        if(row-2>=0 && locations[row-1][col] == 2){
            int a = 0;
            int b = 1;
            for(int r = row-2; r >= 0; r--){
                a++;
                if (locations[r][col] == 2){
                    b++;
                }
                if(locations[r][col] == 1 && a==b){
                    for(int r1 = r+1; r1 < row; r1++){
                        wChip.removeFromBoard();
                        gameGrid[r1][col].removeAll();
                        gameGrid[r1][col].add(bChip.addPicToBoard());
                        locations[r1][col] = 1;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //SOUTH CHECK
        if(row+2<8 && locations[row+1][col] == 2){
            int a = 0;
            int b = 1;
            for(int r = row+2; r < 8; r++){
                a++;
                if (locations[r][col] == 2){
                    b++;
                }
                if(locations[r][col] == 1 && a==b){
                    for(int r1 = r-1; r1 > row; r1--){
                        wChip.removeFromBoard();
                        gameGrid[r1][col].removeAll();
                        gameGrid[r1][col].add(bChip.addPicToBoard());
                        locations[r1][col] = 1;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //SOUTHEAST CHECK 
        if(row+2<8 && col+2<8 && locations[row+1][col+1] == 2){
            int a = 0;
            int b = 1;
            if(row>col){
                for(int s = row+2; s < 8; s++){
                    a++;
                    if (locations[s][col+(s-row)] == 2){
                        b++;
                    }
                    if(locations[s][col+(s-row)] == 1 && a==b){
                        for(int s1 = s-1; s1 > row; s1--){
                            wChip.removeFromBoard();
                            gameGrid[s1][col+(s1-row)].removeAll();
                            gameGrid[s1][col+(s1-row)].add(bChip.addPicToBoard());
                            locations[s1][col+(s1-row)] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col+2; s < 8; s++){
                    a++;
                    if (locations[row+(s-col)][s] == 2){
                        b++;
                    }
                    if(locations[row+(s-col)][s] == 1 && a==b){
                        for(int s1 = s-1; s1 > col; s1--){
                            wChip.removeFromBoard();
                            gameGrid[row+(s1-col)][s1].removeAll();
                            gameGrid[row+(s1-col)][s1].add(bChip.addPicToBoard());
                            locations[row+(s1-col)][s1] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //SOUTHWEST CHECK 
        if(row+2<8 && col-2>=0 && locations[row+1][col-1] == 2){
            int a = 0;
            int b = 1;
            if((7-row)<col){
                for(int s = row+2; s < 8; s++){
                    a++;
                    if (locations[s][col-(s-row)] == 2){
                        b++;
                    }
                    if(locations[s][col-(s-row)] == 1 && a==b){
                        for(int s1 = s-1; s1 > row; s1--){
                            wChip.removeFromBoard();
                            gameGrid[s1][col-(s1-row)].removeAll();
                            gameGrid[s1][col-(s1-row)].add(bChip.addPicToBoard());
                            locations[s1][col-(s1-row)] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col-2; s >= 0; s--){
                    a++;
                    if (locations[row-(s-col)][s] == 2){
                        b++;
                    }
                    if(locations[row-(s-col)][s] == 1 && a==b){
                        for(int s1 = s+1; s1 < col; s1++){
                            wChip.removeFromBoard();
                            gameGrid[row-(s1-col)][s1].removeAll();
                            gameGrid[row-(s1-col)][s1].add(bChip.addPicToBoard());
                            locations[row-(s1-col)][s1] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //NORTHWEST CHECK 
        if(row-2>=0 && col-2>=0 && locations[row-1][col-1] == 2){
            int a = 0;
            int b = 1;
            if(row<col){
                for(int s = row-2; s >= 0; s--){
                    a++;
                    if (locations[s][col+(s-row)] == 2){
                        b++;
                    }
                    if(locations[s][col+(s-row)] == 1 && a==b){
                        for(int s1 = s+1; s1 < row; s1++){
                            wChip.removeFromBoard();
                            gameGrid[s1][col+(s1-row)].removeAll();
                            gameGrid[s1][col+(s1-row)].add(bChip.addPicToBoard());
                            locations[s1][col+(s1-row)] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col-2; s >= 0; s--){
                    a++;
                    if (locations[row+(s-col)][s] == 2){
                        b++;
                    }
                    if(locations[row+(s-col)][s] == 1 && a==b){
                        for(int s1 = s+1; s1 < col; s1++){
                            wChip.removeFromBoard();
                            gameGrid[row+(s1-col)][s1].removeAll();
                            gameGrid[row+(s1-col)][s1].add(bChip.addPicToBoard());
                            locations[row+(s1-col)][s1] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //NORTHEAST CHECK 
        if(row-2>=0 && col+2<8 && locations[row-1][col+1] == 2){
            int a = 0;
            int b = 1;
            if(row<(7-col)){
                for(int s = row-2; s >= 0; s--){
                    a++;
                    if (locations[s][col-(s-row)] == 2){
                        b++;
                    }
                    if(locations[s][col-(s-row)] == 1 && a==b){
                        for(int s1 = s+1; s1 < row; s1++){
                            wChip.removeFromBoard();
                            gameGrid[s1][col-(s1-row)].removeAll();
                            gameGrid[s1][col-(s1-row)].add(bChip.addPicToBoard());
                            locations[s1][col-(s1-row)] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col+2; s < 8; s++){
                    a++;
                    if (locations[row-(s-col)][s] == 2){
                        b++;
                    }
                    if(locations[row-(s-col)][s] == 1 && a==b){
                        for(int s1 = s-1; s1 > col; s1--){
                            wChip.removeFromBoard();
                            gameGrid[row-(s1-col)][s1].removeAll();
                            gameGrid[row-(s1-col)][s1].add(bChip.addPicToBoard());
                            locations[row-(s1-col)][s1] = 1;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        if (canDo){
            gameGrid[row][col].removeAll();
            gameGrid[row][col].add(bChip.addPicToBoard());
            bScore.setText(bChip.getPointsWord());
            wScore.setText(wChip.getPointsWord());
            blacksTurn = false;
            turnWord.setText("White");
            locations[row][col] = 1;
            System.out.println("");
        }
        
        
    }
        
    public void makeTurnWhite(int row, int col){
        boolean canDo = false;
        
        //EAST CHECK
        if(col+2<8 && locations[row][col+1] == 1){
            int a = 0;
            int b = 1;
            for(int c = col+2; c < 8; c++){
                a++;
                if (locations[row][c] == 1){
                    b++;
                }
                if(locations[row][c] == 2 && a==b){
                    for(int c1 = c-1; c1 > col; c1--){
                        bChip.removeFromBoard();
                        gameGrid[row][c1].removeAll();
                        gameGrid[row][c1].add(wChip.addPicToBoard());
                        locations[row][c1] = 2;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //WEST CHECK
        if(col-2>=0 && locations[row][col-1] == 1){
            int a = 0;
            int b = 1;
            for(int c = col-2; c >= 0; c--){
                a++;
                if (locations[row][c] == 1){
                    b++;
                }
                if(locations[row][c] == 2 && a==b){
                    for(int c1 = c+1; c1 < col; c1++){
                        bChip.removeFromBoard();
                        gameGrid[row][c1].removeAll();
                        gameGrid[row][c1].add(wChip.addPicToBoard());
                        locations[row][c1] = 2;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //NORTH CHECK
        if(row-2>=0 && locations[row-1][col] == 1){
            int a = 0;
            int b = 1;
            for(int r = row-2; r >= 0; r--){
                a++;
                if (locations[r][col] == 1){
                    b++;
                }
                if(locations[r][col] == 2 && a==b){
                    for(int r1 = r+1; r1 < row; r1++){
                        bChip.removeFromBoard();
                        gameGrid[r1][col].removeAll();
                        gameGrid[r1][col].add(wChip.addPicToBoard());
                        locations[r1][col] = 2;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //SOUTH CHECK
        if(row+2<8 && locations[row+1][col] == 1){
            int a = 0;
            int b = 1;
            for(int r = row+2; r < 8; r++){
                a++;
                if (locations[r][col] == 1){
                    b++;
                }
                if(locations[r][col] == 2 && a==b){
                    for(int r1 = r-1; r1 > row; r1--){
                        bChip.removeFromBoard();
                        gameGrid[r1][col].removeAll();
                        gameGrid[r1][col].add(wChip.addPicToBoard());
                        locations[r1][col] = 2;
                    }
                    canDo = true;
                    break;
                }
            }
        }
        
        //SOUTHEAST CHECK 
        if(row+2<8 && col+2<8 && locations[row+1][col+1] == 1){
            int a = 0;
            int b = 1;
            if(row>col){
                for(int s = row+2; s < 8; s++){
                    a++;
                    if (locations[s][col+(s-row)] == 1){
                        b++;
                    }
                    if(locations[s][col+(s-row)] == 2 && a==b){
                        for(int s1 = s-1; s1 > row; s1--){
                            bChip.removeFromBoard();
                            gameGrid[s1][col+(s1-row)].removeAll();
                            gameGrid[s1][col+(s1-row)].add(wChip.addPicToBoard());
                            locations[s1][col+(s1-row)] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col+2; s < 8; s++){
                    a++;
                    if (locations[row+(s-col)][s] == 1){
                        b++;
                    }
                    if(locations[row+(s-col)][s] == 2 && a==b){
                        for(int s1 = s-1; s1 > col; s1--){
                            bChip.removeFromBoard();
                            gameGrid[row+(s1-col)][s1].removeAll();
                            gameGrid[row+(s1-col)][s1].add(wChip.addPicToBoard());
                            locations[row+(s1-col)][s1] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //SOUTHWEST CHECK 
        if(row+2<8 && col-2>=0 && locations[row+1][col-1] == 1){
            int a = 0;
            int b = 1;
            if((7-row)<col){
                for(int s = row+2; s < 8; s++){
                    a++;
                    if (locations[s][col-(s-row)] == 1){
                        b++;
                    }
                    if(locations[s][col-(s-row)] == 2 && a==b){
                        for(int s1 = s-1; s1 > row; s1--){
                            bChip.removeFromBoard();
                            gameGrid[s1][col-(s1-row)].removeAll();
                            gameGrid[s1][col-(s1-row)].add(wChip.addPicToBoard());
                            locations[s1][col-(s1-row)] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col-2; s >= 0; s--){
                    a++;
                    if (locations[row-(s-col)][s] == 1){
                        b++;
                    }
                    if(locations[row-(s-col)][s] == 2 && a==b){
                        for(int s1 = s+1; s1 < col; s1++){
                            bChip.removeFromBoard();
                            gameGrid[row-(s1-col)][s1].removeAll();
                            gameGrid[row-(s1-col)][s1].add(wChip.addPicToBoard());
                            locations[row-(s1-col)][s1] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //NORTHWEST CHECK 
        if(row-2>=0 && col-2>=0 && locations[row-1][col-1] == 1){
            int a = 0;
            int b = 1;
            if(row<col){
                for(int s = row-2; s >= 0; s--){
                    a++;
                    if (locations[s][col+(s-row)] == 1){
                        b++;
                    }
                    if(locations[s][col+(s-row)] == 2 && a==b){
                        for(int s1 = s+1; s1 < row; s1++){
                            bChip.removeFromBoard();
                            gameGrid[s1][col+(s1-row)].removeAll();
                            gameGrid[s1][col+(s1-row)].add(wChip.addPicToBoard());
                            locations[s1][col+(s1-row)] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col-2; s >= 0; s--){
                    a++;
                    if (locations[row+(s-col)][s] == 1){
                        b++;
                    }
                    if(locations[row+(s-col)][s] == 2 && a==b){
                        for(int s1 = s+1; s1 < col; s1++){
                            bChip.removeFromBoard();
                            gameGrid[row+(s1-col)][s1].removeAll();
                            gameGrid[row+(s1-col)][s1].add(wChip.addPicToBoard());
                            locations[row+(s1-col)][s1] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        //NORTHEAST CHECK 
        if(row-2>=0 && col+2<8 && locations[row-1][col+1] == 1){
            int a = 0;
            int b = 1;
            if(row<(7-col)){
                for(int s = row-2; s >= 0; s--){
                    a++;
                    if (locations[s][col-(s-row)] == 1){
                        b++;
                    }
                    if(locations[s][col-(s-row)] == 2 && a==b){
                        for(int s1 = s+1; s1 < row; s1++){
                            bChip.removeFromBoard();
                            gameGrid[s1][col-(s1-row)].removeAll();
                            gameGrid[s1][col-(s1-row)].add(wChip.addPicToBoard());
                            locations[s1][col-(s1-row)] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }else{
                for(int s = col+2; s < 8; s++){
                    a++;
                    if (locations[row-(s-col)][s] == 1){
                        b++;
                    }
                    if(locations[row-(s-col)][s] == 2 && a==b){
                        for(int s1 = s-1; s1 > col; s1--){
                            bChip.removeFromBoard();
                            gameGrid[row-(s1-col)][s1].removeAll();
                            gameGrid[row-(s1-col)][s1].add(wChip.addPicToBoard());
                            locations[row-(s1-col)][s1] = 2;
                        }
                        canDo = true;
                        break;
                    }
                }
            }
            
        }
        
        if (canDo){
            gameGrid[row][col].removeAll();
            gameGrid[row][col].add(wChip.addPicToBoard());
            wScore.setText(wChip.getPointsWord());
            bScore.setText(bChip.getPointsWord());
            blacksTurn = true;
            turnWord.setText("Black");
            locations[row][col] = 2;
            System.out.println("");
        }
        
    }
    
}
