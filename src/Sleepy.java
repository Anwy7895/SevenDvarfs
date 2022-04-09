import java.util.HashMap;

public class Sleepy extends Dwarf{
    private HashMap<String, String> reactions;

    public Sleepy() {
        super("Sleepy");
        reactions = new HashMap<>();
        initializeReactions();
    }

    private void initializeReactions() {
        reactions.put("Doc", "?");
        reactions.put("Grumpy", "??");
        reactions.put("Happy", "???");
        reactions.put("Sneezy", "????");
        reactions.put("Bashful", "?????");
        reactions.put("Dopey", "??????");
    }

    @Override
    public String react(GameManager gm){
        String reactionTxt = " ";
        this.reacted = true;
        for(Dwarf dwarf : gm.speakingOrder){
            if(reactions.containsKey(dwarf.name)){
                if(gm.speakingOrder.size() == gm.allDwarfs.length){

                }else{

                }
            }
        }
        reactionTxt = this.name + " " + " ";
        this.doneSpeaking(gm);
        return reactionTxt;
    }
}
