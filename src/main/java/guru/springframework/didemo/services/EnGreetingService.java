package guru.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en", "default"})
public class EnGreetingService implements GreetingService {

    @Override
    public void sayHello() {
        System.out.println("Hello there!");
    }
}
