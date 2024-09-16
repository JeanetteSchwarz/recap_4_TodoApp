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
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getByID(@PathVariable String id) {
        return todoService.getTodoByID(id);
    }

    @PostMapping
    public Todo addNewTodo(@RequestBody Todo newTodo) {
        return todoService.addTodo(newTodo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        return todoService.updateTodo(id, updatedTodo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id){
        return todoService.deleteTodo(id);
    }

}

