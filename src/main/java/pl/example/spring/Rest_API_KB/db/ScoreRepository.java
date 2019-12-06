package pl.example.spring.Rest_API_KB.db;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreRow, Long> {
}