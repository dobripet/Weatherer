package cz.zcu.kiv.si.sportbot.dataLoader.object;

/**
 * @author Marek Rasocha
 *         date 14.05.2017.
 */
public class OpeningTime{
    private int from;
    private int to;

    public OpeningTime(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public OpeningTime() {
    }


    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        OpeningTime that = (OpeningTime) object;

        if (from != that.from) return false;
        return to == that.to;

    }



    @Override
    public String toString() {
        return "OpeningTime{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

}
