package pl.example.spring.Rest_API_KB;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.example.spring.Rest_API_KB.db.StudentRepository;
import pl.example.spring.Rest_API_KB.db.StudentRow;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(StudentRow::toStudent);
    }

    Student addStudent(final NewStudent newStudent) {
        return this.repository.save(new StudentRow(
            newStudent.name,
            newStudent.number,
            newStudent.grupa)).toStudent();
    }

    @Transactional
    public Optional<Student> changeNumber (long studentId, String newNumber) {
        final Optional<StudentRow> student = this.repository.findById(studentId);
        return student.map(c -> {
            c.setNumber(newNumber);
            return c.toStudent();
        });
    }


}
