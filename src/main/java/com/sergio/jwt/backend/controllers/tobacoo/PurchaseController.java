package com.sergio.jwt.backend.controllers.tobacoo;

import com.sergio.jwt.backend.config.UserAuthenticationProvider;
import com.sergio.jwt.backend.dtos.tobacoo.PurchaseDto;
import com.sergio.jwt.backend.services.PurchaseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final UserAuthenticationProvider userAuthenticationProvider;
    private final PurchaseService purchaseService;

    public PurchaseController(UserAuthenticationProvider userAuthenticationProvider, PurchaseService purchaseService) {
        this.userAuthenticationProvider = userAuthenticationProvider;
        this.purchaseService = purchaseService;
    }

    @PostMapping()
    public void purchaseProducts(@RequestBody() PurchaseDto purchaseDto, HttpServletRequest request){
        System.out.println(userAuthenticationProvider.getUserId(request));
        purchaseService.purchaseProducts(purchaseDto,userAuthenticationProvider.getUserId(request));

    }
}
