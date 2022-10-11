//课程接口
public interface Portcourse {
    public void setname();
    public void setSname(int k,String name);
    public String getSname(int k);
    public void setscore();
    public void setSscore(int k,String score);
    public String getSscore(int k);
    public void setattend();
    public void setSattend(int k,String attend);
    public void setSattend2(int k,String ch);
    public String getSattend(int k);
    public void sortscore(Course s,int k);
    public int cmpattend(int k,int at);
}