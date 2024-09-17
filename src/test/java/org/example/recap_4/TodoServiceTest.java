package org.example.recap_4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    private final TodoRepository mockedRepo = mock(TodoRepository.class);
    private final TodoService testService = new TodoService(mockedRepo);

    @Test
    void test_getAllTodos(){
        //GIVEN
        Todo testTodo = new Todo("123", "learn tests", Status.OPEN);
        mockedRepo.save(testTodo);
        List<Todo> expected = List.of(testTodo);
        //WHEN
        when(mockedRepo.findAll()).thenReturn(expected);
        List<Todo> actual = testService.getAllTodos();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void test_getTodoByID() {
        //GIVEN
        Todo testTodo = new Todo("123", "learn java", Status.OPEN);
        mockedRepo.save(testTodo);
        Todo expected = testTodo;
        //WHEN
        when(mockedRepo.findById(testTodo.id())).thenReturn(Optional.of(expected));
        Todo actual = testService.getTodoByID(testTodo.id());
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void test_addTodo(){
        //GIVEN
        Todo testTodo = new Todo("123", "learn java", Status.OPEN);
        Todo expected = testTodo;
        //WHEN
        when(mockedRepo.save(any(Todo.class))).thenReturn(expected);
        Todo actual = testService.addTodo(testTodo);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void test_updateTodo(){
        //GIVEN
        Todo testTodo = new Todo("123", "learn java", Status.OPEN);
        Todo expected = new Todo("123", "learn java", Status.IN_PROGRESS);
        mockedRepo.save(testTodo);
        //WHEN
        when(mockedRepo.save(any(Todo.class))).thenReturn(expected);
        Todo actual = testService.updateTodo("123", expected);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void test_deleteTodo(){
        //GIVEN
        Todo testTodo = new Todo("123", "learn java", Status.OPEN);
        mockedRepo.save(testTodo);
        String expected = "Task deleted";
        //WHEN
        String actual = testService.deleteTodo(testTodo.id());
        //THEN
        assertEquals(expected, actual);
        }


}