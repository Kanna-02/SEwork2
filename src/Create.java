import java.util.Random;
//生成课程
public class Create implements Portcreate {
    public void create(Course[] courses)  {
        //Course[] courses = new Course[5];//5个课程
        Datestu data = new Datestu();
        for (int m = 0; m < 5; m++) {
            //初始化
            courses[m]=new Course();
            courses[m].setname();
            courses[m].setscore();
            courses[m].setattend();
            int count = 90;
            for (int i = 0; i < count; i++) { //生成课程的学生数据
                //名字
                String familyName = data.randFamilyName();
                String randName = data.randName();
                String name = familyName.concat(randName);
                courses[m].setSname(i, name);
                //绩点
                double s = data.randscore();
                String score = String.format("%.2f", s).toString();
                courses[m].setSscore(i, score);
            }
            //按照绩点来排序
            courses[m].sortscore(courses[m], 90);
            //生成缺席80%的5-8人，s[]数组里面
            int sn = new Random().nextInt(4) + 5;
            int[] s = new int[sn];
            for (int i = 0; i < sn; i++) {
                if (i != 0) {

                    int k = new Random().nextInt(20) + 70;//生成70~89名的人
                    while (true) { //生成不重复的数字
                        int flag = 0;
                        for (int j = 1; j <= i; j++) if (k == s[j]) flag = 1;

                        if (flag == 0) break;
                        else {
                            k = new Random().nextInt(20) + 70;
                        }
                    }
                    s[i] = k;
                } else {
                    int k = new Random().nextInt(70); //生成前面的人
                    s[i] = k;
                }
            }
            //生成缺勤80%的考勤
            for (int i = 0; i < sn; i++) {
                String attend = data.noattend();
                courses[m].setSattend(s[i], attend);
            }
            //生成剩下人的考勤
            for (int i = 0; i < 20; i++) {  //20列数据
                int other = new Random().nextInt(4); //随机生成0-3个缺勤人
                int[] a = new int[other]; //装随机生成数的数组
                for (int l = 0; l < other; l++) {
                    int k = new Random().nextInt(90);
                    while (true) {
                        int flag = 0;
                        for (int o = 0; o < sn; o++) if (k == s[o]) flag = 1;
                        if (flag == 0) break;
                        else {
                            k = new Random().nextInt(90);
                        }
                    }
                    a[l] = k;
                }

                for (int j = 0; j < 90; j++) {
                    int flag = 0;
                    for (int k = 0; k < sn; k++) { //判断是不是未生成的人
                        if (j == s[k]) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) continue;
                    else {   //只生成一列考勤
                        if (i == 0) {
                            int flag2 = 0;
                            for (int o = 0; o < other; o++) {
                                if (j == a[o]) {
                                    flag2 = 1;
                                    break;
                                }
                            }
                            if (flag2 == 1) courses[m].setSattend(j, "0");
                            else courses[m].setSattend(j, "1");
                        } else {
                            int flag2 = 0;
                            for (int o = 0; o < other; o++) {
                                if (j == a[o]) {
                                    flag2 = 1;
                                    break;
                                }
                            }
                            if (flag2 == 1) courses[m].setSattend2(j, "0");
                            else courses[m].setSattend2(j, "1");
                        }
                    }
                }
            }
        }
    }
}