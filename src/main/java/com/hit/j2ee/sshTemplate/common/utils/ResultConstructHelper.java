package com.hit.j2ee.sshTemplate.common.utils;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Du on 2016-12-29.
 */
//T是被转换的数据库实体类泛型，T2是转换结果的返回类泛型
public class ResultConstructHelper<T,T2> {
    /**
     *
     * @param resource 被转换的数据库实体对象
     * @param clazz 要转换成为的返回类class
     * @return T2 返回转换结果的实体类
     */
    public T2 construct(T resource,Class clazz){
        T2 result = null;
        if (resource != null){
            try {
                result = (T2)clazz.newInstance(); //创建结果对象
                //获取转换结果类中，参数为resource的构造函数
                Constructor<T> constructor = clazz.getDeclaredConstructor(resource.getClass());
                //执行构造函数
                result = (T2)constructor.newInstance(resource);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<T2> constructList(List<T> resource, Class clazz){
        List<T2> result = new ArrayList<T2>(0);
        try {
            if (resource != null && resource.size()!=0) {
                List<T> list = resource;
                Class tItemClass = list.get(0).getClass();
                Constructor<T> constructor = clazz.getDeclaredConstructor(tItemClass);
                for (Object item : list) {
                    result.add((T2) constructor.newInstance(item));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public T2 getViewResult(T before,Class clazz){
        T2 after = null;
        try {
            Method method = clazz.getMethod("getId", null); //取出Hibernate返回的视图对象中的Id字段
            after = (T2) method.invoke(before);
        } catch (Exception e){
            e.printStackTrace();
        }
        return after;
    }

    public List<T2> getViewResultList(List<T> before, Class clazz){
        T2 after = null;
        List<T2> returnList = new ArrayList<T2>();
        try {
            Method method = clazz.getMethod("getId", null); //取出Hibernate返回的视图对象中的Id字段
            after = (T2) method.invoke(before);
            returnList.add(after);
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnList;
    }

    public void getViewPageResult(Page<T> page,Class clazz){
        List<T> list = page.getResult(); //获取Page的视图返回结果（内嵌联合主键Id的）
        List<T2> listAfter = new ArrayList<T2>(0); //真正要返回给前端的结果
        T2 resultTemp = null;
        try {
            Method method = clazz.getMethod("getId", null); //取出Hibernate返回的视图对象中的Id字段
            for (T temp : list) {
                resultTemp = (T2) method.invoke(temp);
                listAfter.add(resultTemp); //取出并放到最终要返回的结果类型中
            }
            page.setResult(listAfter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
