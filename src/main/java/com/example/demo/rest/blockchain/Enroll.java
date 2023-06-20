package com.example.demo.rest.blockchain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enroll {

    private String profile;
    private List<String> hosts;
    private String certificate_request;

}
