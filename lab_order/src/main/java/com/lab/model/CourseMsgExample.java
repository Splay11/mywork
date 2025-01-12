package com.lab.model;
import java.util.ArrayList;
import java.util.List;
public class CourseMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public CourseMsgExample() {
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
		public Criteria andCnameIsNull() {
			addCriterion("cname is null");
			return (Criteria) this;
		}
		public Criteria andCnameIsNotNull(){
			addCriterion("cname is not null");
			return (Criteria) this;
		}
		public Criteria andCnameEqualTo(String value) {
			addCriterion("cname =", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameNotEqualTo(String value) {
			addCriterion("cname <>", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameGreaterThan(String value) {
			addCriterion("cname >", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameGreaterThanOrEqualTo(String value) {
			addCriterion("cname >=", value, "Cname");
			return (Criteria) this;
		}
		public Criteria andCnameLessThan(String value) {
			addCriterion("cname <", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameLessThanOrEqualTo(String value) {
			addCriterion("cname <=", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameIn(List<String> values) {
			addCriterion("cname in", values, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameNotIn(List<String> values) {
			addCriterion("cname not in", values, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameBetween(String value1, String value2) {
			addCriterion("cname between", value1, value2, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameNotBetween(String value1, String value2) {
			addCriterion("cname not between", value1, value2, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameLike(String value) {
			addCriterion("cname like", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCnameNotLike(String value) {
			addCriterion("cname not like", value, "cname");
			return (Criteria) this;
		}
		public Criteria andCaddressIsNull() {
			addCriterion("caddress is null");
			return (Criteria) this;
		}
		public Criteria andCaddressIsNotNull(){
			addCriterion("caddress is not null");
			return (Criteria) this;
		}
		public Criteria andCaddressEqualTo(String value) {
			addCriterion("caddress =", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressNotEqualTo(String value) {
			addCriterion("caddress <>", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressGreaterThan(String value) {
			addCriterion("caddress >", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressGreaterThanOrEqualTo(String value) {
			addCriterion("caddress >=", value, "Caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressLessThan(String value) {
			addCriterion("caddress <", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressLessThanOrEqualTo(String value) {
			addCriterion("caddress <=", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressIn(List<String> values) {
			addCriterion("caddress in", values, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressNotIn(List<String> values) {
			addCriterion("caddress not in", values, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressBetween(String value1, String value2) {
			addCriterion("caddress between", value1, value2, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressNotBetween(String value1, String value2) {
			addCriterion("caddress not between", value1, value2, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressLike(String value) {
			addCriterion("caddress like", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andCaddressNotLike(String value) {
			addCriterion("caddress not like", value, "caddress");
			return (Criteria) this;
		}
		public Criteria andClassIdIsNull() {
			addCriterion("class_id is null");
			return (Criteria) this;
		}
		public Criteria andClassIdIsNotNull(){
			addCriterion("class_id is not null");
			return (Criteria) this;
		}
		public Criteria andClassIdEqualTo(Integer value) {
			addCriterion("class_id =", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotEqualTo(Integer value) {
			addCriterion("class_id <>", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdGreaterThan(Integer value) {
			addCriterion("class_id >", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("class_id >=", value, "ClassId");
			return (Criteria) this;
		}
		public Criteria andClassIdLessThan(Integer value) {
			addCriterion("class_id <", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("class_id <=", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdIn(List<Integer> values) {
			addCriterion("class_id in", values, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotIn(List<Integer> values) {
			addCriterion("class_id not in", values, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdBetween(Integer value1, Integer value2) {
			addCriterion("class_id between", value1, value2, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("class_id not between", value1, value2, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdLike(Integer value) {
			addCriterion("class_id like", value, "classId");
			return (Criteria) this;
		}
		public Criteria andClassIdNotLike(Integer value) {
			addCriterion("class_id not like", value, "classId");
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
		public Criteria andCourseTimeIsNull() {
			addCriterion("course_time is null");
			return (Criteria) this;
		}
		public Criteria andCourseTimeIsNotNull(){
			addCriterion("course_time is not null");
			return (Criteria) this;
		}
		public Criteria andCourseTimeEqualTo(Integer value) {
			addCriterion("course_time =", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeNotEqualTo(Integer value) {
			addCriterion("course_time <>", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeGreaterThan(Integer value) {
			addCriterion("course_time >", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("course_time >=", value, "CourseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeLessThan(Integer value) {
			addCriterion("course_time <", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeLessThanOrEqualTo(Integer value) {
			addCriterion("course_time <=", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeIn(List<Integer> values) {
			addCriterion("course_time in", values, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeNotIn(List<Integer> values) {
			addCriterion("course_time not in", values, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeBetween(Integer value1, Integer value2) {
			addCriterion("course_time between", value1, value2, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("course_time not between", value1, value2, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeLike(Integer value) {
			addCriterion("course_time like", value, "courseTime");
			return (Criteria) this;
		}
		public Criteria andCourseTimeNotLike(Integer value) {
			addCriterion("course_time not like", value, "courseTime");
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
