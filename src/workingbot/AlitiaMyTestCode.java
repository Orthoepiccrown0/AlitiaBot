package workingbot;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.net.URL;

import java.util.*;

public class AlitiaMyTestCode extends TelegramLongPollingBot {

    List<KeyboardRow> keyboard = new ArrayList<>();
    //private URL url;
    private XmlReader reader;
    KeyboardRow row = new KeyboardRow();
    private  boolean works = false;


    private boolean b_tuttaIT;
    private boolean b_Piemonte;
    private boolean b_Liguria;
    private boolean b_Trentino_Alto;
    private boolean b_Veneto;
    private boolean b_Friuli_Venezia;
    private boolean b_Emilia_Romagna;
    private boolean b_Marche;
    private boolean b_Umbria;
    private boolean b_Lazio;
    private boolean b_Abruzzo;
    private boolean b_Molise;
    private boolean b_Campania;
    private boolean b_Basilicata;
    private boolean b_Puglia;
    private boolean b_Calabria;
    private boolean b_Sicilia;
    private boolean b_Sardegna;
    private boolean b_Toscana;
    private boolean b_Lombardia;

    //liste degli utenti
    private TreeSet<Utente> l_tuttaIT= new TreeSet<Utente>();
    private TreeSet<Utente> l_Piemonte= new TreeSet<Utente>();
    private TreeSet<Utente> l_Liguria= new TreeSet<Utente>();
    private TreeSet<Utente> l_Trentino_Alto= new TreeSet<Utente>();
    private TreeSet<Utente> l_Veneto= new TreeSet<Utente>();
    private TreeSet<Utente> l_Friuli_Venezia= new TreeSet<Utente>();
    private TreeSet<Utente> l_Emilia_Romagna= new TreeSet<Utente>();
    private TreeSet<Utente> l_Marche= new TreeSet<Utente>();
    private TreeSet<Utente> l_Umbria= new TreeSet<Utente>();
    private TreeSet<Utente> l_Lazio= new TreeSet<Utente>();
    private TreeSet<Utente> l_Abruzzo= new TreeSet<Utente>();
    private TreeSet<Utente> l_Molise= new TreeSet<Utente>();
    private TreeSet<Utente> l_Campania= new TreeSet<Utente>();
    private TreeSet<Utente> l_Basilicata= new TreeSet<Utente>();
    private TreeSet<Utente> l_Puglia= new TreeSet<Utente>();
    private TreeSet<Utente> l_Calabria= new TreeSet<Utente>();
    private TreeSet<Utente> l_Sicilia= new TreeSet<Utente>();
    private TreeSet<Utente> l_Toscana= new TreeSet<Utente>();
    private TreeSet<Utente> l_Sardegna= new TreeSet<Utente>();
    private TreeSet<Utente> l_Lombardia= new TreeSet<Utente>();

