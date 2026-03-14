package InteratorPattern.Gooddesign;
import java.util.*;

class Video{
    private String title;
    public Video(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
interface VideoIterator{
    boolean hasNext();
    Video next();

}
class PlaylistIterator implements VideoIterator{
    private List<Video> videos;
    private int index =0;

    public PlaylistIterator(List<Video>videos){
        this.videos = videos ;
    }
    public boolean hasNext(){
        return index < videos.size();
    }
    public Video next(){
        if(!hasNext()){
             throw new RuntimeException("No more videos in playlist");
        }
        return videos.get(index++);
        
    }


}

interface PlaylistCollection{
    VideoIterator createIterator();
}

class Playlist implements PlaylistCollection{
    private List<Video> videos = new ArrayList<>();
    public void addVideo(Video video){
        videos.add(video);
    }
      public VideoIterator createIterator() {
        return new PlaylistIterator(videos);
    }
}

public class Main {
     public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.addVideo(new Video("System Design Tutorial"));
        playlist.addVideo(new Video("Java Multithreading"));
        playlist.addVideo(new Video("Microservices Architecture"));

        VideoIterator iterator = playlist.createIterator();

        while(iterator.hasNext()) {
            Video video = iterator.next();
            System.out.println(video.getTitle());
        }
    }
}
