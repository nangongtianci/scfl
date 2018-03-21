package com.scfl;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class TestLoadClassJar {

    public static void main(String[] args){
        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);
        try {
            classLoader.addJar(new File("/home/ylw/workspace/jar/SCFLJOB.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("JobClass");
            Object object = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("Next",int.class);
            Object o = method.invoke(object,120);
            System.out.println("调用结果" + o);
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }
}
