package ru.glassexpress.modules.factory;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.modules.db_command.*;

public class DBCommandFactory implements DBFactoryMethod{

    static  DBCommand command;


    public DBCommand createCommand(String req) {
        RequestParser parser = new RequestParser();
        parser.parseRequest(req);
        String target = parser.getStringValue("target");
        String action = parser.getStringValue("action");


        if (action.equals("list")&&target.equals("mark")){
            return new DBSelectMarkCommand();
        } else if (action.equals("list")&&target.equals("model")){
            return new DBSelectModelCommand(req);
        } else if (action.equals("list")&&target.equals("generation")){
            return new DBSelectModelCommand(req);

        } else if (action.equals("insert")&&target.equals("mark")){
            return  new DBInsertMarkCommand(req);
        } else if (action.equals("insert")&&target.equals("model")){
            return new DBInsertModelCommand(req);
        } else if (action.equals("insert")&&target.equals("generation")){
            return new DBInsertGenerationCommand(req);
        }



        return null;
    }
}
