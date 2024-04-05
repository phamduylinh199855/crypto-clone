package com.linhpd.project.cryptoclone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Setter
@Getter
public class ApiResponse {
    private Status status;
    private List<CryptoData> data;

}

