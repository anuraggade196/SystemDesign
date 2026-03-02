package ProxyPattern.BadDesign;

interface VideoDownloader{
    void download(String videourl);
}

class RealVideoDownloader implements VideoDownloader{
    @Override
    public void download(String videourl){
        System.out.println("Downloading video from " + videourl);
         try { Thread.sleep(2000); } catch (Exception e) {}
         System.out.println("Download completed!");
    }
}

public class Main {
     public static void main(String[] args) {

        VideoDownloader downloader = new RealVideoDownloader();

        downloader.download("https://example.com/video1");
        System.out.println("---------------------------");

        // ❌ Downloads again — slow & wasteful
        downloader.download("https://example.com/video1");
    }
}
