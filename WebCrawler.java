import java.net.MalformedURLException;
import java.util.LinkedList;

/**
 * WebCrawler
 */

public class WebCrawler {
    private LinkedList<URLDepth> URLDepthPair;



    public static void main(String[] args) throws MalformedURLException{
        if(args.length > 2){
            System.out.println("usage: java Crawler <URL><depth>");
        }
    }
}
