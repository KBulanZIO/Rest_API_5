package pl.example.spring.Rest_API_KB.db;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentRow,Long>
{

}
