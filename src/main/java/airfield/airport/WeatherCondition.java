package airfield.airport;

public enum WeatherCondition {
    SUNNY,
    CLOUDY,
    RAINY,
    STORMY;

    public boolean isSafeForTakeoff(){
        return this != STORMY;
    }


}
