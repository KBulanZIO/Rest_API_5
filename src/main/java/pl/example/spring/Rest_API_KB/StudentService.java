package pl.example.spring.Rest_API_KB;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.example.spring.Rest_API_KB.db.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(dbObj->
                        new Student(
                                dbObj.getId(),
                                dbObj.getName(),
                                dbObj.getNumber(),
                                dbObj.getGroup())
                );
    }

    Student addStudent(NewStudent newStudent) {
        throw new UnsupportedOperationException();
    }

}
