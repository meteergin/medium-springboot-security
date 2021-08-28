package com.meteergin.mediumspringbootsecurity.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author mergin
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String prefix;
    private String title;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDay;
    private String email;
    private String password;
    private Integer status;
}
