package Esercizio3;

import java.util.*;

public class NotificationService {
    private static NotificationService instance;

    private List<Observer> observers = new ArrayList<>();

    private NotificationService() {
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void aggiungi(Observer o) {
        observers.add(o);
    }

    public void rimuovi(Observer o) {
        observers.remove(o);
    }

    public void notifica(Notification notification) {
        for (Observer o : observers) {
            o.update(notification);
        }
    }

    public void inviaNotifica(String type, String message) {
        Notification notification = NotificationFactory.create(type, message);
        System.out.println("Invio " + type + ": \"" + message + "\"");
        notifica(notification);
    }
}

interface Observer {
    void update(Notification notification);
}

class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return type + ": " + message;
    }
}

class NotificationFactory {
    public static Notification create(String type, String message) {
        return new Notification(type, message);
    }
}

class User implements Observer {
    private String nome;

    public User(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void update(Notification notification) {
        System.out.println(
                nome
                        + " ha ricevuto "
                        + notification.getType()
                        + ": "
                        + notification.getMessage());
    }

    public static void main(String[] args) {
        NotificationService svc = NotificationService.getInstance();

        User a = new User("Alice");
        User b = new User("Bob");
        svc.aggiungi(a);
        svc.aggiungi(b);

        svc.inviaNotifica("EMAIL", "Benvenuto nel sistema!");
        System.out.println();
        svc.inviaNotifica("SMS", "Hai un nuovo SMS.");
    }
}