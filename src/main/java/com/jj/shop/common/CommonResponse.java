package com.jj.shop.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse {
    private Long id;
    private String message;
}
