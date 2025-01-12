package com.lab.model;
import java.util.ArrayList;
import java.util.List;
public class SlabOrderExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public SlabOrderExample() {
		oredCriteria = new ArrayList<>();
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	public boolean isDistinct() {
		return distinct;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
	}
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;
		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}
		public boolean isValid() {
			return criteria.size() > 0;
		}
		public List<Criterion> getAllCriteria() {
			return criteria;
		}
		public List<Criterion> getCriteria() {
			return criteria;
		}
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}
		public Criteria andIdIsNotNull(){
			addCriterion("id is not null");
			return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "Id");
			return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}
		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andStuIdIsNull() {
			addCriterion("stu_id is null");
			return (Criteria) this;
		}
		public Criteria andStuIdIsNotNull(){
			addCriterion("stu_id is not null");
			return (Criteria) this;
		}
		public Criteria andStuIdEqualTo(Integer value) {
			addCriterion("stu_id =", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdNotEqualTo(Integer value) {
			addCriterion("stu_id <>", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdGreaterThan(Integer value) {
			addCriterion("stu_id >", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("stu_id >=", value, "StuId");
			return (Criteria) this;
		}
		public Criteria andStuIdLessThan(Integer value) {
			addCriterion("stu_id <", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdLessThanOrEqualTo(Integer value) {
			addCriterion("stu_id <=", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdIn(List<Integer> values) {
			addCriterion("stu_id in", values, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdNotIn(List<Integer> values) {
			addCriterion("stu_id not in", values, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdBetween(Integer value1, Integer value2) {
			addCriterion("stu_id between", value1, value2, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
			addCriterion("stu_id not between", value1, value2, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdLike(Integer value) {
			addCriterion("stu_id like", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuIdNotLike(Integer value) {
			addCriterion("stu_id not like", value, "stuId");
			return (Criteria) this;
		}
		public Criteria andStuNoIsNull() {
			addCriterion("stu_no is null");
			return (Criteria) this;
		}
		public Criteria andStuNoIsNotNull(){
			addCriterion("stu_no is not null");
			return (Criteria) this;
		}
		public Criteria andStuNoEqualTo(String value) {
			addCriterion("stu_no =", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotEqualTo(String value) {
			addCriterion("stu_no <>", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoGreaterThan(String value) {
			addCriterion("stu_no >", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoGreaterThanOrEqualTo(String value) {
			addCriterion("stu_no >=", value, "StuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLessThan(String value) {
			addCriterion("stu_no <", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLessThanOrEqualTo(String value) {
			addCriterion("stu_no <=", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoIn(List<String> values) {
			addCriterion("stu_no in", values, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotIn(List<String> values) {
			addCriterion("stu_no not in", values, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoBetween(String value1, String value2) {
			addCriterion("stu_no between", value1, value2, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotBetween(String value1, String value2) {
			addCriterion("stu_no not between", value1, value2, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoLike(String value) {
			addCriterion("stu_no like", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNoNotLike(String value) {
			addCriterion("stu_no not like", value, "stuNo");
			return (Criteria) this;
		}
		public Criteria andStuNameIsNull() {
			addCriterion("stu_name is null");
			return (Criteria) this;
		}
		public Criteria andStuNameIsNotNull(){
			addCriterion("stu_name is not null");
			return (Criteria) this;
		}
		public Criteria andStuNameEqualTo(String value) {
			addCriterion("stu_name =", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameNotEqualTo(String value) {
			addCriterion("stu_name <>", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameGreaterThan(String value) {
			addCriterion("stu_name >", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameGreaterThanOrEqualTo(String value) {
			addCriterion("stu_name >=", value, "StuName");
			return (Criteria) this;
		}
		public Criteria andStuNameLessThan(String value) {
			addCriterion("stu_name <", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameLessThanOrEqualTo(String value) {
			addCriterion("stu_name <=", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameIn(List<String> values) {
			addCriterion("stu_name in", values, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameNotIn(List<String> values) {
			addCriterion("stu_name not in", values, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameBetween(String value1, String value2) {
			addCriterion("stu_name between", value1, value2, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameNotBetween(String value1, String value2) {
			addCriterion("stu_name not between", value1, value2, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameLike(String value) {
			addCriterion("stu_name like", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andStuNameNotLike(String value) {
			addCriterion("stu_name not like", value, "stuName");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNull() {
			addCriterion("room_id is null");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNotNull(){
			addCriterion("room_id is not null");
			return (Criteria) this;
		}
		public Criteria andRoomIdEqualTo(Integer value) {
			addCriterion("room_id =", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotEqualTo(Integer value) {
			addCriterion("room_id <>", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThan(Integer value) {
			addCriterion("room_id >", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("room_id >=", value, "RoomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThan(Integer value) {
			addCriterion("room_id <", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
			addCriterion("room_id <=", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdIn(List<Integer> values) {
			addCriterion("room_id in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotIn(List<Integer> values) {
			addCriterion("room_id not in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdBetween(Integer value1, Integer value2) {
			addCriterion("room_id between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
			addCriterion("room_id not between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLike(Integer value) {
			addCriterion("room_id like", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotLike(Integer value) {
			addCriterion("room_id not like", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andAppReasonIsNull() {
			addCriterion("app_reason is null");
			return (Criteria) this;
		}
		public Criteria andAppReasonIsNotNull(){
			addCriterion("app_reason is not null");
			return (Criteria) this;
		}
		public Criteria andAppReasonEqualTo(String value) {
			addCriterion("app_reason =", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonNotEqualTo(String value) {
			addCriterion("app_reason <>", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonGreaterThan(String value) {
			addCriterion("app_reason >", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonGreaterThanOrEqualTo(String value) {
			addCriterion("app_reason >=", value, "AppReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonLessThan(String value) {
			addCriterion("app_reason <", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonLessThanOrEqualTo(String value) {
			addCriterion("app_reason <=", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonIn(List<String> values) {
			addCriterion("app_reason in", values, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonNotIn(List<String> values) {
			addCriterion("app_reason not in", values, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonBetween(String value1, String value2) {
			addCriterion("app_reason between", value1, value2, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonNotBetween(String value1, String value2) {
			addCriterion("app_reason not between", value1, value2, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonLike(String value) {
			addCriterion("app_reason like", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andAppReasonNotLike(String value) {
			addCriterion("app_reason not like", value, "appReason");
			return (Criteria) this;
		}
		public Criteria andCollegeIdIsNull() {
			addCriterion("college_id is null");
			return (Criteria) this;
		}
		public Criteria andCollegeIdIsNotNull(){
			addCriterion("college_id is not null");
			return (Criteria) this;
		}
		public Criteria andCollegeIdEqualTo(Integer value) {
			addCriterion("college_id =", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdNotEqualTo(Integer value) {
			addCriterion("college_id <>", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdGreaterThan(Integer value) {
			addCriterion("college_id >", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("college_id >=", value, "CollegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdLessThan(Integer value) {
			addCriterion("college_id <", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
			addCriterion("college_id <=", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdIn(List<Integer> values) {
			addCriterion("college_id in", values, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdNotIn(List<Integer> values) {
			addCriterion("college_id not in", values, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
			addCriterion("college_id between", value1, value2, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("college_id not between", value1, value2, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdLike(Integer value) {
			addCriterion("college_id like", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andCollegeIdNotLike(Integer value) {
			addCriterion("college_id not like", value, "collegeId");
			return (Criteria) this;
		}
		public Criteria andOrderDateIsNull() {
			addCriterion("order_date is null");
			return (Criteria) this;
		}
		public Criteria andOrderDateIsNotNull(){
			addCriterion("order_date is not null");
			return (Criteria) this;
		}
		public Criteria andOrderDateEqualTo(String value) {
			addCriterion("order_date =", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateNotEqualTo(String value) {
			addCriterion("order_date <>", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateGreaterThan(String value) {
			addCriterion("order_date >", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateGreaterThanOrEqualTo(String value) {
			addCriterion("order_date >=", value, "OrderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateLessThan(String value) {
			addCriterion("order_date <", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateLessThanOrEqualTo(String value) {
			addCriterion("order_date <=", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateIn(List<String> values) {
			addCriterion("order_date in", values, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateNotIn(List<String> values) {
			addCriterion("order_date not in", values, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateBetween(String value1, String value2) {
			addCriterion("order_date between", value1, value2, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateNotBetween(String value1, String value2) {
			addCriterion("order_date not between", value1, value2, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateLike(String value) {
			addCriterion("order_date like", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderDateNotLike(String value) {
			addCriterion("order_date not like", value, "orderDate");
			return (Criteria) this;
		}
		public Criteria andOrderTimeIsNull() {
			addCriterion("order_time is null");
			return (Criteria) this;
		}
		public Criteria andOrderTimeIsNotNull(){
			addCriterion("order_time is not null");
			return (Criteria) this;
		}
		public Criteria andOrderTimeEqualTo(Integer value) {
			addCriterion("order_time =", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeNotEqualTo(Integer value) {
			addCriterion("order_time <>", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeGreaterThan(Integer value) {
			addCriterion("order_time >", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_time >=", value, "OrderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeLessThan(Integer value) {
			addCriterion("order_time <", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeLessThanOrEqualTo(Integer value) {
			addCriterion("order_time <=", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeIn(List<Integer> values) {
			addCriterion("order_time in", values, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeNotIn(List<Integer> values) {
			addCriterion("order_time not in", values, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeBetween(Integer value1, Integer value2) {
			addCriterion("order_time between", value1, value2, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("order_time not between", value1, value2, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeLike(Integer value) {
			addCriterion("order_time like", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderTimeNotLike(Integer value) {
			addCriterion("order_time not like", value, "orderTime");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIsNull() {
			addCriterion("order_status is null");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIsNotNull(){
			addCriterion("order_status is not null");
			return (Criteria) this;
		}
		public Criteria andOrderStatusEqualTo(Integer value) {
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotEqualTo(Integer value) {
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusGreaterThan(Integer value) {
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_status >=", value, "OrderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLessThan(Integer value) {
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusIn(List<Integer> values) {
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotIn(List<Integer> values) {
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_status not between", value1, value2, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusLike(Integer value) {
			addCriterion("order_status like", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andOrderStatusNotLike(Integer value) {
			addCriterion("order_status not like", value, "orderStatus");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}
		public Criteria andCreateDateIsNotNull(){
			addCriterion("create_date is not null");
			return (Criteria) this;
		}
		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("create_date >=", value, "CreateDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThan(String value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateLike(String value) {
			addCriterion("create_date like", value, "createDate");
			return (Criteria) this;
		}
		public Criteria andCreateDateNotLike(String value) {
			addCriterion("create_date not like", value, "createDate");
			return (Criteria) this;
		}
	}
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;
		public String getCondition() {
			return condition;
		}
		public Object getValue() {
			return value;
		}
		public Object getSecondValue() {
			return secondValue;
		}
		public boolean isNoValue() {
			return noValue;
		}
		public boolean isSingleValue() {
			return singleValue;
		}
		public boolean isBetweenValue() {
			return betweenValue;
		}
		public boolean isListValue() {
			return listValue;
		}
		public String getTypeHandler() {
			return typeHandler;
		}
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}
		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
