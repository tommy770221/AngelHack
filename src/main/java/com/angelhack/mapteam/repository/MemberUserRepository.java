package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.Country;
import com.angelhack.mapteam.model.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberUserRepository extends CrudRepository<MemberUser,String>, JpaSpecificationExecutor {

        @Query("SELECT usr FROM MemberUser usr  WHERE usr.fbId =:fbId")
        public MemberUser searchByFBID(@Param(value ="fbId" ) String fbId);


        @Query("SELECT usr FROM MemberUser usr  WHERE usr.email =:email")
        public MemberUser searchByEmail(@Param(value ="email" ) String email);


        @Query("SELECT usr FROM MemberUser usr  WHERE usr.lon >=:lonMin and usr.lon<=:lonMax and usr.lat>=:latMin and usr.lat<=:latMax and usr.ageRange in :ageRange and usr.gender in :gender and usr.locale in :locale ")
        public List<MemberUser> searchByDistance(@Param(value ="lonMin" ) Double lonMin,
                                                 @Param(value ="lonMax" )  Double lonMax,
                                                 @Param(value ="latMin" )  Double latMin,
                                                 @Param(value ="latMax" )  Double latMax,
                                                 @Param(value ="ageRange" ) List<String> ageRange,
                                                 @Param(value ="gender" ) List<String> gender,
                                                 @Param(value ="locale" ) List<String> locale);
}
