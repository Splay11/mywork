package com.lab.model;
import java.util.ArrayList;
import java.util.List;
public class LabOrderExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public LabOrderExample() {
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
		public Criteria andUsingIntroIsNull() {
			addCriterion("using_intro is null");
			return (Criteria) this;
		}
		public Criteria andUsingIntroIsNotNull(){
			addCriterion("using_intro is not null");
			return (Criteria) this;
		}
		public Criteria andUsingIntroEqualTo(String value) {
			addCriterion("using_intro =", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotEqualTo(String value) {
			addCriterion("using_intro <>", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroGreaterThan(String value) {
			addCriterion("using_intro >", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroGreaterThanOrEqualTo(String value) {
			addCriterion("using_intro >=", value, "UsingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLessThan(String value) {
			addCriterion("using_intro <", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLessThanOrEqualTo(String value) {
			addCriterion("using_intro <=", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroIn(List<String> values) {
			addCriterion("using_intro in", values, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotIn(List<String> values) {
			addCriterion("using_intro not in", values, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroBetween(String value1, String value2) {
			addCriterion("using_intro between", value1, value2, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotBetween(String value1, String value2) {
			addCriterion("using_intro not between", value1, value2, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLike(String value) {
			addCriterion("using_intro like", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotLike(String value) {
			addCriterion("using_intro not like", value, "usingIntro");
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
