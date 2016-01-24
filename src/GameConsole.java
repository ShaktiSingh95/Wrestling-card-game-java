import resources.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by $SPS on 25-01-2016.
 */
public class GameConsole extends JFrame implements ActionListener{
    
    int score1Value;
    int score2Value;

    Player player1 = new Player();
    Player player2 = new Player();
    Player allCards = new Player();
    private JPanel mainPanel;
    private JButton showCardPlayer1Button;
    private JButton showCardPlayer2Button;
    private JComboBox choice;
    private JButton goButton;
    private JTextField score1;
    private JTextField score2;
    private JPanel panelPlayer1;
    private JPanel panelPlayer2;
    private JTextField tempResult;
    private int chanceController = 1;
    private int buttonActivator = 0;

    public GameConsole() {

        super();
        score1Value = 0;
        score2Value = 0;
        score1.setText(Resources.score + score1Value);
        score2.setText(Resources.score + score2Value);


        this.setContentPane(mainPanel);
        this.setPreferredSize(new Dimension(800,800));
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        goButton.setEnabled(false);
        choice.setEnabled(false);
        showCardPlayer2Button.setEnabled(false);

        this.showCardPlayer1Button.setActionCommand("show1");
        this.showCardPlayer2Button.setActionCommand("show2");
        this.goButton.setActionCommand("go");

        Card john = new Card("John Cena", 7, 200, 20, 100, 5,100);
        Card HHH = new Card("HHH", 7.1, 250, 25, 110, 10,20);
        Card Rock = new Card("Rock", 7.2, 300, 35, 90,10, 6);
        Card Batista = new Card("Baista", 6.4, 280, 17, 200,12, 1);
        Card Ortan = new Card("Ortan", 6.7, 190, 30, 150, 5,11);
        Card BigShow = new Card("BigShow", 6.4, 200, 9, 180,6, 8);

        allCards.add(Ortan);
        allCards.add(BigShow);
        allCards.add(Batista);
        allCards.add(Rock);
        allCards.add(john);
        allCards.add(HHH);
        allCards.shuffle();

    distributeCards();


    }

    private void distributeCards() {

        int i;
        for(i=0;i<allCards.size();i++)
        {

            if(i<(allCards.size()/2)){


                  player1.add(allCards.get(i));

            }
            else
            {

                    player2.add(allCards.get(i));

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttonPressed = (JButton) (e.getSource());
        int winningTeam = -1;
        Card activeCard1 = null;
        Card activeCard2 = null;
        try {
            activeCard1 = player1.get(0);
            activeCard2 = player2.get(0);
        } catch (Exception e1) {

            this.setVisible(false);
            if (player1.isEmpty()) {
                new ResultScreen(2);
            } else {
                new ResultScreen(1);

            }
        }
        if (buttonPressed.getActionCommand() == "show1" && chanceController == 1) {

            panelPlayer1.add(player1.get(0).playerCard);


        } else if (buttonPressed.getActionCommand() == "show2" && chanceController == 2) {

            panelPlayer2.add(player2.get(0).playerCard);


        } else {


            winningTeam = umpire(activeCard1, activeCard2, buttonPressed.getActionCommand());

            if (winningTeam == 1) {

                tempResult.setText("Player 1 wins this chance.");
                score1Value += 10;
                this.player1.add(activeCard2);
                this.player1.shuffle();
                this.player2.set(0, this.player2.get(this.player2.size() - 1));
                this.player2.remove(player2.size() - 1);
                this.player2.shuffle();
                chanceController = 1;
            } else if (winningTeam == 2) {

                score2Value += 10;
                this.player2.add(activeCard1);
                this.player2.shuffle();
                this.player1.set(0, this.player1.get(this.player1.size() - 1));
                this.player1.remove(0);
                this.player1.shuffle();
                chanceController = 2;

            } else if (winningTeam == 0) {
                tempResult.setText("DRAW");
            }
            buttonActivator = toggleButtonActivator();
            if (buttonActivator == 1) {

                this.choice.setEnabled(true);
                this.goButton.setEnabled(true);
                this.showCardPlayer2Button.setEnabled(false);
                this.showCardPlayer1Button.setEnabled(false);

            } else {

                this.choice.setEnabled(false);
                this.goButton.setEnabled(false);
                this.showCardPlayer1Button.setEnabled(true);
                this.showCardPlayer2Button.setEnabled(true);

            }

        }
    }
    private int umpire(Card activeCard1, Card activeCard2, String actionCommand) {

        if(actionCommand == "rank"){

            if (activeCard1.rank > activeCard2.rank) {

                return 2;

            }
            if (activeCard1.rank < activeCard2.rank) {

                return 1;

            }
            if (activeCard1.rank == activeCard2.rank) {

                return 0;

            }

        }

        if (actionCommand == "height") {


            if (activeCard1.height > activeCard2.height) {

                return 1;

            }
            if (activeCard1.height < activeCard2.height) {

                return 2;

            }
            if (activeCard1.height == activeCard2.height) {

                return 0;

            }
        }
        if (actionCommand == "weight") {


            if (activeCard1.weight > activeCard2.weight) {

                return 1;

            }
            if (activeCard1.weight < activeCard2.weight) {

                return 2;

            }
            if (activeCard1.weight == activeCard2.weight) {

                return 0;
            }
        }
        if (actionCommand == "lost") {


            if (activeCard1.matchesLost > activeCard2.matchesLost) {

                return 1;

            }
            if (activeCard1.matchesLost < activeCard2.matchesLost) {

                return 2;

            }
            if (activeCard1.matchesLost == activeCard2.matchesLost) {

                return 0;
            }
        }
        if (actionCommand == "won") {


            if (activeCard1.matchesWon > activeCard2.matchesWon) {

                return 1;

            }
            if (activeCard1.matchesWon < activeCard2.matchesWon) {

                return 2;

            }
            if (activeCard1.matchesWon == activeCard2.matchesWon) {

                return 0;
            }
        }
        if (actionCommand == "draw") {


            if (activeCard1.matchesDraw > activeCard2.matchesDraw) {

                return 1;

            }
            if (activeCard1.matchesDraw < activeCard2.matchesDraw) {

                return 2;

            }
            if (activeCard1.matchesDraw == activeCard2.matchesDraw) {

                return 0;
            }
        }


        return -1;
        
    }

    private int toggleButtonActivator() {
        if(buttonActivator==0){

            return 1;

        }
        else
            return 0;
    }
}