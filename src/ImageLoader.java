import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Created by semeykin on 20.10.2016.
 */
public class ImageLoader extends Thread {
    private String urll;

    //создаем колбек и его метод
    interface Callback {
        void callingBack(String status);
    }

    Caller callback;

    public ImageLoader(String urll, Caller callback) {
        this.urll = urll;
        this.callback = callback;
    }

    void ImageLoader() throws IOException {
        InputStream inp = new URL(urll).openStream();

        FileOutputStream fous = new FileOutputStream(getFileName());

        //System.out.println(inp.);
        int offset = 1;

        while ((offset = inp.read()) != -1) {
            fous.write(offset);
        }
        fous.close();
        inp.close();
    }

    private String getFileName() {
        int lastIndex = urll.lastIndexOf('/');
        return urll.substring(lastIndex);
    }

    @Override
    public void run() {
        System.out.println("Loading image " + urll);
        try {
            ImageLoader();
            callback.callingBack("OK");
        } catch (IOException e) {
            e.printStackTrace();
            callback.callingBack("ERR");
        }
    }
}
