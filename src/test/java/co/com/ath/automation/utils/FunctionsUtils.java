package co.com.ath.automation.utils;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FunctionsUtils {

    public String getDateToday(int numeroDias){
        Date date = new Date();
        DateTime dateTime = new DateTime(date);
        return dateTime
                .plusDays(numeroDias)
                .toString("yyyy-MM-dd'T'HH:mm:ss");
    }
    public String getNamePagare(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        Random rand = new Random();
        int num = rand.nextInt(90) + 10;
        String name = fecha + "_P" + num;
        return name;
    }

    public JSONObject getJsonFinal(String eliminarCampo, String path, int posicion){
        try {
            String jsonBody = IOUtils.toString(
                    this.getClass().getClassLoader().getResourceAsStream(path),
                    StandardCharsets.UTF_8
            );

            JSONObject jObject  = new JSONObject(jsonBody);
            int sizeJsonObject = jObject.length();
            int numObjectDelte = (int) (Math.random() * sizeJsonObject);
            if(eliminarCampo!=null && eliminarCampo.equals("S")){
                JSONArray names = jObject.names();
                if (names == null) return null;
                for (int i = 0; i < names.length(); ++i) {
                    String key = names.getString(i);
                    if (i == posicion) {
                        jObject.remove(key);
                    }
                }
            }
            return jObject;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

}
