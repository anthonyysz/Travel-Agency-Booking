package com.example.demo.services;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}
