package com.sura.global;

import com.sura.domain.ResponseVO;
import com.sura.domain.component.BasicCardView;
import com.sura.domain.component.CitiesView;
import com.sura.domain.subtype.BasicCard;
import com.sura.domain.subtype.CityList;
import com.sura.domain.subtype.Template;
import com.sura.domain.weatherinfo.Weather;
import com.sura.repository.WeatherRepository;
import com.sura.resource.Cities;
import com.sura.resource.ConfigResource;
import com.sura.resource.ImageUrl;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * return type domain 관리 필요
 */
@Component
public class ApiCall {

    private final static Logger logger = LoggerFactory.getLogger(ApiCall.class);

    private final WeatherRepository weatherRepository;
    private  final RestTemplate googleApiRes;

    private String weatherText;
    private String weatherImage;



    private final static String G_END_POINT = "https://maps.googleapis.com/maps/api/geocode/json";
    private final static String W_END_POINT = "https://api.openweathermap.org/data/2.5/weather";

    @Autowired
    public ApiCall(WeatherRepository weatherRepository, RestTemplate googleApiRes) {
        this.weatherRepository = weatherRepository;
        this.googleApiRes = googleApiRes;
    }

    public JSONObject apiCall(String city) {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("11");
        encryptor.setAlgorithm("PBEwithMD5AndDES");

        String apikey = encryptor.decrypt(ConfigResource.GOOGLE_API_KEY.getApiKey());

        Map<String,String> queryString = new HashMap<>();

        queryString.put("key",apikey);
        queryString.put("address",city);

        ResponseEntity<String> res = googleApiRes.getForEntity(G_END_POINT+"?address={address}&key={key}",String.class,queryString);

        String jsonString = res.getBody();

        JsonParse parser = new JsonParse();

        Map resObj = parser.parseResponse("results",jsonString);

        JSONObject lastObj =(JSONObject) resObj.get("geometry");

        JSONObject coordinate =(JSONObject) lastObj.get("location");

        return coordinate;

    }

    public HashMap<String,Map> temperatureApi(String lat, String lng) {

        HashMap<String,Map> result = new HashMap<>();

        Map<String,String> queryString = new HashMap<>();

        queryString.put("key",ConfigResource.WEATHER_API_KEY.getApiKey());
        queryString.put("lon",lng);
        queryString.put("lat",lat);
        queryString.put("units","metric");
        queryString.put("lang","kr");

        ResponseEntity<String> res = googleApiRes.getForEntity(W_END_POINT+"?lon={lon}&lat={lat}&appid={key}&units={units}&lang={lang}",String.class,queryString);

        String jsonString = res.getBody();

        logger.info("weather api response : " + jsonString);

        JsonParse parser = new JsonParse();

        HashMap weather = parser.parseResponse("weather",jsonString);
        HashMap temp = parser.parseResponse("main",jsonString);

        result.put("weather", weather);
        result.put("temp", temp);

        return result;
    }

    public Object reponseApiCall(String city) throws Exception{

        logger.info("api call start");

        ResponseVO vo = new ResponseVO("2.0");
        logger.info("도시 파라미터 : " + city);
        Cities cityConfirm = Cities.findByCity(city);
        Double doubleTemp = null;

        try {

            if(cityConfirm == null ) {

                if(city.equals("도시")) {
                   Object cities = this.cityList();
                    return  cities;

                } else {
                    weatherText = "검색 불가능한 도시 입니다.";
                    weatherImage="";
                }


            } else {

                JSONObject coordinate = apiCall(city);

                Map weatherInfo = temperatureApi(coordinate.get("lat").toString(),coordinate.get("lng").toString());

                HashMap<String, Object> temp= (HashMap<String,Object>)weatherInfo.get("temp");
                HashMap<String, String> mainWeather= (HashMap<String,String>)weatherInfo.get("weather");

                Object temperature = temp.get("temp");
                String imgInfo = ImageUrl.findByGetEmoji(mainWeather.get("description"));
                Double templ = Double.parseDouble(String.valueOf(temperature));
                weatherText = String.format("현재 날씨 : %s %s  \n현재 온도 : %s \n최고 온도 : %s ",
                        mainWeather.get("description"),imgInfo,temp.get("temp"), temp.get("temp_max"));

                String imgUrl = ImageUrl.findByTempImg(templ);
                doubleTemp = Double.parseDouble(temp.get("temp").toString());

                weatherImage =imgUrl;

            }

            HashMap<String, Object> imageUrl = new HashMap<>();

            imageUrl.put("imageUrl",weatherImage);

            BasicCard basicCard = BasicCard.builder()
                    .thumbnail(imageUrl)
                    .description(weatherText)
                    .title("날씨 정보 입니다.")
                    .build();

            BasicCardView basicCardView = BasicCardView.builder()
                    .basicCard(basicCard)
                    .build();

            Template template = Template.builder()
                    .outputs(Collections.singletonList(basicCardView))
                    .build();

            vo.setTemplate(template);

            Weather weather = Weather.builder()
                    .temp(doubleTemp)
                    .city(city)
                    .build();

            Weather w = weatherRepository.save(weather);



        } catch (Exception e) {

            logger.info(e.getMessage());
            e.getStackTrace();
        }


        return vo;
    }

    public Object cityList () {

        ResponseVO vo = new ResponseVO("2.0");

        logger.info("city list come ....");

        CityList city = CityList.builder()
                .cityName("서울")
                .build();

        CitiesView citiesView = CitiesView.builder()
                .citiesView(city)
                .build();

        Template tmp =  Template.builder()
                .outputs(Collections.singletonList(citiesView))
                .build();

        vo.setTemplate(tmp);

        return vo;
    }

}
