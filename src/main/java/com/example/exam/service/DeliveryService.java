package com.example.exam.service;

import com.example.exam.model.Delivery;
import com.example.exam.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class DeliveryService implements CrudInterface<Delivery, Long>{
    private DeliveryRepository deliveryRepository;


    @Override
    public Set<Delivery> findAll() {
        return new HashSet<>(deliveryRepository.findAll());
    }
    @Override
    public Delivery save(Delivery object) {
        return deliveryRepository.save(object);
    }

    @Override
    public void delete(Delivery object) {
        deliveryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        deliveryRepository.deleteById(aLong);
    }

    @Override
    public Optional<Delivery> findById(Long aLong) {
        return deliveryRepository.findById(aLong);
    }
}
