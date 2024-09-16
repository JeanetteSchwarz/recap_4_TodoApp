package org.example.recap_4;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepositiory extends MongoRepository<Todo, String> {
}
