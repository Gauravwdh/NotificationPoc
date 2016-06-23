package in.helpchat.voiceproject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by gauravwadhwa on 22/06/16.
 */

public class JsonParser {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
    private JSONObject jsonObject;

    public JsonParser(String json) {
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public List<Weather> parseWeather() throws JSONException, ParseException {
        JSONArray slots = jsonObject.getJSONArray("slots");
        for (int i = 0; i < slots.length(); i++) {
            JSONObject jsonObject = slots.getJSONObject(i);
            String date = jsonObject.keys().next();
            JSONObject data = jsonObject.getJSONObject(date);

            Weather weather = new Weather();
            weather.date = simpleDateFormat.parse(date);
            weather.dayWeather = null; // gson code DayWeather
        }
        return null;
    }


    public static class Weather {
        private Date date;
        private DayWeather dayWeather;
    }


    public static class DayWeather {
        private SomeClass[] afternoon;
        private SomeClass[] evening;
        private SomeClass[] morning;
    }

    public static class SomeClass{

    }
}
