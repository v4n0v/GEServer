package ru.glassexpress.objects_DB;

import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TitledObject extends BaseObject {

    Map<Integer, String> map;

    public TitledObject(String objectClass) {
        super(objectClass);
        map = new HashMap<>();
    }


    Integer getId(String title){
        Set<Map.Entry<Integer, String>> set = map.entrySet();

        if (map.containsValue(title)){
            for (Map.Entry<Integer, String> element : set) {
                if (element.getValue().equals(title)){
                    return element.getKey();
                }

            }
        }



        return  null;
    }

    String getTitle(int id){
        return map.get(id);
    }


    void addElement(int id, String title){
        map.put(id, title);
    }



    @Override
    public JsonElement toJSONObject() {
        return null;
    }
}
