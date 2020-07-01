package com.sura.config;

import com.sura.global.JsonParse;
import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MyHttpServletWrapper extends HttpServletRequestWrapper {

    private byte[] b;

    public MyHttpServletWrapper (HttpServletRequest request) throws IOException {
        super(request);

        InputStream is = super.getInputStream();
        b = IOUtils.toByteArray(is);

        String reqeustBody = new String(b);

        System.out.println("RequestBody : " + reqeustBody);

        JsonParse jsonParse = new JsonParse();

        Map requestWord = jsonParse.parseResponse("userRequest",reqeustBody);

        String city = requestWord.get("utterance").toString();

        request.setAttribute("city",city);


    }

    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bis = new ByteArrayInputStream(b);
        return new ServletInputStreamImpl(bis);

    }

    class ServletInputStreamImpl extends ServletInputStream{

        private InputStream is;



        public ServletInputStreamImpl(InputStream bis){

            is = bis;

        }



        public int read() throws IOException {

            return is.read();

        }



        public int read(byte[] b) throws IOException {

            return is.read(b);

        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }
    }
}


