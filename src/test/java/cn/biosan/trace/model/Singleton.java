package cn.biosan.trace.model;

public class Singleton {

    static volatile Singleton instance = null;

    public static Singleton getInstance(){

        if(null == instance){
            synchronized (Singleton.class){
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
}
