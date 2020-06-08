package com.sura.global;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(@NonNull ClientHttpResponse clientHttpResponse) throws IOException {
        final HttpStatus statusCode = clientHttpResponse.getStatusCode();
        return !statusCode.is2xxSuccessful();
    }

    @Override
    public void handleError(@NonNull ClientHttpResponse response) throws IOException {

        final String error = getErrorAsString(response);
        log.error("================");
        log.error("Headers: {}", response.getHeaders());
        log.error("Response Status : {}", response.getRawStatusCode());
        log.error("Request body: {}", error);
        log.error("================");

    }

    private String getErrorAsString(@NonNull final ClientHttpResponse response) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()))) {
            return br.readLine();
        }
    }
}
