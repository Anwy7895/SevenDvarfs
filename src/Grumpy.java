import java.util.HashMap;

public class Grumpy extends Dwarf {
    private HashMap<String, String> reactions;

    public Grumpy() {
        super("Grumpy");
        reactions = new HashMap<>();
        initializeReactions();
    }

    private void initializeReactions() {
        reactions.put("Doc", "complains to Doc about always being reprimanded for complaining making him leave");
        reactions.put("Bashful", "complements Bashful on his annoyingness, imidienty stopping his blush");
        reactions.put("Dopey", "complains about his dumbness, making Doc come over to tell him off");
    }

    @Override
    public String react(GameManager gm){
        String reactionTxt;
        this.reacted = true;
        for(Dwarf dwarf : gm.speakingOrder){
            if(reactions.containsKey(dwarf.name)){
                if(gm.activeDwarfs.size() == gm.allDwarfs.length){
                    reactionTxt = "Grumpy never thought he would see all dwarfs together again";
                }else{
                    reactionTxt = this.name + " " + reactions.get(dwarf.name);
                    if(dwarf.name == "Doc"){
                        dwarf.doneSpeaking(gm);
                        dwarf.leaveTheRoom(gm);
                    }else if(dwarf.name == "Dopey"){
                        gm.activeDwarfs.add(gm.allDwarfs[0]);
                        gm.speakingOrder.add(gm.allDwarfs[0]);
                    }
                }
                this.doneSpeaking(gm);
                return reactionTxt;
            }
        }
        reactionTxt = this.name + " sit down to play the orgel to entertain the others" + "";
        this.doneSpeaking(gm);
        return reactionTxt;
    }
}
