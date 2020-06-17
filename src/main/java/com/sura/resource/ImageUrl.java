package com.sura.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum ImageUrl {

    SOHOT_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
    HOT_IMAGE("https://www.google.com/url?sa=i&url=http%3A%2F%2Fm.blog.naver.com%2Fjyjahng98%2F10139698717&psig=AOvVaw2ZWu7ekcytdQjwTTrn1Yyt&ust=1592445730811000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNC8nu7gh-oCFQAAAAAdAAAAABAJ","\uD83C\uDF1E "),
    SOSO_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
    COLD_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
    RAIN_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
    CLOUD_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","☁️");


    private String imageUrl;
    private String emoji;

    ImageUrl(String imageUrl, String emoji) {
        this.imageUrl = imageUrl;
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static String findByGetEmoji(String weather) {

        String emoji = null;

        WeatherCondition condition = WeatherCondition.WEATHER_CONDITIONS;

        String weatherKey = condition.getKeyIndex(weather);

        switch (weatherKey) {

            case "CLOUD" :
                emoji = CLOUD_IMAGE.getEmoji();
                break;

            case "RAIN" :
                emoji = RAIN_IMAGE.getEmoji();
                break;

            case "COLD" :
                emoji = COLD_IMAGE.getEmoji();
                break;

            default:
                emoji = HOT_IMAGE.getEmoji();
                break;

        }

        return emoji;
    }

    public static String findByTempImg(String temp) {

        String imageUrl = null;
        int integerTemp = Integer.parseInt(temp);


        if(integerTemp < 0 ) {
            imageUrl = COLD_IMAGE.getImageUrl();
        } else if (0 < integerTemp && 20 > integerTemp){
            imageUrl = SOSO_IMAGE.getImageUrl();
        } else if ( 20 < integerTemp && 30 > integerTemp) {
            imageUrl = HOT_IMAGE.getImageUrl();
        } else if ( 30 < integerTemp && 40 >integerTemp) {
            imageUrl = SOHOT_IMAGE.getImageUrl();
        }

        return imageUrl;
    }

}
