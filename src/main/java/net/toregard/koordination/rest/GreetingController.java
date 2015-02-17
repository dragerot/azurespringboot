package net.toregard.koordination.rest;

import net.toregard.koordination.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by TG3 on 14.02.2015.
 * POST /rest/hotels - creates a Hotel entity
 * GET /rest/hotels - gets the list of Hotel entities
 * GET /rest/hotels/:id - retrieves an entity with specified Id
 * PUT /rest/hotels/:id - updates an entity
 * DELETE /rest/hotels/:id - deletes an entity with the specified id
 */
@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * List all items example: http://localhost:8080/rest/greeting/list
     * @param name
     * @return
     */
    @RequestMapping(value ="/rest/greeting/list" ,method= RequestMethod.GET,headers="Accept=application/json")
    public List<Greeting> getGreetings(@RequestParam(value = "name", defaultValue = "World") String name) {
        // return new Greeting(counter.incrementAndGet(),String.format(template, name));
           return greetingService.getGreetings();
    }

    /**
     * http://localhost:8080/rest/greeting/add/2/B
     * @param id
     * @param content
     */
    @RequestMapping("/rest/greeting/add/{id}/{content}")
    public void addGreeting(
            @PathVariable("id") long id,
            @PathVariable("content") String content) {
        greetingService.addGreeting(new Greeting(id, content));
    }

    @RequestMapping("/rest/greeting/delete/{id}")
    public void deleteGreetingAtIndex(@PathVariable("id") long id) {
        Greeting val=greetingService.getGreetings().get((int)id);
        if(val!=null) greetingService.getGreetings().remove(val);
        //greetingService.deleteGreetingAtIndex(id);
    }
}
