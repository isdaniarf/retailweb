import isdaniarf.retailweb.Application;
import isdaniarf.retailweb.controller.BillingRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by Isdaniar_F on 16/06/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BillingRestTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void userOrItemNotFound() throws Exception {
        mockMvc.perform(get("/api/getPrice?user=Chris&item=Mirror")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(content().string(BillingRestController.MSG_USER_OR_ITEM_NOT_FOUND));
    }

    @Test
    public void getPriceForEmployeeWithNonGrocery() throws Exception {
        mockMvc.perform(get("/api/getPrice?user=John&item=Chair")
                .contentType(MediaType.TEXT_PLAIN))
                .andExpect(content().string("65.0"));
    }

}
