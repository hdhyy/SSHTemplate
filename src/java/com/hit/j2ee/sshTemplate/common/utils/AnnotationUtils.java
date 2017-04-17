package com.hit.j2ee.sshTemplate.common.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <p>
 * show 注解工具�? <br>
 * 
 * @author eagler006 eagler006@hotmail.com
 * @version 1.1
 * @see org.springframework.core.annotation.AnnotationUtils
 */
public class AnnotationUtils {

	public AnnotationUtils() {
	}

	/**
	 * 
	 * @Title: <p>
	 *         获取�?��类含有指定注解类的所有属�?
	 *         </p>
	 * @Description: TODO
	 * @param @param annotationClass
	 * @param @param clazz
	 * @param @param allFields
	 * @return void
	 * @throws
	 */
	public static void getAnnotationFields(Class clazz, Class annotationClass,
										   List<Field> allFields) {
		if (clazz == null) {
			return;
		}

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			Annotation ann = field.getAnnotation(annotationClass);
			if (ann != null) {
				allFields.add(field);
			}
		}
		getAnnotationFields(clazz.getSuperclass(), annotationClass, allFields);
	}

	/**
	 * 
	 * @Title: <p>
	 *         获取�?��类含有指定注解类的所有方�?
	 *         </p>
	 * @Description: TODO
	 * @param @param annotationClass
	 * @param @param clazz
	 * @param @param allMethods
	 * @return void
	 * @throws
	 */
	public static void getAnnotationMethods(Class clazz, Class annotationClass,
											List<Method> allMethods) {
		if (clazz == null) {
			return;
		}

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			Annotation ann = method.getAnnotation(annotationClass);
			if (ann != null) {
				allMethods.add(method);
			}
		}
		getAnnotationMethods(clazz.getSuperclass(),annotationClass,  allMethods);
	}

	public static void getAnnotations(Class clazz, List<Annotation> allAnnotations) {
	    if (clazz == null) {
            return;
        }
	    Annotation[] annotations = clazz.getAnnotations();
	    for (Annotation annotation : annotations) {
          
            if (annotation != null) {
                allAnnotations.add(annotation);
            }
        }
	    getAnnotations(  clazz.getSuperclass(),allAnnotations);
    }
	/**
	 * <p>
	 * 获取�?��方法的所有注�?<br>
	 * 
	 * @param method
	 * @return Annotation[]
	 */
	public static Annotation[] getAnnotations(Method method) {

		return method.getAnnotations();
	}

	/**
	 * <p>
	 * 获取�?��属�?的所有注�?<br>
	 * 
	 * @param field
	 * @return Annotation[]
	 */
	public static Annotation[] getAnnotations(Field field) {

		return field.getAnnotations();
	}

	/**
	 * <p>
	 * 获取方法的一个注解类�?br>
	 * 
	 * @param method
	 * @param annotationType
	 * @return Annotation
	 */
	public static Annotation getAnnotation(Method method, Class annotationType) {
		Annotation annotation = method.getAnnotation(annotationType);
		Class cl = method.getDeclaringClass();
		do {
			if (annotation != null)
				break;
			cl = cl.getSuperclass();
			if (cl == null || cl.equals(Object.class))
				break;
			try {
				Method equivalentMethod = cl.getDeclaredMethod(
						method.getName(), method.getParameterTypes());
				annotation = equivalentMethod.getAnnotation(annotationType);
			} catch (NoSuchMethodException ex) {
			}
		} while (true);
		return annotation;
	}

	/**
	 * <p>
	 * 获取属�?的一个注解类�?br>
	 * 
	 * @param field
	 * @param annotationType
	 * @return Annotation
	 */
	public static Annotation getAnnotation(Field field, Class annotationType) {

		Annotation annotation = field.getAnnotation(annotationType);
		Class cl = field.getDeclaringClass();
		do {
			if (annotation != null)
				break;
			cl = cl.getSuperclass();
			if (cl == null || cl.equals(Object.class))
				break;
			try {
				Field equivalentField = cl.getDeclaredField(field.getName());
				annotation = equivalentField.getAnnotation(annotationType);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (true);
		return annotation;
	}

	/**
	 * <p>
	 * 查找�?��类的某种注解类型<br>
	 * 
	 * @param clazz
	 * @param annotationType
	 * @return Annotation
	 */
	public static Annotation getAnnotation(Class clazz, Class annotationType) {
		Annotation annotation = clazz.getAnnotation(annotationType);
		if (annotation != null)
			return annotation;
		Class clazzes[] = clazz.getInterfaces();
		int len = clazzes.length;
		for (int i = 0; i < len; i++) {
			Class ifc = clazzes[i];
			annotation = getAnnotation(ifc, annotationType);
			if (annotation != null)
				return annotation;
		}

		if (clazz.getSuperclass() == null
				|| Object.class.equals(clazz.getSuperclass()))
			return null;
		else
			return getAnnotation(clazz.getSuperclass(), annotationType);
	}

	/**
	 * <p>
	 * 查找包含某种注解类型的Class类型的Class<br>
	 * 
	 * @param annotationType
	 * @param clazz
	 * @return Class
	 */
	public static Class getAnnotationDeclaringClass(Class clazz, Class annotationType) {
		if (clazz == null || clazz.equals(Object.class))
			return null;
		else
			return isAnnotationDeclaredLocally(clazz,annotationType) ? clazz
					: getAnnotationDeclaringClass(clazz.getSuperclass(),annotationType);
	}

	/**
	 * <p>
	 * �?���?��类是否包含一个特定的注解类型<br>
	 * 
	 * @param annotationType
	 * @param clazz 
	 * @return boolean
	 */
	public static boolean isAnnotationDeclaredLocally(Class clazz, Class annotationType) {
		boolean declaredLocally = false;
		Iterator i$ = Arrays.asList(clazz.getDeclaredAnnotations()).iterator();
		do {
			if (!i$.hasNext())
				break;
			Annotation annotation = (Annotation) i$.next();
			if (!annotation.annotationType().equals(annotationType))
				continue;
			declaredLocally = true;
			break;
		} while (true);
		return declaredLocally;
	}

	/**
	 * 
	 * @Title:<p> �?���?��已注解元素是否包含特定的注解类型</p>
	 * @Description: TODO
	 * @param @param annotatedElement
	 * @param @param annotation
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isAnnotationDeclaredLocally(AnnotatedElement annotatedElement, Class<? extends Annotation>... annotation) {

		for (Class<? extends Annotation> c : annotation) {
			if (annotatedElement.isAnnotationPresent(c))
				return true;
		}

		return false;
	}

	/**
	 * <p>
	 * 是否有继承关�?br>
	 * 
	 * @param annotationType
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isAnnotationInherited(Class clazz, Class annotationType) {
		return clazz.isAnnotationPresent(annotationType)
				&& !isAnnotationDeclaredLocally(clazz,annotationType);
	}

	/**
	 * <p>
	 * 获取注解�?��的属�?br>
	 * 
	 * @param annotation
	 * @return Map
	 */
	public static Map getAnnotationAttributes(Annotation annotation) {
		Map attrs = new HashMap();
		Method methods[] = annotation.annotationType().getDeclaredMethods();
		for (int j = 0; j < methods.length; j++) {
			Method method = methods[j];
			if (method.getParameterTypes().length != 0
					|| method.getReturnType() == Void.TYPE)
				continue;
			try {
				attrs.put(method.getName(),
						method.invoke(annotation, new Object[0]));
			} catch (Exception ex) {
				throw new IllegalStateException(
						"Could not obtain annotation attribute values", ex);
			}
		}

		return attrs;
	}

	/**
	 * <p>
	 * 获取注解对应的属性�?<br/>
	 * 
	 * @param annotation
	 * @param attributeName
	 * @return Object
	 */
	public static Object getAnnotationAttribute(Annotation annotation,
												String attributeName) {
		try {
			Method method = annotation.annotationType().getDeclaredMethod(
					attributeName, new Class[0]);
			return method.invoke(annotation, new Object[0]);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * <p>
	 * 获取注解对应的属性�?<br/>
	 * 
	 * @param annotationType
	 * @param attributeName
	 * @return Object
	 */
	public static Object getAnnotationAttribute(Class annotationType,
												String attributeName) {
		try {
			Method method = annotationType.getDeclaredMethod(attributeName,
					new Class[0]);
			return method.getDefaultValue();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * <p>
	 * 获取注解默认属�?�?
	 * </p>
	 * 
	 * @param annotation
	 * @return Object
	 */
	public static Object getDefaultAnnotationAttribute(Annotation annotation) {
		return getAnnotationAttribute(annotation, VALUE);
	}

	/**
	 * <p>
	 * 获取注解默认属�?�?
	 * </p>
	 * 
	 * @param annotationType
	 * @return Object
	 */
	public static Object getDefaultAnnotationAttribute(Class annotationType) {
		return getAnnotationAttribute(annotationType, VALUE);
	}

	/**
	 * 
	 * @Title:获得方法的属性名
	 * @Description: TODO
	 * @param @param method
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getFieldName(Method method) {
		Matcher matcher = SETTER_PATTERN.matcher(method.getName());
		if (matcher.matches() && method.getParameterTypes().length == 1) {
			String raw = matcher.group(1);
			return raw.substring(0, 1).toLowerCase() + raw.substring(1);
		}

		matcher = GETTER_PATTERN.matcher(method.getName());
		if (matcher.matches() && method.getParameterTypes().length == 0) {
			String raw = matcher.group(2);
			return raw.substring(0, 1).toLowerCase() + raw.substring(1);
		}

		return null;
	}

	/**
	 * 
	 * @Title: 获得属�?的�?
	 * @Description: TODO
	 * @param @param field
	 * @param @param obj
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public static Object getFieldValue(Field field, Object entity) {
		Object object = null;
		try {
			object = field.get(entity);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	private static final String VALUE = "value";
	private static final Pattern SETTER_PATTERN = Pattern
			.compile("set([A-Z][A-Za-z0-9]*)$");
	private static final Pattern GETTER_PATTERN = Pattern
			.compile("(get|is|has)([A-Z][A-Za-z0-9]*)$");
}
