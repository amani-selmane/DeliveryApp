package com.example.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.DeliveryMan;
import com.example.payloads.DeliveryManPayload;
import com.example.repositry.DeliveryManRepository;
import com.example.service.DeliveryManService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryManServiceImpl implements DeliveryManService {

    @Autowired
    private DeliveryManRepository DeliveryManRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DeliveryManPayload> getAllDeliveryMans() {
        List<DeliveryMan> DeliveryMans = DeliveryManRepository.findAll();
        return DeliveryMans.stream()
                .map(DeliveryMan -> modelMapper.map(DeliveryMan, DeliveryManPayload.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryManPayload getDeliveryManById(int DeliveryManId) {
        Optional<DeliveryMan> optionalDeliveryMan = DeliveryManRepository.findById(DeliveryManId);
        return optionalDeliveryMan.map(DeliveryMan -> modelMapper.map(DeliveryMan, DeliveryManPayload.class)).orElse(null);
    }

    @Override
    public DeliveryManPayload createDeliveryMan(DeliveryManPayload DeliveryManPayload) {
        DeliveryMan DeliveryMan = modelMapper.map(DeliveryManPayload, DeliveryMan.class);
        DeliveryMan savedDeliveryMan = DeliveryManRepository.save(DeliveryMan);
        return modelMapper.map(savedDeliveryMan, DeliveryManPayload.class);
    }

    @Override
    public void deleteDeliveryMan(int DeliveryManId) {
        DeliveryManRepository.deleteById(DeliveryManId);
    }

}
