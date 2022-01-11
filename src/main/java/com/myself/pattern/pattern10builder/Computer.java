package com.myself.pattern.pattern10builder;

public class Computer {
    //必须
    private String cpu;
    //必须
    private String ram;
    //可选
    private int usbCount;
    //可选
    private String keyboard;
    //可选
    private String display;
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }
    
    public static class Builder {
        private final String cpu;//必须
        private final String ram;//必须
        private int usbCount;//可选
        private String keyboard;//可选
        private String display;//可选
        
        public Builder(String cup, String ram) {
            this.cpu = cup;
            this.ram = ram;
        }
        
        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }
        
        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }
        
        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
}
