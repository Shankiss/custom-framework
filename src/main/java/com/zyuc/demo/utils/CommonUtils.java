package com.zyuc.demo.utils;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/11 16:21
 * @Created by ChenHao
 */
public class CommonUtils {

    //数组扩容(考虑性能时优先使用数组),变长数组
    public static <T> T[] expandCapacity(T[] data, int newLen) {
        newLen = newLen < 0 ? 0 : newLen;
        return Arrays.copyOf(data, newLen);
    }

    //推荐使用subList处理局部列表(删除索引位置为20到30的元素)
    public void dealList() {
        List list = new LinkedList<>();
        //生成子列表之后，不能再操作原列表
        list.subList(20, 30).clear();

        //提高性能，只计算一次list.size()
        for (int i = 0, index = list.size(); i < index; i++) {

        }

        //尽量避免使用split
        String str = "a,b,c";
        System.out.println(StringUtils.split(str,","));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> subList = list.subList(0, 1);
        subList.add(4);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(subList.size());
        System.out.println(subList);


        String str = String.join(",", "123".split(""));
        System.out.println(str);//结果1,2,3

    }


}
