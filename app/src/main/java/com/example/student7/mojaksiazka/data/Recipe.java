package com.example.student7.mojaksiazka.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe implements Serializable, Comparable<Recipe> {
    public Integer id;
    public Integer ownerId;
    public String title;
    public String introduction;
    public String ingredients;
    public String steps;
    public String created;
    public Integer preparationMinutes;
    public Integer cookingMinutes;
    public Integer servings;

    public Date getCreatedDate(){                       // przeksztalcenie String w Date - created
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            return sdf.parse(created);                  // parse bierze konkretny String i przeksztalca na Date
        }
        catch (Exception error){                        // zwraca nowy obiekt z aktualna data, jesli bedzie blad
            return new Date();                      // zwraca obiekt Date
        }
    }

    @Override
    public int compareTo(Recipe recipe2) {                  // recipe1.compareTo(recipe2)
        Date date1 = getCreatedDate();                    // date1 dla obiektu, w ktorym aktualnie wywolujemy metode compareTo
        Date date2 = recipe2.getCreatedDate();              // date2 tworzymy date dla obiektu recipe2
        return -date1.compareTo(date2);
    }


}
