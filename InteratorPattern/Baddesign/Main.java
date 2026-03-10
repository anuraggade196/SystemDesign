package InteratorPattern.Baddesign;
import java.util.*;

class Video{
    private String title;
    public Video(String title){
        this.title = title;
    }

    public String getTitle(){
        return title ;
    }


}

class Playlist{
    public List <Video> Videos = new ArrayList<>();
    public void addVideo(Video video){
        Videos.add(video);
    }
}

public class Main {

    public static void main(String [] args){
        Playlist playlist = new Playlist();
        playlist.addVideo(new Video("System Design Tutorial"));
        playlist.addVideo(new Video("Java Collections"));
        playlist.addVideo(new Video("Microservices Architecture"));

        for(int i =0 ; i<playlist.Videos.size(); i++){
            Video v =playlist.Videos.get(i);
            System.out.println(v.getTitle());

        }
    }
    
}
