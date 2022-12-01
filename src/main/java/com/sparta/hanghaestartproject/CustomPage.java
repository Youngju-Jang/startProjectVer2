package com.sparta.hanghaestartproject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomPage<T> extends PageImpl<T> {
     
     @Override
     public String toString() {
          return "총 페이지: " +this.getTotalPages() +"\n"
               + "현재페이지: " + this.getNumber();
     }
     
     /**
      * Constructor of {@code PageImpl}.
      *
      * @param content  the content of this page, must not be {@literal null}.
      * @param pageable the paging information, must not be {@literal null}.
      * @param total    the total amount of items available. The total might be adapted considering the length of the content
      *                 given, if it is going to be the content of the last page. This is in place to mitigate inconsistencies.
      */
     public CustomPage(List content, Pageable pageable, long total) {
          super(content, pageable, total);
     }
     
     /**
      * Creates a new {@link PageImpl} with the given content. This will result in the created {@link Page} being identical
      * to the entire {@link List}.
      *
      * @param content must not be {@literal null}.
      */
     public CustomPage(List content) {
          super(content);
     }
}
