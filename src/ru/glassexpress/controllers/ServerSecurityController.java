package ru.glassexpress.controllers;

public class ServerSecurityController implements SecurityManagerInterface{

    @Override
    public void connectDB() {
        System.out.println("соединение с базой ");
    }

    @Override
    public boolean isValid() {

        System.out.println("валидация завершена");
        return true;
    }

    @Override
    public void validate() {
        connectDB();
        validate();
        System.out.println("валидация");
    }

    @Override
    public void sendEmail() {
        System.out.println("отправка емейла");
    }
}
