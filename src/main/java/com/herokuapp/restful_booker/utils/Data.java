package com.herokuapp.restful_booker.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Data {
    private  static ArrayList<Map<String, String>> data= new ArrayList<>();

    public static ArrayList<Map<String, String>> extractTo(){
        try {
            data= Excel.leerDatosDeHojaDeExcel("src/main/resources/data/Data.xlsx","BookingInfo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
