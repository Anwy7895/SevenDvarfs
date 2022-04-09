import java.util.ArrayList;

public class GameManager {
    public Dwarf[] allDwarfs;
    public ArrayList<Dwarf> speakingOrder;
    public ArrayList<Dwarf> activeDwarfs;

    public GameManager(Dwarf[] allDwarfs){
        this.allDwarfs = allDwarfs;
        speakingOrder = new ArrayList<>();
        activeDwarfs = new ArrayList<>();
        initializeGame();
    }

    private void initializeGame(){
        int firstDwarf = (int) ((Math.random() * (4 - 0)) + 0);
        int secondDwarf = -1;
        while(secondDwarf == -1){
            secondDwarf = (int) ((Math.random() * (4 - 0)) + 0);
            if(secondDwarf == firstDwarf){
                secondDwarf = -1;
            }
        }
        if(firstDwarf == 4){
            firstDwarf = 3;
        }
        if(secondDwarf == 4){
            secondDwarf = 3;
        }

        speakingOrder.add(this.allDwarfs[firstDwarf]);
        speakingOrder.add(this.allDwarfs[secondDwarf]);

        activeDwarfs.add(this.allDwarfs[firstDwarf]);
        activeDwarfs.add(this.allDwarfs[secondDwarf]);

        /*speakingOrder.add(this.allDwarfs[0]);
        activeDwarfs.add(this.allDwarfs[0]);
        speakingOrder.add(this.allDwarfs[1]);
        activeDwarfs.add(this.allDwarfs[1]);
        speakingOrder.add(this.allDwarfs[2]);
        activeDwarfs.add(this.allDwarfs[2]);
        speakingOrder.add(this.allDwarfs[3]);
        activeDwarfs.add(this.allDwarfs[3]);
        speakingOrder.add(this.allDwarfs[4]);
        activeDwarfs.add(this.allDwarfs[4]);
        speakingOrder.add(this.allDwarfs[5]);
        activeDwarfs.add(this.allDwarfs[5]);
        speakingOrder.add(this.allDwarfs[6]);
        activeDwarfs.add(this.allDwarfs[6]);*/

    }

}
