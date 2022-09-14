import java.awt.*;
import java.util.ArrayList;

public class Busket {
    private ArrayList<Ball> balls = new ArrayList<Ball>(20);

    public void add(Ball ball)
    {
        balls.add(ball);
    }

    public void pop()
    {
        if(balls.size() > 0)
            balls.remove(balls.size()-1);
    }

    public int calculateBallByColor(final Color color)
    {
        int counter = 0;
        for(int i = 0; i < balls.size(); i++)
            if(balls.get(i).get_color() == color)
                counter++;

        return counter;
    }

    public float calculateWeight()
    {
        float total = 0;
        for(int i = 0; i < balls.size(); i++)
            total += balls.get(i).get_weight();

        return total;
    }
    
    public void clear()
    {
        balls.clear();
    }
}
