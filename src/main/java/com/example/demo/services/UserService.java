package com.example.demo.services;
import com.example.demo.entities.User;
import com.example.demo.repositories.MongoUserRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private UserRepo userRepo;
    private MongoUserRepo mongoUserRepo;

   //Inyección de dependencias por constructor
    public UserService(UserRepo userRepo, MongoUserRepo mongoUserRepo){
        this.userRepo = userRepo;
        this.mongoUserRepo = mongoUserRepo;

    }

    public String createUser(User user) {
        writeOnFile();
        if(userRepo.findUserByMail(user.getMail()) == null) {
            mongoUserRepo.save(user);
            notifyBySlack();
            postOnQueue();
            return "Creado en Mongo";
        }else {
            sendEmail();
            return "Ya existe el usuario";
        }
        }



     public void notifyBySlack(){
        //Siempre entrará
         //throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error de conexión con Slack");
         System.out.println("hola");
     }

    public void postOnQueue(){
        System.out.println("Se añadió a la cola");;
    }

    public void sendEmail(){
        System.out.println("Se envió el mail a no-response@exceptionexample.com");
    }

    public void writeOnFile(){
        System.out.println("Se escribió la operación");
    }




}

