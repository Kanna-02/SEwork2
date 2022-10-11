import java.util.Random;
import java.util.Scanner;
//使用接口的计算程序
public class Caculate {
    //数据存在courses[]中
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        Course[] courses= new Course[5];
        Portcreate build=new Create();  //使用创造数据的接口
        build.create(courses);  //生成学生数据
        System.out.println("学生数据已经生成完毕，是否查看：Y/N(大写)");
        if(s.next().charAt(0)=='Y'){
            for (int j = 0; j < 5; j++) {
                int m=j+1;
                System.out.println("这是第"+m+"个课程的数据");
                for (int i = 0; i < 90; i++) {
                    System.out.println(courses[j].getSname(i) + "\t" + courses[j].getSscore(i)
                            + "\t" + courses[j].getSattend(i));
                }
            }
        }
        //计算出E
        double avg=0;
        for (int i = 0; i < 5; i++) { //5门课程
            Random random = new Random();
            int[] pop=new int[20];
            int sum=0,effect=0;
            for (int f = 0; f < 10; f++) { //先点10次课
                int num=random.nextInt(2)+5; //生成5-6次的抽点
                int eff=0; //有效的
                for (int j = 0; j < num; j++) {
                    int cmp=random.nextInt(20)+70;//从70-89号后面抽点
                    if(courses[i].cmpattend(cmp,f)==1){  //缺席
                        eff++;
                        pop[cmp-70]++;//存放前10次缺席的人的次数
                    }
                }
                sum+=num; effect+=eff;
            }
            int count=0;
            int[] pson= new int[20];
            for (int f = 0; f < 20; f++) {
                if(pop[f]>=3){
                    pson[count++]=f+70;    //存放经常缺席的号数
                }
            }
            for (int f = 10; f < 20; f++) {  //后面的10次点名只点名经常缺席的人
                int eff=0;
                for (int j = 0; j < count; j++) {  //抽点次数
                    if(courses[i].cmpattend(pson[j],f)==1) eff++;
                }
                sum+=count; effect+=eff;
            }
            double d=1.0*effect/sum;  //每一门课的E
            avg+=d;
        }
        //可以先点名前10次，将多次缺勤的人标记出来，后面10次主要点这些人
        double E1=avg/5; //E取平均值
        String E=String.format("%.2f",E1).toString();
        System.out.println("5门课E的均值为："+E+"(非固定)");
        System.out.println("方案：先从后面20名中抽10次课，然后保存至少缺席3次的人的号数，后面的10次课抽点就从" +
                "这些经常缺席的人当中去抽。五门课均生成E，然后取平均值得到最终结果");
    }
}