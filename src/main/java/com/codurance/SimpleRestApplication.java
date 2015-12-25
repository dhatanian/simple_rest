package com.codurance;

import org.eclipse.jetty.http.HttpStatus;
import spark.Route;

import static spark.Spark.get;

public class SimpleRestApplication {
    public static void main(String[] args) {
        get("/hello", respondWith(new HelloWorld().sayHelloWorld()));
        get("/healthcheck", respondWith("OK"));
    }

    private static Route respondWith(Object responseBody){
        return (request, response) -> {
            response.type("text/plain");
            response.status(HttpStatus.OK_200);
            return responseBody;
        };
    }
}
