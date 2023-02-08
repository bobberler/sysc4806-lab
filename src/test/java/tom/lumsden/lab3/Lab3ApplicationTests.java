package tom.lumsden.lab3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@SpringBootTest
@AutoConfigureMockMvc
class Lab3ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void page() throws Exception{
        mockMvc.perform(get("/page?id=1")).andExpect(content().string(containsString("Address Book 1")));


    }

    @Test
    void addBuddy() throws Exception{
        mockMvc.perform(get("/buddyinfo/add")
                .param("name", "tom")
                .param("address", "street")
                .param("phoneNumber", "613")
                .param("bookId", "1")).andExpect(status().isOk());

        mockMvc.perform(get("/buddyinfo/add")
                .param("name", "joe")
                .param("address", "street")
                .param("phoneNumber", "613")
                .param("bookId", "1")).andExpect(status().isOk());

        mockMvc.perform(get("/addressbook")
                        .param("id", "1"))
                .andExpect(content().string(containsString("tom")))
                .andExpect(content().string(containsString("joe")));

    }


}
