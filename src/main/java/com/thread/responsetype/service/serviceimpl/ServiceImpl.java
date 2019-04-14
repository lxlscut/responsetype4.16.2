package com.thread.responsetype.service.serviceimpl;

import com.thread.responsetype.dao.InfoMapper;
import com.thread.responsetype.dao.PasswordMapper;
import com.thread.responsetype.entity.Info;
import com.thread.responsetype.entity.Password;
import com.thread.responsetype.exception.Mexception;
import com.thread.responsetype.service.usermodel.Usermodel;
import com.thread.responsetype.validation.ValidationResult;
import com.thread.responsetype.validation.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thread.responsetype.error.erroen;
@Service
public class ServiceImpl implements com.thread.responsetype.service.Service {
@Autowired
private InfoMapper in;
@Autowired
private PasswordMapper pm;
@Autowired
private ValidatorImpl validator;

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

    @Override
    @Transactional
    public void register(Usermodel usermodel) throws Mexception {
        if(usermodel == null){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"参数错误");
        }
//        if(StringUtils.isEmpty(usermodel.getName())
//                ||StringUtils.isEmpty(usermodel.getRegisterMode())
//                ||usermodel.getTelephone()==null
//                ||usermodel.getGerder()==null
//                ||StringUtils.isEmpty(usermodel.getRegisterMode()))
//        {
//            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"参数错误");
//        }

        ValidationResult VR  = validator.vr(usermodel);
        if(VR.isIshaserror()){
            System.out.println(VR);
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,VR.geterrmsg());

        }





        Info info = new Info();
        Password password = new Password();
        info = modelconvertinfo(usermodel);
        password = modelconvertpassword(usermodel);
        System.out.println(info);
        System.out.println(password);
        in.insertSelective(info);
        usermodel.setId(info.getId());
        pm.insertSelective(password);
    }

    @Override
    public Usermodel loginvalidate(Integer tel, String password) throws Mexception {
        Info info = new Info();
        Password password1 = new Password();

        Usermodel usermodel = new Usermodel();
        info =  in.selectBytelphone(tel);
        if(info == null){
            throw new Mexception(erroen.PARMETER_VALIDATION_ERROR,"手机号或密码错误");
        }
        password1 = pm.selectByUserid(info.getId());
        usermodel = convert(info,password1);
        if(!StringUtils.equals(password,usermodel.getPassword())){
            throw  new Mexception(erroen.PARMETER_VALIDATION_ERROR,"注册失败");
        }
        else
            return usermodel;
    }


    public Info modelconvertinfo(Usermodel usermodel){
        Info info = new Info();
        if(usermodel == null)
        {
            return null;
        }
        BeanUtils.copyProperties(usermodel,info);
        return info;
    }
    public Password modelconvertpassword(Usermodel usermodel){
        Password password = new Password();
        if(usermodel == null)
        {
            return null;
        }
        password.setUserId(usermodel.getId());
        password.setPassword(usermodel.getPassword());
        return password;
    }
    public Usermodel convert(Info in,Password pw){
        Usermodel usermodel = new Usermodel();
        BeanUtils.copyProperties(in,usermodel);
        usermodel.setPassword(pw.getPassword());
        return usermodel;
    }
}
