package com.example.demo.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServiceController {
    
    public void callExternalApi() {
        try {
            // 1. HttpClient 객체 생성
            HttpClient client = HttpClient.newHttpClient();

            // 2. Request(요청) 설정 (GET 방식 예시)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9090/user")) // 호출할 URL
                    .header("Accept", "application/json") // 헤더 설정
                    .GET()
                    .build();

            // 3. Response(응답) 받기
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. 결과 출력
            System.out.println("상태 코드: " + response.statusCode());
            System.out.println("응답 바디: " + response.body());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}