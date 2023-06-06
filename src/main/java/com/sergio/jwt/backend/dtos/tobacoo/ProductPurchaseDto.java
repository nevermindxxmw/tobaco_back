package com.sergio.jwt.backend.dtos.tobacoo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPurchaseDto {

    public String id;
    public int count;
}
