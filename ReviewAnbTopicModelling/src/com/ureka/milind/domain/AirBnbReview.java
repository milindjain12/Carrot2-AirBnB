package com.ureka.milind.domain;

import java.util.Date;

public class AirBnbReview {
	private Long listingId;
	private Long id;
	private Date date;
	private Long reviewerId;
	private String reviewerName;
	private String review;

	public AirBnbReview() {
	}

	public AirBnbReview(Long listingId, Long id, Date date, Long reviewerId, String reviewerName, String review) {
		super();
		this.listingId = listingId;
		this.id = id;
		this.date = date;
		this.reviewerId = reviewerId;
		this.reviewerName = reviewerName;
		this.review = review;
	}

	public Long getListingId() {
		return listingId;
	}

	public void setListingId(Long listingId) {
		this.listingId = listingId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
