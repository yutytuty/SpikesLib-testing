package frc.robot;

import com.spikes2212.util.XboXUID;

public class OI /*Gevald*/ {
    private final XboXUID xboXUID = new XboXUID(0);

    public double getRightX() {
        return xboXUID.getRightX();
    }

    public double getLeftY() {
        return xboXUID.getLeftY();
    }
}
