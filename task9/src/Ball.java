import java.awt.*;

public class Ball {
    private float _weight;
    private Color _color;

    public Ball(final float weight, final Color color)
    {
        _weight = weight;
        _color = color;
    }

    public Color get_color()
    {
        return _color;
    }

    public void set_color(final Color color)
    {
        _color = color;
    }

    public void set_weight(final float weight)
    {
        _weight = weight;
    }

    public float get_weight()
    {
        return _weight;
    }
}
