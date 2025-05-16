package com.example.service;

import java.util.List;

import com.example.payloads.DeliveryManPayload;

public interface DeliveryManService {
    List<DeliveryManPayload> getAllDeliveryMans();
    DeliveryManPayload getDeliveryManById(int DeliveryManId);
    DeliveryManPayload createDeliveryMan(DeliveryManPayload DeliveryManPayload);
    void deleteDeliveryMan(int DeliveryManId);
}
