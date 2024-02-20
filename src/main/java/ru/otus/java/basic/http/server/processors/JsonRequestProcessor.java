package ru.otus.java.basic.http.server.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.http.server.HttpRequest;
import ru.otus.java.basic.http.server.Json;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

    public class JsonRequestProcessor implements RequestProcessor {
        Json myObject = new Json("123");
        String jsonResponse = new Gson().toJson(myObject);
        @Override
        public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
            String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n" + jsonResponse;
            output.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }
