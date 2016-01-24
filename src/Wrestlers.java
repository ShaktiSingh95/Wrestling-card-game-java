/**
 * Created by $SPS on 25-01-2016.
 */
public class Wrestlers {

    public String name;
    public double height, weight;
    public int matchesLost, matchesWon, matchesDraw,rank;

    public Wrestlers(String name, double height, double weight, int lost, int won, int draw,int rank) {

        this.name = name;
        this.height = height;
        this.weight = weight;
        this.matchesDraw = draw;
        this.matchesWon = won;
        this.matchesLost = lost;
        this.rank = rank;

    }

}
