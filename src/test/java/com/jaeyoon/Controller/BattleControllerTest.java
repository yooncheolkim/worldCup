package com.jaeyoon.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaeyoon.Model.BattleInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BattleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void last() throws Exception{
        BattleInfo battleInfo = new BattleInfo();
        List<String> selected = new ArrayList<>();
        selected.add("1");
        battleInfo.setSelected(selected);

        String json = objectMapper.writeValueAsString(selected);

        mockMvc.perform(get("/hello/last?winner=64")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(json))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
