package com.scfl.dispatching.center.config.invoke;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 自定义类加载器
 * @author ylw
 * @date 18-3-23 下午4:16
 * @param
 * @return
 */
public class OuterJobClassLoader extends URLClassLoader {
    public OuterJobClassLoader(URL[] urls) {
        super(urls);
    }
    public OuterJobClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
    public void addJar(URL url) {
        this.addURL(url);
    }
}
