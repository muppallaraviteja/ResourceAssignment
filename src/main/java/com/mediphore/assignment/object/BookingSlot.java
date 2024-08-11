package com.mediphore.assignment.object;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingSlot {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bookingId;
  private Date bookedFrom;
  private Date bookingTo;

  @ManyToOne
  @JoinColumn(name = "resource_id")
  private Resource resource;

  public BookingSlot(Date bookedFrom, Date bookingTo, Resource resource) {
    this.bookedFrom = bookedFrom;
    this.bookingTo = bookingTo;
    this.resource = resource;
  }
}