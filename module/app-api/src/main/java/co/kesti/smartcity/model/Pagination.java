package co.kesti.smartcity.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination<T> {
    private int previousPage;
    private int nextPage;
    private int firstPage;
    private int lastPage;
    private int page; // 현재 페이지
    private List<Integer> pages;
    private List<T> contents;
    private long totalContents;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
}