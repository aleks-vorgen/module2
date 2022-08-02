package org.example.model;

public class ProcessorResult {
    private String view; //url
    private String page;
    private boolean isForward;

    public ProcessorResult(String view, String page, boolean isForward) {
        this.view = view;
        this.page = page;
        this.isForward = isForward;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isForward() {
        return isForward;
    }

    public void setForward(boolean forward) {
        isForward = forward;
    }
}
