package com.lab.model;
import java.util.ArrayList;
import java.util.List;
public class TlabOrderExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public TlabOrderExample() {
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
		public Criteria andTeacherIdIsNull() {
			addCriterion("teacher_id is null");
			return (Criteria) this;
		}
		public Criteria andTeacherIdIsNotNull(){
			addCriterion("teacher_id is not null");
			return (Criteria) this;
		}
		public Criteria andTeacherIdEqualTo(Integer value) {
			addCriterion("teacher_id =", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotEqualTo(Integer value) {
			addCriterion("teacher_id <>", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdGreaterThan(Integer value) {
			addCriterion("teacher_id >", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("teacher_id >=", value, "TeacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLessThan(Integer value) {
			addCriterion("teacher_id <", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
			addCriterion("teacher_id <=", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdIn(List<Integer> values) {
			addCriterion("teacher_id in", values, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotIn(List<Integer> values) {
			addCriterion("teacher_id not in", values, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
			addCriterion("teacher_id between", value1, value2, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
			addCriterion("teacher_id not between", value1, value2, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdLike(Integer value) {
			addCriterion("teacher_id like", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherIdNotLike(Integer value) {
			addCriterion("teacher_id not like", value, "teacherId");
			return (Criteria) this;
		}
		public Criteria andTeacherNoIsNull() {
			addCriterion("teacher_no is null");
			return (Criteria) this;
		}
		public Criteria andTeacherNoIsNotNull(){
			addCriterion("teacher_no is not null");
			return (Criteria) this;
		}
		public Criteria andTeacherNoEqualTo(String value) {
			addCriterion("teacher_no =", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoNotEqualTo(String value) {
			addCriterion("teacher_no <>", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoGreaterThan(String value) {
			addCriterion("teacher_no >", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoGreaterThanOrEqualTo(String value) {
			addCriterion("teacher_no >=", value, "TeacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoLessThan(String value) {
			addCriterion("teacher_no <", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoLessThanOrEqualTo(String value) {
			addCriterion("teacher_no <=", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoIn(List<String> values) {
			addCriterion("teacher_no in", values, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoNotIn(List<String> values) {
			addCriterion("teacher_no not in", values, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoBetween(String value1, String value2) {
			addCriterion("teacher_no between", value1, value2, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoNotBetween(String value1, String value2) {
			addCriterion("teacher_no not between", value1, value2, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoLike(String value) {
			addCriterion("teacher_no like", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNoNotLike(String value) {
			addCriterion("teacher_no not like", value, "teacherNo");
			return (Criteria) this;
		}
		public Criteria andTeacherNameIsNull() {
			addCriterion("teacher_name is null");
			return (Criteria) this;
		}
		public Criteria andTeacherNameIsNotNull(){
			addCriterion("teacher_name is not null");
			return (Criteria) this;
		}
		public Criteria andTeacherNameEqualTo(String value) {
			addCriterion("teacher_name =", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameNotEqualTo(String value) {
			addCriterion("teacher_name <>", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameGreaterThan(String value) {
			addCriterion("teacher_name >", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
			addCriterion("teacher_name >=", value, "TeacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameLessThan(String value) {
			addCriterion("teacher_name <", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameLessThanOrEqualTo(String value) {
			addCriterion("teacher_name <=", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameIn(List<String> values) {
			addCriterion("teacher_name in", values, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameNotIn(List<String> values) {
			addCriterion("teacher_name not in", values, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameBetween(String value1, String value2) {
			addCriterion("teacher_name between", value1, value2, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameNotBetween(String value1, String value2) {
			addCriterion("teacher_name not between", value1, value2, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameLike(String value) {
			addCriterion("teacher_name like", value, "teacherName");
			return (Criteria) this;
		}
		public Criteria andTeacherNameNotLike(String value) {
			addCriterion("teacher_name not like", value, "teacherName");
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
		public Criteria andOrderReasonIsNull() {
			addCriterion("order_reason is null");
			return (Criteria) this;
		}
		public Criteria andOrderReasonIsNotNull(){
			addCriterion("order_reason is not null");
			return (Criteria) this;
		}
		public Criteria andOrderReasonEqualTo(String value) {
			addCriterion("order_reason =", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonNotEqualTo(String value) {
			addCriterion("order_reason <>", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonGreaterThan(String value) {
			addCriterion("order_reason >", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonGreaterThanOrEqualTo(String value) {
			addCriterion("order_reason >=", value, "OrderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonLessThan(String value) {
			addCriterion("order_reason <", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonLessThanOrEqualTo(String value) {
			addCriterion("order_reason <=", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonIn(List<String> values) {
			addCriterion("order_reason in", values, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonNotIn(List<String> values) {
			addCriterion("order_reason not in", values, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonBetween(String value1, String value2) {
			addCriterion("order_reason between", value1, value2, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonNotBetween(String value1, String value2) {
			addCriterion("order_reason not between", value1, value2, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonLike(String value) {
			addCriterion("order_reason like", value, "orderReason");
			return (Criteria) this;
		}
		public Criteria andOrderReasonNotLike(String value) {
			addCriterion("order_reason not like", value, "orderReason");
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
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
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
		public Criteria andCourseIdIsNull() {
			addCriterion("course_id is null");
			return (Criteria) this;
		}
		public Criteria andCourseIdIsNotNull(){
			addCriterion("course_id is not null");
			return (Criteria) this;
		}
		public Criteria andCourseIdEqualTo(Integer value) {
			addCriterion("course_id =", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotEqualTo(Integer value) {
			addCriterion("course_id <>", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdGreaterThan(Integer value) {
			addCriterion("course_id >", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("course_id >=", value, "CourseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLessThan(Integer value) {
			addCriterion("course_id <", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
			addCriterion("course_id <=", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdIn(List<Integer> values) {
			addCriterion("course_id in", values, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotIn(List<Integer> values) {
			addCriterion("course_id not in", values, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdBetween(Integer value1, Integer value2) {
			addCriterion("course_id between", value1, value2, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("course_id not between", value1, value2, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdLike(Integer value) {
			addCriterion("course_id like", value, "courseId");
			return (Criteria) this;
		}
		public Criteria andCourseIdNotLike(Integer value) {
			addCriterion("course_id not like", value, "courseId");
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
