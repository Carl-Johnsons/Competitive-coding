public class Rectangle_Area {
    public static void main(String[] args) {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1;
        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int xl = Math.max(ax1, bx1);
        int xr = Math.min(ax2, bx2);
        int yl = Math.max(ay1, by1);
        int yr = Math.min(ay2, by2);

        int dx = xr - xl;
        int dy = yr - yl;
        int overlapArea = 0;

        if (dx > 0 && dy > 0) {
            overlapArea = dx * dy;
        }

        int Rect1Area = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int Rect2Area = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        return Rect1Area + Rect2Area - overlapArea;
    }
}
