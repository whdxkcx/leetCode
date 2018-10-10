package HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  res=new ArrayList<>();
        int slen=s.length();
        int plen=p.length();
        if(slen<plen) return res;
        int sa[]=new int[26];
        int pa[]=new int[26];
        for(char c:p.toCharArray()){
            pa[c-'a']++;
        }
        //记录当前窗口包含的p中的字符的个数
        int tCount=0;
        for(int i=0;i<plen;i++){
            int index=s.charAt(i)-'a';
            sa[index]++;
            if(sa[index]<=pa[index])
                tCount++;
        }
        if(tCount==plen)  res.add(0);

        for(int i=plen;i<slen;i++){
         int pos=i-plen;
         int index=s.charAt(pos)-'a';
         if(sa[index]<=pa[index])
             tCount--;
         sa[index]--;
         index=s.charAt(i)-'a';
         sa[index]++;
         if(sa[index]<=pa[index])
             tCount++;
         if(tCount==plen) res.add(pos+1);
        }
        return res;
    }
}
