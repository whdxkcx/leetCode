package Test;

import com.sun.xml.internal.ws.api.pipe.SyncStartForAsyncFeature;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) throws ParseException {
        ArrayList<Integer>  ar=new ArrayList<>();
        ar.add(20);
        ar.add(1);
        ar.add(20);
        ar.add(3);
        ar.add(20);
//        Collections.sort(ar,(a,b)->{return a-b;});
        ar.remove(new Integer(20));
        Queue<Integer>   q=new PriorityQueue<>((a,b)->{return  b-a;});
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(ar);
        System.out.println(q.peek());
        while(!q.isEmpty())
        System.out.println(q.poll());
    }
}
