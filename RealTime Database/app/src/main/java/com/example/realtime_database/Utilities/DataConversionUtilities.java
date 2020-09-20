package com.example.realtime_database.Utilities;

import android.util.Log;

public final class DataConversionUtilities {

    // Parsear de string a entero
    public static int convertSringToInt(String value)
    {

            try {
                value = quitarEspaciosEnBlancoString(value);
                return Integer.parseInt(value);
            }
            catch (NumberFormatException e)
            {
                Log.e("Parsing String-Int: ", e.getMessage());
                return Integer.MIN_VALUE;
            }


    }

    // Parsear de string a real
    public static double convertSringToDouble(String value)
    {

        try {
            value = quitarEspaciosEnBlancoString(value);
            return Double.parseDouble(value);

        }
        catch (NumberFormatException e)
        {
            Log.i("Parsing String-Double: ", e.getMessage());
            return Double.MIN_VALUE;
        }
    }

    // Parsear de string a real
    public static long convertSringToLong(String value)
    {

        try {
            value = quitarEspaciosEnBlancoString(value);
            return Long.parseLong(value);

        }
        catch (NumberFormatException e)
        {
            Log.i("Parsing String-Long: ", e.getMessage());
            return Long.MIN_VALUE;
        }
    }

    private static String quitarEspaciosEnBlancoString(String value){

        return value.replaceAll("\\s", "") ;
    }

    public static String[] splitStringByChar(String value, String character)
    {
        return value.split(character);
    }

}
