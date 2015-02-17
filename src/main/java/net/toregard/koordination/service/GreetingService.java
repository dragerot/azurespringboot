package net.toregard.koordination.service;

import net.toregard.koordination.rest.Greeting;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TG3 on 14.02.2015.
 */

@Component
@Scope("singleton")
public class GreetingService {
    List greetings;

    public GreetingService(){
       greetings=new ArrayList<Greeting>();
    }

    public List<Greeting> getGreetings(){
       return greetings;
    }

    public void addGreeting(Greeting greeting){
        greetings.add(greeting);
    }

    public void deleteGreetingAtIndex( long index ){ greetings.remove(index);
    }
}
