package ProxyPattern.GoodDesign;
import java.util.*;

interface VideoDownloader{
    void download(String videourl);
}

class RealVideDownloader implements VideoDownloader{
    @Override
  public void download(String videoUrl) {
        System.out.println("Downloading video from: " + videoUrl);

        try { Thread.sleep(2000); } catch (Exception e) {}

        System.out.println("Download completed!");
    }
}

class ProxyVideoDownloader implements VideoDownloader{
    private RealVideDownloader realDownloader = new RealVideDownloader();
    private Map<String , String> cache = new HashMap<>();
    @Override
    public void download(String videourl){
        if(cache.containsKey(videourl)){
              System.out.println("Fetching from CACHE: " + videourl);
            return;
        }
        System.out.println("Cache miss! Downloading via RealDownloader...");
        realDownloader.download(videourl);
        cache.put(videourl, "Video File Data");
    }
}

public class Main {
     public static void main(String[] args) {

        VideoDownloader downloader = new ProxyVideoDownloader();

        // First time → downloads
        downloader.download("https://example.com/video1");
        System.out.println("---------------------------");

        // Second time → comes from cache (fast)
        downloader.download("https://example.com/video1");
    }
}
