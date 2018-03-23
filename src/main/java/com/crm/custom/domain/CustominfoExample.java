package com.crm.custom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustominfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustominfoExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
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
            addCriterion("id >=", value, "id");
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

        public Criteria andCustomidIsNull() {
            addCriterion("customId is null");
            return (Criteria) this;
        }

        public Criteria andCustomidIsNotNull() {
            addCriterion("customId is not null");
            return (Criteria) this;
        }

        public Criteria andCustomidEqualTo(Integer value) {
            addCriterion("customId =", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotEqualTo(Integer value) {
            addCriterion("customId <>", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidGreaterThan(Integer value) {
            addCriterion("customId >", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("customId >=", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidLessThan(Integer value) {
            addCriterion("customId <", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidLessThanOrEqualTo(Integer value) {
            addCriterion("customId <=", value, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidIn(List<Integer> values) {
            addCriterion("customId in", values, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotIn(List<Integer> values) {
            addCriterion("customId not in", values, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidBetween(Integer value1, Integer value2) {
            addCriterion("customId between", value1, value2, "customid");
            return (Criteria) this;
        }

        public Criteria andCustomidNotBetween(Integer value1, Integer value2) {
            addCriterion("customId not between", value1, value2, "customid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidIsNull() {
            addCriterion("followManId is null");
            return (Criteria) this;
        }

        public Criteria andFollowmanidIsNotNull() {
            addCriterion("followManId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowmanidEqualTo(Integer value) {
            addCriterion("followManId =", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidNotEqualTo(Integer value) {
            addCriterion("followManId <>", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidGreaterThan(Integer value) {
            addCriterion("followManId >", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("followManId >=", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidLessThan(Integer value) {
            addCriterion("followManId <", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidLessThanOrEqualTo(Integer value) {
            addCriterion("followManId <=", value, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidIn(List<Integer> values) {
            addCriterion("followManId in", values, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidNotIn(List<Integer> values) {
            addCriterion("followManId not in", values, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidBetween(Integer value1, Integer value2) {
            addCriterion("followManId between", value1, value2, "followmanid");
            return (Criteria) this;
        }

        public Criteria andFollowmanidNotBetween(Integer value1, Integer value2) {
            addCriterion("followManId not between", value1, value2, "followmanid");
            return (Criteria) this;
        }

        public Criteria andStatuIsNull() {
            addCriterion("statu is null");
            return (Criteria) this;
        }

        public Criteria andStatuIsNotNull() {
            addCriterion("statu is not null");
            return (Criteria) this;
        }

        public Criteria andStatuEqualTo(String value) {
            addCriterion("statu =", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotEqualTo(String value) {
            addCriterion("statu <>", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThan(String value) {
            addCriterion("statu >", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuGreaterThanOrEqualTo(String value) {
            addCriterion("statu >=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThan(String value) {
            addCriterion("statu <", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLessThanOrEqualTo(String value) {
            addCriterion("statu <=", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuLike(String value) {
            addCriterion("statu like", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotLike(String value) {
            addCriterion("statu not like", value, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuIn(List<String> values) {
            addCriterion("statu in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotIn(List<String> values) {
            addCriterion("statu not in", values, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuBetween(String value1, String value2) {
            addCriterion("statu between", value1, value2, "statu");
            return (Criteria) this;
        }

        public Criteria andStatuNotBetween(String value1, String value2) {
            addCriterion("statu not between", value1, value2, "statu");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterionForJDBCDate("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterionForJDBCDate("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterionForJDBCDate("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterionForJDBCDate("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateIsNull() {
            addCriterion("lastFollowDate is null");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateIsNotNull() {
            addCriterion("lastFollowDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateEqualTo(Date value) {
            addCriterionForJDBCDate("lastFollowDate =", value, "lastfollowdate");
            return (Criteria) this;
        }



        public Criteria andLastfollowdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("lastFollowDate <>", value, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateGreaterThan(Date value) {
            addCriterionForJDBCDate("lastFollowDate >", value, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lastFollowDate >=", value, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateLessThan(Date value) {
            addCriterionForJDBCDate("lastFollowDate <", value, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lastFollowDate <=", value, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateIn(List<Date> values) {
            addCriterionForJDBCDate("lastFollowDate in", values, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("lastFollowDate not in", values, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lastFollowDate between", value1, value2, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andLastfollowdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lastFollowDate not between", value1, value2, "lastfollowdate");
            return (Criteria) this;
        }

        public Criteria andPlandateIsNull() {
            addCriterion("planDate is null");
            return (Criteria) this;
        }

        public Criteria andPlandateIsNotNull() {
            addCriterion("planDate is not null");
            return (Criteria) this;
        }

        public Criteria andPlandateEqualTo(Date value) {
            addCriterionForJDBCDate("planDate =", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotEqualTo(Date value) {
            addCriterionForJDBCDate("planDate <>", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateGreaterThan(Date value) {
            addCriterionForJDBCDate("planDate >", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planDate >=", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateLessThan(Date value) {
            addCriterionForJDBCDate("planDate <", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("planDate <=", value, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateIn(List<Date> values) {
            addCriterionForJDBCDate("planDate in", values, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotIn(List<Date> values) {
            addCriterionForJDBCDate("planDate not in", values, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planDate between", value1, value2, "plandate");
            return (Criteria) this;
        }

        public Criteria andPlandateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("planDate not between", value1, value2, "plandate");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
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