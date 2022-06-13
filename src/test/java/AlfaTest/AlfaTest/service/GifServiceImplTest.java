package AlfaTest.AlfaTest.service;

import AlfaTest.AlfaTest.client.FeignGifClient;


import AlfaTest.AlfaTest.service.Impl.GifServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GifServiceImplTest {
    @Autowired
    private GifServiceImpl gifService;
    @MockBean
    private FeignGifClient gifClient;

    @Test
    public void whenPositiveGetTag() {
        ResponseEntity<Map> testEntity = new ResponseEntity<>(new HashMap(), HttpStatus.OK);
        Mockito.when(gifClient.getRandomGifByTag(anyString(), anyString()))
                .thenReturn(testEntity);
        ResponseEntity<String> result = gifService.getGif("control_test_word");
        assertEquals("control_test_word", result.getBody());
    }
}
