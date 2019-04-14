package com.thread.responsetype.validation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorImpl implements InitializingBean {

    private Validator validator;
    //对对象进行验证
    public ValidationResult vr(Object bean){
     final  ValidationResult VR = new ValidationResult();
        //调用validator校验器来对bean进行校验，结果为一个set
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if(constraintViolationSet.size()>0){
            VR.setIshaserror(true);
            constraintViolationSet.forEach(objectConstraintViolation -> {
                String errmsg = objectConstraintViolation.getMessage();
                String propertyname = objectConstraintViolation.getPropertyPath().toString();
                VR.getResult().put(propertyname,errmsg);
            });
        }

        return  VR;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //通过工厂实例化一个validator
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
}
