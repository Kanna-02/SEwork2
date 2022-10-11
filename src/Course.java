//课程的信息
public class Course implements Portcourse {
    private String[] Sname; //90名学生姓名
    private String[] Sscore;//90名学生分数
    private String[] Sattend;//学生出勤情况，20位字符串
    public void setname(){ Sname=new String[90]; }
    public void setSname(int k,String name){
        Sname[k]=name;
    }
    public String getSname(int k){
        return Sname[k];
    }
    public void setscore(){
        Sscore=new String[90];
    }
    public void setSscore(int k,String score){
        Sscore[k]=score;
    }
    public String getSscore(int k){
        return Sscore[k];
    }
    public void setattend(){
        Sattend=new String[90];
    }
    public void setSattend(int k,String attend){
        Sattend[k]=attend;
    }
    public void setSattend2(int k,String ch) { Sattend[k]+=ch; }
    public String getSattend(int k){
        return Sattend[k];
    }
    public int cmpattend(int k,int at){
        char ch=Sattend[k].charAt(at);
        if(ch=='0') return 1;
        else return 0;
    }
    public void sortscore(Course s,int k){
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < k-1; j++) {
                Double x=new Double(s.Sscore[j]);
                Double y=new Double(s.Sscore[j+1]);
                if(x<y){
                    String t=s.Sscore[j];
                    s.Sscore[j]=s.Sscore[j+1];
                    s.Sscore[j+1]=t;
                    String n=s.Sname[j];
                    s.Sname[j]=s.Sname[j+1];
                    s.Sname[j+1]=n;
                }
            }
        }
    }
}