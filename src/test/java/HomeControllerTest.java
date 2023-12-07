import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import hookah.controller.HomeController;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePageTest() throws Exception {
        mockMvc.perform(get("/")) /*Выполнение GET-запроса*/
                .andExpect(status().isOk()) /*Ожидание HTTP-ответа 200*/
                .andExpect(view().name("home")) /*Ожидание ответа "home"*/
                .andExpect(content().string(containsString("Кальянчик")));
    }
}
