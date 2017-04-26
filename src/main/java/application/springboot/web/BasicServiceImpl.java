package application.springboot.web;

import org.springframework.stereotype.Service;

/**
 * @author Marek Rasocha
 *         date 26.04.2017.
 */
@Service
public class BasicServiceImpl implements BasicService {


    @Override
    public String helloWorld() {
        return "Hello from Basic service and Spring Boot MVC running on Liberty!";
    }
}
