package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.RatesServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RatesController.class)
public class RatesControllerTest {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatesServiceImpl ratesService;

    @Test
    public void whenReturnListOfCharCodes() throws Exception {
        Set<String> responseList = new HashSet<>();
        responseList.add("test");
        Mockito.when(ratesService.getCharCodes())
                .thenReturn(responseList);
        mockMvc.perform(get("/rates/get")
                        .content(mapper.writeValueAsString(responseList))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0]").value("test"));
    }
}
