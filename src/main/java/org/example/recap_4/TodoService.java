package org.example.recap_4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodoByID(String id) {
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo addTodo(Todo newTodo) {
        String generateId = UUID.randomUUID().toString();
        Todo todoToAdd = new Todo(generateId, newTodo.description(), Status.OPEN);
        return todoRepository.save(todoToAdd);
    }

    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updatetedTodo) {
        return todoRepository.save(updatetedTodo);
    }

    public String deleteTodo(String id){
        todoRepository.deleteById(id);
        return "Task deleted";
    }
}
