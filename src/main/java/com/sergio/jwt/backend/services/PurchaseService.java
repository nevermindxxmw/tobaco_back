package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.dtos.tobacoo.PurchaseDto;

public interface PurchaseService {

    void purchaseProducts(PurchaseDto purchaseDto,Long userId);
}
