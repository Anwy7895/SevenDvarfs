public class Start {
    public static void main(String[] args) {
        Doc doc = new Doc();
        Grumpy grumpy = new Grumpy();
        Bashful bashful = new Bashful();
        Dopey dopey = new Dopey();

        Dwarf[] allDwarfs = {doc, grumpy, bashful, dopey};
        GameManager gm = new GameManager(allDwarfs);

        boolean playing = true;
        while(playing){
            boolean lastSpeaker = false;

            if(gm.speakingOrder.size() != 0){
                String currentDwarfs = "Current dwarfs: ";
                for(Dwarf dwarf : gm.activeDwarfs){
                    currentDwarfs += dwarf.name + ", ";
                }
                System.out.println(currentDwarfs);
                System.out.println();
            }

            for(Dwarf dwarf : gm.speakingOrder){
                if(dwarf.reacted == false){
                    //System.out.println(dwarf.name + " is reacting");
                    lastSpeaker = true;
                    System.out.println(dwarf.react(gm));
                    break;
                }
            }
            if(lastSpeaker == false){
                gm.activeDwarfs.get(gm.activeDwarfs.size()-1).react(gm);
                playing = false;
            }

            if(gm.speakingOrder.size() != 0){
                System.out.println("----------------------------------------------------------");
            }
        }
    }
}
