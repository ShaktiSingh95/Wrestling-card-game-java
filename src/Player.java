import java.util.ArrayList;
import java.util.Random;

/**
 * Created by $SPS on 25-01-2016.
 */
public class Player extends ArrayList<Card> {

public void shuffle(){

    int i, random;
    Card temp;
    Random Randumber = new Random();
    for (i = 0; i < this.size(); i++) {

        temp = this.get(i);
        random = Randumber.nextInt(this.size());
        this.set(i, this.get(random));
        this.set(random, temp);

    }

}

}
