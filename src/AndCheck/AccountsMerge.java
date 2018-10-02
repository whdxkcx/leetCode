package AndCheck;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int s[]=new int[accounts.size()];
        HashMap<String,Integer> emailMap=new HashMap<>();//<邮箱，对应的集合的根节点行号>
        HashMap<Integer,List<String>>  rowMap=new HashMap<>();//<行号，集合包含的邮箱>

        int n=accounts.size();
        //初始化s[]
        for(int i=0;i<n;i++){
            s[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(emailMap.containsKey(accounts.get(i).get(j))&&find(i,s)!=find(emailMap.get(accounts.get(i).get(j)),s)){
                    union(emailMap.get(accounts.get(i).get(j)),i,s);
                }
                emailMap.put(accounts.get(i).get(j),find(i,s));
            }
        }

        for(String email: emailMap.keySet()){
            int f=find(emailMap.get(email),s);
            if(rowMap.containsKey(f)){
                rowMap.get(f).add(email);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(accounts.get(emailMap.get(email)).get(0));
                list.add(email);
                rowMap.put(f,list);
            }
        }
        List<List<String>>  res=new ArrayList<>();
        for(int row:rowMap.keySet()){
            Collections.sort(rowMap.get(row));
            rowMap.get(row).set(0,accounts.get(row).get(0));
            res.add(rowMap.get(row));
        }
        return res;
    }

    //查找父节点
    public int find(int i,int s[]){
        if(i!=s[i]){
            s[i]=find(s[i],s);
        }
        return s[i];
    }

    //合并
    public void union(int i,int j,int s[]){
         s[find(j,s)]=find(i,s);
    }



}
