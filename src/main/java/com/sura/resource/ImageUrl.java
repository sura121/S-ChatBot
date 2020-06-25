package com.sura.resource;

public enum ImageUrl {

    SOHOT_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E "),
    HOT_IMAGE("https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hyonews.com%2Fxe%2F72556&psig=AOvVaw163gj31uoUK_WQ-ic1MgUd&ust=1592459601895000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMjsw7mUiOoCFQAAAAAdAAAAABAR","\uD83D\uDD25"),
    SOSO_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF1E"),
    COLD_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","❄️"),
    RAIN_IMAGE("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbxqQRk4Y4uk1M7wPBVzwxDkvbxwQDzm8uMsdI-iunpILEr2zG&usqp=CAU","\uD83C\uDF27"),
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

        return emoji!=null ? emoji: HOT_IMAGE.getEmoji();
    }

    public static String findByTempImg(Double temp) {

        System.out.println(temp);
        String imageUrl = null;

        if(temp < 0 ) {
            imageUrl = COLD_IMAGE.getImageUrl();
        } else if (0 < temp && 20 > temp){
            imageUrl = SOSO_IMAGE.getImageUrl();
        } else if ( 20 < temp && 30 > temp) {
            imageUrl = HOT_IMAGE.getImageUrl();
        } else if ( 30 < temp && 40 >temp) {
            imageUrl = SOHOT_IMAGE.getImageUrl();
        }

        return imageUrl;
    }

}
