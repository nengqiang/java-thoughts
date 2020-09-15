package com.hnq.study.observerpattern.javainnerdemo;

import com.hnq.study.observerpattern.headfirstdemo.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;

    private float temperature;

    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
