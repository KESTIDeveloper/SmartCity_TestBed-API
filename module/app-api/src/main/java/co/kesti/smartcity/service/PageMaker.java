package co.kesti.smartcity.service;

import co.kesti.smartcity.model.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class PageMaker {

    public Pagination toPagination(Page page, int pageCntPerView) {

        int curPage = page.getNumber() + 1;
        int totalPage = page.getTotalPages();
        int startPage = (curPage / pageCntPerView) * pageCntPerView + 1;

        if (curPage % pageCntPerView == 0) {
            startPage = ((curPage - 1) / pageCntPerView) * pageCntPerView + 1;
        }
        int previousPage = Math.max(1, startPage - pageCntPerView);
        int nextPage = Math.min(page.getTotalPages(), startPage + pageCntPerView);

        int lastPage = totalPage;

        log.info("totalPage: {}", totalPage);
        boolean hasNextPage = (lastPage > nextPage) ? true : false;
        boolean hasPreviousPage = (curPage > pageCntPerView) ? true : false;

        List<Integer> pages = IntStream.range(startPage, startPage + pageCntPerView)
                .filter(num -> num <= lastPage)
                .boxed()
                .collect(Collectors.toList());

        return Pagination.builder()
                .previousPage(previousPage)
                .nextPage(nextPage)
                .lastPage(lastPage)
                .firstPage(1)
                .page(curPage)
                .totalContents(page.getTotalElements())
                .contents(page.getContent())
                .hasPreviousPage(hasPreviousPage)
                .hasNextPage(hasNextPage)
                .pages(pages)
                .build();
    }
}
