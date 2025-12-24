package com.back.shared.member.out;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemberApiClient {
    private static final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:8080/member/api/v1")
            .build();

    public static String getRandomSecureTip() {
        return restClient.get()
                .uri("/members/randomSecureTip")
                .retrieve()
                .body(String.class);
    }
}
