package com.lab.model;
import java.util.ArrayList;
import java.util.List;
public class RoomMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public RoomMsgExample() {
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
		public Criteria andRoomNameIsNull() {
			addCriterion("room_name is null");
			return (Criteria) this;
		}
		public Criteria andRoomNameIsNotNull(){
			addCriterion("room_name is not null");
			return (Criteria) this;
		}
		public Criteria andRoomNameEqualTo(String value) {
			addCriterion("room_name =", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameNotEqualTo(String value) {
			addCriterion("room_name <>", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameGreaterThan(String value) {
			addCriterion("room_name >", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
			addCriterion("room_name >=", value, "RoomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameLessThan(String value) {
			addCriterion("room_name <", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameLessThanOrEqualTo(String value) {
			addCriterion("room_name <=", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameIn(List<String> values) {
			addCriterion("room_name in", values, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameNotIn(List<String> values) {
			addCriterion("room_name not in", values, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameBetween(String value1, String value2) {
			addCriterion("room_name between", value1, value2, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameNotBetween(String value1, String value2) {
			addCriterion("room_name not between", value1, value2, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameLike(String value) {
			addCriterion("room_name like", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andRoomNameNotLike(String value) {
			addCriterion("room_name not like", value, "roomName");
			return (Criteria) this;
		}
		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}
		public Criteria andAddressIsNotNull(){
			addCriterion("address is not null");
			return (Criteria) this;
		}
		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "Address");
			return (Criteria) this;
		}
		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}
		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}
		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}
		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}
		public Criteria andManageIdIsNull() {
			addCriterion("manage_id is null");
			return (Criteria) this;
		}
		public Criteria andManageIdIsNotNull(){
			addCriterion("manage_id is not null");
			return (Criteria) this;
		}
		public Criteria andManageIdEqualTo(Integer value) {
			addCriterion("manage_id =", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdNotEqualTo(Integer value) {
			addCriterion("manage_id <>", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdGreaterThan(Integer value) {
			addCriterion("manage_id >", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("manage_id >=", value, "ManageId");
			return (Criteria) this;
		}
		public Criteria andManageIdLessThan(Integer value) {
			addCriterion("manage_id <", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdLessThanOrEqualTo(Integer value) {
			addCriterion("manage_id <=", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdIn(List<Integer> values) {
			addCriterion("manage_id in", values, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdNotIn(List<Integer> values) {
			addCriterion("manage_id not in", values, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdBetween(Integer value1, Integer value2) {
			addCriterion("manage_id between", value1, value2, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdNotBetween(Integer value1, Integer value2) {
			addCriterion("manage_id not between", value1, value2, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdLike(Integer value) {
			addCriterion("manage_id like", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andManageIdNotLike(Integer value) {
			addCriterion("manage_id not like", value, "manageId");
			return (Criteria) this;
		}
		public Criteria andMaxNumIsNull() {
			addCriterion("max_num is null");
			return (Criteria) this;
		}
		public Criteria andMaxNumIsNotNull(){
			addCriterion("max_num is not null");
			return (Criteria) this;
		}
		public Criteria andMaxNumEqualTo(Integer value) {
			addCriterion("max_num =", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumNotEqualTo(Integer value) {
			addCriterion("max_num <>", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumGreaterThan(Integer value) {
			addCriterion("max_num >", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("max_num >=", value, "MaxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumLessThan(Integer value) {
			addCriterion("max_num <", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumLessThanOrEqualTo(Integer value) {
			addCriterion("max_num <=", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumIn(List<Integer> values) {
			addCriterion("max_num in", values, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumNotIn(List<Integer> values) {
			addCriterion("max_num not in", values, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumBetween(Integer value1, Integer value2) {
			addCriterion("max_num between", value1, value2, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumNotBetween(Integer value1, Integer value2) {
			addCriterion("max_num not between", value1, value2, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumLike(Integer value) {
			addCriterion("max_num like", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andMaxNumNotLike(Integer value) {
			addCriterion("max_num not like", value, "maxNum");
			return (Criteria) this;
		}
		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}
		public Criteria andRemarkIsNotNull(){
			addCriterion("remark is not null");
			return (Criteria) this;
		}
		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "Remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIsNull() {
			addCriterion("room_type is null");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIsNotNull(){
			addCriterion("room_type is not null");
			return (Criteria) this;
		}
		public Criteria andRoomTypeEqualTo(Integer value) {
			addCriterion("room_type =", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotEqualTo(Integer value) {
			addCriterion("room_type <>", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeGreaterThan(Integer value) {
			addCriterion("room_type >", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("room_type >=", value, "RoomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLessThan(Integer value) {
			addCriterion("room_type <", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLessThanOrEqualTo(Integer value) {
			addCriterion("room_type <=", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIn(List<Integer> values) {
			addCriterion("room_type in", values, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotIn(List<Integer> values) {
			addCriterion("room_type not in", values, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeBetween(Integer value1, Integer value2) {
			addCriterion("room_type between", value1, value2, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("room_type not between", value1, value2, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLike(Integer value) {
			addCriterion("room_type like", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotLike(Integer value) {
			addCriterion("room_type not like", value, "roomType");
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
