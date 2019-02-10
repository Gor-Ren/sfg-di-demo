package guru.springframework.didemo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("es")
public class EsGreetingService implements GreetingService {

    @Override
    public void sayHello() {
        System.out.println("Aloha! Vamos!");
    }
}
