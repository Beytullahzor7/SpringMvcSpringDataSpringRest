package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//Entity
@Entity
@Table(name = "computer")
public class ComputerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computerId;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "computer_trade")
    private String computerTrade;

    @Column(name = "computer_price")
    private String computerPrice;

    @Column(name = "created_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
