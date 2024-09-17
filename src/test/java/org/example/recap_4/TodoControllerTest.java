package org.example.recap_4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;


import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

   @Autowired
   TodoRepository testRepository;

    @MockBean
    IDService idService;

    @Test
    @DirtiesContext
    void test_getAllTodos() throws Exception{
        //GIVEN
        testRepository.save(new Todo("456", "go swimming", Status.OPEN));
        //WHEN
        mockMvc.perform(get("/api/todo"))
        //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [{
                    "id": "456",
                    "description": "go swimming",
                    "status": "OPEN"
                    }]"""));
    }

    @Test
    @DirtiesContext
    void test_getByID() throws Exception{
        //GIVEN
        testRepository.save(new Todo("456", "go swimming", Status.OPEN));
        //WHEN
        mockMvc.perform(get("/api/todo/456"))
        //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
{
                    "id": "456",
                    "description": "go swimming",
                    "status": "OPEN"
                    }"""));

    }

    @Test
    @DirtiesContext
    void test_updateToDo() throws Exception {
        Todo testToDo = new Todo("789", "feed cat", Status.OPEN);
        testRepository.save(testToDo);
        mockMvc.perform(put("/api/todo/789")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                { "id":"789",
                                "description":"feed cat and dog",
                                "status":"OPEN"}
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                 {
                               "id":"789",
                               "description":"feed cat and dog",
                               "status":"OPEN"}
                               """
                ));
    }

    @Test
    @DirtiesContext
    void test_deleteTodo() throws Exception {
        //GIVEN
        testRepository.save(new Todo("456", "go swimming", Status.OPEN));
       //WHEN
        mockMvc.perform(delete("/api/todo/456"))
        //THEN
                .andExpect(status().isOk())
                .andExpect(content().string("Task deleted")
                );
    }
    }

    /*@Test
    @DirtiesContext
    void test_addNewTodo() throws Exception{
        //GIVEN
        String testID = "1234";
        when(idService.generateID()).thenReturn(testID);

        mockMvc.perform(post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                        "description": "learn spanish",
                        "status": "OPEN"
                        }"""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
{
                        "id": "1234",
                        "description": "learn spanish",
                        "status": "OPEN"}
                  """));


    }*/

  
