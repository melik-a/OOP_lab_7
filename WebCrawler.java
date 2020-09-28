import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.LinkedList;

/**
 * WebCrawler
 */

public class WebCrawler {
    //LinkedList URLDepthPair of all visited sites
    private LinkedList<URLDepthPair> visitedSites;
    //LinkedList URLDepthPair of all sites to visit
    private LinkedList<URLDepthPair> needToVisit;
    static final String HREF_TAG = "<a href=\"http";


    private void getSites(String initURL, int maxDepth) throws Exception{
        needToVisit.add(new URLDepthPair(initURL, 0));
        int webPort = 80;
        URLDepthPair nextURLPair;
        int nextURLDepth;
        while(!needToVisit.isEmpty()){
            nextURLPair = needToVisit.removeFirst(); 
            nextURLDepth = nextURLPair.getDepth();
            Socket sock = new Socket(nextURLPair.getHost(), webPort);
            sock.setSoTimeout(3000); // Time-out after 3 seconds
            OutputStream os = sock.getOutputStream();
            // true tells PrintWriter to flush after every output
            PrintWriter writer = new PrintWriter(os, true);
            writer.println("GET " + nextURLPair.getPath() + " HTTP/1.1");
            writer.println("Host: " + nextURLPair.getHost());
            writer.println("Connection: close");
            writer.println(); 


            InputStream is = sock.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break; // Done reading document!
                // Do something with this line of text.
                System.out.println(line);
            } 

        }

        
        
    }


    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("usage: java Crawler <URL><depth>");
            return;
        }
        String ur = args[0];
        int deep = Integer.parseInt(args[1]);
        try{
            URLDepthPair pair = new URLDepthPair(ur,deep);
            System.out.println(pair.getHost());
            System.out.println(pair.getPath());
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        
    }
}
