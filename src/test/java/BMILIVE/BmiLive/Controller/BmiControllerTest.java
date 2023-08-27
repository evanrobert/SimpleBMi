package BMILIVE.BmiLive.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BmiControllerTest {
    @Autowired
    MockMvc mockMvc;
  @Test
    public void testShowBMIForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testCalculateBMI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate-bmi")
                        .param("height", "1.75")
                        .param("weight", "70"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("bmi"))
                .andExpect(MockMvcResultMatchers.view().name("bmi-form"));
    }

    @Test
    public void testCalculateBmiHeightAndWeight() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate-bmi-2")
                        .param("height", "65")
                        .param("weight", "150"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("bmi"))
                .andExpect(MockMvcResultMatchers.view().name("bmi-form"));
    }
}



