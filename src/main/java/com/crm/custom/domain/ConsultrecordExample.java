package com.crm.custom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ConsultrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultrecordExample() {
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

        public Criteria andConsultmanidIsNull() {
            addCriterion("consultManId is null");
            return (Criteria) this;
        }

        public Criteria andConsultmanidIsNotNull() {
            addCriterion("consultManId is not null");
            return (Criteria) this;
        }

        public Criteria andConsultmanidEqualTo(Integer value) {
            addCriterion("consultManId =", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidNotEqualTo(Integer value) {
            addCriterion("consultManId <>", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidGreaterThan(Integer value) {
            addCriterion("consultManId >", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("consultManId >=", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidLessThan(Integer value) {
            addCriterion("consultManId <", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidLessThanOrEqualTo(Integer value) {
            addCriterion("consultManId <=", value, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidIn(List<Integer> values) {
            addCriterion("consultManId in", values, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidNotIn(List<Integer> values) {
            addCriterion("consultManId not in", values, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidBetween(Integer value1, Integer value2) {
            addCriterion("consultManId between", value1, value2, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultmanidNotBetween(Integer value1, Integer value2) {
            addCriterion("consultManId not between", value1, value2, "consultmanid");
            return (Criteria) this;
        }

        public Criteria andConsultstatuIsNull() {
            addCriterion("consultStatu is null");
            return (Criteria) this;
        }

        public Criteria andConsultstatuIsNotNull() {
            addCriterion("consultStatu is not null");
            return (Criteria) this;
        }

        public Criteria andConsultstatuEqualTo(String value) {
            addCriterion("consultStatu =", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuNotEqualTo(String value) {
            addCriterion("consultStatu <>", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuGreaterThan(String value) {
            addCriterion("consultStatu >", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuGreaterThanOrEqualTo(String value) {
            addCriterion("consultStatu >=", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuLessThan(String value) {
            addCriterion("consultStatu <", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuLessThanOrEqualTo(String value) {
            addCriterion("consultStatu <=", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuLike(String value) {
            addCriterion("consultStatu like", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuNotLike(String value) {
            addCriterion("consultStatu not like", value, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuIn(List<String> values) {
            addCriterion("consultStatu in", values, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuNotIn(List<String> values) {
            addCriterion("consultStatu not in", values, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuBetween(String value1, String value2) {
            addCriterion("consultStatu between", value1, value2, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultstatuNotBetween(String value1, String value2) {
            addCriterion("consultStatu not between", value1, value2, "consultstatu");
            return (Criteria) this;
        }

        public Criteria andConsultdateIsNull() {
            addCriterion("consultDate is null");
            return (Criteria) this;
        }

        public Criteria andConsultdateIsNotNull() {
            addCriterion("consultDate is not null");
            return (Criteria) this;
        }

        public Criteria andConsultdateEqualTo(Date value) {
            addCriterionForJDBCDate("consultDate =", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("consultDate <>", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateGreaterThan(Date value) {
            addCriterionForJDBCDate("consultDate >", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("consultDate >=", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateLessThan(Date value) {
            addCriterionForJDBCDate("consultDate <", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("consultDate <=", value, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateIn(List<Date> values) {
            addCriterionForJDBCDate("consultDate in", values, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("consultDate not in", values, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("consultDate between", value1, value2, "consultdate");
            return (Criteria) this;
        }

        public Criteria andConsultdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("consultDate not between", value1, value2, "consultdate");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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