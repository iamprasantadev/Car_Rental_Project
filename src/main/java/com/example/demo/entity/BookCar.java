package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.dto.BookCarDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
//@Getter
//@Setter
public class BookCar {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;	
private Date fromdate;
private Date todate;
private Long days;
private Long price;

private BookcarStatus bookcarStatus;

@ManyToOne(fetch = FetchType.LAZY,optional = false)
@JoinColumn(name="user_id",nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE) 
@JsonIgnore
private User user;

@ManyToOne(fetch = FetchType.LAZY,optional = false)
@JoinColumn(name="car_id",nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE) 
@JsonIgnore
private Car car;

public BookCarDTO getBookcarDTO() {
	BookCarDTO bookCarDto = new BookCarDTO();
	bookCarDto.setId(id);
	bookCarDto.setDays(days);
	bookCarDto.setBookcarStatus(bookcarStatus);
	bookCarDto.setPrice(price);
	bookCarDto.setTodate(todate);
	bookCarDto.setFromdate(fromdate);
	bookCarDto.setEmail(user.getEmail());
	bookCarDto.setUsername(user.getName());
	bookCarDto.setUserId(user.getId() );
	bookCarDto.setCarId(car.getId());
	return bookCarDto;
}

}
