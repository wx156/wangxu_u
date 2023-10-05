package com.kfm.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Text {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.kfm.base.annotation.Student");
            Annotation[] annotations = aClass.getDeclaredAnnotations();
            for (Annotation ann : annotations) {
                System.out.println(ann);
            }
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
            AnnotatedType annotatedReturnType = declaredConstructor.getAnnotatedReturnType();
            System.out.println(annotatedReturnType);
            Method study = aClass.getMethod("study");
            System.out.println(study.getAnnotation(Log.class).value());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
