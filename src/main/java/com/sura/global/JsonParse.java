package com.sura.global;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class JsonParse {

    private static final Logger logger = LoggerFactory.getLogger(JsonParse.class);


    public HashMap<String,Object> parseResponse(String key, String response) {

        HashMap<String,Object> res = new HashMap<>();

        try {
            JSONParser jsonp = new JSONParser();
            JSONObject obj =(JSONObject)jsonp.parse(response);

            if(!(obj.get(key) instanceof JSONArray)) {
                return  (HashMap<String, Object>) obj.get(key);
            }

            JSONArray jsonArr = (JSONArray)obj.get(key);

            for (Object o : jsonArr) {
                JSONObject resObj = (JSONObject) o;

                if (resObj.size() > 0) {

                    Set set = resObj.keySet();

                    Iterator iterator = set.iterator();

                    if (iterator.hasNext()) {
                        do {
                            String resKey = (String)iterator.next();

                            res.put(resKey,resObj.get(resKey));

                        } while (iterator.hasNext());
                    }
                }

            }

        } catch (ParseException e) {
            e.getErrorType();
        }

        return res;
    }
}
