package org.example.recap_4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepositiory todoRepositiory;

    public List<Todo> getTodos(){
        return todoRepositiory.findAll();
    }

    public Todo addTodo(Todo newTodo) {
        Todo todoToAdd = new Todo(newTodo.description(), Status.OPEN);
        return todoRepositiory.save(todoToAdd);
    }
}
