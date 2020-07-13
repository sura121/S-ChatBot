package com.sura.controller;

import com.sura.TestConfig;
import com.sura.domain.weatherinfo.Weather;
import com.sura.filter.WeatherFilter;
import com.sura.repository.WeatherRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
//@WebAppConfiguration
@PropertySource(ignoreResourceNotFound = true,value = "classpath:application.properties")
public class SChatBotControllerTest {



    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private RestDocumentationResultHandler document;

    @Autowired
    private  WeatherRepository weatherRepository;





    @Before
    public void setUp() {

        this.document = document(
                "{class-name}/{method-name}",
                preprocessResponse(prettyPrint())
        );

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .alwaysDo(document)
                .addFilters(new WeatherFilter())
                .build();

    }


    @Test
    public void 날씨_조회() throws Exception {

        this.mockMvc.perform(post("/chat/kkoChat/v1")
        .accept(MediaType.APPLICATION_JSON)
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
                "    \"utterance\": \"서울\",\n" +
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
    public void 도시_리스트() throws Exception {

        this.mockMvc.perform(post("/chat/kkoChat/cities")
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

    @Test
    public void testCode() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        String ts = df.format(date.getTime());
        System.out.println(ts);
        java.sql.Date dt = java.sql.Date.valueOf(ts);

        System.out.println(dt);


        Weather we = Weather.builder().city("서울").temp(36.5).build();

        System.out.println(we.toString());
//
        Weather id = weatherRepository.save(we);
        System.out.println(id.toString());

//        assertThat(id, CoreMatchers.is(Weather.builder()));

//        assertThat(nullTest,is(nullValue()));
    }

}