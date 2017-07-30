package com.angelhack.mapteam;

import com.angelhack.mapteam.model.MemberUser;
import com.angelhack.mapteam.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FBCredit {


    static ApplicationContext context = null;

    @Autowired
    private MemberUserRepository memberUserRepository;

    public void run() {
        List<MemberUser> memberUserRepositoryList = (List<MemberUser>) memberUserRepository.findAll();
        for(MemberUser s:memberUserRepositoryList) {
            System.out.println(s.toString());
        }

    }


    public static void main(String[] args) {

        context = new ClassPathXmlApplicationContext("classpath:beans-config.xml");
        FBCredit app1 = (FBCredit) context.getBean("fBCredit");
        app1.run();
    }
}
