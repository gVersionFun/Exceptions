package com.example.demo.services;
import com.example.demo.entities.User;
import com.example.demo.repositories.MongoUserRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.userException.ConnectEmailException;
import com.example.demo.services.userException.ConnectWithSlackException;
import com.example.demo.services.userException.EmailNotFoundException;
import com.example.demo.services.userException.SendToQueueException;
import org.springframework.stereotype.Service;





@Service
public class UserService {
    private UserRepo userRepo;
    private MongoUserRepo mongoUserRepo;

    //Inyección de dependencias por constructor
    public UserService(UserRepo userRepo, MongoUserRepo mongoUserRepo) {
        this.userRepo = userRepo;
        this.mongoUserRepo = mongoUserRepo;

    }

    public String createUser(User user) {
        writeOnFile();
        if (userRepo.findUserByMail(user.getMail()) == null) {
            mongoUserRepo.save(user);
            notifyBySlack();
            postOnQueue();
            return "Creado en Mongo";
        } else {
            sendEmail();
            return "Ya existe el usuario";
        }
    }


    public void notifyBySlack() {
        if (!connectionWithSlack()) {
            throw new ConnectWithSlackException("Error de conexión con Slack");
        } else {
            System.out.println("Se notifico por Slack");

        }
    }

    public void postOnQueue() {
        if (!connectionWithQueue()) {
            throw new SendToQueueException("Error de conexión con el sistema externo");
        } else {
            System.out.println("Se agregó el mensaje a la cola");

        }
    }

    public void sendEmail() {
        if (!connectionSendEmail()) {
            throw new ConnectEmailException("Error de conexión con el servicio de Email");
        } else {
            //en caso de escribir mal el mail, el servicio debería retornar un 400
            if (!verificationSendEmail()) {
                throw new EmailNotFoundException("Email incorrecto");
            } else {
                System.out.println("Se envió el mail a no-response@exceptionexample.com");
            }
        }


    }

    public void writeOnFile() {
        System.out.println("Se escribió la operación");
    }

    public boolean connectionWithSlack() {
        return true;
    }

    public boolean connectionWithQueue() {
        return true;
    }

    public boolean connectionSendEmail() {
        return true;
    }

    public boolean verificationSendEmail() {
        return false;
    }
}


