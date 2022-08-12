package com.nytd.retail.util;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class PageUtil {

    /**
     * 传入page limit list
     *
     * @param page
     * @param limit
     * @param resultList
     * @return
     */
    public static Page getPage(Integer page, Integer limit, List resultList) {

        //获取pageable的参数的页码，从1开始
        int pageNo = page;
        //获取pageable的页显示大小
        int pageSize = limit;

        int fromIndex = pageSize * (pageNo - 1);
        int toIndex = pageSize * pageNo;

        if (toIndex > resultList.size()) {
            toIndex = resultList.size();
        }
        if (fromIndex > toIndex) {
            fromIndex = toIndex;
        }
        //获取list的分页集合
        List result = resultList.subList(fromIndex, toIndex);
        //创建page对象，并且可以排序
        Page pageResult = new PageImpl(result, new PageRequest(pageNo - 1, pageSize), resultList.size());

        return pageResult;
    }
}

