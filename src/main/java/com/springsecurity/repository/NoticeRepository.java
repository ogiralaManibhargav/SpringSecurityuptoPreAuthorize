package com.springsecurity.repository;

import com.springsecurity.entity.NoticeDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<NoticeDetails, Long> {
    @Query(value = "from NoticeDetails n where CURDATE() BETWEEN noticeBeginigDate AND noticeEndDate")
    List<NoticeDetails> findAllActiveNotices();
}