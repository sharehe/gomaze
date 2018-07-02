package cn.sharehe.goMaze.maze;

import cn.sharehe.goMaze.beans.Point;
import cn.sharehe.goMaze.utils.AlgoVisHelper;

/**
 * 创建迷宫
 * @Author: wugui
 * @Date 2018-6-10 14:39
 */
public class CreateMazeThread implements Runnable{
    private AlgoJFrame algoJFrame;
    private MazeData createMazeData;
    private int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    private RandeQueue<Point> queue;
    public CreateMazeThread(AlgoJFrame algoJFrame, MazeData createMazeData) {
        this.algoJFrame = algoJFrame;
        this.createMazeData = createMazeData;
        queue = new RandeQueue<>();
    }

    @Override
    public void run() {
//        createMaze(1,1);
        stack(1,1);
        createMazeData.setCreateSuccess();
        createMazeData.setInitOver();
        algoJFrame.setTopText("按键盘任意键开始走迷宫");
        System.out.println("迷宫生成完成");
    }

    /**
     * 递归 生成迷宫
     * @param x
     * @param y
     */
    private void createMaze(int x, int y){
        algoJFrame.rePaint(createMazeData);
//        AlgoVisHelper.pause(10);
        int newX,newY;
        for (int i = 0; i < d.length; i++) {
            newX = x + d[i][0] * 2;
            newY = y + d[i][1] * 2;
            if (!createMazeData.isOut(newX,newY) && !createMazeData.getOverItem(newX,newY)){
                createMazeData.setOverItem(newX,newY);
                createMazeData.setDataItem(x + d[i][0],y + d[i][1]);
                createMaze(newX, newY);
            }
        }
    }

    /**
     * 生成随机迷宫
     * @param x
     * @param y
     */
    private void stack(int x, int y){
        queue.add(new Point(x,y));
        Point point = null;
        while (!queue.isEmpty()){
            point = queue.remove();
            AlgoVisHelper.pause(20);
            algoJFrame.rePaint(createMazeData);
            int newX,newY;
            for (int i = 0; i < d.length; i++) {
                newX = point.getX() + d[i][0] * 2;
                newY = point.getY() + d[i][1] * 2;
                if (!createMazeData.isOut(newX,newY) && !createMazeData.getOverItem(newX,newY)){
                    queue.add(new Point(newX,newY));
                    createMazeData.setOverItem(newX,newY);
                    createMazeData.setDataItem(point.getX() + d[i][0], point.getY() + d[i][1]);
                }
            }
        }
    }
}
