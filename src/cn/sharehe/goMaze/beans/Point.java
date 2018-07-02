package cn.sharehe.goMaze.beans;

/**
 * 走迷宫的点
 * @Author: wugui
 * @Date 2018-6-8 15:36
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
