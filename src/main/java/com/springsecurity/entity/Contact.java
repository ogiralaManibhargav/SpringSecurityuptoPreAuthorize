package com.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name="contact_messages")
public class Contact {

  /*  @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="contact_id")*/
  @Id
  @Column(name = "contact_id")
    private String contactId;
    @Column(name="contact_name")
    private String name;
    @Column(name="contact_email")
    private String email;

    @Column(name="subject")
    private String subject;

    @Column(name="message")
    private String message;

    @Column(name="create_dt")
    private Date createdDate;


}
