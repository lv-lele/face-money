package com.bearhunting.cameraholder.utils;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;


/***
 * 分页封装工具
 * @author scott
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtils<T> {
  private Integer pageNo;
  private Integer pageSize;
  private Integer pageCount;
  private Long totalCount;
  private List<T> pageContent;

  public static <E, V> PageUtils<V> convert(Page<E> page, List<V> content) {
    PageUtils<V> pageUtils = new PageUtils<>();
    pageUtils.setPageNo(page.getNumber() + 1);
    pageUtils.setPageSize(page.getSize());
    pageUtils.setPageContent(content);
    pageUtils.setPageCount(page.getTotalPages());
    pageUtils.setTotalCount(page.getTotalElements());
    return pageUtils;
  }

  public static <E> PageUtils<E> convert(Page<E> page) {
    PageUtils<E> pageUtils = new PageUtils<>();
    pageUtils.setPageNo(page.getNumber() + 1);
    pageUtils.setPageSize(page.getSize());
    pageUtils.setPageContent(page.getContent());
    pageUtils.setPageCount(page.getTotalPages());
    pageUtils.setTotalCount(page.getTotalElements());
    return pageUtils;
  }

  public static PageUtils listToPage(List<?> list, Integer page, Integer pageSize) {
    long pageTotal = 0;
    int totalPage = 0;
    if (list != null) {
      pageTotal = list.size();
      int len = list.size();

      if (len % pageSize == 0) {
        totalPage = len / pageSize;
      } else {
        totalPage = len / pageSize + 1;
      }
      //进行分页操作
      if (len >= pageSize) {
        if (page != null && page != 0) {
          int start = (page - 1) * pageSize;
          int last;
          if (page == totalPage) {
            last = start + (len % pageSize == 0 ? pageSize : len % pageSize);
          } else {
            last = pageSize * page;
          }

          list = list.subList(start, last);
        }

      } else {
        list = list.subList(0, len);
      }
    }
    PageUtils p = new PageUtils();
    p.setPageNo(page);
    p.setPageSize(pageSize);
    p.setPageCount(totalPage);
    p.setTotalCount(pageTotal);
    p.setPageContent(list);
    return p;
  }
}
