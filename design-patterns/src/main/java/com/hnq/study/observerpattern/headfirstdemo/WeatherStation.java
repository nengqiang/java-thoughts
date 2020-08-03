package com.hnq.study.observerpattern.headfirstdemo;

import com.hnq.study.observerpattern.headfirstdemo.impl.CurrentConditionsDisplay;
import com.hnq.study.observerpattern.headfirstdemo.impl.WeatherData;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public class WeatherStation {

    public static void main(String[] args) {
        station1();
    }

    private static void station1() {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80F, 65F, 30.4F);
        weatherData.setMeasurements(82F, 70F, 29.2F);
        weatherData.setMeasurements(78F, 90F, 29.2F);
    }

}
