import java.net.MalformedURLException;
import java.net.URL;

/**
 * URLDepth
 */
public class URLDepthPair {
    private String URLaddress;
    private int Depth = 0;
    URL address;
    public static final String URL_PREFIX = "http://";


    public URLDepthPair(String url, int depth) throws MalformedURLException{
        if(!url.startsWith(URL_PREFIX) || depth < 0){
            throw new MalformedURLException("Something wrong with input data");
        }
        this.URLaddress = url;
        this.Depth = depth;
    }

    public String getPath() throws MalformedURLException{
        return new URL(URLaddress).getPath();
    }

    public String getHost() throws MalformedURLException{
        return new URL(URLaddress).getHost();
    }

    public String toString() {
        return URLaddress + " - " + Depth;
    }
}