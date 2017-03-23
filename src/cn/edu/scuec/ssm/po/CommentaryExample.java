package cn.edu.scuec.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentaryExample() {
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

        public Criteria andMusicIdIsNull() {
            addCriterion("music_id is null");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNotNull() {
            addCriterion("music_id is not null");
            return (Criteria) this;
        }

        public Criteria andMusicIdEqualTo(Integer value) {
            addCriterion("music_id =", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotEqualTo(Integer value) {
            addCriterion("music_id <>", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThan(Integer value) {
            addCriterion("music_id >", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("music_id >=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThan(Integer value) {
            addCriterion("music_id <", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThanOrEqualTo(Integer value) {
            addCriterion("music_id <=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdIn(List<Integer> values) {
            addCriterion("music_id in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotIn(List<Integer> values) {
            addCriterion("music_id not in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdBetween(Integer value1, Integer value2) {
            addCriterion("music_id between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("music_id not between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commenttime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commenttime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(Date value) {
            addCriterion("commenttime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(Date value) {
            addCriterion("commenttime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(Date value) {
            addCriterion("commenttime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commenttime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(Date value) {
            addCriterion("commenttime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("commenttime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<Date> values) {
            addCriterion("commenttime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<Date> values) {
            addCriterion("commenttime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(Date value1, Date value2) {
            addCriterion("commenttime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("commenttime not between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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