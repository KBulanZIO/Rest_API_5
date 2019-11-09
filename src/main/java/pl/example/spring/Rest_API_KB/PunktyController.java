package pl.example.spring.Rest_API_KB;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {

    private final StudentService service;

    public PunktyController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/hello")
    public String GetHello() {
        String data = LocalDateTime.now().toString();
        return "hello " + data;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers()
    {
        return this.service.getStudents().asJava();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(@RequestBody NewStudent newStudent)
    {
        return this.service.addStudent(newStudent);
    }


}