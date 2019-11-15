package pl.example.spring.Rest_API_KB;

import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.example.spring.Rest_API_KB.db.StudentRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService(repository);
    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService(repository);
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService(repository);
        final Student created=service.addStudent(new NewStudent("Student1","1-2-3","IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1",all.get(0).name);
    }

    @Test
    public void addStudentHasNewId() {
        final StudentService service = new StudentService(repository);
        final Student created1  = service.addStudent(new NewStudent("Andrew","1","IP"));
        final Student created2  = service.addStudent(new NewStudent("Krzysztof","2","IP"));
        assertEquals(2,service.getStudents().size());
        assertNotEquals(created1.id,created2.id);
    }

    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

}