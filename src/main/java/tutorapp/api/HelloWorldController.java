package tutorapp.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tutorapp.api.Greeting;

@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}