package DynamicPrograming;

import javax.sql.StatementEventListener;

public class BestTimetoBuyandSellStockwithCooldown309 {
    //第i天卖出的最大累积收益 = max(第i-1天买入~第i天卖出的最大累积收益, 第i-1天卖出后反悔~改为第i天卖出的最大累积收益)
    //第i天买入的最大累积收益 = max(第i-2天卖出~第i天买入的最大累积收益, 第i-1天买入后反悔~改为第i天买入的最大累积收益)
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if(len<=1)  return 0;
        int sell[]=new int[len];
        int buy[]=new int[len];
        sell[0]=0;
        buy[0]=-prices[0];
        int diff=0;
        int max= 0;
        for(int i=1;i<len;i++){
            diff=prices[i]-prices[i-1];
            sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]+diff);
            if(i>1) buy[i]=Math.max(buy[i-1]-diff,sell[i-2]-prices[i]);
            else buy[i]=buy[i-1]-diff;
            max=Math.max(max,sell[i]);
        }
        return max;
    }
}
