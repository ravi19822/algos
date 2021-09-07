

import java.util.HashMap;
import java.util.*;

public class Arrays1 {
    public static void main(String[] args) {


        int[] arr={1,9,9,20,20,40,30};
        Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
        for (int num:arr
             ) {

            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (int key:hashMap.keySet()
             ) {
            System.out.println("key is "+key+" value is "+hashMap.get(key));
        }



    }
}
