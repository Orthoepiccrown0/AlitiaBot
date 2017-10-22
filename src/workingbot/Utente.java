package workingbot;

public class Utente implements Comparable<Utente>{
    public long hisChatId;
    public String nickname;

    public Utente(long id, String nick){
        hisChatId = id;
        nickname = nick;
    }

    @Override
    public int compareTo(Utente o) {
        if(hisChatId>o.hisChatId) return 1;
        else if(hisChatId<o.hisChatId) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return ""+hisChatId;
    }
}
