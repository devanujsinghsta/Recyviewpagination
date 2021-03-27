package com.example.anujtest.networkingCalling;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelData {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("about")
        @Expose
        private String about;
        @SerializedName("submitted")
        @Expose
        private Integer submitted;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("submission_count")
        @Expose
        private Integer submissionCount;
        @SerializedName("comment_count")
        @Expose
        private Integer commentCount;
        @SerializedName("created_at")
        @Expose
        private Integer createdAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public Integer getSubmitted() {
            return submitted;
        }

        public void setSubmitted(Integer submitted) {
            this.submitted = submitted;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getSubmissionCount() {
            return submissionCount;
        }

        public void setSubmissionCount(Integer submissionCount) {
            this.submissionCount = submissionCount;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public Integer getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Integer createdAt) {
            this.createdAt = createdAt;
        }

    }

}
