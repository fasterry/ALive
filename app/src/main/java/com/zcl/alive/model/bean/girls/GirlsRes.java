package com.zcl.alive.model.bean.girls;

import java.util.List;

public class GirlsRes{
    boolean error;
    List<GirlsInfo> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<GirlsInfo> getResults() {
        return results;
    }

    public void setResults(List<GirlsInfo> results) {
        this.results = results;
    }
}
