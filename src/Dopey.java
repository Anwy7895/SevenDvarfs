import java.util.HashMap;

public class Dopey extends Dwarf {
    private HashMap<String, String> reactions;

    public Dopey() {
        super("Dopey");
        reactions = new HashMap<>();
        initializeReactions();
    }

    private void initializeReactions() {
        reactions.put("Doc", "and Doc has a conversation about carnivorous plants");
        reactions.put("Grumpy", "tries complementing Grumpy but he can not find any good qualities making him " +
                "angry so he leaves");
        reactions.put("Bashful", "has a weird noice competition making Doc come over to see what is going on");
    }

    @Override
    public String react(GameManager gm){
        String reactionTxt;
        this.reacted = true;
        for(Dwarf dwarf : gm.speakingOrder){
            if(reactions.containsKey(dwarf.name)){
                if(gm.activeDwarfs.size() == gm.allDwarfs.length){
                    reactionTxt = "Dopey is happy to see all the dwarfs together for ones";
                }else{
                    reactionTxt = this.name + " " + reactions.get(dwarf.name);
                    if(dwarf.name == "Grumpy"){
                        dwarf.doneSpeaking(gm);
                        dwarf.leaveTheRoom(gm);
                    }else if (dwarf.name == "Bashful"){
                        gm.activeDwarfs.add(gm.allDwarfs[0]);
                        gm.speakingOrder.add(gm.allDwarfs[0]);
                    }
                }
                this.doneSpeaking(gm);
                return reactionTxt;
            }
        }
        reactionTxt = this.name + " sit start making possessed noises" + "";
        this.doneSpeaking(gm);
        return reactionTxt;
    }
}
