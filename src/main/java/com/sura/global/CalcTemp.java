package com.sura.global;

import com.sura.domain.TemperatureVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalcTemp {




    public TemperatureVO setTemp(Map response)
    {
        try {
            response.entrySet().stream().forEach(e->{
                Map.Entry<String, Double> tmp = (Map.Entry<String, Double>) e;

                String s = tempCalc(tmp.getValue());

                System.out.println(s);
//                tmp.setValue(tempCalc(tmp.getValue()));
//                System.out.println("chg : " + tempCalc(tmp.getValue()) + "origin : " + tmp.getValue() );

            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        TemperatureVO vo = (TemperatureVO) response;

        return  vo;
    }


    private String tempCalc(Double temp) {

        Double f =  9 / 5 * temp + 32;
        String tmp = String.valueOf(f);
        return  tmp;
    }
}
