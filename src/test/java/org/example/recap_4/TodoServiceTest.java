package org.example.recap_4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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


}