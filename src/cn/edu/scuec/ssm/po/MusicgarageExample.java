package cn.edu.scuec.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class MusicgarageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusicgarageExample() {
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

        public Criteria andSongtitleIsNull() {
            addCriterion("songtitle is null");
            return (Criteria) this;
        }

        public Criteria andSongtitleIsNotNull() {
            addCriterion("songtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSongtitleEqualTo(String value) {
            addCriterion("songtitle =", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleNotEqualTo(String value) {
            addCriterion("songtitle <>", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleGreaterThan(String value) {
            addCriterion("songtitle >", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleGreaterThanOrEqualTo(String value) {
            addCriterion("songtitle >=", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleLessThan(String value) {
            addCriterion("songtitle <", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleLessThanOrEqualTo(String value) {
            addCriterion("songtitle <=", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleLike(String value) {
            addCriterion("songtitle like", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleNotLike(String value) {
            addCriterion("songtitle not like", value, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleIn(List<String> values) {
            addCriterion("songtitle in", values, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleNotIn(List<String> values) {
            addCriterion("songtitle not in", values, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleBetween(String value1, String value2) {
            addCriterion("songtitle between", value1, value2, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSongtitleNotBetween(String value1, String value2) {
            addCriterion("songtitle not between", value1, value2, "songtitle");
            return (Criteria) this;
        }

        public Criteria andSingerIsNull() {
            addCriterion("singer is null");
            return (Criteria) this;
        }

        public Criteria andSingerIsNotNull() {
            addCriterion("singer is not null");
            return (Criteria) this;
        }

        public Criteria andSingerEqualTo(String value) {
            addCriterion("singer =", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotEqualTo(String value) {
            addCriterion("singer <>", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThan(String value) {
            addCriterion("singer >", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThanOrEqualTo(String value) {
            addCriterion("singer >=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThan(String value) {
            addCriterion("singer <", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThanOrEqualTo(String value) {
            addCriterion("singer <=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLike(String value) {
            addCriterion("singer like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotLike(String value) {
            addCriterion("singer not like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerIn(List<String> values) {
            addCriterion("singer in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotIn(List<String> values) {
            addCriterion("singer not in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerBetween(String value1, String value2) {
            addCriterion("singer between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotBetween(String value1, String value2) {
            addCriterion("singer not between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNull() {
            addCriterion("album is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIsNotNull() {
            addCriterion("album is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumEqualTo(String value) {
            addCriterion("album =", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotEqualTo(String value) {
            addCriterion("album <>", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThan(String value) {
            addCriterion("album >", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumGreaterThanOrEqualTo(String value) {
            addCriterion("album >=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThan(String value) {
            addCriterion("album <", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLessThanOrEqualTo(String value) {
            addCriterion("album <=", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumLike(String value) {
            addCriterion("album like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotLike(String value) {
            addCriterion("album not like", value, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumIn(List<String> values) {
            addCriterion("album in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotIn(List<String> values) {
            addCriterion("album not in", values, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumBetween(String value1, String value2) {
            addCriterion("album between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andAlbumNotBetween(String value1, String value2) {
            addCriterion("album not between", value1, value2, "album");
            return (Criteria) this;
        }

        public Criteria andSongaddressIsNull() {
            addCriterion("songaddress is null");
            return (Criteria) this;
        }

        public Criteria andSongaddressIsNotNull() {
            addCriterion("songaddress is not null");
            return (Criteria) this;
        }

        public Criteria andSongaddressEqualTo(String value) {
            addCriterion("songaddress =", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressNotEqualTo(String value) {
            addCriterion("songaddress <>", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressGreaterThan(String value) {
            addCriterion("songaddress >", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressGreaterThanOrEqualTo(String value) {
            addCriterion("songaddress >=", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressLessThan(String value) {
            addCriterion("songaddress <", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressLessThanOrEqualTo(String value) {
            addCriterion("songaddress <=", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressLike(String value) {
            addCriterion("songaddress like", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressNotLike(String value) {
            addCriterion("songaddress not like", value, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressIn(List<String> values) {
            addCriterion("songaddress in", values, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressNotIn(List<String> values) {
            addCriterion("songaddress not in", values, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressBetween(String value1, String value2) {
            addCriterion("songaddress between", value1, value2, "songaddress");
            return (Criteria) this;
        }

        public Criteria andSongaddressNotBetween(String value1, String value2) {
            addCriterion("songaddress not between", value1, value2, "songaddress");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNull() {
            addCriterion("capacity is null");
            return (Criteria) this;
        }

        public Criteria andCapacityIsNotNull() {
            addCriterion("capacity is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityEqualTo(Integer value) {
            addCriterion("capacity =", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotEqualTo(Integer value) {
            addCriterion("capacity <>", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThan(Integer value) {
            addCriterion("capacity >", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("capacity >=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThan(Integer value) {
            addCriterion("capacity <", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("capacity <=", value, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityIn(List<Integer> values) {
            addCriterion("capacity in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotIn(List<Integer> values) {
            addCriterion("capacity not in", values, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityBetween(Integer value1, Integer value2) {
            addCriterion("capacity between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("capacity not between", value1, value2, "capacity");
            return (Criteria) this;
        }

        public Criteria andPlaytimeIsNull() {
            addCriterion("playtime is null");
            return (Criteria) this;
        }

        public Criteria andPlaytimeIsNotNull() {
            addCriterion("playtime is not null");
            return (Criteria) this;
        }

        public Criteria andPlaytimeEqualTo(Integer value) {
            addCriterion("playtime =", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeNotEqualTo(Integer value) {
            addCriterion("playtime <>", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeGreaterThan(Integer value) {
            addCriterion("playtime >", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("playtime >=", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeLessThan(Integer value) {
            addCriterion("playtime <", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeLessThanOrEqualTo(Integer value) {
            addCriterion("playtime <=", value, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeIn(List<Integer> values) {
            addCriterion("playtime in", values, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeNotIn(List<Integer> values) {
            addCriterion("playtime not in", values, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeBetween(Integer value1, Integer value2) {
            addCriterion("playtime between", value1, value2, "playtime");
            return (Criteria) this;
        }

        public Criteria andPlaytimeNotBetween(Integer value1, Integer value2) {
            addCriterion("playtime not between", value1, value2, "playtime");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrIsNull() {
            addCriterion("albumimgadr is null");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrIsNotNull() {
            addCriterion("albumimgadr is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrEqualTo(String value) {
            addCriterion("albumimgadr =", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrNotEqualTo(String value) {
            addCriterion("albumimgadr <>", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrGreaterThan(String value) {
            addCriterion("albumimgadr >", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrGreaterThanOrEqualTo(String value) {
            addCriterion("albumimgadr >=", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrLessThan(String value) {
            addCriterion("albumimgadr <", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrLessThanOrEqualTo(String value) {
            addCriterion("albumimgadr <=", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrLike(String value) {
            addCriterion("albumimgadr like", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrNotLike(String value) {
            addCriterion("albumimgadr not like", value, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrIn(List<String> values) {
            addCriterion("albumimgadr in", values, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrNotIn(List<String> values) {
            addCriterion("albumimgadr not in", values, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrBetween(String value1, String value2) {
            addCriterion("albumimgadr between", value1, value2, "albumimgadr");
            return (Criteria) this;
        }

        public Criteria andAlbumimgadrNotBetween(String value1, String value2) {
            addCriterion("albumimgadr not between", value1, value2, "albumimgadr");
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