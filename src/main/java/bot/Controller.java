package bot;
import java.util.ArrayList;
import java.io.*;
/**
 * Created by Aluno on 16/09/2016.
 */
public class Controller {
    Model model;
    Bot bot;

    Controller(){
        model = new Model("mongodb://arteiro:abacate@ds019846.mlab.com:19846/arteiro");
        bot = new Bot();
    }
    String adminId = "-164346147";
    // Chats ID
    // Lucas = 136505761 / samuel = 153878723 / grupo = -164346147
    protected void testMessage(String text) {
        bot.sendMessage(text, adminId);
    }

    protected void testSearch(String artistName){
        ArrayList< Artist > artistas;
        artistas = model.searchArtistName(artistName);
        for (int i = 0; i < artistas.size(); i++) {
            try {
            bot.sendPhoto(adminId, artistas.get(i).getArte() ,  artistas.get(i).mountArtist());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}