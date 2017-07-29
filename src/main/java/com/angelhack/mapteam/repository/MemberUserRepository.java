package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.model.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberUserRepository extends CrudRepository<MemberUser,String>, JpaSpecificationExecutor {

        @Query("SELECT usr FROM MemberUser usr  WHERE usr.fbId =:fbId")
        public MemberUser searchByFBID(@Param(value ="fbId" ) String fbId);

}
