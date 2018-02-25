package ru.glassexpress.controllers;

import ru.glassexpress.modules.db_command.*;
import ru.glassexpress.modules.factory.DBCommandFactory;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.ErrorObject;

import javax.servlet.http.HttpServletRequest;

public class ServerResponseController {

    String req;

    public synchronized String createResponse(HttpServletRequest request) {

        req = request.getQueryString();

        DBCommandFactory factory = new DBCommandFactory();

        DBCommand command = factory.createCommand(req);
        Composite compositeFromCommand = command.execute();

        if (compositeFromCommand != null) {
            return compositeFromCommand.toJSONObject().toString();

        } else {
            compositeFromCommand = new Composite();
            compositeFromCommand.addComponent(new ErrorObject());
            return compositeFromCommand.toJSONObject().toString();
        }

    }
}