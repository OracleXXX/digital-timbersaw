package com.digitaltimbersawapi.repository;

import com.digitaltimbersawapi.domain.ContactUsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ContactUsRepository extends JpaRepository<ContactUsEntity, Long> {

    @Query(value = "select * from contact_us where name like ?1 and is_delete = ?2", nativeQuery = true)
    Page<ContactUsEntity> findByNameLikeAndIsDel(Pageable pageable, String name, Integer isDel);

    @Transactional
    @Modifying
    @Query(value = "update contact_us set is_delete = 1 where id = ?1", nativeQuery = true)
    void logicDeleteById(Long id);
}
