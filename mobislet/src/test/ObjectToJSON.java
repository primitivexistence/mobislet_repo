package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.mobislet.request.AddAddressRequest;
import com.mobislet.request.GetDiscoveryRequest;

public class ObjectToJSON {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object obj = new GetDiscoveryRequest();//Change this for Object class
		
		Gson gson = new Gson();
		setSampleFieldValues(obj);
		String json = gson.toJson(obj);
		System.out.println(json);
	}
	
	public static void setSampleFieldValues(Object o){
		Method[] methods= o.getClass().getDeclaredMethods();
		
		for(int i=0; i<methods.length; i++){
			Method m = methods[i];
			
			if(!m.getName().startsWith("set"))
				continue;
			
			Class<?>[] parameterClasses = m.getParameterTypes();
			
			Object prm = null;
			for(int j=0; j<parameterClasses.length; j++){
				Class<?> c = parameterClasses[j];
				if(c.getName().endsWith("Integer")){
					prm = new Integer(1);
				}else if(c.getName().endsWith("String")){
					prm = new String("K");
				}else if(c.getName().endsWith("Boolean")){
					prm = new Boolean(true);
				}else if(c.getName().endsWith("BigDecimal")){
					prm = new BigDecimal(1);
				}else if(c.getName().endsWith("Long")){
					prm = new Long(1);
				}else if(c.getName().endsWith("ArrayList")){
					prm = new ArrayList<>();
				}else{
					try {
						prm = Class.forName(c.getName()).getConstructor().newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					setSampleFieldValues(prm);
				}
			}
			
			try {
				m.invoke(o, prm);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
