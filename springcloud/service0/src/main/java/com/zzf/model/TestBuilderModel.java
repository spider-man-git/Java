package com.zzf.model;

public class TestBuilderModel {

    private Long id;

    private String name;

    private Integer age;

    private String idNo;

    private int sex;

    public static class Builder{

        private Long id;

        private String name;

        private Integer age;

        private String idNo;

        private int sex;

        public Builder(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder idNo(String idNo){
            this.idNo = idNo;
            return this;
        }

        public Builder sex(int sex){
            this.sex = sex;
            return this;
        }

        public TestBuilderModel build(){
            return new TestBuilderModel(this);
        }

    }

    private TestBuilderModel(Builder builder){

    }



}
