package pl.example.spring.Rest_API_KB;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoStudentException extends RuntimeException {

    public NoStudentException(long id) {
        super("Student o id :"+id+" does not exists");}
}
