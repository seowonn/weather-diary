package zerobase.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Service
public class DiaryService {

    @Value("${openWeatherMap.key}")
    private String apiKey;

    public void createDiary(LocalDate date, String text){
        // 1. open weather map에서 날씨 데이터 가져오기
        String weatherData = getWeatherString();
    }

    private String getWeatherString(){
        String apiUrl =
                "https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=" + apiKey;
        try{
            URL url = new URL(apiUrl);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            BufferedReader br;
            if(responseCode == 200){
                br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );
            }else{
                br = new BufferedReader(
                        new InputStreamReader(connection.getErrorStream())
                );
            }

            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();
            return response.toString();

        } catch (Exception e){
            return "failed to get response.";
        }
    }

}
