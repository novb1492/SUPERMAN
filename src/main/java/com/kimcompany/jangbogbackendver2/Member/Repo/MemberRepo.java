package com.kimcompany.jangbogbackendver2.Member.Repo;

import com.kimcompany.jangbogbackendver2.Member.Model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<MemberEntity,Long>, MemberSupport {

    @Query("SELECT m from MemberEntity  m where m.email=:email")
    Optional<MemberEntity> findByEmail(@Param("email") String email);
}
