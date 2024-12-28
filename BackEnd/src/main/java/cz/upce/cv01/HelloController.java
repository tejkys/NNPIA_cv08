package cz.upce.cv01;

import org.springframework.web.bind.annotation.*;

/*
    The key difference between @Controler and @RestController annotation is @ResponseBody annotation,
    @Controler does not automatically add the @ResponseBody annotation to all of the controller’s methods,
    which means that you need to add it to each method individually if you want to return a JSON
    or XML response.@RestController automatically adds the @ResponseBody annotation to all of the controller’s methods.
    https://medium.com/javarevisited/difference-between-controller-and-restcontroller-in-spring-boot-and-spring-mvc-216578ad445f
 */

/*
    XML is a markup language, whereas JSON and YAML are data formats.
    XML uses tags to define the elements and stores data in a tree structure,
    whereas data in JSON is stored like a map with key/value pairs. YAML, on the other hand,
    allows representation of data both in list or sequence format and in the form of a map with key/value pairs.
     JSON and YAML uses different indentation styles: JSON uses tabs, whereas YAML uses a hyphen (-) followed by whitespace.
     https://community.cisco.com/t5/developer-general-knowledge-base/xml-vs-json-vs-yaml/ta-p/4729758
*/

@RestController
public class HelloController {
    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }
    @GetMapping("/parameter/query")
    public String helloWorldWithQueryParameter(
            @RequestParam(required = false, defaultValue = "default", value="param") String param) {
        return "Hello world from Spring Boot application. With parameters: " + param;
    }
    @GetMapping("/parameter/path/{value}")
    public String helloWorldWithPathParameter(
            @PathVariable(value="value") String value
            ) {
        return "Hello world from Spring Boot application. With parameters: " + value;
    }
    @PostMapping("/requestBody")
    public DataDTO postController(
            @RequestBody DataDTO loginForm) {
        return loginForm;
    }
}
