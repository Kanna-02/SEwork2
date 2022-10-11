
//随机生成的库
        import java.text.NumberFormat;
        import java.util.Random;

public class Datestu implements Portdate {
    String familyName = "李王张刘陈杨赵黄周吴徐孙胡朱高林何郭马梁宋于谢郑";
    String Name = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清" +
            "飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友" +
            "裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛" +
            "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺" +
            "媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜";
    //生成姓氏
    @Override
    public String randFamilyName() {
        String str = "";
        int strLen;
        //int randNum = new Random().nextInt(1) + 1;
        int index;
        strLen = familyName.length();
        index = new Random().nextInt(strLen); //从字符串长度中随机一个数字
        str = String.valueOf(familyName.charAt(index));//找到数字对应的字符
        return str;
    }
    //生成名字
    @Override
    public String randName() {
        String name = "";
        int randNum = new Random().nextInt(2) + 1;
        int index;
        int strLen = Name.length();
        if (randNum % 2 == 0) { //1个字名
            index = new Random().nextInt(strLen - 1);
            name = Name.substring(index, index + randNum);
        } else { //2个字名
            index = new Random().nextInt(strLen);
            name = Name.substring(index, index + randNum);
        }
        return name;
    }
    //生成随机小数
    @Override
    public double randscore(){
        //生成1-4的随机数
        double s=(double)(Math.random()*3+1);
        NumberFormat nf = NumberFormat.getNumberInstance();
        return s;
    }
    //生成考勤80%
    @Override
    public String noattend(){ //16个0，4个1x
        String str="01";
        Random random=new Random();
        StringBuffer sh=new StringBuffer();
        int flag=0;
        for (int i = 0; i < 20; i++) {
            int n=random.nextInt(2);
            if(n==1){
                if(flag<4) flag++;
                else n=0;
            }
            sh.append(str.charAt(n));
        }
        return sh.toString();
    }
}
