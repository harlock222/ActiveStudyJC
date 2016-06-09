/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Harlock
 */
public class DemoHashMap {
     public static void main(String[] args) {
        HashMap user = new HashMap();
        HashMap<Integer, String > user1 = new HashMap<> ();
        user.put("ID1", "TranvanA");
        user1.put(1, "Vu Van A");
        System.out.println(user.get("ID1"));
        for (int i=1; i<2; i++){
          System.out.println(user1.get(i));
        }
         for (Integer i : user1.keySet()) {
            System.out.println(i + " " + user1.get(i));
        }
      // Lay mot tap hop cac entry
      Set set = user1.entrySet();
      // Lay mot iterator
      Iterator i = set.iterator();
      // Hien thi cac phan tu
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.println(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
    }
}
