package com.springsecurity.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Data
@Table(name="notice_details")
public class NoticeDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="notice_id")
    private Long noticeId;
    @Column(name="notice_summary")
    private String noticeSummary;
    @Column(name="notice_details")
    private String noticeDetails;
    @Column(name="notic_beg_dt")
    private Date noticeBeginigDate;
    @Column(name="notic_end_dt")
    private Date noticeEndDate;
    @Column(name="create_dt")
    private Date createdDate;
    @Column(name="update_dt")
    private Date updateDate;
}
