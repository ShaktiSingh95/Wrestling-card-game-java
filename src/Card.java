import javax.swing.*;
import resources.*;
/**
 * Created by $SPS on 25-01-2016.
 */
public class Card extends Wrestlers {
    public JPanel playerCard;
    public JLabel labelName;
    public JLabel labelRank;
    public JLabel labelWeight;
    public JLabel labelHeight;
    public JLabel labelMatchesLost;
    public JLabel labelMatchesWon;
    public JLabel labelMatchesDraw;


    public Card(String name, double height, double weight, int lost, int won, int draw,int rank) {

        super(name,height,weight,lost,won,draw,rank);
        this.labelName.setText(Resources.name+name);
        this.labelHeight.setText(Resources.height+height);
        this.labelWeight.setText(Resources.weight+weight);
        this.labelMatchesDraw.setText(Resources.draw+draw);
        this.labelMatchesWon.setText(Resources.won+won);
        this.labelMatchesLost.setText(Resources.lost+lost);
        this.labelRank.setText(Resources.rank + rank);

    }
}
