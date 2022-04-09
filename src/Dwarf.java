
public abstract class Dwarf {
    public String name;
    public boolean reacted = false;
    public String reaction;

    public Dwarf(String name){
        this.name = name;
    }

    protected void doneSpeaking(GameManager gm){
        gm.speakingOrder.remove(this);
    }

    protected void leaveTheRoom(GameManager gm){
        gm.activeDwarfs.remove(this);
    }


    public String react(GameManager gm){
        this.reacted = true;
        return "";
    }
}
