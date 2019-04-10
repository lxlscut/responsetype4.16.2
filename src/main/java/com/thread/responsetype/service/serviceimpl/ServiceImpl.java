package com.thread.responsetype.service.serviceimpl;

import com.thread.responsetype.dao.InfoMapper;
import com.thread.responsetype.dao.PasswordMapper;
import com.thread.responsetype.entity.Info;
import com.thread.responsetype.entity.Password;
import com.thread.responsetype.service.usermodel.Usermodel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements com.thread.responsetype.service.Service {
@Autowired
private InfoMapper in;
@Autowired
private PasswordMapper pm;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Info record) {
        return 0;
    }

    @Override
    public int insertSelective(Info record) {
        return 0;
    }

    @Override
    public Usermodel selectByPrimaryKey(Integer id) {
        Info i = in.selectByPrimaryKey(id);
        if(i == null){
            return null;
        }
        Password password = pm.selectByUserid(i.getId());
        if(i == null){
            return null;
        }
        return convert(i,password);
    }

    @Override
    public int updateByPrimaryKeySelective(Info record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Info record) {
        return 0;
    }

    public Usermodel convert(Info in,Password pw){
        Usermodel usermodel = new Usermodel();
        BeanUtils.copyProperties(in,usermodel);
        usermodel.setPassword(pw.getPassword());
        return usermodel;
    }
}
