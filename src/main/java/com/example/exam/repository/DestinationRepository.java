package com.example.exam.repository;

import com.example.exam.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
