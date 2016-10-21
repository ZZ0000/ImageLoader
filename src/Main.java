import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Created by semeykin on 20.10.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String [] arrUrl = new String [] {
            "http://www.datalogic.com/upload/prod_cat/header/adc/on-counter-reader.jpg",
            "http://www.datalogic.com/upload/prod_cat/header/adc/general-purpose-handhelds.jpg",
            "http://www.datalogic.com/upload/prod_line/Cobalto-190x199.png",
            "http://www.google.ru/intl/en_com/images/logo_plain.png",
            "http://333v.ru/uploads/b6/b6c2362f607d67394efa83cef06607d7.jpg",
            "http://333v.ru/uploads/8b/8bb25c8583e9d46c388cca1420e56a7b.jpg",
            "http://333v.ru/uploads/9f/9f1b25161a53773cb1ca73a5a5418023.jpg",
            "http://333v.ru/uploads/14/144cce9fb1b04fd8f7757ad0ef252bce.jpg",
            "http://333v.ru/uploads/f0/f0220d7e59ab0f62709683170a66dd49.jpg",
            "http://333v.ru/uploads/66/66215271aff06ffa18001fa8dba6c75e.jpg",
            "http://333v.ru/uploads/d4/d44fee3f037f58abeae284378d661f6a.jpg",
            "http://images2.fanpop.com/images/photos/7800000/Nature-Full-HD-Wallpaper-national-geographic-7822501-1920-1080.jpg",
            "http://img6.faloo.com/picture/0x0/0/195/195534.jpg"};

        Caller caller = new Caller();

        Thread [] result = new Thread[arrUrl.length];
        ImageLoader imageLoader = null;

        for (int i = 0; i < arrUrl.length; i++) {
            String url = arrUrl[i];
            imageLoader = new ImageLoader(url, caller); //Создание и запуск потока
            imageLoader.start();
            result[i] = imageLoader;
        }
        //Ожидание завершение потоков
        for (Thread t : result) {
            t.join();
        }

        System.out.println(caller.getStatuses());
    }
}
