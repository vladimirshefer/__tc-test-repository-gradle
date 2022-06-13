package AlfaTest.AlfaTest.controller;

import AlfaTest.AlfaTest.service.Impl.MainServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {
    private ObjectMapper mapper = new ObjectMapper();
    private final String RICH_TAG = "rich";
    private final String BROKE_TAG = "broke";
    @Autowired
    public MockMvc mockMvc;
    @MockBean
    private MainServiceImpl mainService;

    @Test
    public void whenReturnGif() throws Exception {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("", HttpStatus.OK);
        Mockito.when(mainService.getGifByCharCode(RICH_TAG))
                .thenReturn(responseEntity);
        mockMvc.perform(get("/gif/TEST")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
