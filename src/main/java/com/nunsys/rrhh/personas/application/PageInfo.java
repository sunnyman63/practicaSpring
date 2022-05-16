package com.nunsys.rrhh.personas.application;

import java.util.Optional;

public class PageInfo {

    private final int page;
    private final int pageSize;

    private PageInfo(PageInfoBuilder builder) {
        this.page = builder.page;
        this.pageSize = builder.pageSize;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public static class PageInfoBuilder {
        private Integer page;
        private Integer pageSize = 10;

        public PageInfoBuilder setPage(Integer page) {
            if (page != null) {
                this.page = page;
            }
            return this;
        }

        public PageInfoBuilder setPageSize(Integer pageSize) {
            if (pageSize != null) {
                this.pageSize = pageSize;
            }
            return this;
        }

        public Optional<PageInfo> build() {
            if(page!=null) {
                PageInfo pageInfo = new PageInfo(this);
                return Optional.of(pageInfo);
            } else {
                return Optional.empty();
            }
        }
    }

}
