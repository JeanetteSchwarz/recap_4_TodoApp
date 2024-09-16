package org.example.recap_4;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getALlTodos(){
        return todoService.getTodos();
    }

    @PostMapping
    public Todo addNewTodo(@RequestBody Todo newTodo) {
        return todoService.addTodo(newTodo);
    }
}
