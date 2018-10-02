package co.com.ath.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FunctionsUtils {

    public String getDateToday(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String fechaHoy = sdf.format(date);
        return fechaHoy;
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

}
