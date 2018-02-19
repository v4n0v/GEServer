package ru.glassexpress.controllers;

import ru.glassexpress.modules.DBDataMapper;
import ru.glassexpress.objects_DB.Composite;

import javax.servlet.http.HttpServletRequest;

public class ServerResponseController {



    public synchronized String createResponse(HttpServletRequest request) {
        String answerJson = null;
        String operation = request.getParameter("action");
        String target = request.getParameter("target");
        String req = request.getQueryString();

        String mark;
        String model;
        switch (operation) {
            case "list":
                switch (target) {
                    case "mark":
                        System.out.println("list mark");
                        answerJson = getCarMarksList();

                        break;
                    case "model":
                        System.out.println("list model from" +request.getParameter("mark")) ;
                        answerJson = getCarModelList(  request.getParameter("mark"));

                        break;
                    default:
                        break;

                }
                break;
            case "drop":
                System.out.println("Delete request");
                break;
            case "insert":
                System.out.println("Insert request");
                switch (target) {
                    case "mark":

                        if (insertCarMark(request.getParameter("mark"))) {
                            System.out.println("insert mark "+request.getParameter("mark"));

                            answerJson = "ok";
                        }
                        break;
                    case "model":

                        if (insertCarModel(request.getParameter("mark"), request.getParameter("model"))) {
                            System.out.println("insert model "+request.getParameter("model")+" "+request.getParameter("mark"));

                            answerJson = "ok";
                        }
                        break;
                     default:
                            break;
                }

                break;
            default:
                answerJson = "FUCK OFF";
                break;
        }
        return answerJson;
    }

    private boolean insertCarMark(String mark) {
        return DBDataMapper.insertMark(mark);
    }

    private boolean insertCarModel(String mark, String model) {
        return DBDataMapper.insertModel(mark, model);
    }

    private String getCarModelList(String mark) {

        Composite composite = DBDataMapper.getCarModelList(mark);
        if (composite!=null) {
           return composite.toJSONObject().toString();
        }


        return "FUCK OFF";
    }
    private String getCarMarksList() {

        Composite composite = DBDataMapper.getCarMarksList();
        if (composite!=null) {
            return composite.toJSONObject().toString();
        }
        return "FUCK OFF";
    }
}
