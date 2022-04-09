import java.util.HashMap;

public class Bashful extends Dwarf{
    private HashMap<String, String> reactions;

    public Bashful() {
        super("Bashful");
        reactions = new HashMap<>();
        initializeReactions();
    }

    private void initializeReactions() {
        reactions.put("Doc", "and Doc has a nice conversation about apples, making Grumpy come " +
                "over and remind them about what apples did");
        reactions.put("Grumpy", "gets insulted by what grumpy said and walk away");
        reactions.put("Dopey", "and Dopey dances together");
    }

    @Override
    public String react(GameManager gm){
        String reactionTxt;
        this.reacted = true;
        for(Dwarf dwarf : gm.speakingOrder){
            if(reactions.containsKey(dwarf.name)){
                if(gm.activeDwarfs.size() == gm.allDwarfs.length){
                    reactionTxt = "Bashful is happy to see all the dwarfs together for ones";
                }else{
                    reactionTxt = this.name + " " + reactions.get(dwarf.name);
                    if(dwarf.name == "Doc"){
                        gm.activeDwarfs.add(gm.allDwarfs[1]);
                        gm.speakingOrder.add(gm.allDwarfs[1]);
                    }else if (dwarf.name == "Grumpy"){
                        dwarf.doneSpeaking(gm);
                        dwarf.leaveTheRoom(gm);
                    }
                }
                this.doneSpeaking(gm);
                return reactionTxt;
            }
        }
        reactionTxt = this.name + " ignores the situation" + "";
        this.doneSpeaking(gm);
        return reactionTxt;
    }
}
