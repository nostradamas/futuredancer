package com.fdm.model.enumModel;

public enum Teacher_direction {
        CHINESE("中国舞", 1), BALLET("芭蕾舞", 2), LATIN("拉丁舞", 3), DIRECTS("编导", 4), BALLROOM("国际标准舞", 5);  
        private String name;  
        private int index;  
        private Teacher_direction(String name, int index) {  
            this.name = name;  
            this.index = index;  
        }  
        public static String getName(int index) {  
            for (Teacher_direction c : Teacher_direction.values()) {  
                if (c.getIndex() == index) {  
                    return c.name;  
                }  
            }  
            return null;  
        }  
        // get set 方法  
        public String getName() {  
            return name;  
        }  
        public void setName(String name) {  
            this.name = name;  
        }  
        public int getIndex() {  
            return index;  
        }  
        public void setIndex(int index) {  
            this.index = index;  
        }  
}
