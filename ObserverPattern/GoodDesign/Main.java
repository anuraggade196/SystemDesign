package ObserverPattern.GoodDesign;

import java.util.*;

interface Subscriber {
    void update(String videoTitle);
}


class EmailSubscriber implements Subscriber {

    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(
                "Email sent to " + email +
                " : new video is updated " + videoTitle
        );
    }

}


class MobileAppSubscriber implements Subscriber {

    private String username;

    public MobileAppSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String videoTitle) {

        System.out.println(
                "In-app notification for " + username +
                " : New video - " + videoTitle
        );

    }

}


interface Channel {

    void subscribe(Subscriber s);

    void unsubscribe(Subscriber s);

    void notifySubscribers();

}



class YoutubeChannel implements Channel {

    private List<Subscriber> subscribers =
            new ArrayList<>();

    private String videotitle;


    @Override
    public void subscribe(Subscriber s) {

        subscribers.add(s);

    }


    @Override
    public void unsubscribe(Subscriber s) {

        subscribers.remove(s);

    }


    @Override
    public void notifySubscribers() {

        for (Subscriber s : subscribers) {
            s.update(videotitle);
        }

    }


    public void uploadVideo(String title) {

        System.out.println(
                "\nVideo uploaded : " + title
        );

        this.videotitle = title;

        notifySubscribers();

    }

}



public class Main {

    public static void main(String[] args) {

        YoutubeChannel channel =
                new YoutubeChannel();


        Subscriber s1 =
                new EmailSubscriber("user1@gmail.com");

        Subscriber s2 =
                new MobileAppSubscriber("user123");

        Subscriber s3 =
                new EmailSubscriber("user2@gmail.com");


        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);


        channel.uploadVideo(
                "Observer Pattern Explained"
        );


        channel.unsubscribe(s2);


        channel.uploadVideo(
                "Bridge Pattern Explained"
        );

    }

}