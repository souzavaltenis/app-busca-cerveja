package com.example.consultorcerveja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExpertCerveja {

    private List<String> cLarger, cPilsen, cSchwarzbier;

    private HashMap<String, List<String>> marcas;

    public ExpertCerveja(){

        cLarger = new ArrayList<>(Arrays.asList("Brahma extra", "Corona", "Heineken"));
        cPilsen = new ArrayList<>(Arrays.asList("Skol", "Kaiser", "Bohemia"));
        cSchwarzbier = new ArrayList<>(Arrays.asList("Schwarzer Kristall", "Verrine", "BrewDog Zeitgeist"));

        marcas = new HashMap<>();

        marcas.put("Larger", cLarger);
        marcas.put("Pilsen", cPilsen);
        marcas.put("Schwarzbier", cSchwarzbier);
    }

    public List<String> getMarcas(String color){
        return marcas.get(color);
    }

}
