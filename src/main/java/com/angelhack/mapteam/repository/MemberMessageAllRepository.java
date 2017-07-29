package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.MemberMessageAll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMessageAllRepository extends CrudRepository<MemberMessageAll,String> {

    @Query("SELECT usr FROM MemberMessageAll usr  WHERE usr.fromEmail =:fromEmail " +
            " order by usr.createDate desc")
    public List<MemberMessageAll> searchByEmail(@Param(value ="fromEmail" ) String fromEmail);
}
