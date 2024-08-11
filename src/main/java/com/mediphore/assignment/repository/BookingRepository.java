package com.mediphore.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.BookingSlot;

public interface BookingRepository extends JpaRepository<BookingSlot, Long> {
  List<BookingSlot> findByResource_ResourceId(Long resourceId);

}