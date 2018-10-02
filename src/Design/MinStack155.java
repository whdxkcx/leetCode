package Design;

import java.util.ArrayList;
import java.util.List;

public class MinStack155 {
    List<Integer> data ;
    int min;
    public MinStack155() {
        data = new ArrayList<Integer>();
        min = Integer.MAX_VALUE;

    }
    public void push(int x) {
        if(x<=min){
            data.add(min);
            min=x;
        }
        data.add(x);
    }

    public void pop() {
        if(!data.isEmpty()){
            if(data.remove(data.size()-1)== min){
                min= data.remove(data.size()-1);
            }
        }
    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
        return min;
    }
}
