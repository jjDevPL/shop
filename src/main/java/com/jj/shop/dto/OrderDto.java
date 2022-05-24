package com.jj.shop.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;
@Data
public class OrderDto {
    @NotNull
    @NotEmpty
    //prodid, count
    private Map<Long,Integer> productList;
    @NotNull
    private Long userId;
}
