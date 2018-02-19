package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

import java.util.List;


public class CarMarks {
    Integer[] ids;

    public String[] getMarkTitles() {
        return markTitles;
    }

    String[] markTitles;
    public CarMarks(){}



    public CarMarks(Integer[] ids,
                    String[] markTitles) {
        this.ids = ids;
        this.markTitles = markTitles;
    }




    public String toGET() {
        return null;
    }


}

