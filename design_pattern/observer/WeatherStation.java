public class WeatherStation {
    public static void main(String... s) {
        WeatherData weatherData = new WeatherData();
        
        CurrentConditions currentConditions = new CurrentConditions(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurement(100.1f, 20.2f, 12.5f);
        weatherData.setMeasurement(10.1f, 22.2f, 98.5f);
        weatherData.setMeasurement(145.1f, 28.2f, 17.5f);

    }
}