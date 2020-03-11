package com.hff.services.realize;

import com.hff.entity.Admin;
import com.hff.mappers.AdminMapper;
import com.hff.services.interservice.AdminI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther hff
 * @time 2020/3/3 - 19:00
 **/
@Service
public class AdminImpl implements AdminI {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin checkAdmin(Admin admin) {
        return adminMapper.checkAdmin(admin);
    }
}
