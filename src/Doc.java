import java.util.HashMap;

public class Doc extends Dwarf{
    private HashMap<String, String> reactions;

    public Doc() {
        super("Doc");
        reactions = new HashMap<>();
        initializeReactions();
    }

    private void initializeReactions() {
        reactions.put("Grumpy", "is trying to calm Grumpy down, making Bashful come over to help");
        reactions.put("Bashful", "compliments Bashful and makes him blush, and run off");
        reactions.put("Dopey", "tries to teach Dopey what 2+2 is, making Grumpy come over to tell him how dumb he is");
    }

    @Override
    public String react(GameManager gm){
        String reactionTxt;
        this.reacted = true;
        for(Dwarf dwarf : gm.speakingOrder){
            if(reactions.containsKey(dwarf.name)){
                if(gm.activeDwarfs.size() == gm.allDwarfs.length){
                    reactionTxt = "Doc is happy to see all the dwarfs together for ones";
                }else{
                    reactionTxt = this.name + " " + reactions.get(dwarf.name);
                    if(dwarf.name == "Grumpy"){
                        gm.activeDwarfs.add(gm.allDwarfs[2]);
                        gm.speakingOrder.add(gm.allDwarfs[2]);
                    }else if(dwarf.name == "Bashful"){
                        dwarf.doneSpeaking(gm);
                        dwarf.leaveTheRoom(gm);
                    }else if(dwarf.name == "Dopey"){
                        gm.activeDwarfs.add(gm.allDwarfs[1]);
                        gm.speakingOrder.add(gm.allDwarfs[1]);
                    }
                }
                this.doneSpeaking(gm);
                return reactionTxt;
            }
        }
        reactionTxt = this.name + " tells the others to find their instruments, he want to jam" + "";
        this.doneSpeaking(gm);
        return reactionTxt;
    }
}
