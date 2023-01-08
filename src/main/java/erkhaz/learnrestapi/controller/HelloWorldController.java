package erkhaz.learnrestapi.controller;


import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller annotation tells that the java class is a controller
 *
 * @ResponseBody  annotation tells controller that the object
 * returned is automatically serialized into JSON
 * and passed back into the HttpRespinse object
 *
 * @RestController annotation tells both of the above
 */
@RestController
public class HelloWorldController {
}
