package cz.zcu.kiv.si.sportbot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.zcu.kiv.si.sportbot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matej Lochman on 14.5.17.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping
   //@CrossOrigin(origins = "http://localhost:8080")
    public String currentWeather() {
        //return "{\"coord\":{\"lon\":13.38,\"lat\":49.75},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"base\":\"stations\",\"main\":{\"temp\":17.05,\"pressure\":1029,\"humidity\":72,\"temp_min\":16,\"temp_max\":18},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":250},\"clouds\":{\"all\":90},\"dt\":1494853200,\"sys\":{\"type\":1,\"id\":5891,\"message\":0.0188,\"country\":\"CZ\",\"sunrise\":1494818442,\"sunset\":1494873952},\"id\":3068160,\"name\":\"Plzen\",\"cod\":200}";
        try {
            return mapper.writeValueAsString(weatherService.getCurrentWeather());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/forecast")
    //@CrossOrigin(origins = "http://localhost:8080")
    public String weatherForecast() {
        //return "{\"cod\":\"200\",\"message\":0.0339,\"cnt\":35,\"list\":[{\"dt\":1494860400,\"main\":{\"temp\":18.04,\"temp_min\":16.99,\"temp_max\":18.04,\"pressure\":985.33,\"sea_level\":1041.89,\"grnd_level\":985.33,\"humidity\":85,\"temp_kf\":1.05},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":2.01,\"deg\":289.511},\"rain\":{\"3h\":0.775},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-15 15:00:00\"},{\"dt\":1494871200,\"main\":{\"temp\":14.06,\"temp_min\":13.27,\"temp_max\":14.06,\"pressure\":985.94,\"sea_level\":1042.41,\"grnd_level\":985.94,\"humidity\":90,\"temp_kf\":0.79},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":1.62,\"deg\":11.0063},\"rain\":{\"3h\":0.585},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-15 18:00:00\"},{\"dt\":1494882000,\"main\":{\"temp\":11.91,\"temp_min\":11.38,\"temp_max\":11.91,\"pressure\":986.95,\"sea_level\":1043.8,\"grnd_level\":986.95,\"humidity\":91,\"temp_kf\":0.52},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":1.21,\"deg\":84.5002},\"rain\":{\"3h\":0.27},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-15 21:00:00\"},{\"dt\":1494892800,\"main\":{\"temp\":10.37,\"temp_min\":10.11,\"temp_max\":10.37,\"pressure\":987.27,\"sea_level\":1044.33,\"grnd_level\":987.27,\"humidity\":96,\"temp_kf\":0.26},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":0.96,\"deg\":153.004},\"rain\":{\"3h\":0.0049999999999999},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-16 00:00:00\"},{\"dt\":1494903600,\"main\":{\"temp\":9.32,\"temp_min\":9.32,\"temp_max\":9.32,\"pressure\":987.27,\"sea_level\":1044.54,\"grnd_level\":987.27,\"humidity\":94,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":1.06,\"deg\":20.0023},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-16 03:00:00\"},{\"dt\":1494914400,\"main\":{\"temp\":11.4,\"temp_min\":11.4,\"temp_max\":11.4,\"pressure\":987.63,\"sea_level\":1044.68,\"grnd_level\":987.63,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":1.66,\"deg\":57.0001},\"rain\":{\"3h\":0.025},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-16 06:00:00\"},{\"dt\":1494925200,\"main\":{\"temp\":15.15,\"temp_min\":15.15,\"temp_max\":15.15,\"pressure\":987.82,\"sea_level\":1044.35,\"grnd_level\":987.82,\"humidity\":91,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":48},\"wind\":{\"speed\":1.92,\"deg\":114.503},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-16 09:00:00\"},{\"dt\":1494936000,\"main\":{\"temp\":17.06,\"temp_min\":17.06,\"temp_max\":17.06,\"pressure\":986.89,\"sea_level\":1043.2,\"grnd_level\":986.89,\"humidity\":80,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":1.84,\"deg\":93.5054},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-16 12:00:00\"},{\"dt\":1494946800,\"main\":{\"temp\":17.67,\"temp_min\":17.67,\"temp_max\":17.67,\"pressure\":985.95,\"sea_level\":1042.18,\"grnd_level\":985.95,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":1.88,\"deg\":87.0035},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-16 15:00:00\"},{\"dt\":1494957600,\"main\":{\"temp\":15.89,\"temp_min\":15.89,\"temp_max\":15.89,\"pressure\":985.54,\"sea_level\":1041.84,\"grnd_level\":985.54,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.79,\"deg\":94.0009},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-16 18:00:00\"},{\"dt\":1494968400,\"main\":{\"temp\":11.87,\"temp_min\":11.87,\"temp_max\":11.87,\"pressure\":985.81,\"sea_level\":1042.52,\"grnd_level\":985.81,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":2.91,\"deg\":107.503},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-16 21:00:00\"},{\"dt\":1494979200,\"main\":{\"temp\":9.98,\"temp_min\":9.98,\"temp_max\":9.98,\"pressure\":985.34,\"sea_level\":1042.23,\"grnd_level\":985.34,\"humidity\":83,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"02n\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":2.29,\"deg\":116.001},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-17 00:00:00\"},{\"dt\":1494990000,\"main\":{\"temp\":8.55,\"temp_min\":8.55,\"temp_max\":8.55,\"pressure\":984.08,\"sea_level\":1041.2,\"grnd_level\":984.08,\"humidity\":86,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.32,\"deg\":104.5},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-17 03:00:00\"},{\"dt\":1495000800,\"main\":{\"temp\":12.68,\"temp_min\":12.68,\"temp_max\":12.68,\"pressure\":983.3,\"sea_level\":1039.88,\"grnd_level\":983.3,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.91,\"deg\":115},\"rain\":{\"3h\":0.0049999999999999},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-17 06:00:00\"},{\"dt\":1495011600,\"main\":{\"temp\":17.04,\"temp_min\":17.04,\"temp_max\":17.04,\"pressure\":982.41,\"sea_level\":1038.48,\"grnd_level\":982.41,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"02d\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":2.93,\"deg\":133.006},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-17 09:00:00\"},{\"dt\":1495022400,\"main\":{\"temp\":18.92,\"temp_min\":18.92,\"temp_max\":18.92,\"pressure\":980.75,\"sea_level\":1036.47,\"grnd_level\":980.75,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":32},\"wind\":{\"speed\":3.04,\"deg\":128},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-17 12:00:00\"},{\"dt\":1495033200,\"main\":{\"temp\":19.5,\"temp_min\":19.5,\"temp_max\":19.5,\"pressure\":978.75,\"sea_level\":1034.39,\"grnd_level\":978.75,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":2.53,\"deg\":127.502},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-17 15:00:00\"},{\"dt\":1495044000,\"main\":{\"temp\":17.81,\"temp_min\":17.81,\"temp_max\":17.81,\"pressure\":977.12,\"sea_level\":1032.74,\"grnd_level\":977.12,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":1.82,\"deg\":103.509},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-17 18:00:00\"},{\"dt\":1495054800,\"main\":{\"temp\":13.86,\"temp_min\":13.86,\"temp_max\":13.86,\"pressure\":975.89,\"sea_level\":1031.8,\"grnd_level\":975.89,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":2.27,\"deg\":91.5052},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-17 21:00:00\"},{\"dt\":1495065600,\"main\":{\"temp\":12.13,\"temp_min\":12.13,\"temp_max\":12.13,\"pressure\":974.1,\"sea_level\":1030.08,\"grnd_level\":974.1,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":1.21,\"deg\":85.5033},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-18 00:00:00\"},{\"dt\":1495076400,\"main\":{\"temp\":11.28,\"temp_min\":11.28,\"temp_max\":11.28,\"pressure\":972.39,\"sea_level\":1028.34,\"grnd_level\":972.39,\"humidity\":79,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":1.17,\"deg\":73.5007},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-18 03:00:00\"},{\"dt\":1495087200,\"main\":{\"temp\":15.04,\"temp_min\":15.04,\"temp_max\":15.04,\"pressure\":971.45,\"sea_level\":1027.16,\"grnd_level\":971.45,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":32},\"wind\":{\"speed\":1.85,\"deg\":112.003},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-18 06:00:00\"},{\"dt\":1495098000,\"main\":{\"temp\":19.94,\"temp_min\":19.94,\"temp_max\":19.94,\"pressure\":970.39,\"sea_level\":1025.62,\"grnd_level\":970.39,\"humidity\":74,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":1.97,\"deg\":150.501},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-18 09:00:00\"},{\"dt\":1495108800,\"main\":{\"temp\":22.26,\"temp_min\":22.26,\"temp_max\":22.26,\"pressure\":969.39,\"sea_level\":1024.42,\"grnd_level\":969.39,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":3.55,\"deg\":227.001},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-18 12:00:00\"},{\"dt\":1495119600,\"main\":{\"temp\":21.29,\"temp_min\":21.29,\"temp_max\":21.29,\"pressure\":968.94,\"sea_level\":1023.96,\"grnd_level\":968.94,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":3.75,\"deg\":263.5},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-18 15:00:00\"},{\"dt\":1495130400,\"main\":{\"temp\":17.59,\"temp_min\":17.59,\"temp_max\":17.59,\"pressure\":969.14,\"sea_level\":1024.06,\"grnd_level\":969.14,\"humidity\":81,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.36,\"deg\":257.501},\"rain\":{\"3h\":0.33},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-18 18:00:00\"},{\"dt\":1495141200,\"main\":{\"temp\":15.41,\"temp_min\":15.41,\"temp_max\":15.41,\"pressure\":968.54,\"sea_level\":1023.84,\"grnd_level\":968.54,\"humidity\":94,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":2.51,\"deg\":202.5},\"rain\":{\"3h\":0.65},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-18 21:00:00\"},{\"dt\":1495152000,\"main\":{\"temp\":14.08,\"temp_min\":14.08,\"temp_max\":14.08,\"pressure\":967.88,\"sea_level\":1023.29,\"grnd_level\":967.88,\"humidity\":96,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":1.61,\"deg\":183.002},\"rain\":{\"3h\":0.08},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-19 00:00:00\"},{\"dt\":1495162800,\"main\":{\"temp\":13.57,\"temp_min\":13.57,\"temp_max\":13.57,\"pressure\":967.22,\"sea_level\":1022.7,\"grnd_level\":967.22,\"humidity\":97,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":1.31,\"deg\":188.001},\"rain\":{\"3h\":0.16},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-19 03:00:00\"},{\"dt\":1495173600,\"main\":{\"temp\":15.41,\"temp_min\":15.41,\"temp_max\":15.41,\"pressure\":966.35,\"sea_level\":1021.78,\"grnd_level\":966.35,\"humidity\":96,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":1.91,\"deg\":78.5048},\"rain\":{\"3h\":0.05},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-19 06:00:00\"},{\"dt\":1495184400,\"main\":{\"temp\":19.91,\"temp_min\":19.91,\"temp_max\":19.91,\"pressure\":965.07,\"sea_level\":1020.27,\"grnd_level\":965.07,\"humidity\":94,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":2.71,\"deg\":103.002},\"rain\":{\"3h\":0.5},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-19 09:00:00\"},{\"dt\":1495195200,\"main\":{\"temp\":21.91,\"temp_min\":21.91,\"temp_max\":21.91,\"pressure\":963.42,\"sea_level\":1018.55,\"grnd_level\":963.42,\"humidity\":77,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":2.77,\"deg\":118.501},\"rain\":{\"3h\":0.34},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-19 12:00:00\"},{\"dt\":1495206000,\"main\":{\"temp\":20.4,\"temp_min\":20.4,\"temp_max\":20.4,\"pressure\":961.73,\"sea_level\":1016.76,\"grnd_level\":961.73,\"humidity\":82,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":24},\"wind\":{\"speed\":3.01,\"deg\":122.501},\"rain\":{\"3h\":1.93},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-19 15:00:00\"},{\"dt\":1495216800,\"main\":{\"temp\":18.42,\"temp_min\":18.42,\"temp_max\":18.42,\"pressure\":959.94,\"sea_level\":1014.9,\"grnd_level\":959.94,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":2.76,\"deg\":112},\"rain\":{\"3h\":0.94},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-05-19 18:00:00\"},{\"dt\":1495227600,\"main\":{\"temp\":16.23,\"temp_min\":16.23,\"temp_max\":16.23,\"pressure\":958.5,\"sea_level\":1013.61,\"grnd_level\":958.5,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":3.26,\"deg\":90.5007},\"rain\":{\"3h\":0.040000000000001},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-05-19 21:00:00\"}],\"city\":{\"id\":3068160,\"name\":\"Plzen\",\"coord\":{\"lat\":49.7475,\"lon\":13.3776},\"country\":\"CZ\"}}";
        try {
            return mapper.writeValueAsString(weatherService.getWeatherForecast());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequestMapping(value = "/forecast/daily")
    //@CrossOrigin(origins = "http://localhost:8080")
    public String weatherForecastDaily() {
        //return "{\"city\":{\"id\":3068160,\"name\":\"Plzen\",\"coord\":{\"lon\":13.3776,\"lat\":49.7475},\"country\":\"CZ\",\"population\":0},\"cod\":\"200\",\"message\":0.0491498,\"cnt\":7,\"list\":[{\"dt\":1494846000,\"temp\":{\"day\":17.05,\"min\":10.37,\"max\":18.04,\"night\":10.37,\"eve\":14.06,\"morn\":17.05},\"pressure\":985.68,\"humidity\":100,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":3.36,\"deg\":280,\"clouds\":76,\"rain\":3.89},{\"dt\":1494932400,\"temp\":{\"day\":17.06,\"min\":9.98,\"max\":17.67,\"night\":9.98,\"eve\":15.89,\"morn\":11.4},\"pressure\":986.89,\"humidity\":80,\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"speed\":1.84,\"deg\":94,\"clouds\":36},{\"dt\":1495018800,\"temp\":{\"day\":18.92,\"min\":12.13,\"max\":19.5,\"night\":12.13,\"eve\":17.81,\"morn\":12.68},\"pressure\":980.75,\"humidity\":73,\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"speed\":3.04,\"deg\":128,\"clouds\":32},{\"dt\":1495105200,\"temp\":{\"day\":19.83,\"min\":13.39,\"max\":19.83,\"night\":13.39,\"eve\":18.94,\"morn\":14.33},\"pressure\":964.18,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":3.52,\"deg\":151,\"clouds\":85,\"rain\":0.72},{\"dt\":1495191600,\"temp\":{\"day\":17.93,\"min\":12.54,\"max\":17.93,\"night\":12.54,\"eve\":16.24,\"morn\":14.05},\"pressure\":968.13,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":3.95,\"deg\":24,\"clouds\":55,\"rain\":3.17},{\"dt\":1495278000,\"temp\":{\"day\":20.92,\"min\":13.14,\"max\":20.92,\"night\":13.23,\"eve\":17.77,\"morn\":13.14},\"pressure\":971.07,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":2.07,\"deg\":114,\"clouds\":5,\"rain\":4.06},{\"dt\":1495364400,\"temp\":{\"day\":15.33,\"min\":9.26,\"max\":15.33,\"night\":9.26,\"eve\":13.46,\"morn\":12.51},\"pressure\":972.89,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":5.17,\"deg\":339,\"clouds\":30,\"rain\":1.44}]}";
        try {
            return mapper.writeValueAsString(weatherService.getWeatherForecastDaily());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

        //return weatherService.getWeatherForecastDaily();
    }
    @RequestMapping(value = "/test")
    //@CrossOrigin(origins = "http://localhost:8080")
    public String test() {
    return "{  \n" +
            "   \"sportplace\":{  \n" +
            "      \"contact\":{  \n" +
            "         \"name\":\"Avalon Fitness Center\",\n" +
            "         \"address\":\"PODĚBRADOVA 2842/1, 301 00 Plzeň\",\n" +
            "         \"phone\":\"725 428 141\",\n" +
            "         \"email\":\"info@avalonfitness.cz\",\n" +
            "         \"url\":\"http://www.avalonfitness.cz\",\n" +
            "         \"lat\":49.746232,\n" +
            "         \"lon\":13.368771,\n" +
            "\t\t \"z\":14\n" +
            "      },\n" +
            "      \"open\":{  \n" +
            "         \"monday\":[6, 22],\n" +
            "         \"tuesday\":[6, 22],\n" +
            "         \"wednesday\":[6, 22],\n" +
            "         \"thursday\":[6, 22],\n" +
            "         \"friday\":[6, 22],\n" +
            "         \"saturday\":[8, 22],\n" +
            "         \"sunday\":[8, 22]\n" +
            "      },\n" +
            "      \"sport\":[  \n" +
            "         {  \n" +
            "            \"fitness\":{  \n" +
            "               \"price\":100,\n" +
            "               \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "         {  \n" +
            "            \"crossfit\":{  \n" +
            "               \"price\":100,\n" +
            "               \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "\t\t {  \n" +
            "            \"fitbox\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "\t\t {  \n" +
            "            \"zumba\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "\t\t {  \n" +
            "            \"hiit\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "\t\t {  \n" +
            "            \"kickbox\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "         {  \n" +
            "            \"box\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "         {  \n" +
            "            \"sebeobrana\":{  \n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         },\n" +
            "\t\t {  \n" +
            "            \"cyklistika\":{\n" +
            "               \"price\":100,\n" +
            "                \"outside\":false,\n" +
            "               \"reservation\":true\n" +
            "            }\n" +
            "         }\n" +
            "      ]\n" +
            "   }\n" +
            "}\n";
    }


}
