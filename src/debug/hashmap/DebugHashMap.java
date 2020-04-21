package debug.hashmap;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sky
 * @date 2020/3/16 - 6:49 上午
 */
public class DebugHashMap {
	public static void main(String[] args) {
		Map<Object, Object> hashMap = new HashMap<>();
		hashMap.put("柳岩",18);
		hashMap.put("杨幂",28);
		hashMap.put("刘德华",40);
		hashMap.put("柳岩",20);
		
		method(hashMap);
		method_1(hashMap);
		method_2(hashMap);

	}

	private static void method_2(Map<Object, Object> hashMap) {
		hashMap.forEach((key,value)-> System.out.println(key +" "+value));
	}

	private static void method_1(Map<Object, Object> hashMap) {
		Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
		for(Map.Entry entry: entries){
			System.out.println("key :"+entry.getKey()+" value :"+entry.getValue());
		}
	}

	private static void method(Map<Object, Object> hashMap) {
		Set<Object> keySet = hashMap.keySet();
		for (Object str:keySet) {
			System.out.println("key : "+str);
		}

		Collection<Object> values = hashMap.values();
		for(Object value : values){
			System.out.println("value :"+value);
		}
	}
}
