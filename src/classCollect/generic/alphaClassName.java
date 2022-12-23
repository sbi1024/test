package classCollect.generic;

import classCollect.alphabet.A;

import java.util.List;

public class alphaClassName<T extends A> {
    public List<T> alpha;

    public List<T> getAlpha() {
        return alpha;
    }

    public void setAlpha(List<T> alpha) {
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return "alphaClassName{" +
                "alpha=" + alpha +
                '}';
    }

    public void soutAlpha() {
        for (T obj : alpha) {
            System.out.println("<K> > obj ========>>>>>" + obj);
            obj.soutData();
        }
    }
}
