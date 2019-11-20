public abstract class Common {
    public static final String AIRPORTS_DELIMITER = "\",";
    public static final String FLIGHTS_DELIMITER = ",";

    public static final int CSV_AIRPORT_ID_INDEX = 0;
    public static final int CSV_AIRPORT_NAME_INDEX = 1;
    public static final int CSV_ORIGIN_AIRPORT_ID_INDEX = 11;
    public static final int CSV_DEST_AIRPORT_ID_INDEX = 14;
    public static final int CSV_DELAY_INDEX = 18;

    public static final String AIRPORTS_HEADER = "Code,Description";
    public static final String FLIGHTS_HEADER = "\"YEAR\",\"QUARTER\",\"MONTH\",\"DAY_OF_MONTH\",\"DAY_OF_WEEK\",\"FL_DATE\",\"UNIQUE_CARRIER\",\"AIRLINE_ID\",\"CARRIER\",\"TAIL_NUM\",\"FL_NUM\",\"ORIGIN_AIRPORT_ID\",\"ORIGIN_AIRPORT_SEQ_ID\",\"ORIGIN_CITY_MARKET_ID\",\"DEST_AIRPORT_ID\",\"WHEELS_ON\",\"ARR_TIME\",\"ARR_DELAY\",\"ARR_DELAY_NEW\",\"CANCELLED\",\"CANCELLATION_CODE\",\"AIR_TIME\",\"DISTANCE\",";
}
