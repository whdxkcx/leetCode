package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        boolean[][] map = new boolean[n][n];
        int[] deg = new int[n];
        for(int[] req : prerequisites){
            map[req[0]][req[1]] = true;
            deg[req[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(deg[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int j = 0; j < n; j++){
                if(deg[j] > 0 && map[cur][j]){
                    deg[j]--;
                    if(deg[j] == 0) q.offer(j);
                }
            }
        }
        for(int d : deg){
            if(d != 0) return false;
        }
        return true;
    }
}
