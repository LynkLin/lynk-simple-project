package com.lynk.business.ccdi.entity.xml.req.basic;

import com.lynk.business.ccdi.entity.ReqBasic;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;

public interface ReqConvertible {
    /**
     * convert to T
     * @param clz
     * @param <T>
     * @return
     */
    default <T> T convertTo(Class<T> clz) {
        T t = null;
        try {
            t = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (this instanceof BasicInfo && clz.isInstance(ReqBasic.class)) {
            BasicInfo basicInfo = (BasicInfo) this;

            ReqBasic reqBasic = new ReqBasic();

            reqBasic.setQqdbs(basicInfo.getQqdbs());
            reqBasic.setQqcslx(basicInfo.getQqcslx());
            reqBasic.setSqjgdm(basicInfo.getSqjgdm());
            reqBasic.setSqjgmc(basicInfo.getSqjgmc());
            reqBasic.setMbjgdm(basicInfo.getMbjgdm());
            reqBasic.setZtlb(basicInfo.getZtlb());
            reqBasic.setAjlx(basicInfo.getAjlx());
            reqBasic.setJjcd(basicInfo.getJjcd());
            reqBasic.setBeiz(basicInfo.getBeiz());
            reqBasic.setFssj(basicInfo.getFssj());
            reqBasic.setFlwsh(basicInfo.getFlwsh());
            return (T) reqBasic;
        }
        return null;
    }
}