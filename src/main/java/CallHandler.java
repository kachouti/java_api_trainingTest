package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class CallHandler implements HttpHandler {
        private final int code = 200;

    private final String body = "Hello,ok";

    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(code, body.length());
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(body.getBytes());
        }
    }

    public String getBody() {
        return body;
    }

    public int getCode() {
        return code;
    }
}
