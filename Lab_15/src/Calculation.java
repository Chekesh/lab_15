import java.io.Serializable;
public class Calculation implements Serializable {
    int x;
    double y;
    Calculation(int x){
        this.x=x;
    }
    void action(){
        y = x-Math.sin(x);
    }
}
