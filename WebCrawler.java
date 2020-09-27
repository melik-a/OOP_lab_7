import java.net.MalformedURLException;
import java.util.LinkedList;

/**
 * WebCrawler
 */

public class WebCrawler {
    //LinkedList URLDepthPair of all visited sites
    private LinkedList<URLDepthPair> visitedSites;


    private void getSites(){

    }


    public static void main(String[] args) throws MalformedURLException{
        if(args.length != 2){
            System.out.println("usage: java Crawler <URL><depth>");
            return;
        }
        String ur = args[0];
        int deep = Integer.parseInt(args[1]);
        URLDepthPair pair = new URLDepthPair(ur,deep);
        System.out.println(pair.getHost());
        System.out.println(pair.getPath());
    }
}
