/*
package com.lion.DesignPattern.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    private int index = 0;
    public FilterChain addFilter(Filter f){
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if (filters.size() == index) return;
        Filter f = filters.get(index);
        f.doFilter(request, response, this);
    }
}
*/
