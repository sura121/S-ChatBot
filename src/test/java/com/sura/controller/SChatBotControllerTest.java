package com.sura.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SChatBotControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void helloBot() throws Exception {

        ResultActions result = this.mockMvc.perform(post("/chat/kkoChat/v1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "  \"intent\": {\n" +
                "    \"id\": \"8lgsct2k2smg1x5do2t09m29\",\n" +
                "    \"name\": \"블록 이름\"\n" +
                "  },\n" +
                "  \"userRequest\": {\n" +
                "    \"timezone\": \"Asia/Seoul\",\n" +
                "    \"params\": {\n" +
                "      \"ignoreMe\": \"true\"\n" +
                "    },\n" +
                "    \"block\": {\n" +
                "      \"id\": \"8lgsct2k2smg1x5do2t09m29\",\n" +
                "      \"name\": \"블록 이름\"\n" +
                "    },\n" +
                "    \"utterance\": \"발화 내용\",\n" +
                "    \"lang\": null,\n" +
                "    \"user\": {\n" +
                "      \"id\": \"842040\",\n" +
                "      \"type\": \"accountId\",\n" +
                "      \"properties\": {}\n" +
                "    }\n" +
                "  },\n" +
                "  \"bot\": {\n" +
                "    \"id\": \"5edb3bd3c7ab2b0001df0a20\",\n" +
                "    \"name\": \"봇 이름\"\n" +
                "  },\n" +
                "  \"action\": {\n" +
                "    \"name\": \"gymyangwyn\",\n" +
                "    \"clientExtra\": null,\n" +
                "    \"params\": {},\n" +
                "    \"id\": \"uftn2y4kdpdmowil4ai58b62\",\n" +
                "    \"detailParams\": {}\n" +
                "  }\n" +
                "}")
        ).andDo(print());



    }


    @Test
    public void Cities() throws Exception {

        ResultActions result = this.mockMvc.perform(post("/chat/kkoChat/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"intent\": {\n" +
                        "    \"id\": \"8lgsct2k2smg1x5do2t09m29\",\n" +
                        "    \"name\": \"블록 이름\"\n" +
                        "  },\n" +
                        "  \"userRequest\": {\n" +
                        "    \"timezone\": \"Asia/Seoul\",\n" +
                        "    \"params\": {\n" +
                        "      \"ignoreMe\": \"true\"\n" +
                        "    },\n" +
                        "    \"block\": {\n" +
                        "      \"id\": \"8lgsct2k2smg1x5do2t09m29\",\n" +
                        "      \"name\": \"블록 이름\"\n" +
                        "    },\n" +
                        "    \"utterance\": \"도시\",\n" +
                        "    \"lang\": null,\n" +
                        "    \"user\": {\n" +
                        "      \"id\": \"842040\",\n" +
                        "      \"type\": \"accountId\",\n" +
                        "      \"properties\": {}\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"bot\": {\n" +
                        "    \"id\": \"5edb3bd3c7ab2b0001df0a20\",\n" +
                        "    \"name\": \"봇 이름\"\n" +
                        "  },\n" +
                        "  \"action\": {\n" +
                        "    \"name\": \"gymyangwyn\",\n" +
                        "    \"clientExtra\": null,\n" +
                        "    \"params\": {},\n" +
                        "    \"id\": \"uftn2y4kdpdmowil4ai58b62\",\n" +
                        "    \"detailParams\": {}\n" +
                        "  }\n" +
                        "}")
        ).andDo(print());



    }
}