
class Subscriber{
    String name ;
    Subscriber(String name){
        this.name = name ;

    }
    void notifyUser(String video){
        System.out.println(name + " got notification" + video);
    }

}

class YouTubeChannel{
    Subscriber s1;
    Subscriber s2 ;
    Subscriber s3;
    YouTubeChannel(Subscriber s1 , Subscriber s2 , Subscriber s3){
        this.s1 = s1;
        this.s2 = s2 ;
        this.s3 = s3 ;
    }
    void uploadVideo(String video){
        System.out.println("video uploaded" + video);
        s1.notifyUser(video);
          s2.notifyUser(video);
            s3.notifyUser(video);

    }
}


public class Main {
public static void main(String[] args) {

        Subscriber a = new Subscriber("User1");
        Subscriber b = new Subscriber("User2");
        Subscriber c = new Subscriber("User3");

        YouTubeChannel channel =
                new YouTubeChannel(a, b, c);

        channel.uploadVideo("Observer Pattern Explained");
    }
    
}