    private int minDiAttesa = 3;
    @Override
    public void onUpdateReceived(Update update) {
        //General thread
        if(!works){
            works = true;
            new Thread(new Runnable(){

                @Override
                public void run() {
                    while(true){
                        isThereusers();
                        if(b_tuttaIT){
                            try {
                                URL urlAnsa = new URL("http://www.ansa.it/sito/ansait_rss.xml");
                                URL urlReppublica = new URL("http://www.repubblica.it/rss/homepage/rss2.0.xml");
                                URL urlCorriere = new URL("http://xml2.corriereobjects.it/rss/homepage.xml");
                                reader = null;

                                //System.out.println(new Date());
                                reader(new Date(), urlAnsa,"tuttaIT");
                                reader(new Date(), urlReppublica,"tuttaIT");
                                reader(new Date(), urlCorriere,"tuttaIT");
                                //Thread.sleep(1000 * 60 * 10);
                            }catch(Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Abruzzo){
                            try{
                                URL url = new URL("http://www.ansa.it/abruzzo/notizie/abruzzo_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Abruzzo");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Basilicata){
                            try{
                                URL url = new URL("http://www.ansa.it/basilicata/notizie/basilicata_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Basilicata");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Calabria){
                            try{
                                URL url = new URL("http://www.ansa.it/calabria/notizie/calabria_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Calabria");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Campania){
                            try{
                                URL url = new URL("http://www.ansa.it/campania/notizie/campania_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Campania");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Emilia_Romagna){
                            try{
                                URL url = new URL("http://www.ansa.it/emiliaromagna/notizie/emiliaromagna_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Emilia-Romagna");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Friuli_Venezia){
                            try{
                                URL url = new URL("http://www.ansa.it/friuliveneziagiulia/notizie/friuliveneziagiulia_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Friuli-Venezia");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Lazio){
                            try{
                                URL url = new URL("http://www.ansa.it/lazio/notizie/lazio_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Lazio");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Liguria){
                            try{
                                URL url = new URL("http://www.ansa.it/liguria/notizie/liguria_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Liguria");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Lombardia){
                            try{
                                URL url = new URL("http://www.ansa.it/lombardia/notizie/lombardia_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Lombardia");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Marche){
                            try{
                                URL url = new URL("http://www.ansa.it/marche/notizie/marche_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Marche");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Molise){
                            try{
                                URL url = new URL("http://www.ansa.it/molise/notizie/molise_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Molise");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Piemonte){
                            try{
                                URL url = new URL("http://www.ansa.it/piemonte/notizie/piemonte_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Piemonte");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Puglia){
                            try{
                                URL url = new URL("http://www.ansa.it/puglia/notizie/puglia_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Puglia");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Sardegna){
                            try{
                                URL url = new URL("http://www.ansa.it/sardegna/notizie/sardegna_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Sardegna");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Sicilia){
                            try{
                                URL url = new URL("http://www.ansa.it/sicilia/notizie/sicilia_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Sicilia");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Toscana){
                            try{
                                URL url = new URL("http://www.ansa.it/toscana/notizie/toscana_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Toscana");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Trentino_Alto){
                            try{
                                URL url = new URL("http://www.ansa.it/trentino/notizie/trentino_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Trentino-Alto");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Umbria){
                            try{
                                URL url = new URL("http://www.ansa.it/umbria/notizie/umbria_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Umbria");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        } if(b_Veneto){
                            try{
                                URL url = new URL("http://www.ansa.it/veneto/notizie/veneto_rss.xml");
                                reader = null;
                                reader(new Date(), url,"Veneto");
                            }catch (Exception ex){System.out.println(ex.getMessage());}
                        }
                        try {
                            Thread.sleep(1000*60*minDiAttesa);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }



        String msg = update.getMessage().getText();

        if(msg.equals("/reset")){
            deleteUser(update.getMessage().getFrom().getUserName(),update.getMessage().getChatId());
        }

        if(msg.equals("/start")){
        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(update.getMessage().getChatId())
                .setText("Scegli la tua regione");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        
        String[] regioni = {"Piemonte","Liguria","Trentino-Alto","Veneto","Friuli-Venezia",
                "Emilia-Romagna","Marche","Umbria","Lazio","Abruzzo","Molise","Campania","Basilicata",
                "Puglia","Calabria","Sicilia","Sardegna","Toscana","Lombardia"};

        Arrays.sort(regioni);
        keyboard.clear();
        for(int i =0;i<regioni.length;i++){
            row.add(regioni[i]);
            newRow();
        }
        row.add("Tutta Italia");
        newRow();
        
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message
        message.setReplyMarkup(keyboardMarkup);
        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        }

        //-----------------Start My Superprogram-----------------
        if(update.getMessage().getText().equals("Tutta Italia")){
            l_tuttaIT.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Piemonte")){
            l_Piemonte.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Liguria")){
            l_Liguria.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Trentino-Alto")){
            l_Trentino_Alto.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Friuli-Venezia")){
            l_Friuli_Venezia.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Emilia-Romagna")){
            l_Emilia_Romagna.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Marche")){
            l_Marche.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Umbria")){
            l_Umbria.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Lazio")){
            l_Lazio.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Abruzzo")){
            l_Abruzzo.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Molise")){
            l_Molise.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Campania")){
            l_Campania.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Basilicata")){
            l_Basilicata.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Puglia")){
            l_Puglia.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Calabria")){
            l_Calabria.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Sicilia")){
            l_Sicilia.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Sardegna")){
            l_Sardegna.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Toscana")){
            l_Toscana.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Lombardia")){
            l_Lombardia.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }
        else if(update.getMessage().getText().equals("Veneto")){
            l_Veneto.add(new Utente(update.getMessage().getChatId(),update.getMessage().getFrom().getUserName()));
            sendReply(update.getMessage().getChatId());
        }

        //-----------------END OF MY SUPERPROGRAM----------------
    }

    private void deleteUser(String userName,long chatID){
        try{
            Utente utente = new Utente(chatID,userName);
            l_Abruzzo.remove(utente);
            l_Basilicata.remove(utente);
            l_Calabria.remove(utente);
            l_Campania.remove(utente);
            l_Emilia_Romagna.remove(utente);
            l_Friuli_Venezia.remove(utente);
            l_Lazio.remove(utente);
            l_Liguria.remove(utente);
            l_Lombardia.remove(utente);
            l_Marche.remove(utente);
            l_Molise.remove(utente);
            l_Piemonte.remove(utente);
            l_Puglia.remove(utente);
            l_Sardegna.remove(utente);
            l_Sicilia.remove(utente);
            l_Toscana.remove(utente);
            l_Trentino_Alto.remove(utente);
            l_tuttaIT.remove(utente);
            l_Umbria.remove(utente);
            l_Veneto.remove(utente);
	    sendSystemMessage("Abbiamo resettato il tuo account su Routers",chatID);
        }catch (Exception ex){}
    }

    private void isThereusers(){
        if(!l_Veneto.isEmpty())b_Veneto = true;
        else b_Veneto = false;

        if(!l_Lombardia.isEmpty())b_Lombardia = true;
        else b_Lombardia = false;

        if(!l_Toscana.isEmpty())b_Toscana = true;
        else b_Toscana = false;

        if(!l_tuttaIT.isEmpty())b_tuttaIT = true;
        else b_tuttaIT = false;

        if(!l_Sardegna.isEmpty())b_Sardegna = true;
        else b_Sardegna = false;

        if(!l_Sicilia.isEmpty())b_Sicilia = true;
        else b_Sicilia = false;

        if(!l_Calabria.isEmpty())b_Calabria = true;
        else b_Calabria = false;

        if(!l_Puglia.isEmpty())b_Puglia = true;
        else b_Puglia = false;

        if(!l_Basilicata.isEmpty())b_Basilicata = true;
        else b_Basilicata = false;

        if(!l_Campania.isEmpty())b_Campania = true;
        else b_Campania = false;

        if(!l_Molise.isEmpty())b_Molise = true;
        else b_Molise = false;

        if(!l_Abruzzo.isEmpty())b_Abruzzo = true;
        else b_Abruzzo = false;

        if(!l_Lazio.isEmpty())b_Lazio = true;
        else b_Lazio = false;

        if(!l_Umbria.isEmpty())b_Umbria = true;
        else b_Umbria = false;

        if(!l_Marche.isEmpty())b_Marche = true;
        else b_Marche = false;

        if(!l_Emilia_Romagna.isEmpty())b_Emilia_Romagna = true;
        else b_Emilia_Romagna = false;

        if(!l_Friuli_Venezia.isEmpty())b_Friuli_Venezia = true;
        else b_Friuli_Venezia = false;

        if(!l_Trentino_Alto.isEmpty())b_Trentino_Alto = true;
        else b_Trentino_Alto = false;

        if(!l_Liguria.isEmpty())b_Liguria = true;
        else b_Liguria = false;

        if(!l_Piemonte.isEmpty())b_Piemonte = true;
        else b_Piemonte = false;

    }

    private void sendReply(long chatID){
        SendMessage tmp = new SendMessage()
                .setChatId(chatID)
                .setText("Grazie per aver scelto Routers");
        tmp.setReplyMarkup(new ReplyKeyboardRemove());
        try {
            execute(tmp);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void toAllMySubs(String titolo,String link,String descrizione, String source){

        if(source=="tuttaIT") {
            if(!l_tuttaIT.isEmpty()){
                Iterator<Utente> it = l_tuttaIT.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }else if(source=="Liguria") {
            if(!l_Liguria.isEmpty()){
                Iterator<Utente> it = l_Liguria.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Trentino-Alto") {
            if(!l_Trentino_Alto.isEmpty()){
                Iterator<Utente> it = l_Trentino_Alto.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Veneto") {
            if(!l_Veneto.isEmpty()){
                Iterator<Utente> it = l_Veneto.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Friuli-Venezia") {
            if(!l_Friuli_Venezia.isEmpty()){
                Iterator<Utente> it = l_Friuli_Venezia.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Emilia-Romagna") {
            if(!l_Emilia_Romagna.isEmpty()){
                Iterator<Utente> it = l_Emilia_Romagna.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Marche") {
            if(!l_Marche.isEmpty()){
                Iterator<Utente> it = l_Marche.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Umbria") {
            if(!l_Umbria.isEmpty()){
                Iterator<Utente> it = l_Umbria.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Lazio") {
            if(!l_Lazio.isEmpty()){
                Iterator<Utente> it = l_Lazio.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Abruzzo") {
            if(!l_Abruzzo.isEmpty()){
                Iterator<Utente> it = l_Abruzzo.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Molise") {
            if(!l_Molise.isEmpty()){
                Iterator<Utente> it = l_Molise.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Campania") {
            if(!l_Campania.isEmpty()){
                Iterator<Utente> it = l_Campania.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Basilicata") {
            if(!l_Basilicata.isEmpty()){
                Iterator<Utente> it = l_Basilicata.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Puglia") {
            if(!l_Puglia.isEmpty()){
                Iterator<Utente> it = l_Puglia.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Calabria") {
            if(!l_Calabria.isEmpty()){
                Iterator<Utente> it = l_Calabria.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Sicilia") {
            if(!l_Sicilia.isEmpty()){
                Iterator<Utente> it = l_Sicilia.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Sardegna") {
            if(!l_Sardegna.isEmpty()){
                Iterator<Utente> it = l_Sardegna.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Toscana") {
            if(!l_Toscana.isEmpty()){
                Iterator<Utente> it = l_Toscana.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Lombardia") {
            if(!l_Lombardia.isEmpty()){
                Iterator<Utente> it = l_Lombardia.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
        else if(source=="Piemonte") {
            if(!l_Piemonte.isEmpty()){
                Iterator<Utente> it = l_Piemonte.iterator();
                while(it.hasNext() )
                    sendMyMessage(titolo,link,descrizione,it.next().hisChatId);
            }

        }
    }

    private void sendMyMessage(String titolo,String link,String descrizione, long chatid){
        SendMessage tmp = new SendMessage()
                    .setChatId(chatid)
                    .setText(titolo+"\n"+link+"\n"+descrizione);
            
            try {
                execute(tmp);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }

    private void sendSystemMessage(String messagio, long chatid){
        SendMessage tmp = new SendMessage()
                .setChatId(chatid)
                .setText(messagio);

        try {
            execute(tmp);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    private synchronized void reader(Date oraEsatta, URL url, String source) throws IOException{
            try {
	     
                //Istanziamo uno stream reader dall'url della nostra sorgente feed
	      reader = new XmlReader(url);
	      //Diamo in pasto il nostro reader al parser RSS
	      SyndFeed feed = new SyndFeedInput().build(reader);
	      //System.out.println("XYI");

	     for (Iterator<SyndEntry> i = feed.getEntries().iterator(); i.hasNext();) {
	    	 //Iteriamo tutte le voci presenti nel nostro feed e ne stampiano le proprieta fondmentali
	        SyndEntry entry = i.next();
			Date oraPosting = entry.getPublishedDate();
			long oraPost = oraPosting.getTime();
			long oraEsat = oraEsatta.getTime();
			if(oraPost<=oraEsat&&oraPost>=oraEsat-(1000*60*minDiAttesa)) {
				System.out.println("titolo:" + entry.getTitle());
				System.out.println("link:" + entry.getLink());
				System.out.println("descrizione:" + entry.getDescription().getValue());
				System.out.println("Regione "+ source+"\n");
                                toAllMySubs(entry.getTitle(), entry.getLink(),entry.getDescription().getValue(), source);
                                Thread.sleep(3000);
                        }
		 }
	        }catch(Exception ex){ex.getMessage();}
            finally {
	        	//Chiudiamo lo stream precedentemente aperto.
	            if (reader != null)
	                reader.close();
	        }


        }

    private void newRow(){
        keyboard.add(row);
        // Create another keyboard row
        row = new KeyboardRow();
    }

    @Override
    public String getBotUsername() {
        return "AlitiaBot";
    }

    @Override
    public String getBotToken() {
        return "429106817:AAGMn195xM0Tszu5pijaWeYJupePl--yy58";
    }
}
