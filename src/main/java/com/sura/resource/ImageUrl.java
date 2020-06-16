package com.sura.resource;

import java.util.HashMap;

public enum ImageUrl {

    HOT_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
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

    public static HashMap<String, String> findByGetEmoji(String weather) {

        HashMap<String, String> res = new HashMap<>();

        switch (weather) {

            case "흐림" :
                res.put("emoji",CLOUD_IMAGE.getEmoji());
                res.put("imageUrl",CLOUD_IMAGE.getImageUrl());
                break;

            case "비" :
                res.put("emoji",RAIN_IMAGE.getEmoji());
                res.put("imageUrl",RAIN_IMAGE.getImageUrl());
                break;

            case "추움" :
                res.put("emoji",COLD_IMAGE.getEmoji());
                res.put("imageUrl",COLD_IMAGE.getImageUrl());
                break;

            default:
                res.put("emoji",HOT_IMAGE.getEmoji());
                res.put("imageUrl",HOT_IMAGE.getImageUrl());
                break;

        }

        return res;
    }
}
