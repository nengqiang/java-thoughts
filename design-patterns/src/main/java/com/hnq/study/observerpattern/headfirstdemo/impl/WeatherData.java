package com.hnq.study.observerpattern.headfirstdemo.impl;

import com.google.common.collect.Lists;
import com.hnq.study.observerpattern.headfirstdemo.Observer;
import com.hnq.study.observerpattern.headfirstdemo.Subject;

import java.util.List;

/**
 * @author henengqiang
 * @date 2020/8/3
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = Lists.newArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.removeIf(observer -> observers.contains(o));
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(temperature, humidity, pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
