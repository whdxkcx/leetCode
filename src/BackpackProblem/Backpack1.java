package BackpackProblem;

public class Backpack1 {

    public static void main(String[] args){
        int  reactorCap=100,numberOfRadLiquid=5,criticalMass=15;
        int[] volumes={50,40,30,20,10};
        int[] masses={1,2,3,9,5};
        int[] energies={300,480,270,200,180};
        Backpack1 bp=new Backpack1();
        System.out.println(bp.maxEnergyGenerate(reactorCap,numberOfRadLiquid,criticalMass,
                volumes,masses,energies));
    }


    public int maxEnergyGenerate(int reactorCap,int numberOfRadLiquid,
                                 int criticalMass,int[] volumes,int[] masses,int[] energies){
        int f[][]=new int[reactorCap+1][criticalMass+1];
        for(int i=0;i<numberOfRadLiquid;i++){
            for(int v=reactorCap;v>=volumes[i];v--){
                for(int m=criticalMass;m>=masses[i];m--)
                f[v][m]=Math.max(f[v-volumes[i]][m-masses[i]]+energies[i],f[v][m]);
            }
        }
        return f[reactorCap][criticalMass];
    }
}
